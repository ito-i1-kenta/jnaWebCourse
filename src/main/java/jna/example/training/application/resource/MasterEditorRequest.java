package jna.example.training.application.resource;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MasterEditorRequest {
    @NotNull
    public String assigneeId;

    @NotNull
    public String assigneeName;

    public void factory(MasterEditorResponseResource responseResource){
        this.assigneeId = String.valueOf(responseResource.getAssigneeId().getAssignee());
        this.assigneeName = responseResource.getAssigneeName().getAssigneeName();
    }
}
