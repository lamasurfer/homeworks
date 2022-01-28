package unit_3.homework3_4.task341;


import java.util.Scanner;

public class Main {

    static final int LEGAL_AGE = 18;


    public static void main(String[] args) throws UserNotFoundException, AccessDeniedException {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter login");
        String login = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();

        validateUser(getUserByLoginAndPassword(login, password));


    }

    public static User[] getUsers() {
        User user1 = new User("aaaaa", "1111", "aa@mail.io", 17);
        User user2 = new User("bbbbb", "2222", "bb@mail.io", 21);
        User user3 = new User("ccccc", "3333", "cc@mail.io", 22);
        User user4 = new User("ddddd", "4444", "dd@mail.io", 15);
        User user5 = new User("eeeee", "5555", "ee@mail.io", 24);
        User user6 = new User("fffff", "6666", "ff@mail.io", 25);

        return new User[]{user1, user2, user3, user4, user5, user6};
    }

    public static User getUserByLoginAndPassword(String login, String password) throws UserNotFoundException {
        User[] users = getUsers();
        for (User user : users) {
            if (login.equals(user.getLogin()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found!");
    }

    public static void validateUser(User user) throws AccessDeniedException {
        if (user.getAge() < LEGAL_AGE) {
            throw new AccessDeniedException("Users age is invalid!");
        } else {
            System.out.println("Access granted!");
        }
    }
}
