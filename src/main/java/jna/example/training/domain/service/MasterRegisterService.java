package jna.example.training.domain.service;

import jna.example.training.application.resource.MasterRegisterRequest;
import jna.example.training.application.resource.MasterViewerResponse;
import jna.example.training.application.resource.MasterViewerResponseResource;
import jna.example.training.domain.object.AssigneeId;
import jna.example.training.domain.object.AssigneeName;
import jna.example.training.infrastructure.entity.AssigneeEntity;
import jna.example.training.infrastructure.mapper.AssigneeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class MasterRegisterService {

    private final AssigneeMapper assigneeMapper;

    /**
     * 拠点情報取得
     */
    public List<MasterViewerResponseResource> search(){
        List<AssigneeEntity> result = assigneeMapper.getAssigneeList();

        return result.stream().map(val->searchFactory(val)).collect(Collectors.toList());

    }



    /**
     * 拠点建築
     */
    public void masterRegister(MasterRegisterRequest masterRegisterRequest){

        assigneeMapper.save(masterRegisterRequest.getAssigneeName());
    }


    private MasterViewerResponseResource searchFactory(AssigneeEntity entity){
        return MasterViewerResponseResource.builder()
                .assigneeId(AssigneeId.of(entity.getAssigneeId()))
                .assigneeName(AssigneeName.of(entity.getAssigneeName()))
                .build();
    }
}
