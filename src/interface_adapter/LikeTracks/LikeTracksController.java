package interface_adapter.LikeTracks;

import use_case.LikeTracks.LikeTracksInputBoundary;
import use_case.LikeTracks.LikeTracksInputData;

public class LikeTracksController {
    final LikeTracksInputBoundary likeTracksInteractor;
    public LikeTracksController(LikeTracksInputBoundary likeTracksInteractor) {
        this.likeTracksInteractor = likeTracksInteractor;
    }

    public void like(LikeTracksInputData likeTracksInputData) {
        LikeTracksInputData likeTracksInputDatas = new LikeTracksInputData(likeTracksInputData.toString());
        likeTracksInteractor.like(likeTracksInputDatas);
    }
    public void unlike(LikeTracksInputData likeTracksInputData) {
        LikeTracksInputData likeTracksInputDatas = new LikeTracksInputData(likeTracksInputData.toString());
        likeTracksInteractor.unlike(likeTracksInputDatas);
    }
}
