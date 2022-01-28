package com.example.jdata_security.model.persons;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.Objects;

public class PersonId implements Serializable {

    @NotBlank(message = "{name.is.blank}")
    private String name;
    @NotBlank(message = "{surname.is.blank}")
    private String surname;
    @PositiveOrZero(message = "{age.is.invalid}")
    @Max(value = 120, message = "{age.is.too.high}")
    private int age;

    public PersonId() {
    }

    public PersonId(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonId personId = (PersonId) o;
        return age == personId.age
                && Objects.equals(name, personId.name)
                && Objects.equals(surname, personId.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    @Override
    public String toString() {
        return "PersonId{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
