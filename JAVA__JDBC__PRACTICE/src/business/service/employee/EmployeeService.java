package business.service.employee;

import business.model.Department;
import business.model.Employee;
import business.service.AppService;

import java.util.List;
import java.util.Map;

public interface EmployeeService extends AppService<Employee> {
    List<Employee> findAllWithPaging();
    List<Employee> searchByName(String name);
    List<Employee> searchByAgeRange(int minAge, int maxAge);
    List<Employee> sortBySalaryDesc(int page, int size);
    List<Employee> sortByNameAsc(int page, int size);
    Map<Integer, Long> getEmployeeCountByDepartment();
    int getTotalEmployeeCount();
    Department getDepartmentWithMostEmployees();
    Department getDepartmentWithHighestSalary();
}