package unit_3.homework3_1.training31;

public class GenreByForm extends Genre {
    public GenreByForm() {
        super("Жанр по форме текста"); //присвоим уникальный атрибут одному из трех базовых жанров
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        GenreByForm genreByForm = (GenreByForm) object;

        return attribute != null ? attribute.equals(genreByForm.attribute) : false;
    }

    public static class ProseGenre extends GenreByForm {

        @Override
        public String getGenreName() {
            return GenreEnum.PROSE.name();
        }
    }

    public static class VerseGenre extends GenreByForm {

        @Override
        public String getGenreName() {
            return GenreEnum.VERSE.name();
        }
    }
}