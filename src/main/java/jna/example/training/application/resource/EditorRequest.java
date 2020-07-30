package jna.example.training.application.resource;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Optional;

@Data
public class EditorRequest {
    // 桁数、数値のバリデート
    @NotNull
    @Pattern(regexp = "[0-9]{6}")
    public String empNo;

    @NotNull
    public String userName;

    @NotNull
    public String password;

    // 日付（YYYY-MM-DD）のバリデーション
    public String birthDate;

    @NotNull
    public String sex;

    @NotNull
    public String birthPlace;

    public String nickName;

    @NotNull
    public String assignee;

    @NotNull
    public String unitPrice;

    @NotNull
    public String position;

    public String photo;

    public void factory(EditorResponseResource responseResource) {
        this.userName = responseResource.getUserName().getUserName();
        this.password = responseResource.getPassword().getPassword();
        this.birthDate = Optional.ofNullable(responseResource.getBirthDate()).map(val -> val.getBirthDate().toString()).orElse(null);
        this.sex = String.valueOf(responseResource.getSexId().getSex());
        this.birthPlace = String.valueOf(responseResource.getBirthPlaceId().getBirthPlace());
        this.nickName = Optional.ofNullable(responseResource.getNickName()).map(val -> val.getNickName()).orElse(null);
        this.assignee = String.valueOf(responseResource.getAssigneeId().getAssignee());
        this.unitPrice = String.valueOf(responseResource.getUnitPrice().getUnitPrice());
        this.position =String.valueOf(responseResource.getPositionId().getPositionId());
        this.photo = Optional.ofNullable(responseResource.getPhoto()).map(val -> val.getPhoto()).orElse(null);
    }

}
