package use_case.signup;

public class SignupInputData {

    final private String username;
    final private String password;
    final private String repeatPassword;

    public SignupInputData(String uname, String password, String repeatPassword) {
        this.username = uname;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }
}
