package jna.example.training.application.resource;

import jna.example.training.domain.object.*;
import jna.example.training.infrastructure.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor(staticName = "create")
public class Register_Editor_Resource {
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


    public EmployeeEntity toEntity() {
        return EmployeeEntity.builder()
                .empNo(empNo.getEmpNo())
                .userName(userName.getUserName())
                .password(password.getPassword())
                .birthDate(Optional.ofNullable(birthDate)
                        .map(BirthDate::getBirthDate).orElse(null))
                .sexId(sexId.getSex())
                .birthPlaceId(birthPlaceId.getBirthPlace())
                .nickName(Optional.ofNullable(nickName)
                        .map(NickName::getNickName).orElse(null))
                .assigneeId(assigneeId.getAssignee())
                .unitPrice(unitPrice.getUnitPrice())
                .positionId(positionId.getPositionId())
                .photo(Optional.ofNullable(photo)
                        .map(val -> val.getPhoto().getBytes()).orElse(null))
                .build();
    }
}
