// business/service/classroom/ClassroomServiceImp.java
package business.service.classroom;

import business.dao.classroom.ClassroomDao;
import business.dao.classroom.ClassroomDaoImp;
import business.model.ClassRoom;
import business.model.Student;
import java.util.List;

public class ClassroomServiceImp implements ClassroomService {
    private final ClassroomDao classroomDao;

    public ClassroomServiceImp() {
        classroomDao = new ClassroomDaoImp();
    }

    @Override
    public List<ClassRoom> findAll() {
        return classroomDao.findAll();
    }

    @Override
    public boolean save(ClassRoom classroom) {
        return classroomDao.save(classroom);
    }

    @Override
    public boolean update(ClassRoom classroom) {
        return classroomDao.update(classroom);
    }

    @Override
    public boolean delete(ClassRoom classroom) {
        return classroomDao.delete(classroom);
    }

    @Override
    public ClassRoom findById(int id) {
        return classroomDao.findById(id);
    }

    @Override
    public List<Student> getStudentsInClassroom(int classroomId) {
        return classroomDao.getStudentsInClassroom(classroomId);
    }

    @Override
    public int countStudentsByAgeRange(int classroomId, int minAge, int maxAge) {
        return classroomDao.countStudentsByAgeRange(classroomId, minAge, maxAge);
    }

    @Override
    public int countStudentsByStatus(int classroomId, boolean status) {
        return classroomDao.countStudentsByStatus(classroomId, status);
    }
}