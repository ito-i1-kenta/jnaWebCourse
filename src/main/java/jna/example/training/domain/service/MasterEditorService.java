package jna.example.training.domain.service;

import jna.example.training.application.resource.MasterEditorResource;
import jna.example.training.application.resource.MasterEditorResponseResource;
import jna.example.training.domain.object.AssigneeId;
import jna.example.training.domain.object.AssigneeName;
import jna.example.training.infrastructure.entity.AssigneeEntity;
import jna.example.training.infrastructure.mapper.AssigneeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MasterEditorService {
    private final AssigneeMapper assigneeMapper;



    /**
     * 拠点情報更新
     */
    public void masterEditor(MasterEditorResource resource){
        AssigneeEntity entity = resource.toEntity();

        assigneeMapper.update(entity);
    }

    public MasterEditorResponseResource searchById(AssigneeId assigneeId){

        AssigneeEntity result = assigneeMapper.searchById(String.valueOf(assigneeId.getAssignee()));


        return MasterEditorResponseResource.builder()
                .assigneeId(AssigneeId.of(result.getAssigneeId()))
                .assigneeName(AssigneeName.of(result.getAssigneeName()))
                .build();
    }


}
