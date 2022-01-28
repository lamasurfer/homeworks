package unit_4.homework4_4.task443;

import java.util.*;

public class Investigation {

    private Map<String, User> users = new TreeMap<>();
    private Map<String, Set<String>> usersIps = new HashMap<>();
    private Map<String, Integer> ipsCounter = new HashMap<>();


    public void automate(Scanner scanner_users, Scanner scanner_logs) {
        addUsers(scanner_users);
        addLogs(scanner_logs);
        findVillain();
    }

    private void addUsers(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.matches("(\\d{1,3}\\.){3}\\d{1,3};\\d+;[еЁА-я\\s]+;[еЁА-я\\s,\\d]+.+")) {
                String[] userData = line.split(";");
                String userId = userData[1];
                if (!users.containsKey(userId)) {
                    users.put(userId, new User(userData));
                }
                Set<String> ipsSet = usersIps.get(userId);
                if (ipsSet == null) {
                    ipsSet = new HashSet<>();
                    usersIps.put(userId, ipsSet);
                }
                String userIp = userData[0];
                ipsSet.add(userIp);
            }
        }
        scanner.close();
    }

    private void addLogs(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] logsData = line.split(":");
            Integer key = ipsCounter.get(logsData[0]);
            if (key == null) {
                ipsCounter.put(logsData[0], 1);
            } else {
                ipsCounter.put(logsData[0], ++key);
            }
        }
        scanner.close();
    }

    private void findVillain() {
        Map<User, Integer> userRequests = getUserRequests();
        int requestsCount = 0;
        for (Map.Entry<User, Integer> entry : userRequests.entrySet()) {
            requestsCount = requestsCount < entry.getValue() ? entry.getValue() : requestsCount;
        }
        System.out.println("Предполагаемые злоумышленники: ");
        for (Map.Entry<User, Integer> entry : userRequests.entrySet()) {
            if (entry.getValue() == requestsCount) {
                System.out.println(entry.getKey());
                System.out.println("Количество входов: " + entry.getValue());
            }
        }
    }

    private Map<User, Integer> getUserRequests() {
        int totalRequests = 0;
        Map<User, Integer> userRequests = new HashMap<>();
        for (Map.Entry<String, User> user : users.entrySet()) {
            Set<String> set = usersIps.get(user.getKey());
            for (String s : set) {
                if (ipsCounter.get(s) != null) {
                    totalRequests += ipsCounter.get(s);
                }
                userRequests.put(user.getValue(), totalRequests);
            }
            totalRequests = 0;
        }
        return userRequests;
    }
}