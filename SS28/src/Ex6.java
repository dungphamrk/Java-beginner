import java.sql.*;
import java.time.LocalDate;

public class Ex6 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Ex6";
        String user = "root";
        String password = "1111";
        Connection conn = null;
        PreparedStatement callst = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            callst = conn.prepareCall("{call createDepartment(?)}");
            callst.setString(1, "Developer");
            callst.executeUpdate();
            callst=conn.prepareCall("{call addEmployee(?,?)}");
            callst.setString(1, "Pham Quang Dung");
            callst.setInt(2, 1);
            callst.executeUpdate();
            callst=conn.prepareCall("{call addEmployee(?,?)}");
            callst.setString(1, "Nguyen Van A");
            callst.setInt(2, 1);
            callst.executeUpdate();
            conn.commit();
            System.out.println("Đơn hàng và chi tiết đã được lưu.");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (conn != null) {
                    System.out.println("Rollback ");
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (callst != null) callst.close();
                if (conn != null) conn.close();
                System.out.println("Đã đóng kết nối.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
