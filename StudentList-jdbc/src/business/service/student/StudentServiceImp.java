package business.service.student;

import business.dao.student.StudentDaoImp;
import business.dao.student.StudentDao;
import business.model.Student;

import java.util.List;

public class StudentServiceImp implements StudentService {
    private final StudentDao studentDaoImp;

    public StudentServiceImp() {
        studentDaoImp = new StudentDaoImp();
    }

    @Override
    public List<Student> findAll() {
        return studentDaoImp.findAll();
    }

    @Override
    public boolean save(Student student) {
        return studentDaoImp.save(student);
    }

    @Override
    public boolean update(Student student) {
        return studentDaoImp.update(student);
    }

    @Override
    public boolean delete(Student student) {
        return studentDaoImp.delete(student);
    }

    @Override
    public Student findById(int id) {
        return studentDaoImp.findById(id);
    }

    @Override
    public int getCountStudentByStatus(boolean status) {
        return studentDaoImp.getCountStudentByStatus(status);
    }
}