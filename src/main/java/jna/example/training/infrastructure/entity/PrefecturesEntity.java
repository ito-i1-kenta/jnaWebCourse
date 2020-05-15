package jna.example.training.infrastructure.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrefecturesEntity {
    private int placeId;
    private String placeName;
}
