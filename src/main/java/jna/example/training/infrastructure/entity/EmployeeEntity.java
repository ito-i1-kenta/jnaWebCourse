package jna.example.training.infrastructure.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@Builder
@EqualsAndHashCode(callSuper = true)
public class EmployeeEntity extends CommonEntity {
    private String empNo;
    private String userName;
    private String password;
    private LocalDate birthDate;
    private int sexId;
    private String sexName;
    private int birthPlaceId;
    private String birthPlaceName;
    private String nickName;
    private int assigneeId;
    private String unitPrice;
    private int positionId;
    private String positionName;
    private String assigneeName;
    private byte[] photo;
}
