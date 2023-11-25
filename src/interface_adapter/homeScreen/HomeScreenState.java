package interface_adapter.homeScreen;

import java.util.ArrayList;

public class HomeScreenState {
    private String username = "";
    ArrayList<String> output;

    public HomeScreenState(HomeScreenState copy) {
        username = copy.username;
        output = copy.output;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public HomeScreenState() {}

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public void setOutput(ArrayList<String> output) {
        this.output = output;
    }
    public String getOutput() {
        //Get a string builder to build the output
        StringBuilder outputBuilder = new StringBuilder();
        for (Object x : output) {
            outputBuilder.append(x);
            outputBuilder.append("\n");
        }
        return outputBuilder.toString();
    }

}
