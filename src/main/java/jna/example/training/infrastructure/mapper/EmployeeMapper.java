package jna.example.training.infrastructure.mapper;

import jna.example.training.infrastructure.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {

    void save(EmployeeEntity entity);

}
