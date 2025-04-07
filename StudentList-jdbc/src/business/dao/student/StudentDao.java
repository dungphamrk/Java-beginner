package business.dao.student;

import business.dao.AppDAO;
import business.model.Student;

public interface StudentDao extends AppDAO<Student> {
    int getCountStudentByStatus(boolean status);

    Student findById(int id);
}