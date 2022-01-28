package unit_4.homework4_4.task441;

public enum Group {
    WORK("Работа"),
    FRIENDS("Друзья"),
    FAMILY("Семья");

    static final Group[] GROUPS = {WORK, FRIENDS, FAMILY};

    private final String description;

    Group(String description) {
        this.description = description;
    }

    static Group getByDescription(String input) {
        for (Group group : GROUPS) {
            if (group.getDescription().equalsIgnoreCase(input)) {
                return group;
            }
        }
        return null;
    }

    static void showGroups() {
        System.out.println("Доступные группы:");
        for (Group group : GROUPS) {
            System.out.println("- " + group);
        }
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
