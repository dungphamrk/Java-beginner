package entity;

import util.Validator;

import java.time.LocalDateTime;
import java.util.Scanner;

class Schedule implements IApp {
    static int autoId = 1;
    int scheduleId;
    int classroomId;
    LocalDateTime startTime;
    LocalDateTime endTime;

    public Schedule(int scheduleId, int classroomId, LocalDateTime startTime, LocalDateTime endTime) {
        this.scheduleId = scheduleId;
        this.classroomId = classroomId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static int getAutoId() {
        return autoId;
    }

    public static void setAutoId(int autoId) {
        Schedule.autoId = autoId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public void inputData(Scanner scanner) {
        this.scheduleId = autoId++;
        classroomId = Validator.validateInt("Nhập mã lớp học: ", scanner, 1);

        while (true) {
            try {
                System.out.print("Nhập thời gian bắt đầu (yyyy-MM-dd HH:mm:ss): ");
                startTime = LocalDateTime.parse(scanner.nextLine().trim().replace(" ", "T"));
                System.out.print("Nhập thời gian kết thúc (yyyy-MM-dd HH:mm:ss): ");
                endTime = LocalDateTime.parse(scanner.nextLine().trim().replace(" ", "T"));
                if (endTime.isAfter(startTime)) break;
                System.out.println("Thời gian kết thúc phải sau thời gian bắt đầu!");
            } catch (Exception e) {
                System.out.println("Định dạng không hợp lệ. Vui lòng nhập đúng định dạng yyyy-MM-dd HH:mm:ss");
            }
        }
    }

    public void display() {
        System.out.println("Mã lịch: " + scheduleId + ", Lớp: " + classroomId + ", Bắt đầu: " + startTime + ", Kết thúc: " + endTime);
    }
}
