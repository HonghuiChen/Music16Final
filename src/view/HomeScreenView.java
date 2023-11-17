package view;

import interface_adapter.homeScreen.HomeScreenState;
import interface_adapter.homeScreen.HomeScreenViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class HomeScreenView extends JFrame implements ActionListener, PropertyChangeListener {

    public final String viewName = "logged in";
    private final HomeScreenViewModel homeScreenViewModel;

    JLabel username;

    final JButton logOut;
    private JTextField searchInputField;
    private JComboBox<String> searchTypeDropdown;
    private JTextArea outputArea;
    private JButton searchButton;

    /**
     * A window with a title and a JButton.
     */
    public HomeScreenView(HomeScreenViewModel homeScreenViewModel) {
        this.homeScreenViewModel = homeScreenViewModel;
        this.homeScreenViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Logged In Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Currently logged in: ");
        username = new JLabel();

        JPanel buttons = new JPanel();
        logOut = new JButton(homeScreenViewModel.LOGOUT_BUTTON_LABEL);
        buttons.add(logOut);

        // Initialize components
        searchInputField = new JTextField(20);
        searchTypeDropdown = new JComboBox<>(new String[]{"Search Tracks", "Search Songs", "Search Artists"});
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        searchButton = new JButton("Search");

        // Layout
        this.setLayout(new FlowLayout());
        this.add(searchInputField);
        this.add(searchTypeDropdown);
        this.add(searchButton);
        this.add(new JScrollPane(outputArea));

        // Action listeners
        searchButton.addActionListener(e -> performSearch());

        // Frame settings
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void performSearch() {
        String query = searchInputField.getText();
        String searchType = (String) searchTypeDropdown.getSelectedItem();
        // Call interactor here with query and searchType
        // For example: String result = interactor.search(query, searchType);
        // Then display the result
        String result = "Mock result for " + query + " with type " + searchType; // Replace with actual call
        outputArea.setText(result);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        HomeScreenState state = (HomeScreenState) evt.getNewValue();
        username.setText(state.getUsername());
    }
}