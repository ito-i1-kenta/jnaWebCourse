package jna.example.training.domain.service;

import jna.example.training.application.resource.EmployeeEntityResource;
import jna.example.training.application.resource.Register_Editor_Resource;
import jna.example.training.infrastructure.entity.*;
import jna.example.training.infrastructure.mapper.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegisterService {

    private final EmployeeMapper employeeMapper;
    private final SexMapper sexMapper;
    private final PrefecturesMapper prefecturesMapper;
    private final AssigneesMapper assigneesMapper;
    private final PositionMapper positionMapper;


    /**
     * 社員情報登録
     */
    public void register(Register_Editor_Resource resource) {
        EmployeeEntity entity = resource.toEntity();
        entity.insertData();

        employeeMapper.save(EmployeeEntityResource.factory(entity));

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
     * 勤務地リスト取得
     */
    public List<AssigneeEntity> getAssigneeList() {
        return assigneesMapper.getAssigneeList();
    }

    /**
     *  役職リスト取得
     */
    public List<PositionEntity> getPositionList(){return positionMapper.getPositionList();}

}
