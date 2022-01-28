package unit_4.homework4_1.task412;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        while (true) {

            System.out.println("\nВведите информацию о сотруднике через пробел "
                    + "(фамилия имя возраст пол образование должность отдел)");

            try {
                Employee emp = inputEmployee();
                if (employeeList.contains(emp)) {
                    Employee.counter--;
                    throw new DuplicateEmployeeException();
                }
                employeeList.add(emp);
            } catch (DuplicateEmployeeException | IllegalArgumentException | InputMismatchException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("\nЕсли хотите закончить ввод данных, введите end, или нажмите enter для продолжения.");
            String input = scanner.nextLine();
            if ("end".equals(input) || "утв".equals(input)) {
                break;
            }
        }

        if (employeeList.size() != 0) {

            printEmployeeList(employeeList);

            while (true) {

                System.out.println("\nНажмите enter если хотите внести изменения или введите end для выхода.");
                String input = scanner.nextLine();
                if ("end".equals(input) || "утв".equals(input)) {
                    break;
                }

                System.out.println("Введите № сотрудника, данные которого хотите изменить:");

                try {
                    int counter = 0;
                    int empIndex = searchById(employeeList);
                    if (empIndex != -1) {
                        while (counter < Employee.FIELDS.length) {
                            changeField(employeeList, empIndex, counter);
                            counter++;
                        }
                    } else {
                        System.out.println("\nСотрудника с таким номером нет!");
                    }
                    scanner.nextLine();
                } catch (NameIsInvalidException | AgeIsInvalidException e) {
                    System.out.println(e.getMessage());
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("\nВы ввели не число!");
                    scanner.nextLine();
                }

                printEmployeeList(employeeList);

            }
        }
        System.out.println("\nЗавершение работы...");
    }


    static Employee inputEmployee() {
        String input = scanner.nextLine().trim();
        if (!input.matches("([а-яА-ЯёЁ_-]+\\s+){2}\\d+\\s+([а-яА-ЯёЁ-]+\\s+){2}([a-zA-Zа-яА-ЯёЁ_-]+\\s+).+")) {
            throw new InputMismatchException("\nОшибка ввода данных!"
                    + "\nВведите фамилию и имя в буквенном формате, а возраст в числовом. Например:"
                    + "\n<Иванова Светлана 21 женский высшее инженер СУ-2>,"
                    + "\nдля составных имен можно использовать '_' и '-'.");
        }
        String[] temp = input.split("\\s+");
        return new Employee(temp);
    }

    static void printEmployeeList(List<Employee> employeeList) {
        System.out.print("\nСписок сотрудников:\n№  ");
        for (String field : Employee.FIELDS) {
            System.out.printf("%-15s", field);
        }
        System.out.println();
        for (Employee employee : employeeList) {
            System.out.printf("%s%n", employee.toString());
        }
    }

    static int searchById(List<Employee> employeeList) {
        int id = scanner.nextInt();
        for (Employee employees : employeeList) {
            if (employees.getID() == id) {
                return employeeList.indexOf(employees);
            }
        }
        return -1;
    }
//        static int searchBySurname(List<Employee> employeeList) {
//        String surname = scanner.next();
//        String name = scanner.next();
//
//        for (Employee employees : employeeList) {
//            if (employees.getSurname().equals(surname) && employees.getName().equals(name)) {
//                return employeeList.indexOf(employees);
//            }
//        }
//        return -1;

    static void changeField(List<Employee> employeeList, int empIndex, int counter) {
        System.out.printf("\nХотите изменить поле <%s> сорудника? (д)а / (н)ет: ", Employee.FIELDS[counter]);
        String input = scanner.next();
        if ("д".equals(input) || "l".equals(input)) {
            System.out.println("\nВведите новое значение поля <" + Employee.FIELDS[counter] + "> и нажмите enter: ");
            switch (Employee.FIELDS[counter]) {
                case "Фамилия":
                    employeeList.get(empIndex).setSurname(scanner.next());
                    break;
                case "Имя":
                    employeeList.get(empIndex).setName(scanner.next());
                    break;
                case "Возраст":
                    employeeList.get(empIndex).setAge(scanner.nextInt());
                    break;
                case "Пол":
                    employeeList.get(empIndex).setGender(scanner.next());
                    break;
                case "Образование":
                    employeeList.get(empIndex).setEducation(scanner.next());
                    break;
                case "Должность":
                    employeeList.get(empIndex).setPosition(scanner.next());
                    break;
                case "Отдел":
                    employeeList.get(empIndex).setDivision(scanner.next());
                    break;
            }
            System.out.println("\nИзмененные данные: \n" + employeeList.get(empIndex).toString());
        }
    }
}
