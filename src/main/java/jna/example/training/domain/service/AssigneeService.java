package jna.example.training.domain.service;

import jna.example.training.infrastructure.entity.AssigneeEntity;
import jna.example.training.infrastructure.mapper.AssigneesMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AssigneeService {
    private final AssigneesMapper assigneesMapper;

    public AssigneeEntity searchById(int id) {
        return assigneesMapper.searchById(id);
    }

    public void save(String assigneeName) {
        assigneesMapper.save(assigneeName);
    }

    public void delete(int assigneeID) {
        assigneesMapper.delete(assigneeID);
    }

    public void edit(AssigneeEntity assigneeEntity) {
        assigneesMapper.edit(assigneeEntity);
    }

}
