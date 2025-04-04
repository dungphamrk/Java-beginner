package Ex1;

class Account {
    private int id;
    private String name;
    private int age;

    private static Account instance = null;

    private Account() {
        this.id = 1;
        this.name = "Default User";
        this.age = 25;
    }

    public static Account getInstance() {
        if (instance == null) {
            instance = new Account();
        }
        return instance;
    }

    // Các getter và setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
