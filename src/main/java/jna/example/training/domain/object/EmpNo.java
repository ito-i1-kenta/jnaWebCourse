package jna.example.training.domain.object;

import lombok.Value;

import java.util.Optional;

@Value
public class EmpNo {

    private String empNo;

    private EmpNo(String value) {
        this.empNo = value;
    }

    public static EmpNo of(String value) {
        return Optional.ofNullable(value).map(EmpNo::new).orElse(null);
    }

}
