package unit_1.homework1_6.Director;

import java.time.LocalDate;

public class Film {

    public LocalDate release;
    public String title;
    public String[] countries;

    public Film(LocalDate release, String title, String[] countries) {
        this.release = release;
        this.title = title;
        this.countries = countries;
    } // конструктор

}
