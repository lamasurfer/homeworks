package unit_4.homework4_1.regex;

public class Main {
    public static void main(String[] args) {
//        String input = "Иванов Иванов 34";
        //Иванов Петр 35 мужской высшее инженер Н-12 \D+\s\d{2}
//        String pattern = "[а-яА-Я]+\\s\\d+";

//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        if (input.matches("([а-яА-Я]+\\s){2}\\d+\\s([а-яА-Я]+\\s){3}([а-яА-Яa-zA-Z0-9\\p{Punct}]+)")) {
//            String result = input;
//            System.out.println(result);
//        } else {
//            System.out.println("не пашет");
//        }

        String[] fields = {"Фамилия", "Имя", "Возраст", "Пол", "Образование", "Должность", "Отдел"};


        String temp = "";
        for (String field : fields) {
            temp = temp.concat(field).concat(" ");
        }
        System.out.println("№  " + temp);
    }
}
