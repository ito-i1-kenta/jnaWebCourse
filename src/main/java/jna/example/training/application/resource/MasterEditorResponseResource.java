package jna.example.training.application.resource;

import jna.example.training.domain.object.AssigneeId;
import jna.example.training.domain.object.AssigneeName;
import jna.example.training.infrastructure.entity.AssigneeEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MasterEditorResponseResource {
    private AssigneeId assigneeId;
    private AssigneeName assigneeName;


}
