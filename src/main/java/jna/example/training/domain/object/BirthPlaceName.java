package jna.example.training.domain.object;

import lombok.Value;

import java.util.Optional;

@Value
public class BirthPlaceName {

    private String birthPlaceName;

    private BirthPlaceName(String value) {
        this.birthPlaceName = value;
    }

    public static BirthPlaceName of(String value) {
        return Optional.ofNullable(value).map(BirthPlaceName::new).orElse(null);
    }

}
