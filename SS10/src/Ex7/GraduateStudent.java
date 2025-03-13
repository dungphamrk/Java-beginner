package Ex7;

public class GraduateStudent extends Student {
    String researchTopic;
    String supervisorName;
    public GraduateStudent(String name, String id, double gpa, String researchTopic, String supervisorName) {
        super(name, id, gpa);
        this.researchTopic = researchTopic;
        this.supervisorName = supervisorName;
    }
}
