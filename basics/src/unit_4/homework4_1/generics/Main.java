package unit_4.homework4_1.generics;

import unit_4.homework4_1.generics.fruits.Apple;
import unit_4.homework4_1.generics.fruits.Banana;
import unit_4.homework4_1.generics.fruits.Cabbage;
import unit_4.homework4_1.generics.fruits.Fruit;

public class Main {
    public static void main(String[] a) {

//        параметризируем класс типом String
//        Box<String> sample1 = new Box<>("Нетология");
//        System.out.println(sample1);
//        параметризируем класс типом Integer
//        Box<String> sample2 = new Box<>("1");
//        System.out.println(sample2);
//        параметризируем класс типом Boolean
//        Box<Boolean> sample3 = new Box<>(Boolean.TRUE);
//        System.out.println(sample3);


//        параметризируем класс типом String для ключа и значения
//        Box2<String, String> sample21 = new Box2<>("имя", "Нетология");
//        System.out.println(sample21);
//        параметризируем класс типом Integer для ключа и Boolean для значения
//        Box2<Integer, Boolean> sample22 = new Box2<>(1, Boolean.TRUE);
//        System.out.println(sample22);


//        ArrayList<Box2<String, String>> list1 = new ArrayList<>();
//        list1.add(sample21);

        FruitBox<String, Banana> bananaBox = new FruitBox<>("banana", new Banana());
        bananaBox.getObj().printClass();

        FruitBox<String, Apple> appleBox = new FruitBox<>("apple", new Apple());
        appleBox.getObj().printClass();

        FruitBox<String, Fruit> fruitBox = new FruitBox<>("fruit", new Fruit());
        fruitBox.getObj().printClass();

        System.out.println();
        VegetableBox<String, Cabbage> cabbageBox = new VegetableBox<>("cabbage", new Cabbage());
        cabbageBox.getObj().printClass();


    }
}
