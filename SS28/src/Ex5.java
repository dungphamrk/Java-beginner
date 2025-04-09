import java.sql.*;
import java.time.LocalDate;


public class Ex5 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Ex5";
        String user = "root";
        String password = "1111";
        Connection conn = null;
        PreparedStatement callst = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);
            callst = conn.prepareCall("{call createOrder(?,?)}");
            callst.setString(1, "Nguyễn Văn B");
            callst.setDate(2, Date.valueOf(LocalDate.now()));
            callst.executeUpdate();

            ResultSet rs = callst.getGeneratedKeys();
            int orderId = 0;
            if (rs.next()) orderId = rs.getInt(1);

            callst=conn.prepareCall("{call insertOrderDetails(?,?,?)}");
            callst.setInt(1, orderId);
            callst.setString(2, "Sản phẩm A");
            callst.setInt(3, 2);
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
