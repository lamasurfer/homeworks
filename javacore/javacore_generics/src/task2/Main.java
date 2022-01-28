package task2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Box<String, String> sample1 = new Box<>("имя", "Нетология");
        System.out.println(sample1);

        Box<Integer, Boolean> sample2 = new Box<>(1, Boolean.TRUE);
        System.out.println(sample2);

//        ArrayList<Box<String, Integer>> list1 = new ArrayList<>();
//        ошибка заключается в несоотвествии типов
//
//        list1.add(sample1);
//        list1.add(sample2);

        ArrayList<Box<String, String>> list1 = new ArrayList<>();
        list1.add(sample1);

        ArrayList<Box<Integer, Boolean>> list2 = new ArrayList<>();
        list2.add(sample2);

        ArrayList<Box<?, ?>> list3 = new ArrayList<>();
        list3.add(sample1);
        list3.add(sample2);


    }
}
