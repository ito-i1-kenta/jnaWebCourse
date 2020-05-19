package jna.example.training.domain.object;

import lombok.Value;

import java.util.Optional;

@Value
public class SexName {

    private String sexName;

    private SexName(String value) {
        this.sexName = value;
    }

    public static SexName of(String value) {
        return Optional.ofNullable(value).map(SexName::new).orElse(null);
    }

}
