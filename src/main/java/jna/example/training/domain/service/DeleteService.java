package jna.example.training.domain.service;

import jna.example.training.infrastructure.mapper.EmployeeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteService {

    private final EmployeeMapper employeeMapper;

    /**
     * 社員情報削除
     */
    public boolean delete(String empNo) {
        return employeeMapper.delete(empNo);
    }
}
