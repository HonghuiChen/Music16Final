package entity;

import java.time.LocalDateTime;

public class UserFactory {

    // Just UserFactory class without Interface since we probably only have one type of user
    public User create(String name, String password, LocalDateTime ltd) {
        return new User(name, password, ltd);
    }

}
