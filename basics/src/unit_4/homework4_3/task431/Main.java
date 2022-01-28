package unit_4.homework4_3.task431;

public class Main {
    public static void main(String[] args) {

//        ContactInputService contactInputService = new ContactInputService();
//        contactInputService.runUserInput();

        ContactsService contactsServiceDemo = new ContactsService();

        Contact johnDoe = new Contact("Джон Доу", "79267777777");
        Contact janeDoe = new Contact("Джейн Доу", "79267777777");
        Contact arnieSmith = new Contact("Арни Смит", "79267777777");
        Contact barnieSmith = new Contact("Барни Смит", "79267777777");
        Contact a = new Contact("А", "79267777777");

//        contactsServiceDemo.addGroup("Семья");
//        contactsServiceDemo.addGroup("Работа");

        contactsServiceDemo.addContact("Семья", johnDoe);
        contactsServiceDemo.addContact("Семья", janeDoe);
        contactsServiceDemo.addContact("Семья", arnieSmith);
        contactsServiceDemo.addContact("Семья", barnieSmith);
        contactsServiceDemo.addContact("Работа", barnieSmith);
        contactsServiceDemo.addContact("Работа", barnieSmith);
        contactsServiceDemo.addContact("Работа", a);


        contactsServiceDemo.showPhoneContacts();

    }
}

