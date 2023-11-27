package interface_adapter.LikeTracks;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LikeTracksViewModel extends ViewModel {
    public static final String LIKE_BUTTON_LABEL = "Like";

    private LikeTracksState state = new LikeTracksState();

    public LikeTracksViewModel() {
        super("Like");
    }

    public void setState(LikeTracksState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this); // ???

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public LikeTracksState getState() {
        return state;
    }
}
