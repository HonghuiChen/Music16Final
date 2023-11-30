package interface_adapter.LikeArtists;

import use_case.LikeArtists.LikeArtistsInputData;
import use_case.LikeArtists.LikeArtistsInputBoundary;

public class LikeArtistsController {
    final LikeArtistsInputBoundary likeArtistsInteractor;
    public LikeArtistsController(LikeArtistsInputBoundary likeArtistsInteractor) {
        this.likeArtistsInteractor = likeArtistsInteractor;
    }

    public void like(String artist) {
        LikeArtistsInputData likeArtistsInputDatas = new LikeArtistsInputData(artist);
        likeArtistsInteractor.like(likeArtistsInputDatas);
    }
    public void unlike(String artist) {
        LikeArtistsInputData likeArtistsInputDatas = new LikeArtistsInputData(artist);
        likeArtistsInteractor.unlike(likeArtistsInputDatas);
    }
}

