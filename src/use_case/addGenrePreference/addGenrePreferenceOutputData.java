package use_case.addGenrePreference;

public class addGenrePreferenceOutputData {

    private final String genre;
    private boolean useCaseFailed;

    public addGenrePreferenceOutputData(String genre, boolean useCaseFailed) {
        this.genre = genre;
        this.useCaseFailed = useCaseFailed;
    }

    public String getGenre() {
        return genre;
    }
}
