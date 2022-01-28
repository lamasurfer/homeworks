package org.example.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CityGame {

    static List<String> cities = getCities();

    private void removeUsedCity(String move) {
        cities.remove(move);
    }

    public List<String> possibleMoves(String letter) {
        String patternString = "^" + letter;
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        List<String> result = new ArrayList<>();
        result = cities.stream()
                .filter(pattern.asPredicate())
                .collect(Collectors.toList());
        return result;
    }

    public String firstMove() {
        Random random = new Random();
        int index = random.nextInt(cities.size());
        String firstMove = cities.get(index);
        removeUsedCity(firstMove);
        return firstMove;
    }

    public String nextMove(List<String> possibleMoves) {
        if (possibleMoves.size() == 0) {
            return "Oh, look's like I'm out of cities...";
        }
        String nextMove;
        Random random = new Random();
        int index = random.nextInt(possibleMoves.size());
        nextMove = possibleMoves.get(index);
        removeUsedCity(nextMove);
        return nextMove;
    }

    public String getLetter(String city) {
        int length = city.length();
        return String.valueOf(city.charAt(length - 1));
    }

    private static List<String> getCities() {
        List<String> cities = new ArrayList<>();
        String city;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("cities.txt"))) {
            while ((city = bufferedReader.readLine()) != null) {
                cities.add(city);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cities;
    }
}
