package jna.example.training.infrastructure.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AssigneeEntity {
    private String assigneeId;
    private String assigneeName;
}
