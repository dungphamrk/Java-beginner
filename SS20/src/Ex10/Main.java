package Ex10;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        User u1 = new User(1, "Quý", "quy@example.com");
        User u2 = new User(2, "Lan", null);
        User u3 = new User(3, "Huyền", "huyen@example.com");

        List<Task> tasks = List.of(
                new Task(1, "Viết báo cáo", u1, LocalDate.of(2025, 3, 20), false),
                new Task(2, "Thiết kế slide", u1, LocalDate.of(2025, 3, 25), true),
                new Task(3, "Họp nhóm", u2, LocalDate.of(2025, 3, 18), false),
                new Task(4, "Nộp tài liệu", u3, LocalDate.of(2025, 3, 22), true),
                new Task(5, "Chuẩn bị thuyết trình", u2, LocalDate.of(2025, 3, 19), true)
        );

        LocalDate today = LocalDate.of(2025, 3, 23);

        System.out.println("=== Công việc quá hạn chưa hoàn thành ===");
        tasks.stream()
                .filter(task -> !task.isCompleted() && task.getDueDate().isBefore(today))
                .forEach(System.out::println);

        long completedTasks = tasks.stream()
                .filter(Task::isCompleted)
                .count();
        System.out.println("Tổng số công việc đã hoàn thành: " + completedTasks);
        System.out.println("=== Thống kê công việc theo người dùng ===");
        List<User> users = List.of(u1, u2, u3);
        for (User user : users) {
            long totalTasks = tasks.stream()
                    .filter(task -> task.getAssignedTo().equals(user))
                    .count();
            long overdueTasks = tasks.stream()
                    .filter(task -> task.getAssignedTo().equals(user))
                    .filter(task -> !task.isCompleted())
                    .filter(task -> task.getDueDate().isBefore(today))
                    .count();
            System.out.println(user.toString());
            System.out.println("Tổng công việc: " + totalTasks + " | Quá hạn: " + overdueTasks);
            System.out.println("---");
        }
    }
}