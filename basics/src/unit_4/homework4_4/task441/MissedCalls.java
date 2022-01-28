package unit_4.homework4_4.task441;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss uuuu-MM-dd");
    private Map<LocalDateTime, String> missedCalls = new TreeMap<>();

    public void addMissedCall(String number) {
        LocalDateTime localDateTime = LocalDateTime.now();
        missedCalls.put(localDateTime, number);
        System.out.println("Новый пропущенный вызов!");
    }

    public void deleteMissedCalls() {
        if (!isEmpty()) {
            missedCalls.clear();
            System.out.println("Список пропущенных вызовов очищен.");
        }
    }

    public void showMissedCalls(ContactsService contactsService) {
        if (!isEmpty()) {
            System.out.println("Пропущенные вызовы: ");
            for (Map.Entry<LocalDateTime, String> entry : missedCalls.entrySet()) {
                String name = contactsService.nameByNumber(entry.getValue());
                System.out.println(entry.getKey().format(formatter) + " " + name + " +" + entry.getValue());
            }
        }
    }

    boolean isEmpty() {
        if (missedCalls.isEmpty()) {
            System.out.println("Пропущенных вызовов пока нет.");
            return true;
        }
        return false;
    }

    public Map<LocalDateTime, String> getMissedCalls() {
        return missedCalls;
    }

    public void setMissedCalls(Map<LocalDateTime, String> missedCalls) {
        this.missedCalls = missedCalls;
    }
}