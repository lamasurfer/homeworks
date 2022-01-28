package unit_1.homework1_6;

import java.time.LocalDate;

public class Author {
    public String name;
    public String surname;
    public LocalDate birthday;
    public String origin;

    public Author() {
    }  // "явный" конструктор по умолчанию

    public Author(String name, String surname, LocalDate birthday, String origin) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.origin = origin;
    }

    public String toString() {
        return "\nАвтор " + name + " " + surname + ". Родился " + birthday + " в стране " + origin;
    }
}

