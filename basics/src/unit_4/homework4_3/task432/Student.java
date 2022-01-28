package unit_4.homework4_3.task432;

import java.util.Objects;

public class Student {

    private final String studentId;
    private String name;
    private String group;

    public Student(String name, String group, String studentId) {
        this.name = name;
        this.group = group;
        this.studentId = studentId;
    }

    public Student(String[] temp) {
        this.name = temp[0];
        this.group = temp[1];
        this.studentId = temp[2];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId.equals(student.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", name, group, studentId);
    }
}
