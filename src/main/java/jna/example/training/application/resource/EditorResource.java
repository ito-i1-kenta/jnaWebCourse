package jna.example.training.application.resource;

import jna.example.training.domain.object.*;
import jna.example.training.infrastructure.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Data
@AllArgsConstructor(staticName = "edit")
public class EditorResource {
    private EmpNo empNo;
    private UserName userName;
    private Password password;
    private BirthDate birthDate;
    private SexId sexId;
    private BirthPlaceId birthPlaceId;
    private NickName nickName;
    private AssigneeId assigneeId;
    private Photo photo;

    public EmployeeEntity toEntity() {
        return EmployeeEntity.builder()
                .empNo(empNo.getEmpNo())
                .userName(userName.getUserName())
                .password(password.getPassword())
                .birthDate(Optional.ofNullable(birthDate)
                        .map(BirthDate::getBirthDate).map(val->val.format(DateTimeFormatter.ISO_LOCAL_DATE)).orElse(null))
                .sexId(sexId.getSex())
                .birthPlaceId(birthPlaceId.getBirthPlace())
                .nickName(Optional.ofNullable(nickName)
                        .map(NickName::getNickName).orElse(null))
                .assigneeId(assigneeId.getAssignee())
                .photo(Optional.ofNullable(photo)
                        .map(val -> val.getPhoto().getBytes()).orElse(null))
                .build();
    }
}
