package business;

import entity.*;

import java.util.ArrayList;
import java.util.List;

public class UniversityData {
    private List<Course> courses = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<ClassRoom> classRooms = new ArrayList<>();
    private List<CourseRegistration> registrations = new ArrayList<>();

    public List<Course> getCourses() {
        return courses;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<ClassRoom> getClassRooms() {
        return classRooms;
    }

    public List<CourseRegistration> getRegistrations() {
        return registrations;
    }
}