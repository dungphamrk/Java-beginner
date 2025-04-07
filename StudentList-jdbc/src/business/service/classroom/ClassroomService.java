package business.service.classroom;

import business.model.ClassRoom;
import business.model.Student;
import business.service.AppService;

import java.util.List;

public interface ClassroomService extends AppService<ClassRoom> {
    ClassRoom findById(int id);

    List<Student> getStudentsInClassroom(int classroomId);

    int countStudentsByAgeRange(int classroomId, int minAge, int maxAge);

    int countStudentsByStatus(int classroomId, boolean status);
}