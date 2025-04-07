package business.dao.classroom;

import business.dao.AppDAO;
import business.model.ClassRoom;
import business.model.Student;

import java.util.List;

public interface ClassroomDao extends AppDAO<ClassRoom> {
    ClassRoom findById(int id);

    List<Student> getStudentsInClassroom(int classroomId);

    int countStudentsByAgeRange(int classroomId, int minAge, int maxAge);

    int countStudentsByStatus(int classroomId, boolean status);
}