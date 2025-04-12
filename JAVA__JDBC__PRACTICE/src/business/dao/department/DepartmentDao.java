package business.dao.department;

import business.dao.AppDao;
import business.model.Department;

import java.util.List;

public interface DepartmentDao extends AppDao<Department> {
    // Tìm kiếm phòng ban theo tên
    List<Department> searchByName(String name);

    // Lấy danh sách phòng ban với phân trang
    List<Department> findAllWithPaging(int page, int size);
}