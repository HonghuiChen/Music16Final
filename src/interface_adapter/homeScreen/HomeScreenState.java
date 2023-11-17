package interface_adapter.homeScreen;

public class HomeScreenState {
    private String username = "";

    public HomeScreenState(HomeScreenState copy) {
        username = copy.username;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public HomeScreenState() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
