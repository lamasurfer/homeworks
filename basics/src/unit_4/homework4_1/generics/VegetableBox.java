package unit_4.homework4_1.generics;

import unit_4.homework4_1.generics.fruits.Cabbage;

class VegetableBox<K, T extends Cabbage> {

    private K key;
    private T obj;


    public VegetableBox(K key, T obj) {
        this.key = key;
        this.obj = obj;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "Box2{" +
                "key=" + key +
                "; keyType=" + key.getClass().getName() +
                ", obj=" + obj +
                "; objType=" + obj.getClass().getName() +
                '}';
    }
}