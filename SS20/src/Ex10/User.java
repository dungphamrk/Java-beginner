package Ex10;

import java.time.LocalDate;
import java.util.Optional;

public class User {
    private int id;
    private String name;
    Optional<String> email;

    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = Optional.ofNullable(email);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return email;
    }
    @Override
    public String toString() {
        return "Tên: " + name + "\n" +
                "Email: " + email.orElse("Không có email");
    }
}