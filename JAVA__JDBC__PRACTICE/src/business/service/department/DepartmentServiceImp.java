package business.service.department;

import business.dao.department.DepartmentDao;
import business.dao.department.DepartmentDaoImp;
import business.model.Department;

import java.util.List;

public class DepartmentServiceImp implements DepartmentService {
    private final DepartmentDao departmentDao;

    public DepartmentServiceImp() {
        departmentDao = new DepartmentDaoImp();
    }
    @Override
    public List<Department> findAllWithPaging(int  page, int size) {
        return departmentDao.findAllWithPaging(page, size);
    }

    @Override
    public int save(Department department) {
        return departmentDao.save(department);
    }

    @Override
    public int update(Department department) {
        return departmentDao.update(department);
    }

    @Override
    public int delete(Department department) {
        return departmentDao.delete(department);
    }

    @Override
    public List<Department> searchByName(String name) {
        return departmentDao.searchByName(name);
    }
}