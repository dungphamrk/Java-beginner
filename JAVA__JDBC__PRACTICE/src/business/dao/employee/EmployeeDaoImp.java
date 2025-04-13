package business.dao.employee;

import business.config.ConnectionDB;
import business.model.Department;
import business.model.Employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDaoImp implements EmployeeDao {

    @Override
    public List<Employee> findAll() {
        return findAllWithPaging(1, 10); // Mặc định trang 1, 10 bản ghi
    }

    public List<Employee> findAllWithPaging(int page, int size) {
        Connection conn = null;
        CallableStatement callStmt = null;
        List<Employee> employees = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call GetEmployees(?,?,?)}");
            callStmt.setInt(1, page);
            callStmt.setInt(2, size);
            callStmt.registerOutParameter(3, Types.INTEGER);
            ResultSet rs = callStmt.executeQuery();
            if (callStmt.getInt(3) == 1) {
                while (rs.next()) {
                    Employee emp = new Employee();
                    emp.setEmployeeId(rs.getString("employee_id"));
                    emp.setFullName(rs.getString("full_name"));
                    emp.setEmail(rs.getString("email"));
                    emp.setPhoneNumber(rs.getString("phone_number"));
                    emp.setGender(Employee.Gender.valueOf(rs.getString("gender")));
                    emp.setPayGrade(rs.getInt("pay_grade"));
                    emp.setSalary(rs.getDouble("salary"));
                    emp.setBirthDate(rs.getDate("birth_date").toLocalDate());
                    emp.setAddress(rs.getString("address"));
                    emp.setStatus(Employee.Status.valueOf(rs.getString("status")));
                    emp.setDepartmentId(rs.getInt("department_id"));
                    employees.add(emp);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy danh sách nhân viên: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return employees;
    }

    @Override
    public int save(Employee employee) {
        Connection conn = null;
        CallableStatement callStmt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callStmt = conn.prepareCall("{call AddEmployee(?,?,?,?,?,?,?,?,?,?,?,?)}");
            callStmt.setString(1, employee.getEmployeeId());
            callStmt.setString(2, employee.getFullName());
            callStmt.setString(3, employee.getEmail());
            callStmt.setString(4, employee.getPhoneNumber());
            callStmt.setString(5, employee.getGender().name());
            callStmt.setInt(6, employee.getPayGrade());
            callStmt.setDouble(7, employee.getSalary());
            callStmt.setObject(8, employee.getBirthDate());
            callStmt.setString(9, employee.getAddress());
            callStmt.setString(10, employee.getStatus().name());
            callStmt.setInt(11, employee.getDepartmentId());
            callStmt.registerOutParameter(12, Types.INTEGER);
            callStmt.execute();
            conn.commit();
            return callStmt.getInt(12) ;
        } catch (SQLException e) {
            System.err.println("Lỗi khi thêm nhân viên: " + e.getMessage());
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
    public int update(Employee employee) {
        Connection conn = null;
        CallableStatement callStmt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callStmt = conn.prepareCall("{call UpdateEmployee(?,?,?,?,?,?,?,?,?,?,?,?)}");
            callStmt.setString(1, employee.getEmployeeId());
            callStmt.setString(2, employee.getFullName());
            callStmt.setString(3, employee.getEmail());
            callStmt.setString(4, employee.getPhoneNumber());
            callStmt.setString(5, employee.getGender().name());
            callStmt.setInt(6, employee.getPayGrade());
            callStmt.setDouble(7, employee.getSalary());
            callStmt.setObject(8, employee.getBirthDate());
            callStmt.setString(9, employee.getAddress());
            callStmt.setString(10, employee.getStatus().name());
            callStmt.setInt(11, employee.getDepartmentId());
            callStmt.registerOutParameter(12, Types.INTEGER);
            callStmt.execute();
            conn.commit();
            return callStmt.getInt(12) ;
        } catch (SQLException e) {
            System.err.println("Lỗi khi cập nhật nhân viên: " + e.getMessage());
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
    public int delete(Employee employee) {
        Connection conn = null;
        CallableStatement callStmt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callStmt = conn.prepareCall("{call DeleteEmployee(?,?)}");
            callStmt.setString(1, employee.getEmployeeId());
            callStmt.registerOutParameter(2, Types.INTEGER);
            callStmt.execute();
            conn.commit();
            return callStmt.getInt(2) ;
        } catch (SQLException e) {
            System.err.println("Lỗi khi xóa nhân viên: " + e.getMessage());
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
    public List<Employee> searchByName(String name) {
        Connection conn = null;
        CallableStatement callStmt = null;
        List<Employee> employees = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call SearchEmployeeByName(?,?)}");
            callStmt.setString(1, name);
            callStmt.registerOutParameter(2, Types.INTEGER);
            ResultSet rs = callStmt.executeQuery();
            if (callStmt.getInt(2) == 1) {
                while (rs.next()) {
                    Employee emp = new Employee();
                    emp.setEmployeeId(rs.getString("employee_id"));
                    emp.setFullName(rs.getString("full_name"));
                    emp.setEmail(rs.getString("email"));
                    emp.setPhoneNumber(rs.getString("phone_number"));
                    emp.setGender(Employee.Gender.valueOf(rs.getString("gender")));
                    emp.setPayGrade(rs.getInt("pay_grade"));
                    emp.setSalary(rs.getDouble("salary"));
                    emp.setBirthDate(rs.getDate("birth_date").toLocalDate());
                    emp.setAddress(rs.getString("address"));
                    emp.setStatus(Employee.Status.valueOf(rs.getString("status")));
                    emp.setDepartmentId(rs.getInt("department_id"));
                    employees.add(emp);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi tìm kiếm nhân viên theo tên: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return employees;
    }

    @Override
    public List<Employee> searchByAgeRange(int minAge, int maxAge) {
        Connection conn = null;
        CallableStatement callStmt = null;
        List<Employee> employees = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call SearchEmployeeByAgeRange(?,?,?)}");
            callStmt.setInt(1, minAge);
            callStmt.setInt(2, maxAge);
            callStmt.registerOutParameter(3, Types.INTEGER);
            ResultSet rs = callStmt.executeQuery();
            if (callStmt.getInt(3) == 1) {
                while (rs.next()) {
                    Employee emp = new Employee();
                    emp.setEmployeeId(rs.getString("employee_id"));
                    emp.setFullName(rs.getString("full_name"));
                    emp.setEmail(rs.getString("email"));
                    emp.setPhoneNumber(rs.getString("phone_number"));
                    emp.setGender(Employee.Gender.valueOf(rs.getString("gender")));
                    emp.setPayGrade(rs.getInt("pay_grade"));
                    emp.setSalary(rs.getDouble("salary"));
                    emp.setBirthDate(rs.getDate("birth_date").toLocalDate());
                    emp.setAddress(rs.getString("address"));
                    emp.setStatus(Employee.Status.valueOf(rs.getString("status")));
                    emp.setDepartmentId(rs.getInt("department_id"));
                    employees.add(emp);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi tìm kiếm nhân viên theo tuổi: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return employees;
    }

    @Override
    public List<Employee> sortBySalaryDesc(int page, int size) {
        Connection conn = null;
        CallableStatement callStmt = null;
        List<Employee> employees = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call SortEmployeeBySalaryDesc(?,?,?)}");
            callStmt.setInt(1, page);
            callStmt.setInt(2, size);
            callStmt.registerOutParameter(3, Types.INTEGER);
            ResultSet rs = callStmt.executeQuery();
            if (callStmt.getInt(3) == 1) {
                while (rs.next()) {
                    Employee emp = new Employee();
                    emp.setEmployeeId(rs.getString("employee_id"));
                    emp.setFullName(rs.getString("full_name"));
                    emp.setEmail(rs.getString("email"));
                    emp.setPhoneNumber(rs.getString("phone_number"));
                    emp.setGender(Employee.Gender.valueOf(rs.getString("gender")));
                    emp.setPayGrade(rs.getInt("pay_grade"));
                    emp.setSalary(rs.getDouble("salary"));
                    emp.setBirthDate(rs.getDate("birth_date").toLocalDate());
                    emp.setAddress(rs.getString("address"));
                    emp.setStatus(Employee.Status.valueOf(rs.getString("status")));
                    emp.setDepartmentId(rs.getInt("department_id"));
                    employees.add(emp);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi sắp xếp nhân viên theo lương: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return employees;
    }

    @Override
    public List<Employee> sortByNameAsc(int page, int size) {
        Connection conn = null;
        CallableStatement callStmt = null;
        List<Employee> employees = new ArrayList<>();
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call SortEmployeeByNameAsc(?,?,?)}");
            callStmt.setInt(1, page);
            callStmt.setInt(2, size);
            callStmt.registerOutParameter(3, Types.INTEGER);
            ResultSet rs = callStmt.executeQuery();
            if (callStmt.getInt(3) == 1) {
                while (rs.next()) {
                    Employee emp = new Employee();
                    emp.setEmployeeId(rs.getString("employee_id"));
                    emp.setFullName(rs.getString("full_name"));
                    emp.setEmail(rs.getString("email"));
                    emp.setPhoneNumber(rs.getString("phone_number"));
                    emp.setGender(Employee.Gender.valueOf(rs.getString("gender")));
                    emp.setPayGrade(rs.getInt("pay_grade"));
                    emp.setSalary(rs.getDouble("salary"));
                    emp.setBirthDate(rs.getDate("birth_date").toLocalDate());
                    emp.setAddress(rs.getString("address"));
                    emp.setStatus(Employee.Status.valueOf(rs.getString("status")));
                    emp.setDepartmentId(rs.getInt("department_id"));
                    employees.add(emp);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi sắp xếp nhân viên theo tên: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return employees;
    }

    @Override
    public Map<Integer, Long> getEmployeeCountByDepartment() {
        Connection conn = null;
        CallableStatement callStmt = null;
        Map<Integer, Long> result = new HashMap<>();
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call GetEmployeeCountByDepartment(?)}");
            callStmt.registerOutParameter(1, Types.INTEGER);
            ResultSet rs = callStmt.executeQuery();
            if (callStmt.getInt(1) == 1) {
                while (rs.next()) {
                    result.put(rs.getInt("department_id"), rs.getLong("employee_count"));
                }
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi thống kê nhân viên theo phòng ban: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return result;
    }

    @Override
    public int getTotalEmployeeCount() {
        Connection conn = null;
        CallableStatement callStmt = null;
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call GetTotalEmployeeCount(?,?)}");
            callStmt.registerOutParameter(1, Types.INTEGER);
            callStmt.registerOutParameter(2, Types.INTEGER);
            callStmt.execute();
            if (callStmt.getInt(2) == 1) {
                return callStmt.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy tổng số nhân viên: " + e.getMessage());
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
    public Department getDepartmentWithMostEmployees() {
        Connection conn = null;
        CallableStatement callStmt = null;
        Department dept = null;
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call GetDepartmentWithMostEmployees(?)}");
            callStmt.registerOutParameter(1, Types.INTEGER);
            ResultSet rs = callStmt.executeQuery();
            if (callStmt.getInt(1) == 1 && rs.next()) {
                dept = new Department();
                dept.setDepartmentId(rs.getInt("department_id"));
                dept.setDepartmentName(rs.getString("department_name"));
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy phòng ban có nhiều nhân viên nhất: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return dept;
    }

    @Override
    public Department getDepartmentWithHighestSalary() {
        Connection conn = null;
        CallableStatement callStmt = null;
        Department dept = null;
        try {
            conn = ConnectionDB.openConnection();
            callStmt = conn.prepareCall("{call GetDepartmentWithHighestSalary(?)}");
            callStmt.registerOutParameter(1, Types.INTEGER);
            ResultSet rs = callStmt.executeQuery();
            if (callStmt.getInt(1) == 1 && rs.next()) {
                dept = new Department();
                dept.setDepartmentId(rs.getInt("department_id"));
                dept.setDepartmentName(rs.getString("department_name"));
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi lấy phòng ban có tổng lương cao nhất: " + e.getMessage());
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            ConnectionDB.closeConnection(conn, callStmt);
        }
        return dept;
    }
}