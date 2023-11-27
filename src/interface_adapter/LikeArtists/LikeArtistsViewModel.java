package interface_adapter.LikeArtists;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LikeArtistsViewModel extends ViewModel {
    public static final String LIKE_BUTTON_LABEL = "Like"; // do the like and unlike button use the same button?

    private LikeArtistsState state = new LikeArtistsState();

    public LikeArtistsViewModel(){
        super("Like");
    }
    public void setState(LikeArtistsState state){
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this); // ???
    public void firePropertyChanged(){
        support.firePropertyChange("state", null, this.state);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public LikeArtistsState getState() {
        return state;
    }
}
