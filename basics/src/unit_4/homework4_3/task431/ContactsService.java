package unit_4.homework4_3.task431;

import java.util.*;


public class ContactsService {

    private Map<String, List<Contact>> phoneContacts = new HashMap<>();

    public void addGroup(String input) {
        if (!checkGroup(input)) {
            phoneContacts.put(input, new ArrayList<>());
        } else {
            System.out.printf("%nГруппа <%s> уже добавлена!%n", input);
        }
    }

    public void addContact(String input, Contact contact) {
        if (!checkGroup(input)) addGroup(input);
        List<Contact> temp = phoneContacts.get(input);
        int pos = Math.abs(Collections.binarySearch(temp, contact)) - 1;
        if (Collections.binarySearch(temp, contact) < 0) {
            temp.add(pos, contact);
            phoneContacts.put(input, temp);
        } else {
            System.out.printf("%nКонтакт <%s> уже есть в группе <%s>!%n", contact, input);
        }

    }

    public void addContact(List<String> inputs, Contact contact) {
        for (String input : inputs) {
            addContact(input, contact);
        }
    }

    public void showGroups() {
        System.out.println("Доступные группы:");
        for (String s : phoneContacts.keySet()) {
            System.out.println("- " + s);
        }
    }

    public void showPhoneContacts() {
        System.out.println();
        for (Map.Entry<String, List<Contact>> entry : phoneContacts.entrySet()) {
            System.out.println("- " + entry.getKey());
            for (Object contact : entry.getValue().toArray()) {
                System.out.printf("\t%s\n", contact);
            }
        }
        System.out.println();
    }

    public boolean checkGroup(String input) {
        return phoneContacts.containsKey(input);
    }
}



