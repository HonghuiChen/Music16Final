package interface_adapter.GenrePreference;

public class GenreState {
    private String genre = "";
    private String addGenreError = null;
    private String deleteGenreError = null;

    public GenreState(interface_adapter.GenrePreference.GenreState copy) {
        genre = copy.genre;
        addGenreError = copy.addGenreError;
        deleteGenreError = copy.deleteGenreError;
    }
    public GenreState() {}

    public String getGenre() {
        return genre;
    }

    public String getAddGenreError() {
        return addGenreError;
    }

    public String getDeleteGenreError() {
        return deleteGenreError;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAddGenreError(String addError) {
        this.addGenreError = addError;
    }

    public void setDeleteGenreError(String deleteError) {
        this.deleteGenreError = deleteError;
    }


}
