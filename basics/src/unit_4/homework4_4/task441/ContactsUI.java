package unit_4.homework4_4.task441;

import java.util.Scanner;

public class ContactsUI {

    static Scanner scanner = new Scanner(System.in);

    static String[] options = {
            "\n1. Добавить контакт",
            "2. Добавить пропущенный вызов",
            "3. Вывести все пропущенные вызовы",
            "4. Очистить пропущенные вызовы",
            "5. Удалить контакт",
            "6. Изменить контакт ",
            "0. Выход\n",
    };

    private static void inputNewContact(ContactsService contactsService) {
        System.out.println("Введите имя, фамилию, номер и группу нового контакта: ");
        Group.showGroups();
        String input = scanner.nextLine().replaceAll("[()+\\-]*", "");
        checkContactInput(input);
        String[] contactFields = input.split("\\s+");
        Group group = Group.getByDescription(contactFields[3].trim());
        Contact contact = new Contact(contactFields[0].trim(), contactFields[1].trim(), contactFields[2].trim(), group);
        contactsService.addContact(contact);
        contactsService.showPhoneContacts();
    }

    private static void inputMissedCall(MissedCalls missedCalls) {
        System.out.println("Введите номер пропущенного вызова: ");
        String input = scanner.nextLine().replaceAll("[()+\\-\\s]*", "");
        if (checkNumber(input)) {
            missedCalls.addMissedCall(input);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static void deleteContact(ContactsService contactsService) {
        contactsService.showPhoneContacts();
        System.out.println("Введите имя и фамилию удаляемого контакта через пробел или введите его номер:");
        String input = scanner.nextLine().trim();
        if (checkName(input)) {
            String[] contactNames = input.split("\\s+");
            contactsService.deleteByName(contactNames);
        } else if (checkNumber(input)) {
            contactsService.deleteByNumber(input);
        } else {
            throw new IllegalArgumentException();
        }
        contactsService.showPhoneContacts();
    }

    private static void changeContact(ContactsService contactsService) {
        contactsService.showPhoneContacts();
        System.out.println("Введите имя и фамилию изменяемого контакта через пробел или введите его номер:");
        String input = scanner.nextLine().trim();
        Contact contact = getOldContact(contactsService, input);
        if (contact != null) {
            changeContactFields(contact);
            contactsService.showPhoneContacts();
        } else {
            System.out.println("Такого контакта нет!");
        }
    }

    private static void changeContactFields(Contact contact) {
        int counter = 0;
        while (counter < Contact.FIELDS.length) {
            System.out.printf("Хотите изменить значение <%s> контакта: (да/нет)", Contact.FIELDS[counter]);
            String input = scanner.nextLine().trim();
            if (input.matches("д(а)*|l(f)*")) {
                switch (Contact.FIELDS[counter]) {
                    case "имя":
                        System.out.printf("Новое <%s>", Contact.FIELDS[counter]);
                        input = scanner.nextLine();
                        contact.setName(input);
                        break;
                    case "фамилия":
                        System.out.printf("Новая <%s>", Contact.FIELDS[counter]);
                        input = scanner.nextLine();
                        contact.setSurname(input);
                        break;
                    case "группа":
                        System.out.printf("Новая <%s>", Contact.FIELDS[counter]);
                        Group.showGroups();
                        input = scanner.nextLine();
                        if (input.matches("([Сс]емья|[Рр]абота|[Дд]рузья)")) {
                            Group group = Group.getByDescription(input);
                            contact.setGroup(group);
                        } else {
                            throw new IllegalArgumentException();
                        }
                        break;
                }
            }
            counter++;
        }
    }

    private static Contact getOldContact(ContactsService contactsService, String input) {
        if (checkName(input)) {
            String[] temp = input.split("\\s+");
            return contactsService.contactByName(temp);
        } else if (checkNumber(input)) {
            return contactsService.contactByNumber(input);
        }
        throw new IllegalArgumentException();
    }

    private static void checkContactInput(String input) {
        if (!input.matches("([A-Za-zЁёА-я]+\\s+){2}"
                + "((\\+*7|8)(\\(*[\\d]{3}\\)*)-*([\\d]{3})-*([\\d]{2})-*([\\d]{2}))\\s+"
                + "([Сс]емья|[Рр]абота|[Дд]рузья)")) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean checkName(String input) {
        String regex = "[A-Za-zЁёА-я]+\\s+[A-Za-zЁёА-я]+\\s*";
        return input.matches("[A-Za-zЁёА-я]+\\s+[A-Za-zЁёА-я]+\\s*");
    }

    private static boolean checkNumber(String input) {
        return input.matches("(\\+*7|8)(\\(*[\\d]{3}\\)*)-*([\\d]{3})-*([\\d]{2})-*([\\d]{2})");
    }

    private static void showOptions() {
        for (String option : options) {
            System.out.println(option);
        }
    }

    public void runUI() {

        ContactsService contactsService = new ContactsService();
        MissedCalls missedCalls = new MissedCalls();

        while (true) {
            showOptions();
            System.out.println("Выберите действие:");
            try {
                String input = scanner.nextLine();
                switch (input) {
                    case "1":
                        inputNewContact(contactsService);
                        break;
                    case "2":
                        inputMissedCall(missedCalls);
                        break;
                    case "3":
                        missedCalls.showMissedCalls(contactsService);
                        break;
                    case "4":
                        missedCalls.deleteMissedCalls();
                        break;
                    case "5":
                        if (!contactsService.isEmpty()) {
                            deleteContact(contactsService);
                        }
                        break;
                    case "6":
                        if (!contactsService.isEmpty()) {
                            changeContact(contactsService);
                        }
                        break;
                    case "0":
                        System.out.println("Завершение работы...");
                        return;
                    default:
                        System.out.println("Повторите выбор.");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка ввода данных!");
            }
        }
    }
}
