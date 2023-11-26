package use_case.deleteGenrePreference;

public class deleteGenrePreferenceOutputData {
    private final String genre;
    private boolean useCaseFailed;

    public deleteGenrePreferenceOutputData(String genre, boolean useCaseFailed) {
        this.genre = genre;
        this.useCaseFailed = useCaseFailed;
    }

    public String getGenre() {
        return genre;
    }
}
