package unit_4.homework4_3.training43;

import java.util.HashSet;

public class StorageAdmin {

    private HashSet<Storage> storages = new HashSet<>();


    public void addStorage(Storage storage) {
//        if(!storages.add(storage)) {
//            System.out.println("- " + storage.toString());
//        }
        System.out.println(storages.add(storage));
    }


    public void inputProduct(String input) {
        String[] temp = input.split("\\s+");

    }

    @Override
    public String toString() {
        return storages.toString();
    }
}