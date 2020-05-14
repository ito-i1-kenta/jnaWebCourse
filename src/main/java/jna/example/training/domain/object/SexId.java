package jna.example.training.domain.object;

import lombok.Value;

import java.util.Optional;

@Value
public class SexId {

    private int sex;

    private SexId(String value) {
        this.sex = Integer.parseInt(value);
    }

    public static SexId of(String value) {
        return Optional.ofNullable(value).map(SexId::new).orElse(null);
    }

}
