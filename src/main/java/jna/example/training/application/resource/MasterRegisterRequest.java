package jna.example.training.application.resource;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MasterRegisterRequest {
    // 桁数、数値のバリデート

    @NotNull
    public String assigneeName;
}
