package com.example.jdata_security.model.persons;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
@IdClass(PersonId.class)
public class Person {

    @Id
    @NotBlank(message = "{name.is.blank}")
    private String name;
    @Id
    @NotBlank(message = "{surname.is.blank}")
    private String surname;
    @Id
    @PositiveOrZero(message = "{age.is.invalid}")
    @Max(value = 120, message = "{age.is.too.high}")
    private int age;
    private String phoneNumber;
    private String cityOfLiving;

    protected Person() {
    }

    public Person(String name, String surname, int age, String phoneNumber, String cityOfLiving) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.cityOfLiving = cityOfLiving;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCityOfLiving() {
        return cityOfLiving;
    }

    public void setCityOfLiving(String cityOfLiving) {
        this.cityOfLiving = cityOfLiving;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cityOfLiving='" + cityOfLiving + '\'' +
                '}';
    }
}
