package interface_adapter.LikeTracks;

import use_case.LikeTracks.LikeTracksInputBoundary;
import use_case.LikeTracks.LikeTracksInputData;

public class LikeTracksController {
    final LikeTracksInputBoundary likeTracksInteractor;
    public LikeTracksController(LikeTracksInputBoundary likeTracksInteractor) {
        this.likeTracksInteractor = likeTracksInteractor;
    }

    public void like(String track) {
        LikeTracksInputData likeTracksInputDatas = new LikeTracksInputData(track);
        likeTracksInteractor.like(likeTracksInputDatas);
    }
    public void unlike(String track) {
        LikeTracksInputData likeTracksInputDatas = new LikeTracksInputData(track);
        likeTracksInteractor.unlike(likeTracksInputDatas);
    }
}