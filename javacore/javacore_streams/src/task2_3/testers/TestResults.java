package task2_3.testers;

import java.util.*;
import java.util.stream.Stream;

class TestResults {

    private final Map<Integer, List<Test>> testResults = new TreeMap<>();

    public TestResults() {
    }

    public void addTest(Test test) {
        int sampleSize = test.getSampleSize();
        if (!testResults.containsKey(sampleSize)) {
            testResults.put(sampleSize, new ArrayList<>());
        }
        testResults.get(sampleSize).add(test);
    }

    public void analyze() {
        System.out.println();
        for (Integer sampleSize : testResults.keySet()) {
            List<Test> tests = testResults.get(sampleSize);
            Stream<Test> successfulCasesCount = tests
                    .stream()
                    .filter(x -> x.getPercentage() < 0);
            OptionalDouble sequential = tests
                    .stream()
                    .mapToDouble(Test::getSequentialTime)
                    .average();
            OptionalDouble parallel = tests
                    .stream()
                    .mapToDouble(Test::getParallelTime)
                    .average();
            OptionalDouble percent = tests
                    .stream()
                    .filter(x -> x.getPercentage() < 0)
                    .mapToDouble(Test::getPercentage)
                    .average();

            int totalCases = testResults.get(sampleSize).size();
            int successfulCases = (int) successfulCasesCount.count();
            double successRate = successfulCases / (double) totalCases * 100;

            System.out.println("Для выборки размером: " + sampleSize);
            System.out.println("\t- всего тестов: " + totalCases);
            System.out.println("\t- успешных случаев: " + successfulCases);
            System.out.printf("\t- %% успешных тестов: %.1f%%%n", successRate);
            if (sequential.isPresent() && parallel.isPresent() && percent.isPresent()) {
                System.out.printf("\t- среднее время последовательного теста: %.7f%n", sequential.getAsDouble());
                System.out.printf("\t- среднее время параллельного теста: %.7f%n", parallel.getAsDouble());
                if (percent.getAsDouble() != 0) {
                    System.out.printf("\t- рост производительности для успешных " +
                            "случаев в среднем на: %.1f%%%n", -(percent.getAsDouble()));
                }
            }
        }
        System.out.println();
    }
}
