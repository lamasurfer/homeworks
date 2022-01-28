package unit_3.homework3_1.training31;

public class GenreByContent extends Genre {
    public GenreByContent() {
        super("Жанр по контенту книги"); //присвоим уникальный атрибут одному из трех базовых жанров
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        GenreByContent genreByContent = (GenreByContent) object;

        return attribute != null ? attribute.equals(genreByContent.attribute) : false;
    }


    public static class DetectiveGenre extends GenreByContent {

        @Override
        public String getGenreName() {
            return GenreEnum.DETECTIVE.name();
        }
    }

    public static class FantasticGenre extends GenreByContent {

        @Override
        public String getGenreName() {
            return GenreEnum.FANTASTIC.name();
        }
    }

    public static class ProfessionalGenre extends GenreByContent {

        @Override
        public String getGenreName() {
            return GenreEnum.PROFESSIONAL.name();
        }
    }
}

