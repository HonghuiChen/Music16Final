package use_case.deleteGenrePreference;

public class deleteGenrePreferenceInputData {
    final private String genre;

    public deleteGenrePreferenceInputData(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
