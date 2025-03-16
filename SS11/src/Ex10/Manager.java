package Ex10;

class Manager extends Employee implements AttendMeeting {
    public Manager(String name, double salary) {
        super(name, salary);
    }
    @Override
    public String work() {
        return "Quản lý " + name + " (Lương: $" + salary + ") đang giám sát dự án";
    }

    @Override
    public String takeVacation() {
        return "Quản lý " + name + " (Lương: $" + salary + ") đang đi nghỉ phép tại Pháp.";
    }

    @Override
    public String attendMeeting() {
        return "Quản lý " + name + " (Lương: $" + salary + ") đang tham gia cuộc họp";
    }
}