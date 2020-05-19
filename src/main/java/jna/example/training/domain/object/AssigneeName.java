package jna.example.training.domain.object;

import lombok.Value;

import java.util.Optional;

@Value
public class AssigneeName {

    private String assigneeName;

    private AssigneeName(String value) {
        this.assigneeName = value;
    }

    public static AssigneeName of(String value) {
        return Optional.ofNullable(value).map(AssigneeName::new).orElse(null);
    }

}
