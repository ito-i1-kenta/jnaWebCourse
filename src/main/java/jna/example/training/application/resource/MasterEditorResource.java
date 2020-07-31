package jna.example.training.application.resource;

import jna.example.training.domain.object.AssigneeId;
import jna.example.training.domain.object.AssigneeName;
import jna.example.training.infrastructure.entity.AssigneeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "masterEdit")
public class MasterEditorResource {
    private AssigneeId assigneeId;
    private AssigneeName assigneeName;

    public AssigneeEntity toEntity(){
        return AssigneeEntity.builder()
                .assigneeId(String.valueOf(assigneeId.getAssignee()))
                .assigneeName(assigneeName.getAssigneeName())
                .build();
    }
}
