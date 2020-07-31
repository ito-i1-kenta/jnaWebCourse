package jna.example.training.domain.service;


import jna.example.training.application.resource.EditorResource;
import jna.example.training.application.resource.RegisterResource;
import jna.example.training.infrastructure.entity.AssigneeEntity;
import jna.example.training.infrastructure.entity.EmployeeEntity;
import jna.example.training.infrastructure.entity.PrefecturesEntity;
import jna.example.training.infrastructure.entity.SexEntity;
import jna.example.training.infrastructure.mapper.AssigneeMapper;
import jna.example.training.infrastructure.mapper.EmployeeMapper;
import jna.example.training.infrastructure.mapper.PrefecturesMapper;
import jna.example.training.infrastructure.mapper.SexMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EditorService {
    private final EmployeeMapper employeeMapper;
    private final SexMapper sexMapper;
    private final PrefecturesMapper prefecturesMapper;
    private final AssigneeMapper assigneeMapper;

    /**
     * 社員情報更新
     */
    public void editor(EditorResource resource) {
        EmployeeEntity entity = resource.toEntity();
        entity.insertData();

        employeeMapper.update(entity);

    }
}
