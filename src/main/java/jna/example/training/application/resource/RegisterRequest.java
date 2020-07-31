package jna.example.training.application.resource;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class RegisterRequest {
    // 桁数、数値のバリデート
    @NotNull
    @Pattern(regexp = "[0-9]{6}")
    public String empNo;

    @NotNull
    public String userName;

    @NotNull
    public String password;

    // 日付（YYYY-MM-DD）のバリデーション
    @DateTimeFormat
    public String birthDate;

    @NotNull
    public String sex;

    @NotNull
    public String birthPlace;

    public String nickName;

    @NotNull
    public String assignee;

    public String photo;

}
