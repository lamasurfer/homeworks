package unit_4.homework4_1.task411;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        List<String> tasks = new ArrayList<>();

        while (true) {

            showOptions();
            String input = scanner.nextLine();

            try {
                switch (input) {
                    case "1":
                        addTask(tasks);
                        break;
                    case "2":
                        if (!listIsEmpty(tasks)) showTaskList(tasks);
                        break;
                    case "3":
                        removeTask(tasks);
                        break;
                    case "4":
                        renameTask(tasks);
                        break;
                    case "5":
                        addTaskTo(tasks);
                        break;
                    case "6":
                        swapTasks(tasks);
                        break;
                    case "0":
                        System.out.println("\nЗавершение работы...");
                        return;
                    default:
                        System.out.println("\nПовторите выбор.");
                        break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Такой задачи нет!");
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число!");
            }
        }
    }

    static void showOptions() {
        System.out.println("\nВыберите действие:"
                + "\n1. Добавить задачу"
                + "\n2. Вывести список задач"
                + "\n3. Удалить задачу"
                + "\n4. Переименовать задачу"
                + "\n5. Добавить задачу перед другой задачей"
                + "\n6. Поменять задачи местами"
                + "\n0. Выход"
                + "\n");
    }

    static void showTaskList(List<String> tasks) {
        System.out.println("\nСписок задач:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.printf("Задача №%d %s%n", i + 1, tasks.get(i));
        }
    }

    static void addTask(List<String> tasks) {
        System.out.println("\nВведите название задачи (для отмены введите end)");
        String task = scanner.nextLine();
        if ("end".equals(task)) {
            return;
        }
        tasks.add(task);
        System.out.println("\nЗадача добавлена.");

        showTaskList(tasks);
    }

    static void removeTask(List<String> tasks) {
        if (listIsEmpty(tasks)) return;

        showTaskList(tasks);

        System.out.println("\nВведите номер удаляемой задачи (для отмены введите end)");
        String task = scanner.next();
        scanner.nextLine();
        if ("end".equals(task)) {
            return;
        }

        int taskNumber;
        taskNumber = Integer.parseInt(task) - 1;
        tasks.remove(taskNumber);
        System.out.println("\nЗадача удалена.");

        if (!listIsEmpty(tasks)) showTaskList(tasks);

    }

    static void renameTask(List<String> tasks) {
        if (listIsEmpty(tasks)) return;

        showTaskList(tasks);

        System.out.println("\nВведите номер изменяемой задачи (для отмены введите end)");
        String task = scanner.next();
        scanner.nextLine();
        if ("end".equals(task)) {
            return;
        }

        int taskNumber;
        taskNumber = Integer.parseInt(task) - 1;
        if (taskNumber < 0 || taskNumber >= tasks.size()) {
            throw new IndexOutOfBoundsException();
        }
        System.out.println("\nВведите новое название задачи:");
        String name = scanner.nextLine();
        tasks.set(taskNumber, name);
        System.out.println("\nЗадача переименована.");

        showTaskList(tasks);

    }

    static void addTaskTo(List<String> tasks) {
        if (listIsEmpty(tasks)) return;

        showTaskList(tasks);

        System.out.println("\nВведите номер задачи, перед которой хотите поместить новую задачу "
                + "(для отмены введите end)");
        String task = scanner.next();
        scanner.nextLine();
        if ("end".equals(task)) {
            return;
        }

        int taskIndex;
        taskIndex = Integer.parseInt(task) - 1;
        if (taskIndex < 0 || taskIndex >= tasks.size()) {
            throw new IndexOutOfBoundsException();
        }
        System.out.println("\nВведите название задачи:");
        String name = scanner.nextLine();
        tasks.add(taskIndex, name);
        System.out.println("\nЗадача добавлена.");

        showTaskList(tasks);

    }

    static void swapTasks(List<String> tasks) {
        if (tasks.isEmpty() || tasks.size() < 2) {
            System.out.println("\nСлишком мало задач...");
            return;
        }
        showTaskList(tasks);

        System.out.println("\nВведите номер первой задачи (для отмены введите end)");
        String task = scanner.next();
        scanner.nextLine();
        if ("end".equals(task)) {
            return;
        }
        int firstTaskIndex = Integer.parseInt(task) - 1;
        if (firstTaskIndex < 0 || firstTaskIndex >= tasks.size()) {
            throw new IndexOutOfBoundsException();
        }
        System.out.println("\nВведите номер второй задачи");
        task = scanner.next();
        scanner.nextLine();
        int secondTaskIndex = Integer.parseInt(task) - 1;

        String temp = tasks.get(firstTaskIndex);
        tasks.set(firstTaskIndex, tasks.get(secondTaskIndex));
        tasks.set(secondTaskIndex, temp);

        showTaskList(tasks);
    }

    static boolean listIsEmpty(List<String> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("\nЗадач пока нет...");
            return true;
        }
        return false;
    }
}

