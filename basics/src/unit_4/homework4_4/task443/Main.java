package unit_4.homework4_4.task443;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        File file = new File("src/unit_4/homework4_4/task443/resources/users.db");
        File file2 = new File("src/unit_4/homework4_4/task443/resources/server.log");
        Investigation investigation = new Investigation();

        Scanner scanner_users = null;
        Scanner scanner_logs = null;

        try {
            scanner_users = new Scanner(file);
            scanner_logs = new Scanner(file2);
            investigation.automate(scanner_users, scanner_logs);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
        } finally {
            if (scanner_users != null) scanner_users.close();
            if (scanner_logs != null) scanner_logs.close();
        }


    }
}
