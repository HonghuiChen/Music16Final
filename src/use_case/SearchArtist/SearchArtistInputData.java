package use_case.SearchArtist;

public class SearchArtistInputData {
    final private String query;

    public SearchArtistInputData(String query){
        this.query = query;
    }

    String getQuery(){
        return query;
    }
}
