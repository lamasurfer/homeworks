package task3;

import task3.fruits.Apple;
import task3.fruits.Banana;
import task3.fruits.Fruit;

public class Main {
    public static void main(String[] args) {

        Box<String, Banana> bananaBox = new Box<>("banana", new Banana());
        bananaBox.getObj().printClass();

        Box<String, Apple> appleBox = new Box<>("apple", new Apple());
        appleBox.getObj().printClass();

        Box<String, Fruit> fruitBox = new Box<>("fruit", new Fruit());
        fruitBox.getObj().printClass();

//        ошибка в том, что наш обычный бокс может хранить только объекты класса Fruit или его наследников
//        Box<String, Cabbage> cabbageBox = new Box<>("cabbage", new Cabbage());
//        cabbageBox.getObj().printClass();

        VegetableBox<String, Cabbage> cabbageBox = new VegetableBox<>("cabbage", new Cabbage());
        cabbageBox.getObj().printClass();
    }
}

