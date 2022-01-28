package unit_3.homework3_1.training31;

public class Genre {

    protected String attribute;

    public Genre(String attribute) {
        this.attribute = attribute;
    }

    public String getAttributeOfGenre() {
        return attribute;
    }

    public String getGenreName() {
        return "Жанр не указан";
    }

}
