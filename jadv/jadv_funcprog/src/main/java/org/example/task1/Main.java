package org.example.task1;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        String message = "MoO moO MoO mOo MOO OOM MMM moO moO MMM mOo mOo moO " +
                "MMM mOo MMM moO moO MOO MOo mOo MoO moO moo mOo mOo moo";

        String regex = "\\s+";

        BiFunction<String, String, List<String>> dictionary = (source, delimiter) ->
                Arrays.stream(source.split(delimiter))
                        .distinct()
                        .sorted()
                        .collect(Collectors.toList());

        dictionary.apply(message, regex).forEach(System.out::println);

    }
}
