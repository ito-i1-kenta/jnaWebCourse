package jna.example.training.infrastructure.mapper;

import jna.example.training.infrastructure.entity.AssigneeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssigneesMapper {
    List<AssigneeEntity> getAssigneeList();
    AssigneeEntity searchById(int assigneeId);
    void edit(AssigneeEntity assigneeEntity);
    void delete(int assigneeId);
    void save(String assigneeName);

}
