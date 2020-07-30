package jna.example.training.infrastructure.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PositionEntity {
    private int positionId;
    private String positionName;

}
