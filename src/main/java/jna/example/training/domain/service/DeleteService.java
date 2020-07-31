package jna.example.training.domain.service;

import jna.example.training.infrastructure.mapper.AssigneeMapper;
import jna.example.training.infrastructure.mapper.EmployeeMapper;
import jna.example.training.infrastructure.mapper.PrefecturesMapper;
import jna.example.training.infrastructure.mapper.SexMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DeleteService {

    private final EmployeeMapper employeeMapper;
    private final SexMapper sexMapper;
    private final PrefecturesMapper prefecturesMapper;
    private final AssigneeMapper assigneeMapper;

    /**
     * 社員情報削除
     */
    public void delete(String empNo){
        employeeMapper.delete(empNo);
    }



}
