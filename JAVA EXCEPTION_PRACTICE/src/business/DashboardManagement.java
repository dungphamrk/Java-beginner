package business;

import entity.ClassRoom;
import entity.Course;
import entity.CourseRegistration;
import entity.Student;
import entity.Teacher;

import java.util.Comparator;
import java.util.List;

public class DashboardManagement {
    private List<Student> students;
    private List<Teacher> teachers;
    private List<Course> courses;
    private List<ClassRoom> classRooms;
    private List<CourseRegistration> registrations;

    public DashboardManagement(List<Student> students, List<Teacher> teachers, List<Course> courses,
                               List<ClassRoom> classRooms, List<CourseRegistration> registrations) {
        this.students = students;
        this.teachers = teachers;
        this.courses = courses;
        this.classRooms = classRooms;
        this.registrations = registrations;
    }

    public void showStats() {
        System.out.println("Số sinh viên: " + students.size());
        System.out.println("Số giảng viên: " + teachers.size());
        System.out.println("Số khóa học: " + courses.size());
        System.out.println("Số lớp học: " + classRooms.size());
    }

    public void top3Courses() {
        courses.stream()
                .sorted(Comparator.comparingInt((Course c) -> (int) registrations.stream()
                        .filter(r -> r.getCourseId().equals(c.getCourseId()) && "ENROLLED".equals(r.getStatus()))
                        .count()).reversed())
                .limit(3)
                .forEach(c -> System.out.println(c.getCourseId() + " - " + c.getCourseName() + " - " +
                        registrations.stream()
                                .filter(r -> r.getCourseId().equals(c.getCourseId()) && "ENROLLED".equals(r.getStatus()))
                                .count()));
    }

    public void top3ClassRooms() {
        classRooms.stream()
                .sorted(Comparator.comparingInt((ClassRoom c) -> c.getListStudents().size()).reversed())
                .limit(3)
                .forEach(c -> System.out.println(c.getClassroomId() + " - " + c.getClassRoomName() + " - " + c.getListStudents().size()));
    }

    public void top3Teachers() {
        teachers.stream()
                .sorted(Comparator.comparingInt((Teacher t) -> (int) classRooms.stream()
                        .filter(c -> c.getTeacherId() == t.getTeacherId())
                        .mapToInt(c -> c.getListStudents().size())
                        .sum()).reversed())
                .limit(3)
                .forEach(t -> System.out.println(t.getTeacherId() + " - " + t.getName() + " - " +
                        classRooms.stream()
                                .filter(c -> c.getTeacherId() == t.getTeacherId())
                                .mapToInt(c -> c.getListStudents().size())
                                .sum()));
    }

    public void top3Students() {
        students.stream()
                .sorted(Comparator.comparingInt((Student s) -> (int) registrations.stream()
                        .filter(r -> r.getStudentId().equals(s.getStudentId()))
                        .count()).reversed())
                .limit(3)
                .forEach(s -> System.out.println(s.getStudentId() + " - " + s.getName() + " - " +
                        registrations.stream()
                                .filter(r -> r.getStudentId().equals(s.getStudentId()))
                                .count()));
    }
}