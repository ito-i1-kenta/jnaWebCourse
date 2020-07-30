package jna.example.training.domain.object;

import lombok.Value;

import java.util.Optional;

@Value
public class PositionId {
    private int positionId;

    private PositionId(String value){
        this.positionId = Integer.parseInt(value);
    }

    public static PositionId of(String value){
        return Optional.ofNullable(value).map(PositionId::new).orElse(null);
    }
}
