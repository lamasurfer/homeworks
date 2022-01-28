package unit_1.homework1_6.Director;

import java.time.LocalDate;

class Main {
    public static void main(String[] args) {

        Film film1 = new Film(LocalDate.parse("1998-10-10"), "Карты, деньги, два ствола",
                new String[]{"Великобритания"});
        Film film2 = new Film(LocalDate.parse("2008-01-02"), "Рок-н-рольщик", new String[]{"США", "Великобритания"});

        Director director = new Director(LocalDate.parse("1968-09-10"), "Гай", "Ричи", new Film[]{film1, film2});

        Director director2 = new Director(LocalDate.parse("1938-09-15"), "Scott", "Stevens", new Film[]{film2});

        //System.out.printf("Режиссер: %s %s, дата рождения: %s", director.name, director.surname, director.birthday);

        //System.out.println("   Фильмы:");
        //for (Film film: director.films) {
        //  System.out.printf("   %s %s%n", film.title, film.release);
        //  for (String county: film.countries) {
        //    System.out.printf("      %s%n", county);
        //  }
        //}

        //System.out.println(director.toString());

        //director.fullDescription(director);
        //director2.fullDescription(director2);
        //director.fullDescription(director2);
        //director2.fullDescription(director2);

        director.fullDescription();
        director2.fullDescription();


    }


}
