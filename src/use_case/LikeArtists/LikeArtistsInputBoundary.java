package use_case.LikeArtists;

public interface LikeArtistsInputBoundary {
    void like(LikeArtistsInputData likeArtistsInputData);
    void unlike(LikeArtistsInputData likeArtistsInputData);
}
