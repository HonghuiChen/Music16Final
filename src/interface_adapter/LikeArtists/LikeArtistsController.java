package interface_adapter.LikeArtists;

import use_case.LikeArtists.LikeArtistsInputData;
import use_case.LikeArtists.LikeArtistsInputBoundary;

public class LikeArtistsController {
    final LikeArtistsInputBoundary likeArtistsInteractor;
    public LikeArtistsController(LikeArtistsInputBoundary likeArtistsInteractor) {
        this.likeArtistsInteractor = likeArtistsInteractor;
    }

    public void like(LikeArtistsInputData likeArtistsInputData) {
        LikeArtistsInputData likeArtistsInputDatas = new LikeArtistsInputData(likeArtistsInputData.toString());
        likeArtistsInteractor.like(likeArtistsInputDatas);
    }
    public void unlike(LikeArtistsInputData likeArtistsInputData) {
        LikeArtistsInputData likeArtistsInputDatas = new LikeArtistsInputData(likeArtistsInputData.toString());
        likeArtistsInteractor.unlike(likeArtistsInputDatas);
    }
}

