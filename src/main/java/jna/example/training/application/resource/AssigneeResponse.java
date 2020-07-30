package jna.example.training.application.resource;

import jna.example.training.infrastructure.entity.AssigneeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AssigneeResponse {
    private List<AssigneeEntity> assigneeEntityList;

}
