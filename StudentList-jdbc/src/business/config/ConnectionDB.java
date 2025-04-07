package business.config;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "";
    private static final String URL = "jdbc:mysql://localhost:3306/StudentManagement";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "1111";

    public static Connection openConnection() {
        Connection conn = null;
        try {
            //1. Set driver kết nối đến CSDL MySQL - Với type-3 trở xuống
//            Class.forName(DRIVER);//Type-4 tự nhận
            //2. Khởi tạo đối tượng connection từ ứng dụng Java đến CSDL
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Có lỗi trong quá trình kết nối với CSDL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Có lỗi không xác định trong quá trình kết nối: " + e.getMessage());
        }
        return conn;
    }

    public static void closeConnection(Connection conn, CallableStatement callSt) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (callSt != null) {
            try {
                callSt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}