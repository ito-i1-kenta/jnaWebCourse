package jna.example.training.application.service;

import jna.example.training.application.resource.RegisterRequest;
import jna.example.training.application.resource.Register_Editor_Resource;
import jna.example.training.domain.object.*;
import jna.example.training.domain.service.RegisterService;
import jna.example.training.infrastructure.entity.AssigneeEntity;
import jna.example.training.infrastructure.entity.EmployeeEntity;
import jna.example.training.infrastructure.entity.PrefecturesEntity;
import jna.example.training.infrastructure.entity.SexEntity;
import jna.example.training.infrastructure.mapper.AssigneesMapper;
import jna.example.training.infrastructure.mapper.EmployeeMapper;
import jna.example.training.infrastructure.mapper.PrefecturesMapper;
import jna.example.training.infrastructure.mapper.SexMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class RegisterServiceTest {

    @Mock
    private EmployeeMapper employeeMapper;

    @Mock
    private SexMapper sexMapper;

    @Mock
    private PrefecturesMapper prefecturesMapper;

    @Mock
    private AssigneesMapper assigneesMapper;

    @Autowired
    private RegisterService service;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        service = new RegisterService(employeeMapper, sexMapper,prefecturesMapper, assigneesMapper);
    }

    @DisplayName("normal_test")
    @Test
    public void normal_test() throws Exception {

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.empNo = "012345";
        registerRequest.userName = "テスト";
        registerRequest.password = "test";
        registerRequest.birthDate = "2020-06-02";
        registerRequest.sex = "0";
        registerRequest.birthPlace = "1";
        registerRequest.nickName = "テスター";
        registerRequest.assignee = "1";
        registerRequest.photo = "";

        Register_Editor_Resource resource = Register_Editor_Resource.create(
                EmpNo.of(registerRequest.empNo),
                UserName.of(registerRequest.userName),
                Password.of(registerRequest.password),
                BirthDate.of(registerRequest.birthDate),
                SexId.of(registerRequest.sex),
                BirthPlaceId.of(registerRequest.birthPlace),
                NickName.of(registerRequest.nickName),
                AssigneeId.of(registerRequest.assignee),
                Photo.of(registerRequest.photo)
        );

        doNothing().when(employeeMapper).save(isA(EmployeeEntity.class));
        service.register(resource);
        verify(employeeMapper).save(isA(EmployeeEntity.class));

        List<SexEntity> sexEntityList = new ArrayList<>();
        when(sexMapper.getSexList()).thenReturn(sexEntityList);
        service.getSexList();
        verify(sexMapper).getSexList();

        List<AssigneeEntity> assigneeEntityList = new ArrayList<>();
        when(assigneesMapper.getAssigneeList()).thenReturn(assigneeEntityList);
        service.getAssigneeList();
        verify(assigneesMapper).getAssigneeList();

        List<PrefecturesEntity> prefecturesEntityList = new ArrayList<>();
        when(prefecturesMapper.getPrefecturesList()).thenReturn(prefecturesEntityList);
        service.getPrefecturesList();
        verify(prefecturesMapper).getPrefecturesList();
    }
}
