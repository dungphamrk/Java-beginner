import java.sql.*;
import java.time.LocalDateTime;

public class Ex9 {
    private static final String URL = "jdbc:mysql://localhost:3306/Ex9";
    private static final String USER = "root";
    private static final String PASSWORD = "1111";
    public static void main(String[] args) {
        placeBid(1, 1, 150.0);
        placeBid(2, 1, 100.0);
        placeBid(3, 1, 1000.0);
    }

    public static void placeBid(int userId, int auctionId, double bidAmount) {
        Connection conn = null;
        PreparedStatement checkUserStmt = null;
        PreparedStatement checkAuctionStmt = null;
        PreparedStatement updateAuctionStmt = null;
        PreparedStatement insertBidStmt = null;
        PreparedStatement logFailureStmt = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            checkUserStmt = conn.prepareStatement(
                    "SELECT balance FROM users WHERE user_id = ?");
            checkUserStmt.setInt(1, userId);
            ResultSet userRs = checkUserStmt.executeQuery();

            if (!userRs.next()) {
                logFailure(conn, userId, auctionId, bidAmount, "User does not exist");
                throw new SQLException("Invalid user ID");
            }

            double userBalance = userRs.getDouble("balance");
            if (userBalance < bidAmount) {
                logFailure(conn, userId, auctionId, bidAmount, "Insufficient balance");
                throw new SQLException("User balance is insufficient");
            }

            checkAuctionStmt = conn.prepareStatement(
                    "SELECT highest_bid, status FROM auctions WHERE auction_id = ?");
            checkAuctionStmt.setInt(1, auctionId);
            ResultSet auctionRs = checkAuctionStmt.executeQuery();

            if (!auctionRs.next() || !"OPEN".equals(auctionRs.getString("status"))) {
                logFailure(conn, userId, auctionId, bidAmount, "Auction is closed or does not exist");
                throw new SQLException("Invalid auction");
            }

            double currentHighestBid = auctionRs.getDouble("highest_bid");
            if (bidAmount <= currentHighestBid) {
                logFailure(conn, userId, auctionId, bidAmount, "Bid amount is lower than current highest bid");
                throw new SQLException("Bid amount too low");
            }

            updateAuctionStmt = conn.prepareStatement(
                    "UPDATE auctions SET highest_bid = ? WHERE auction_id = ?");
            updateAuctionStmt.setDouble(1, bidAmount);
            updateAuctionStmt.setInt(2, auctionId);
            updateAuctionStmt.executeUpdate();

            insertBidStmt = conn.prepareStatement(
                    "INSERT INTO bids (auction_id, user_id, bid_amount, timestamp) " +
                            "VALUES (?, ?, ?, ?)");
            insertBidStmt.setInt(1, auctionId);
            insertBidStmt.setInt(2, userId);
            insertBidStmt.setDouble(3, bidAmount);
            insertBidStmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            insertBidStmt.executeUpdate();

            conn.commit();
            System.out.println("Bid placed successfully: User " + userId +
                    " placed " + bidAmount + " on auction " + auctionId);

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    System.out.println("Rolling back transaction for user " + userId);
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (checkUserStmt != null) checkUserStmt.close();
                if (checkAuctionStmt != null) checkAuctionStmt.close();
                if (updateAuctionStmt != null) updateAuctionStmt.close();
                if (insertBidStmt != null) insertBidStmt.close();
                if (logFailureStmt != null) logFailureStmt.close();
                if (conn != null) conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static void logFailure(Connection conn, int userId, int auctionId,
                                   double bidAmount, String reason) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO failed_bids (user_id, auction_id, bid_amount, reason, timestamp) " +
                        "VALUES (?, ?, ?, ?, ?)");
        stmt.setInt(1, userId);
        stmt.setInt(2, auctionId);
        stmt.setDouble(3, bidAmount);
        stmt.setString(4, reason);
        stmt.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
        stmt.executeUpdate();
        stmt.close();
        System.out.println("Logged failure: " + reason);
    }
}