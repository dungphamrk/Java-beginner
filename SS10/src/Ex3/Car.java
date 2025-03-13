package Ex3;

import java.time.LocalDate;
public class Car {
    private String make;
    private String model;
    private int year;

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        if (year < LocalDate.now().getYear())
            this.year = year;
        else {
            System.out.println("năm sản xuất không được lớn hơn năm hiện tại");
        }
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }
    public int getYear() {
        return year;
    }

}


