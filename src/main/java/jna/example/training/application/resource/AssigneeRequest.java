package jna.example.training.application.resource;

import jna.example.training.infrastructure.entity.AssigneeEntity;
import lombok.Data;

@Data
public class AssigneeRequest {
    private String assigneeId;
    private String assigneeName;

    public void setAssigneeEntity(AssigneeEntity assigneeEntity){
        this.assigneeId = String.valueOf(assigneeEntity.getAssigneeId());
        this.assigneeName = assigneeEntity.getAssigneeName();
    }

    public AssigneeEntity getAssigneeEntity(){
        return AssigneeEntity.builder()
                .assigneeId(Integer.parseInt(assigneeId))
                .assigneeName(assigneeName)
                .build();
    }
}
