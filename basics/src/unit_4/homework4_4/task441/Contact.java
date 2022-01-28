package unit_4.homework4_4.task441;

import java.util.Objects;

public class Contact implements Comparable<Contact> {

    static final String[] FIELDS = {"имя", "фамилия", "группа"};
    private final String phone; //(Номер телефона — String);
    private String name; //(Имя — String);
    private String surname; //(Фамилия — String);
    private Group group; //(Группа — Enum).

    public Contact(String name, String surname, String phone, Group group) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.group = group;
    }

    public Contact(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(phone, contact.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone);
    }

    @Override
    public String toString() {
        return String.format("Имя: %s %s, телефон: %s, группа: %s", name, surname, phone, group);
    }

    @Override
    public int compareTo(Contact o) {
        return this.name.compareTo(o.name);
    }


}
