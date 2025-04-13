package business.dao.employee;

import business.dao.AppDao;
import business.model.Department;
import business.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeDao extends AppDao<Employee> {
    // Tìm kiếm nhân viên theo tên
    List<Employee> searchByName(String name);

    // Tìm kiếm nhân viên theo khoảng tuổi
    List<Employee> searchByAgeRange(int minAge, int maxAge);

    // Sắp xếp nhân viên theo lương giảm dần
    List<Employee> sortBySalaryDesc(int page, int size);

    // Sắp xếp nhân viên theo tên tăng dần
    List<Employee> sortByNameAsc(int page, int size);

    // Thống kê số lượng nhân viên theo phòng ban
    Map<Integer, Long> getEmployeeCountByDepartment();

    // Tổng số nhân viên
    int getTotalEmployeeCount();

    // Phòng ban có nhiều nhân viên nhất
    Department getDepartmentWithMostEmployees();

    // Phòng ban có tổng lương cao nhất
    Department getDepartmentWithHighestSalary();

    List<Employee> findAllWithPaging(int page, int size);
}