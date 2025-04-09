import java.sql.*;
import java.util.logging.*;

public class Ex7 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/Ex7;DB_CLOSE_DELAY=-1";
    private static final String USER = "root";
    private static final String PASSWORD = "1111";
    private static final Logger logger = Logger.getLogger(Ex7.class.getName());

    public static void main(String[] args) {
        try {
            FileHandler fh = new FileHandler("kiemtra_mucdocolap.log");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setLevel(Level.INFO);

            createTable();

            testIsolationLevel(Connection.TRANSACTION_READ_UNCOMMITTED, "read_uncommit ");
            testIsolationLevel(Connection.TRANSACTION_READ_COMMITTED, "read_commit");
            testIsolationLevel(Connection.TRANSACTION_REPEATABLE_READ, "read");
            testIsolationLevel(Connection.TRANSACTION_SERIALIZABLE, "SERIALIZABLE");

        } catch (Exception e) {
            logger.severe("Lỗi: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createTable() throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            stmt.execute("DROP TABLE IF EXISTS orders");
            stmt.execute("CREATE TABLE orders (" +
                    "order_id INT PRIMARY KEY," +
                    "customer_name VARCHAR(255)," +
                    "status VARCHAR(50))");
            stmt.execute("INSERT INTO orders VALUES (1, 'Nguyễn Văn A', 'ĐANG_CHỜ')");
        }
    }

    private static void testIsolationLevel(int isolationLevel, String levelName) throws SQLException {
        logger.info("\n=== Kiểm tra " + levelName + " ===");

        Connection conn1 = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        conn1.setAutoCommit(false);
        conn1.setTransactionIsolation(isolationLevel);

        Connection conn2 = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        conn2.setAutoCommit(false);

        try {
            logResult(conn1, "Đọc lần đầu", 1);

            Statement stmt2 = conn2.createStatement();
            stmt2.executeUpdate("INSERT INTO orders VALUES (2, 'Trần Thị B', 'ĐANG_XỬ_LÝ')");
            logger.info("Kết nối 2: Đã thêm đơn hàng mới (chưa cam kết)");

            logResult(conn1, "Đọc sau khi thêm chưa cam kết", 2);

            stmt2.executeUpdate("UPDATE orders SET status = 'ĐÃ_CẬP_NHẬT' WHERE order_id = 1");
            logger.info("Kết nối 2: Đã cập nhật đơn hàng 1 (chưa cam kết)");

            logResult(conn1, "Đọc sau khi cập nhật chưa cam kết", 1);

            conn2.commit();
            logger.info("Kết nối 2: Đã cam kết các thay đổi");
            logResult(conn1, "Đọc cuối cùng sau khi cam kết", 2);

        } catch (SQLException e) {
            logger.severe("Lỗi trong " + levelName + ": " + e.getMessage());
        } finally {
            conn1.rollback();
            conn2.rollback();
            conn1.close();
            conn2.close();
        }
    }

    private static void logResult(Connection conn, String phase, int expectedRows) throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM orders");

        int rowCount = 0;
        StringBuilder result = new StringBuilder(phase + ": ");
        while (rs.next()) {
            rowCount++;
            result.append("\nMã đơn: ").append(rs.getInt("order_id"))
                    .append(", Khách hàng: ").append(rs.getString("customer_name"))
                    .append(", Trạng thái: ").append(rs.getString("status"));
        }

        logger.info(result.toString());

        // Phân tích hiện tượng
        if (phase.contains("thêm chưa cam kết") && rowCount > 1) {
            logger.info("-> Phát hiện Dirty Read: Có thể thấy dữ liệu thêm vào chưa cam kết");
        }
        if (phase.contains("cập nhật chưa cam kết") && rowCount > 0) {
            String status = getStatus(conn, 1);
            if (status.equals("ĐÃ_CẬP_NHẬT")) {
                logger.info("-> Phát hiện Dirty Read: Có thể thấy dữ liệu cập nhật chưa cam kết");
            }
        }
        if (phase.contains("Đọc cuối cùng") && rowCount > expectedRows) {
            logger.info("-> Phát hiện Phantom Read: Xuất hiện dòng mới");
        }
    }

    private static String getStatus(Connection conn, int orderId) throws SQLException {
        PreparedStatement pstmt = conn.prepareStatement("SELECT status FROM orders WHERE order_id = ?");
        pstmt.setInt(1, orderId);
        ResultSet rs = pstmt.executeQuery();
        return rs.next() ? rs.getString("status") : "";
    }
}