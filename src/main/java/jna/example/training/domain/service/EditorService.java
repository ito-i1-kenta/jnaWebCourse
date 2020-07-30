package jna.example.training.domain.service;

import jna.example.training.application.resource.EmployeeEntityResource;
import jna.example.training.application.resource.Register_Editor_Resource;
import jna.example.training.infrastructure.entity.EmployeeEntity;
import jna.example.training.infrastructure.mapper.EmployeeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EditorService {
    private final EmployeeMapper employeeMapper;

    public void edit(Register_Editor_Resource resource){
        EmployeeEntity entity = resource.toEntity();
        entity.insertData();

        employeeMapper.edit(EmployeeEntityResource.factory(entity));
    }


}
