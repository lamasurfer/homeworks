package unit_4.homework4_1.task412;

public class Employee {

    static final int MIN_AGE = 16;
    static final int MAX_AGE = 65;
    static final String[] FIELDS = {"Фамилия", "Имя", "Возраст", "Пол", "Образование", "Должность", "Отдел"};
    static int counter = 1;
    private final int ID;
    private String surname;
    private String name;
    private int age;
    private String gender;
    private String education;
    private String position;
    private String division;

    public Employee(int ID, String surname, String name, int age, String gender, String education, String position, String division) {
        this.ID = counter++;
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.education = education;
        this.position = position;
        this.division = division;
    }

    public Employee(String[] strings) {
        this.surname = strings[0];
        this.name = strings[1];
        int age = Integer.parseInt(strings[2]);
        if (!isValid(age)) throw new AgeIsInvalidException();
        this.age = age;
        this.gender = strings[3];
        this.education = strings[4];
        this.position = strings[5];
        this.division = strings[6];
        this.ID = counter++;
    }

    public int getID() {
        return ID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (!isValid(surname)) throw new NameIsInvalidException();
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!isValid(name)) throw new NameIsInvalidException();
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (!isValid(age)) throw new AgeIsInvalidException();
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    @Override
    public String toString() {
        return String.format("%-3s%-15s%-15s%-15s%-15s%-15s%-15s%-15s",
                ID, surname, name, age, gender, education, position, division);

    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) return false;

        Employee employee = (Employee) obj;
        return this.surname != null && this.surname.equals(employee.surname)
                && this.name != null && this.name.equals(employee.name)
                && this.age == employee.age
                && this.gender != null && this.gender.equals(employee.gender)
                && this.education != null && this.education.equals(employee.education)
                && this.position != null && this.position.equals(employee.position)
                && this.division != null && this.division.equals(employee.division);
    }

    public boolean isValid(int age) {
        return age >= MIN_AGE && age <= MAX_AGE;
    }

    public boolean isValid(String name) {
        return name.matches("[а-яА-ЯёЁ_-]+");
    }


}
