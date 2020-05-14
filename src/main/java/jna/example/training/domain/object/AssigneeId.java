package jna.example.training.domain.object;

import lombok.Value;

import java.util.Optional;

@Value
public class AssigneeId {

    private int assignee;

    private AssigneeId(String value) {
        this.assignee = Integer.parseInt(value);
    }

    public static AssigneeId of(String value) {
        return Optional.ofNullable(value).map(AssigneeId::new).orElse(null);
    }

}
