package unit_1.homework1_6.Director;

import java.time.LocalDate;

public class Director {

    public LocalDate birthday; // дата рождения
    public String name; // имя
    public String surname; // фамилия
    public Film[] films; // массив срежессированных фильмов

    public Director(LocalDate birthday, String name, String surname, Film[] films) {
        this.birthday = birthday;
        this.name = name;
        this.surname = surname;
        this.films = films;
    }

    public String toString() {
        return "Режиссер: " + name + " " + surname + ", дата рождения: " + birthday + " .";
    }

    //public void fullDescription(Director Director) {
    //  System.out.printf("%n   Фильмы режиссера: %s %s", Director.name, //Director.surname);
    //  for (Film film: Director.films) {
    //    System.out.printf("%n   %s %s%n", film.title, film.release);
    //    }
    //  }
    //}

    public void fullDescription() {
        System.out.printf("%n   Фильмы режиссера: %s %s", name, surname);
        for (Film film : films) {
            System.out.printf("%n   %s %s%n", film.title, film.release);

        }
    }

}
