package task2_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {



        List<Integer> intList = Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4);
        List<Integer> resultList = rawSort(intList);
        for (Integer integer : resultList) {
            System.out.print(integer + " ");
        }

    }


    public static List<Integer> rawSort(List<Integer> intList) {
        List<Integer> results = new ArrayList<>();
        int key;
        for (int i = 0; i < intList.size(); i++) {
            key = intList.get(i);
            if (key > 0 && key % 2 == 0) {
                if (results.size() == 0) results.add(key);
                else if (key <= results.get(0)) results.add(0, key);
                else if (key >= results.get(results.size() - 1)) results.add(key);
                else search(results, key);
            }
        }
        return results;
    }


    public static void search(List<Integer> results, int key) {
        int left = 0;
        int right = results.size() - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int middleValue = results.get(middle);

            if (middleValue < key) {
                left = middle + 1;
            } else if (middleValue > key) {
                right = middle - 1;
            } else {
                results.add(middle, key);
                return;
            }
        }
        results.add(left, key);
    }
}