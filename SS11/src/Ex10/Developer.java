package Ex10;

class Developer extends Employee {
    public Developer(String name, double salary) {
        super(name, salary);
    }
    @Override
    public String work() {
        return "Lập trình viên " + name + " (Lương: $" + salary + ") đang viết code cho hệ thống mới";
    }
    @Override
    public String takeVacation() {
        return "Lập trình viên " + name + " (Lương: $" + salary + ") đang đi nghỉ phép ở Bali.";
    }
}