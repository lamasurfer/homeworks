package unit_4.homework4_3.training43;

import java.util.HashMap;
import java.util.Objects;

public class Storage {

    private HashMap<Integer, Product> products = new HashMap<>();
    private String storageName;

    public Storage(String storageName) {
        this.storageName = storageName;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storage storage = (Storage) o;
        return storageName.equals(storage.storageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storageName);
    }

    public void addProduct(Product product) {
        products.put(product.getNumber(), product);
    }

    public void showProducts() {
        System.out.println(storageName);
        products.forEach((integer, product) -> System.out.println(product));


    }

    @Override
    public String toString() {
        return storageName;
    }
}
