package jna.example.training.domain.object;

import lombok.Value;

import java.util.Optional;

@Value
public class PositionName {
    private String positionName;

    private PositionName(String value){
        this.positionName = value;
    }

    public static PositionName of(String value){
        return Optional.ofNullable(value).map(PositionName::new).orElse(null);
    }
}
