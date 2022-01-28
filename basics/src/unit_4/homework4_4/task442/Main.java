package unit_4.homework4_4.task442;

public class Main {
    public static void main(String[] args) {

//        CandidatesUI newUI = new CandidatesUI();
//        newUI.runUserInput();


        Candidates candidates = new Candidates();
        Candidate[] people = {
                new Candidate("Джон Доу", "муж", "45", 5, 3),
                new Candidate("Джон Доу", "муж", "45", 1, 3),
                new Candidate("Джейн Доу", "муж", "21", 5, 3),
                new Candidate("Джон Смит", "муж", "18", 4, 5),
                new Candidate("Джон Джей Смит", "муж", "18", 4, 4),
                new Candidate("Джейн Смит", "жен", "19", 1, 3),
                new Candidate("Арни Смит", "муж", "33", 1, 2),
                new Candidate("Барни Смит", "муж", "27", 2, 5),
                new Candidate("Джон Паблик", "муж", "22", 1, 1),
                new Candidate("Джейн Паблик", "муж", "35", 0, 5),
                new Candidate("Аарон Доу", "муж", "25", 1, 3),//
                new Candidate("Аарон Доу", "муж", "25", 1, 3),//
                new Candidate("Марк Доу", "муж", "25", 5, 5),
                new Candidate("Марк Шон Доу", "муж", "25", 5, 5),
        };

        candidates.addCandidate(people);
        System.out.println("***************************");
        candidates.showCandidates();
    }

}
