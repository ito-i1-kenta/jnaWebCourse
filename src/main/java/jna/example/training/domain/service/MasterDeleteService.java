package jna.example.training.domain.service;

import jna.example.training.infrastructure.mapper.AssigneeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MasterDeleteService {
    private final AssigneeMapper assigneeMapper;

    /**
     * 拠点解体
     */
    public void masterDelete(String assigneeId){
        assigneeMapper.delete(assigneeId);
    }
}
