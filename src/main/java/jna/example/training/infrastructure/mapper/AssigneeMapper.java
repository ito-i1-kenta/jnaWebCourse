package jna.example.training.infrastructure.mapper;

import jna.example.training.infrastructure.entity.AssigneeEntity;
import jna.example.training.infrastructure.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssigneeMapper {

    List<AssigneeEntity> getAssigneeList();

    AssigneeEntity searchById(String assigneeId);

    void save(String assigneeName);

    void update(AssigneeEntity entity);

    void delete(String assigneeId);
}
