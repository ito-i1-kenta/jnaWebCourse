package jna.example.training.infrastructure.mapper;

import jna.example.training.infrastructure.entity.AssigneeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AssigneeMapper {

    List<AssigneeEntity> getAssigneeList();
}
