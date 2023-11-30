package view;

import interface_adapter.GenrePreference.GenreController;
import interface_adapter.GenrePreference.GenreState;
import interface_adapter.GenrePreference.GenreViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GenreView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "genre preference";
    private final GenreViewModel genreViewModel;

    final JTextField genreInputField = new JTextField(15);
    private final JLabel genreErrorField = new JLabel();

    final JButton add;
    final JButton delete;
    final JButton cancel;
    private final GenreController GenreController;

    public GenreView(GenreViewModel genreViewModel, GenreController controller) {

        this.GenreController = controller;
        this.genreViewModel = genreViewModel;
        this.genreViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Add Genre Preference Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Genre"), genreInputField);

        JPanel buttons = new JPanel();
        add = new JButton(GenreViewModel.ADD_BUTTON_LABEL);
        buttons.add(add);
        delete = new JButton(GenreViewModel.DELETE_BUTTON_LABEL);
        buttons.add(delete);
        cancel = new JButton(GenreViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        add.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(add)) {
                            GenreState currentState = genreViewModel.getState();

                            GenreController.add(currentState.getGenre());
                        }
                    }
                }
        );

        delete.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(delete)) {
                            GenreState currentState = genreViewModel.getState();

                            GenreController.delete(currentState.getGenre());
                        }
                    }
                }
        );

        genreInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                GenreState currentState = genreViewModel.getState();
                currentState.setGenre(genreInputField.getText() + e.getKeyChar());
                genreViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        this.add(title);
        this.add(usernameInfo);
        this.add(genreErrorField);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        GenreState state = (GenreState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(GenreState state) {
        genreInputField.setText(state.getGenre());
    }

}