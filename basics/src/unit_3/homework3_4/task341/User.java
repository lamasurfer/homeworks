package unit_3.homework3_4.task341;

public class User {
    private String login;
    private String password;
    private String email;
    private int age;

    public User() {
    }

    public User(String login, String password, String email, int age) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return login + password + email + age;
    }

}
