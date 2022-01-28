package unit_3.homework3_1.training31;

public class GenreByNumberOfPages extends Genre {
    public GenreByNumberOfPages() {
        super("Жанр по количеству страниц"); //присвоим уникальный атрибут одному из трех базовых жанров
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        GenreByNumberOfPages genreByNumberOfPages = (GenreByNumberOfPages) object;

        return attribute != null ? attribute.equals(genreByNumberOfPages.attribute) : false;
    }

    public static class StoryGenre extends GenreByNumberOfPages {

        @Override
        public String getGenreName() {
            return GenreEnum.STORY.name();
        }
    }

    public static class NovelGenre extends GenreByNumberOfPages {

        @Override
        public String getGenreName() {
            return GenreEnum.NOVEL.name();
        }
    }

    public static class NarrativeGenre extends GenreByNumberOfPages {

        @Override
        public String getGenreName() {
            return GenreEnum.NARRATIVE.name();
        }
    }

}
