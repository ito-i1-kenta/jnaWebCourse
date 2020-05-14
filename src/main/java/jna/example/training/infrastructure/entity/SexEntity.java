package jna.example.training.infrastructure.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SexEntity {
    private int sexId;
    private String sexName;
}
