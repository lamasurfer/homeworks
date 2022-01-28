package unit_4.homework4_3.task431;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactInputService {

    static Scanner scanner = new Scanner(System.in);

    private static Contact formatContact(String input) {
        String[] temp = input.split("\\s+[+*\\d]");
        return Contact.fromStringArray(temp);
    }

    private static void checkContactInput(String input) {
        if (!input.matches("([A-Za-zЁёА-я]+\\s+){1,2}([0-9\\-+()]+)")) {
            throw new IllegalArgumentException("Ошибка ввода данных!");
        }
    }

    private static void checkGroups(ContactsService cS, List<String> temp) {
        for (String group : temp) {
            if (!cS.checkGroup(group)) {
                System.out.printf("%nГруппы <%s> нет, добавить? (да/нет) %n", group);
                String input = scanner.nextLine();
                if ("да".equals(input)) {
                    cS.addGroup(group);
                } else {
                    temp.remove(group);
                }
            }
        }
    }

    public void runUserInput() {

        ContactsService contactsService = new ContactsService();

        System.out.println("Введите название группы контактов:");
        String input = scanner.nextLine().trim();
        do {
            contactsService.addGroup(input);
            System.out.println("Создать еще одну группу (введите название или введите нет)?");
            input = scanner.nextLine().trim();
        } while (!"нет".equals(input));

        while (true) {
            try {
                System.out.println("Создать контакт (введите наименование и его номер или введите нет)?");
                input = scanner.nextLine().trim();
                if ("нет".equals(input)) break;
                checkContactInput(input);
                Contact contact = formatContact(input);

                contactsService.showGroups();

                System.out.println("Укажите группы контакта через пробел: ");
                input = scanner.nextLine().trim();
                //String[] temp = input.split("\\s+");
                List<String> temp = new ArrayList<>(Arrays.asList(input.split("\\s+")));
                checkGroups(contactsService, temp);
                contactsService.addContact(temp, contact);
                contactsService.showPhoneContacts();


            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        contactsService.showPhoneContacts();
        System.out.println("Завершение работы...");
    }
}

