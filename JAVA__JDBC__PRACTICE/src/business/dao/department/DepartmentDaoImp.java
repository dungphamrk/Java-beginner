package business.dao.department;

import business.config.ConnectionDB;
import business.model.Department;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImp implements DepartmentDao {

    @Override
    public List<Department> findAll() {
        return findAllWithPaging(1, 5); // Mặc định trang 1, 5 bản ghi
    }

    @Override
    public List<Department> findAllWithPaging(int page, int size) {
        Connection conn = null;
        CallableStatement callStmt = null;
        List<Department> departments = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call GetDepartments(?,?,?)}");
            callStmt.setInt(1, page);
            callStmt.setInt(2, size);
            callStmt.registerOutParameter(3, Types.INTEGER);
            ResultSet rs = callStmt.executeQuery();
            if (callStmt.getInt(3) == 1) {
                while (rs.next()) {
                    Department dept = new Department();
                    dept.setDepartmentId(rs.getInt("department_id"));
                    dept.setDepartmentName(rs.getString("department_name"));
                    dept.setDescription(rs.getString("description"));
                    dept.setStatus(Department.Status.valueOf(rs.getString("status")));
                    departments.add(dept);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách phòng ban: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return departments;
    }

    @Override
    public int save(Department department) {
        Connection conn = null;
        CallableStatement callStmt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callStmt = conn.prepareCall("{call AddDepartment(?,?,?,?)}");
            callStmt.setString(1, department.getDepartmentName());
            callStmt.setString(2, department.getDescription());
            callStmt.setString(3, department.getStatus().name());
            callStmt.registerOutParameter(4, Types.INTEGER);
            callStmt.execute();
            conn.commit();
            return callStmt.getInt(4) ;
        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm phòng ban: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return 0;
    }

    @Override
    public int update(Department department) {
        Connection conn = null;
        CallableStatement callStmt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callStmt = conn.prepareCall("{call UpdateDepartment(?,?,?,?,?)}");
            callStmt.setInt(1, department.getDepartmentId());
            callStmt.setString(2, department.getDepartmentName());
            callStmt.setString(3, department.getDescription());
            callStmt.setString(4, department.getStatus().name());
            callStmt.registerOutParameter(5, Types.INTEGER);
            callStmt.execute();
            conn.commit();
            return callStmt.getInt(5);
        } catch (SQLException e) {
            System.err.println("Lỗi khi cập nhật phòng ban: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return 0;
    }

    @Override
    public int delete(Department department) {
        Connection conn = null;
        CallableStatement callStmt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callStmt = conn.prepareCall("{call DeleteDepartment(?,?)}");
            callStmt.setInt(1, department.getDepartmentId());
            callStmt.registerOutParameter(2, Types.INTEGER);
            callStmt.execute();
            conn.commit();
            return callStmt.getInt(2) ;
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa phòng ban: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return 0;
    }

    @Override
    public List<Department> searchByName(String name) {
        Connection conn = null;
        CallableStatement callStmt = null;
        List<Department> departments = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call SearchDepartmentByName(?,?)}");
            callStmt.setString(1, name);
            callStmt.registerOutParameter(2, Types.INTEGER);
            ResultSet rs = callStmt.executeQuery();
            if (callStmt.getInt(2) == 1) {
                while (rs.next()) {
                    Department dept = new Department();
                    dept.setDepartmentId(rs.getInt("department_id"));
                    dept.setDepartmentName(rs.getString("department_name"));
                    dept.setDescription(rs.getString("description"));
                    dept.setStatus(Department.Status.valueOf(rs.getString("status")));
                    departments.add(dept);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi tìm kiếm phòng ban theo tên: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return departments;
    }
}