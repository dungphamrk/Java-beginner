package business.service.student;

import business.model.Student;
import business.service.AppService;

public interface StudentServiceImp extends AppService<Student> {
    Student findById(int id);

    int getCountStudentByStatus(boolean status);
}