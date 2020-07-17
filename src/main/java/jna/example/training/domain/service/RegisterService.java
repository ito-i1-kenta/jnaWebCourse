package jna.example.training.domain.service;

import jna.example.training.application.resource.RegisterResource;
import jna.example.training.infrastructure.entity.AssigneeEntity;
import jna.example.training.infrastructure.entity.EmployeeEntity;
import jna.example.training.infrastructure.entity.PrefecturesEntity;
import jna.example.training.infrastructure.entity.SexEntity;
import jna.example.training.infrastructure.mapper.AssigneeMapper;
import jna.example.training.infrastructure.mapper.EmployeeMapper;
import jna.example.training.infrastructure.mapper.PrefecturesMapper;
import jna.example.training.infrastructure.mapper.SexMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegisterService {

    private final EmployeeMapper employeeMapper;
    private final SexMapper sexMapper;
    private final PrefecturesMapper prefecturesMapper;
    private final AssigneeMapper assigneeMapper;

    /**
     * 社員情報登録
     */
    public void register(RegisterResource resource) {
        EmployeeEntity entity = resource.toEntity();
        entity.insertData();

        employeeMapper.save(entity);

    }

    /**
     * 性別リスト取得
     */
    public List<SexEntity> getSexList() {
        return sexMapper.getSexList();
    }

    /**
     * 出身地リスト取得
     */
    public List<PrefecturesEntity> getPrefecturesList() {
        return prefecturesMapper.getPrefecturesList();
    }

    /**
     * 配属先リスト取得
     */
    public List<AssigneeEntity> getAssigneeList(){
        return assigneeMapper.getAssigneeList();
    }
}
