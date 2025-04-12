package business.service.employee;

import business.dao.employee.EmployeeDao;
import business.dao.employee.EmployeeDaoImp;
import business.model.Department;
import business.model.Employee;

import java.util.List;
import java.util.Map;

public class EmployeeServiceImp implements EmployeeService {
    private final EmployeeDao employeeDao;

    public EmployeeServiceImp() {
        employeeDao = new EmployeeDaoImp();
    }
    @Override
    public List<Employee> findAllWithPaging() {
        return employeeDao.findAll();
    }

    @Override
    public int save(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    public boolean update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public boolean delete(Employee employee) {
        return employeeDao.delete(employee);
    }

    @Override
    public List<Employee> searchByName(String name) {
        return employeeDao.searchByName(name);
    }

    @Override
    public List<Employee> searchByAgeRange(int minAge, int maxAge) {
        return employeeDao.searchByAgeRange(minAge, maxAge);
    }

    @Override
    public List<Employee> sortBySalaryDesc(int page, int size) {
        return employeeDao.sortBySalaryDesc(page, size);
    }

    @Override
    public List<Employee> sortByNameAsc(int page, int size) {
        return employeeDao.sortByNameAsc(page, size);
    }

    @Override
    public Map<Integer, Long> getEmployeeCountByDepartment() {
        return employeeDao.getEmployeeCountByDepartment();
    }

    @Override
    public int getTotalEmployeeCount() {
        return employeeDao.getTotalEmployeeCount();
    }

    @Override
    public Department getDepartmentWithMostEmployees() {
        return employeeDao.getDepartmentWithMostEmployees();
    }

    @Override
    public Department getDepartmentWithHighestSalary() {
        return employeeDao.getDepartmentWithHighestSalary();
    }
}