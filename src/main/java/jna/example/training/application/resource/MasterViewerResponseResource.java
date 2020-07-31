package jna.example.training.application.resource;

import jna.example.training.domain.object.AssigneeId;
import jna.example.training.domain.object.AssigneeName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MasterViewerResponseResource {
    private AssigneeId assigneeId;
    private AssigneeName assigneeName;
}
