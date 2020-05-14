package jna.example.training.domain.object;

import lombok.Value;

import java.util.Optional;

@Value
public class Password {

    private String password;

    private Password(String value) {
        this.password = value;
    }

    public static Password of(String value) {
        return Optional.ofNullable(value).map(Password::new).orElse(null);
    }

}
