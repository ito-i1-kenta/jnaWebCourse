package jna.example.training.application.resource;

import jna.example.training.domain.object.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ViewerResponseResource {
    private EmpNo empNo;
    private UserName userName;
    private BirthDate birthDate;
    private SexName sexName;
    private BirthPlaceName birthPlaceName;
    private NickName nickName;
    private AssigneeName assigneeName;
    private UnitPrice unitPrice;
    private PositionName positionName;
    private Photo photo;

}
