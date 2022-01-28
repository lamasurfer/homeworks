package unit_4.homework4_4.task442;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Candidates {

    Set<Candidate> candidateSet = new TreeSet<>(
            Comparator.comparing(Candidate::getName, Comparator.reverseOrder())
                    .thenComparing(Candidate::getRating, Comparator.reverseOrder())
                    .thenComparing(Candidate::getRating, Comparator.reverseOrder()));


    public void addCandidate(Candidate candidate) {
        if (!candidateSet.contains(candidate)) {
            candidateSet.add(candidate);
        } else {
            System.out.println("Такой кандидат уже есть!");
        }
    }

    public void addCandidate(Candidate[] candidatesArray) {
        candidateSet.addAll(Arrays.asList(candidatesArray));
    }

    public void showCandidates() {
        System.out.println("ФИО, Релевантность резюме, Оценка на собеседовании");
        int counter = 1;
        for (Candidate candidate : candidateSet) {
            System.out.println(counter + ". " + candidate);
            counter++;
        }
    }


}
