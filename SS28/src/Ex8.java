import java.sql.*;
import java.time.LocalDate;

public class Ex8 {
    private static final String URL = "jdbc:mysql://localhost:3306/Ex8";
    private static final String USER = "root";
    private static final String PASSWORD = "1111";

    public static void main(String[] args) {
        bookRoom(1, 1);
        bookRoom(1, 2);
        bookRoom(999, 3);
    }

    public static void bookRoom(int customerId, int roomId) {
        Connection conn = null;
        PreparedStatement checkRoomStmt = null;
        PreparedStatement updateRoomStmt = null;
        PreparedStatement insertBookingStmt = null;
        PreparedStatement logFailureStmt = null;

        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false);

            if (!customerExists(conn, customerId)) {
                logFailure(conn, customerId, roomId, "Customer does not exist");
                throw new SQLException("Invalid customer ID");
            }

            checkRoomStmt = conn.prepareStatement(
                    "SELECT availability FROM rooms WHERE room_id = ?");
            checkRoomStmt.setInt(1, roomId);
            ResultSet rs = checkRoomStmt.executeQuery();

            if (rs.next() && rs.getBoolean("availability")) {
                updateRoomStmt = conn.prepareStatement(
                        "UPDATE rooms SET availability = false WHERE room_id = ?");
                updateRoomStmt.setInt(1, roomId);
                updateRoomStmt.executeUpdate();

                insertBookingStmt = conn.prepareStatement(
                        "INSERT INTO bookings (customer_id, room_id, booking_date, status) " +
                                "VALUES (?, ?, ?, ?)");
                insertBookingStmt.setInt(1, customerId);
                insertBookingStmt.setInt(2, roomId);
                insertBookingStmt.setDate(3, Date.valueOf(LocalDate.now()));
                insertBookingStmt.setString(4, "Confirmed");
                insertBookingStmt.executeUpdate();

                conn.commit();
                System.out.println("Booking successful for customer " + customerId +
                        " and room " + roomId);
            } else {
                // Phòng đã được đặt, ghi log lỗi
                logFailure(conn, customerId, roomId, "Room is not available");
                throw new SQLException("Room is not available");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    System.out.println("Rolling back transaction for customer " + customerId);
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (checkRoomStmt != null) checkRoomStmt.close();
                if (updateRoomStmt != null) updateRoomStmt.close();
                if (insertBookingStmt != null) insertBookingStmt.close();
                if (logFailureStmt != null) logFailureStmt.close();
                if (conn != null) conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean customerExists(Connection conn, int customerId) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "SELECT COUNT(*) FROM customers WHERE customer_id = ?");
        stmt.setInt(1, customerId);
        ResultSet rs = stmt.executeQuery();
        rs.next();
        boolean exists = rs.getInt(1) > 0;
        stmt.close();
        return exists;
    }

    private static void logFailure(Connection conn, int customerId, int roomId, String reason)
            throws SQLException {
        PreparedStatement stmt = conn.prepareStatement(
                "INSERT INTO failed_bookings (customer_id, room_id, failure_reason, failure_date) " +
                        "VALUES (?, ?, ?, ?" +
                        ")");
        stmt.setInt(1, customerId);
        stmt.setInt(2, roomId);
        stmt.setString(3, reason);
        stmt.setDate(4, Date.valueOf(LocalDate.now()));
        stmt.executeUpdate();
        stmt.close();
        System.out.println("Logged failure: " + reason);
    }
}