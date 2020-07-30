package jna.example.training.infrastructure.mapper;

import jna.example.training.application.resource.EmployeeEntityResource;
import jna.example.training.infrastructure.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    List<EmployeeEntity> search(EmployeeEntity entity);

    EmployeeEntity searchByEmpNo(String empNo);

    void save(EmployeeEntity entity);

    void save(EmployeeEntityResource resource);

    void delete(String id);

    void edit(EmployeeEntity entity);

    void edit(EmployeeEntityResource resource);

}
