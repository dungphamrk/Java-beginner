package Ex7;

public class GraduateStudent extends Student {
    String researchTopic;
    String supervisorName;
    public GraduateStudent(String name, String id, double gpa, String researchTopic, String supervisorName) {
        super(name, id, gpa);
        this.researchTopic = researchTopic;
        this.supervisorName = supervisorName;
    }

    public String getSupervisorName() {
        return supervisorName;
    }

    public void setSupervisorName(String supervisorName) {
        if(supervisorName.equals("")){
            System.out.println("Tên ko phù hợp! Câu lệnh sẽ ko được thực thi");
            return;
        }
        this.supervisorName = supervisorName;
    }

    public String getResearchTopic() {
        return researchTopic;
    }

    public void setResearchTopic(String researchTopic) {
        if(researchTopic.equals("")){
            System.out.println("Tên đề tài ko phù hợp! Câu lệnh sẽ ko được thực thi");
            return;
        }
        this.researchTopic = researchTopic;
    }

    @Override
    public void getDetails(){
        System.out.println("Tên: " + name);
        System.out.println("ID: " + id);
        System.out.println("GPA: " + gpa);
        System.out.println("Đề tài: " + researchTopic);
        System.out.println("Giảng viên hướng dẫn: " + supervisorName);
    }

}
