package unit_4.homework4_3.task432;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();
        studentService.runUserInput(scanner);

        System.out.println();
        StudentService studentService1 = new StudentService();

        Student student1 = new Student("Иванов Иван Иванович", "1243-Б", "001");
        Student student2 = new Student("Иванов Иван Иванович", "1243-Б", "001");
        Student student3 = new Student("Иванов Иван Иванович", "1243-Б", "002");
        Student student4 = new Student("Сергеев Семен Игнатьевич", "1243-Б", "003");

        studentService1.addStudent(student1, student2, student3, student4);
        studentService1.addStudent(student1);
        studentService1.showStudents();

    }
}
