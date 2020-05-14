package jna.example.training.domain.object;

import lombok.Value;

import java.util.Optional;

@Value
public class UserName {

    private String userName;

    private UserName(String value) {
        this.userName = value;
    }

    public static UserName of(String value) {
        return Optional.ofNullable(value).map(UserName::new).orElse(null);
    }

}
