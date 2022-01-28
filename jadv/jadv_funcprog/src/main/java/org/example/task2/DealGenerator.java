package org.example.task2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;

public class DealGenerator {

    private final Random random = new Random();
    private IntSupplier sides;
    private IntSupplier price;

    private DealGenerator() {
    }

    public DealGenerator setRandomSeed(long seed) {
        random.setSeed(seed);
        return this;
    }

    public DealGenerator setSides(int min, int max) {
        sides = () -> min + random.nextInt(max - min + 1);
        return this;
    }

    public DealGenerator setPrice(int min, int max) {
        price = () -> min + random.nextInt(max - min + 1);
        return this;
    }

    private List<Deal> generate(int count) {
        return Arrays.stream(new Deal[count])
                .map(x -> new Deal(sides.getAsInt(), sides.getAsInt(), price.getAsInt()))
                .collect(Collectors.toList());
    }

    public static List<Deal> generateDeals(int deals, Consumer<DealGenerator> consumer) {
        final DealGenerator generator = new DealGenerator();
        consumer.accept(generator);
        return generator.generate(deals);
    }
}
