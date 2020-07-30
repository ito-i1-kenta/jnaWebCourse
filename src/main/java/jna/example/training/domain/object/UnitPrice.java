package jna.example.training.domain.object;

import lombok.Value;

import java.util.Optional;

@Value
public class UnitPrice {
    private String unitPrice;

    private UnitPrice(String value) {
        this.unitPrice = value;
    }

    public static UnitPrice of(String value) {
        return Optional.ofNullable(value).map(UnitPrice::new).orElse(null);
    }

}
