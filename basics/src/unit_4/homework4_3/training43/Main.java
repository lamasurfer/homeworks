package unit_4.homework4_3.training43;

public class Main {
    public static void main(String[] args) {

        StorageAdmin storageAdmin = new StorageAdmin();

        Storage storage1 = new Storage("Склад 1");
        Storage storage2 = new Storage("Склад 2");
        Storage storage3 = new Storage("Склад 3");
        Storage storage4 = new Storage("Склад 1");

        Product product1 = new Product(1, "Молоко", 1000);
        Product product2 = new Product(2, "Чай", 1000);

        storage1.addProduct(product1);
        storage1.addProduct(product2);


        storageAdmin.addStorage(new Storage("Склад 1"));
        storageAdmin.addStorage(new Storage("Склад 2"));
        storageAdmin.addStorage(new Storage("Склад 3"));
        storageAdmin.addStorage(new Storage("Склад 1"));


        System.out.println(storageAdmin.toString());


    }
}
