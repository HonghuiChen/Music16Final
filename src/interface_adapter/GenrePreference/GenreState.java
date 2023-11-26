package interface_adapter.GenrePreference;

public class GenreState {
    private String genre = "";
    private String genreError = null;

    public GenreState(interface_adapter.GenrePreference.GenreState copy) {
        genre = copy.genre;
        genreError = copy.genreError;
    }
    public GenreState() {}

    public String getGenre() {
        return genre;
    }

    public String getGenreError() {
        return genreError;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setGenreError(String genreError) {
        this.genreError = genreError;
    }

}
