package jna.example.training.infrastructure.mapper;

import jna.example.training.infrastructure.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    List<EmployeeEntity> search(EmployeeEntity entity);

    EmployeeEntity searchById(String empNo);

    void save(EmployeeEntity entity);

}
