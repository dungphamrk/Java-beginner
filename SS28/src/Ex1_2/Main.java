package Ex1_2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            if (conn != null) {
                conn.setAutoCommit(false);
                String sql = "{call crease_user(?, ?)}";
                callSt = conn.prepareCall(sql);
                callSt.setString(1, "Pham Quang Dung");
                callSt.setString(2, "pqd@gmail.com");
                callSt.execute();
                conn.commit();
                System.out.println("Thêm mới thành công");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Đã rollback thay đổi do lỗi.");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }
}
