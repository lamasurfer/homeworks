package task2_3.testers;

import task2_3.person.Education;
import task2_3.person.Person;
import task2_3.person.Sex;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tester {

    private final TestResults testResults = new TestResults();
    private int counter = 1;
    final String description;

    public Tester(String description) {
        this.description = description;
    }

    public void performTestOn(TestCase testCase) {
        int sampleSize = testCase.getSampleSize();
        double sequentialTime = calculateSequential(testCase);
        double parallelTime = calculateParallel(testCase);
        Test test = new Test(counter, sampleSize, sequentialTime, parallelTime);
        testResults.addTest(test);
        showLog(test);
        counter++;
    }

    public void showResults() {
        testResults.analyze();
    }

    public void performTestOn(TestCase... testCases) {
        for (TestCase testCase : testCases) {
            performTestOn(testCase);
        }
    }

    private double calculateSequential(TestCase testCase) {
        long startTime = System.nanoTime();
        Collection<Person> persons = testCase.getPersons();
        Stream<Person> illegalAge = persons
                .stream()
                .filter(x -> x.getAge() < 18);
        illegalAge.count();

        Stream<String> uncleSam = persons
                .stream()
                .filter(x -> x.getSex().equals(Sex.MAN))
                .filter(x -> x.getAge() >= 18 && x.getAge() <= 27)
                .map(Person::getSurname);

        List<String> uncleSamWantsThem = uncleSam.collect(Collectors.toList());

        Stream<String> hR = persons
                .stream()
                .filter(x -> x.getAge() >= 16)
                .filter(x -> x.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(Person::getSurname))
                .map(Person::getSurname);

        List<String> whiteCollars = hR.collect(Collectors.toList());

        long stopTime = System.nanoTime();
        return (double) (stopTime - startTime) / 1_000_000_000.0;
    }

    private double calculateParallel(TestCase testCase) {
        long startTime = System.nanoTime();
        Collection<Person> persons = testCase.getPersons();
        Stream<Person> illegalAge = persons
                .parallelStream()
                .filter(x -> x.getAge() < 18);
        illegalAge.count();

        Stream<String> uncleSam = persons
                .parallelStream()
                .filter(x -> x.getSex().equals(Sex.MAN))
                .filter(x -> x.getAge() >= 18 && x.getAge() <= 27)
                .map(Person::getSurname);
        List<String> uncleSamWantsThem = uncleSam.collect(Collectors.toList());

        Stream<String> hR = persons
                .parallelStream()
                .filter(x -> x.getAge() >= 16)
                .filter(x -> x.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(Person::getSurname))
                .map(Person::getSurname);
        List<String> whiteCollars = hR.collect(Collectors.toList());

        long stopTime = System.nanoTime();
        return (double) (stopTime - startTime) / 1_000_000_000.0;
    }

    public void showLog(Test test) {
        if (counter == 1) {
            System.out.println(description);
            System.out.println(" №   | выборка, чел | последовательно | параллельно   | разность, сек | %     ");
            System.out.println("------------------------------------------------------------------------------");
        }
        System.out.print(test);

    }

}
