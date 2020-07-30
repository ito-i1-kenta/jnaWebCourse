package jna.example.training.domain.service;

import jna.example.training.infrastructure.mapper.EmployeeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class DeleteService {

    private final EmployeeMapper employeeMapper;

    /**
     * 削除処理
     */
    public void delete(String emp_No){
        employeeMapper.delete(emp_No);
    }
}
