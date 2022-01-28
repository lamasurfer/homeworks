package unit_4.homework4_3.task432;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StudentService {

    private Set<Student> students = new HashSet<>();

    private static void checkInput(String input) {
        if (!input.matches("([ЁёА-я]+\\s+){2}([ЁёА-я]+(\\s*,\\s*))([ЁёА-я0-9\\-_]+)(\\s*,\\s*)(\\d+)")) {
            throw new IllegalArgumentException("Ошибка ввода данных!");
        }
    }

    public void addStudent(Student student) {
        if (!students.add(student)) {
            System.out.println("Студент с таким № студенческого билета уже есть!");
        } else {
            System.out.println("Добавлен новый студент.");
        }
    }

    public void addStudent(String input) {
        String[] temp = input.split("\\s*,\\s*");
        Student student = new Student(temp);
        addStudent(student);
    }

    public void addStudent(Student... students) {
        for (Student student : students) {
            addStudent(student);
        }
    }

    public void showStudents() {
        System.out.println("\nСписок студентов:");
        for (Student student : students) {
            System.out.println("- " + student);
        }
    }

    public void runUserInput(Scanner scanner) {
        while (true) {
            try {
                System.out.println("Введите информацию о студенте: "
                        + "<ФИО, номер группы, номер студенческого билета> (end для выхода):");
                String input = scanner.nextLine().trim();
                if ("end".equals(input)) break;

                checkInput(input);
                this.addStudent(input);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        if (!students.isEmpty()) this.showStudents();
        System.out.println("Завершение работы...");
    }
}
