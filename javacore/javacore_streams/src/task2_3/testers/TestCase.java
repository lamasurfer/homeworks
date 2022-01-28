package task2_3.testers;

import task2_3.person.Education;
import task2_3.person.Person;
import task2_3.person.Sex;

import java.util.*;

public class TestCase {

    private static final List<String> NAMES = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
    private static final List<String> SURNAMES =
            Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
    private final int sampleSize;
    private final Collection<Person> persons;


    public TestCase(int sampleSize) {
        this.sampleSize = sampleSize;
        persons = createSampleWithSize(sampleSize);
    }


    Collection<Person> getPersons() {
        return persons;
    }

    int getSampleSize() {
        return sampleSize;
    }

    private Collection<Person> createSampleWithSize(int sampleSize) {

        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < sampleSize; i++) {
            persons.add(new Person(
                    NAMES.get(new Random().nextInt(NAMES.size())),
                    SURNAMES.get(new Random().nextInt(SURNAMES.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        return persons;
    }
}
