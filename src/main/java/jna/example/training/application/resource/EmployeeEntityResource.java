package jna.example.training.application.resource;

import jna.example.training.infrastructure.entity.EmployeeEntity;
import jna.example.training.utility.FormatLocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@Data
@Builder
@AllArgsConstructor(staticName = "create")
public class EmployeeEntityResource {
    private String empNo;
    private String userName;
    private String password;
    private String birthDate;
    private int sexId;
    private int birthPlaceId;
    private String nickName;
    private int assigneeId;
    private String unitPrice;
    private int positionId;
    private byte[] photo;
    private String createAt;
    private String updateAt;

    public static EmployeeEntityResource factory(EmployeeEntity entity) {
        return EmployeeEntityResource.builder()
                .empNo(entity.getEmpNo())
                .userName(entity.getUserName())
                .password(entity.getPassword())
                .birthDate(Optional.ofNullable(entity.getBirthDate())
                        .map(val -> FormatLocalDate.toStr(val, "yyyy/MM/dd")).orElse(null))
                .sexId(entity.getSexId())
                .birthPlaceId(entity.getBirthPlaceId())
                .nickName(Optional.ofNullable(entity.getNickName())
                        .map(String::toString).orElse(null))
                .assigneeId(entity.getAssigneeId())
                .unitPrice(entity.getUnitPrice())
                .positionId(entity.getPositionId())
                .photo(null)
                .createAt(Optional.ofNullable(entity.getCreateAt())
                        .map(val -> FormatLocalDate.toStr(val, "yyyy/MM/dd")).orElse(null))
                .updateAt(Optional.ofNullable(entity.getUpdateAt())
                        .map(val -> FormatLocalDate.toStr(val, "yyyy/MM/dd")).orElse(null))
                .build();
    }
}
