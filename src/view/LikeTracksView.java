package view;

import interface_adapter.LikeTracks.LikeTracksController;
import interface_adapter.LikeTracks.LikeTracksState;
import interface_adapter.LikeTracks.LikeTracksViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LikeTracksView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "like song";
    private final LikeTracksViewModel likeTracksViewModel;
    final JButton likeTrack;
    private final LikeTracksController likeTracksController;

    public LikeTracksView(LikeTracksViewModel likeTracksViewModel, LikeTracksController likeTracksController){
        this.likeTracksController = likeTracksController;
        this.likeTracksViewModel = likeTracksViewModel;
        this.likeTracksViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Song");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        likeTrack = new JButton(likeTracksViewModel.LIKE_BUTTON_LABEL);
        buttons.add(likeTrack);

        // do i need to add cancel button?

        likeTrack.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(likeTrack)){
                            LikeTracksState currState = likeTracksViewModel.getState();

                            likeTracksController.like(currState.getTrack());
                            likeTracksController.unlike(currState.getTrack()); // ?
                        }
                    }
                }
        );
        this.add(title);
        this.add(buttons);
    }
    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt){
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt){
        LikeTracksState state = (LikeTracksState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(LikeTracksState state){
        // ?
    }
}
