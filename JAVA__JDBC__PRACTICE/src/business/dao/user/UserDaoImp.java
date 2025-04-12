package business.dao.user;
import business.config.ConnectionDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class UserDaoImp implements UserDao {

    @Override
    public boolean login(String username,String password){
        Connection conn = null;
        CallableStatement callStmt = null;
        try{
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call Login(?,?)}");
            callStmt.setString(1,username);
            callStmt.setString(2,password);
            callStmt.registerOutParameter(3, Types.INTEGER);
            callStmt.executeQuery();
            return callStmt.getInt(2)==1;
        } catch (SQLException e) {
            System.err.println("Có lỗi xảy ra trong quá trình đăng nhập, dữ liệu đã được rollback");
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } catch (Exception e) {
            System.err.println("Có lỗi không xác định khi làm việc với db: " + e.getMessage());
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return false;
    }

    @Override
    public void logout() {
        System.exit(0);
    }
}
