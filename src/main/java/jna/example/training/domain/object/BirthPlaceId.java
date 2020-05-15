package jna.example.training.domain.object;

import lombok.Value;

import java.util.Optional;

@Value
public class BirthPlaceId {

    private int birthPlace;

    private BirthPlaceId(String value) {
        this.birthPlace = Integer.parseInt(value);
    }

    public static BirthPlaceId of(String value) {
        return Optional.ofNullable(value).map(BirthPlaceId::new).orElse(null);
    }

}
