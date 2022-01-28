package task2_2;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        TestCase testCase = new TestCase(10_000_000);
        Collection<Person> persons = testCase.getPersons();

        Stream<Person> illegalAge = persons
                .parallelStream()
                .filter(x -> x.getAge() < 18);

        System.out.println("Несовершеннолетних: " + illegalAge.count());

        Stream<String> uncleSam = persons
                .parallelStream()
                .filter(x -> x.getSex().equals(Sex.MAN))
                .filter(x -> x.getAge() >= 18 && x.getAge() <= 27)
                .map(Person::getSurname);

        List<String> uncleSamWantsThem = uncleSam.collect(Collectors.toList());
        System.out.println("Призывников: " + uncleSamWantsThem.size());

        Stream<String> hR = persons
                .parallelStream()
                .filter(x -> x.getEducation().equals(Education.HIGHER))
                .filter(x -> x.getAge() >= 18 && x.getAge() <= 60 && x.getSex().equals(Sex.WOMEN)
                        || x.getAge() >= 18 && x.getAge() <= 65 && x.getSex().equals(Sex.MAN))
                .sorted(Comparator.comparing(Person::getSurname))
                .map(Person::getSurname);

        List<String> whiteCollars = hR.collect(Collectors.toList());
        System.out.println("Потенциально работоспособных людей с высшим образованием: " + whiteCollars.size());
    }
}
