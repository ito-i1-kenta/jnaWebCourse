package jna.example.training.application.resource;

import jna.example.training.domain.object.EmpNo;
import jna.example.training.domain.object.UserName;
import jna.example.training.infrastructure.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "create")
public class ViewerSearchConditionResource {
    private EmpNo empNo;
    private UserName userName;

    public EmployeeEntity toEntity() {
        return EmployeeEntity.builder()
                .empNo(empNo.getEmpNo())
                .userName(userName.getUserName())
                .build();
    }
}
