package unit_4.homework4_4.task441;

import java.util.HashMap;
import java.util.Map;

public class ContactsService {

    private Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (!contacts.containsKey(contact.getPhone())) {
            contacts.put(contact.getPhone(), contact);
        } else {
            System.out.println("Такой контакт уже есть!");
        }
    }

    public void deleteByNumber(String number) {
        if (contacts.containsKey(number)) {
            contacts.remove(number);
        } else {
            System.out.println("Контакта с таким номером нет!");
        }
    }

    public void deleteByName(String[] names) {
        Contact contact = contactByName(names);
        if (contact != null) {
            deleteByNumber(contact.getPhone());
        } else {
            System.out.println("Контакта с таким именем нет!");
        }
    }

    public Contact contactByName(String[] names) {
        String name = names[0];
        String surname = names[1];
        for (Contact contact : contacts.values()) {
            if (contact.getName().equals(name) && contact.getSurname().equals(surname)) {
                return contact;
            }
        }
        return null;
    }

    public Contact contactByNumber(String number) {
        return contacts.get(number);
    }

    public void showPhoneContacts() {
        if (!isEmpty()) {
            System.out.println("\nСписок контактов: ");
            for (Contact value : contacts.values()) {
                System.out.println(value);
            }
        }
    }

    public String nameByNumber(String number) {
        if (contacts.containsKey(number)) {
            return contacts.get(number).getName() + " " + contacts.get(number).getSurname();
        }
        return "*неизвестно*";
    }

    public boolean isEmpty() {
        if (contacts.isEmpty()) {
            System.out.println("Список контактов пуст.");
            return true;
        }
        return false;
    }
}
