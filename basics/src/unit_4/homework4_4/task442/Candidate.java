package unit_4.homework4_4.task442;

import java.util.Objects;

//public class Candidate implements Comparable<Candidate> {
public class Candidate {

    private final String name;
    private String gender;
    private String age;
    private int relevance;
    private int rating;

    public Candidate(String name, String gender, String age, int relevance, int rating) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.relevance = relevance;
        this.rating = rating;
    }

    public Candidate(String[] input) {
        this.name = input[0];
        this.gender = input[1];
        this.age = input[2];
        this.relevance = Integer.parseInt(input[3].trim());
        this.rating = Integer.parseInt(input[4].trim());
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s", name, relevance, rating);
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getRelevance() {
        return relevance;
    }

    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidate candidate = (Candidate) o;
        return Objects.equals(name, candidate.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

//    @Override
//    public int compareTo(Candidate o) {
//
//            int i = o.relevance - relevance;
//            if (i != 0) return i;
//
//            return o.rating - rating;
//    }
}
