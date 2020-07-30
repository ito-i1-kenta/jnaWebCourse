package jna.example.training.application.resource;

import jna.example.training.domain.object.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EditorResponseResource {
    private EmpNo empNo;
    private UserName userName;
    private Password password;
    private BirthDate birthDate;
    private SexId sexId;
    private BirthPlaceId birthPlaceId;
    private NickName nickName;
    private AssigneeId assigneeId;
    private UnitPrice unitPrice;
    private PositionId positionId;
    private Photo photo;

}
