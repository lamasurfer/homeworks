package unit_4.homework4_4.task443;

import java.util.Objects;

public class User implements Comparable<User> {

    private final String id;
    private String surname;
    private String name;
    private String secondName;
    private String address;


    public User(String id, String surname, String name, String secondName, String address) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.secondName = secondName;
        this.address = address;
    }

    public User(String[] temp) {
        this.id = temp[1];
        String name = temp[2];
        String[] names = name.split("\\s");
        this.surname = names[0];
        this.name = names[1];
        this.secondName = names[2];
        this.address = temp[3].replaceAll(",", ", ");
    }

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%nФИО: %s %s %s%nАдрес: %s", surname, name, secondName, address);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    @Override
    public int compareTo(User o) {
        return this.id.compareTo(o.id);
    }
}
