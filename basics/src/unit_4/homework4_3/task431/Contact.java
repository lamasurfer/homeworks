package unit_4.homework4_3.task431;

import java.util.Objects;

public class Contact implements Comparable<Contact> {

    private final String name;
    private String number;

    public Contact(String name) {
        this.name = name;
    }

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Contact(String[] input) {
        this.name = input[0];
        this.number = input[1];
    }

    public static Contact fromStringArray(String[] input) {
        return new Contact(input[0], input[1]);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Имя: %s, телефон: +%s", name, number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(number, contact.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(Contact o) {
        return this.name.compareTo(o.name);
    }
}
