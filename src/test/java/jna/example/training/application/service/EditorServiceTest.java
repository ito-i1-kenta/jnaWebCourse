package jna.example.training.application.service;

import jna.example.training.application.resource.RegisterRequest;
import jna.example.training.application.resource.Register_Editor_Resource;
import jna.example.training.domain.object.*;
import jna.example.training.domain.service.EditorService;
import jna.example.training.infrastructure.entity.EmployeeEntity;
import jna.example.training.infrastructure.mapper.EmployeeMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class EditorServiceTest {
    @Mock
    private EmployeeMapper employeeMapper;

    @Autowired
    private EditorService service;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        service = new EditorService(employeeMapper);
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

        doNothing().when(employeeMapper).edit(isA(EmployeeEntity.class));
        service.edit(resource);
        verify(employeeMapper).edit(isA(EmployeeEntity.class));
    }
}
