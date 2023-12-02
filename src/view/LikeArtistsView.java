package view;

import interface_adapter.LikeArtists.LikeArtistsController;
import interface_adapter.LikeArtists.LikeArtistsState;
import interface_adapter.LikeArtists.LikeArtistsViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LikeArtistsView extends JPanel implements ActionListener, PropertyChangeListener{

    public final String viewName = "like artist";
    private final LikeArtistsViewModel likeArtistsViewModel;

    final JButton likeArtist;
    private final LikeArtistsController likeArtistsController;

    public LikeArtistsView(LikeArtistsViewModel likeArtistsViewModel, LikeArtistsController likeArtistsController) {
        this.likeArtistsController = likeArtistsController;
        this.likeArtistsViewModel = likeArtistsViewModel;
        this.likeArtistsViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Artist");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        likeArtist = new JButton(likeArtistsViewModel.LIKE_BUTTON_LABEL);
        buttons.add(likeArtist);

        // do i need to add cancel button?

        likeArtist.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(likeArtist)){
                            LikeArtistsState currState = likeArtistsViewModel.getState();

                            likeArtistsController.like(currState.getArtists());
                            likeArtistsController.unlike(currState.getArtists()); // ?
                        }

                    }
                }
        );
        this.add(title);
//        this.add(artistInfo); //TODO need fix
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
        LikeArtistsState state = (LikeArtistsState) evt.getNewValue();
        setFields(state);
    }
    private void setFields(LikeArtistsState state){
        // ?
    }

}
