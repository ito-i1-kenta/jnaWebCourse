package jna.example.training.application.service;

import jna.example.training.application.resource.*;
import jna.example.training.domain.object.*;
import jna.example.training.domain.service.ViewerService;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ViewerServiceTest {

    @Mock
    private EmployeeMapper employeeMapper;

    @Autowired
    private ViewerService service;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        service = new ViewerService(employeeMapper);
    }

    @DisplayName("Normal Test")
    @Test
    public void normal_test() {

        ViewerSearchRequest viewerSearchRequest = new ViewerSearchRequest();
        viewerSearchRequest.setEmpNo("1");
        viewerSearchRequest.setUserName("test");
        ViewerResource resource = new ViewerResource();
        resource.setViewerSearchConditionResource(
                ViewerSearchConditionResource.create(
                        Optional.ofNullable(viewerSearchRequest.empNo).map(EmpNo::of).orElse(null),
                        Optional.ofNullable(viewerSearchRequest.userName).map(UserName::of).orElse(null)
                ));
        EmployeeEntity entity = resource.getViewerSearchConditionResource().toEntity();

        //return 一致生成
        ViewerResponseResource viewerResponseResource = ViewerResponseResource.builder()
                .empNo(EmpNo.of(entity.getEmpNo()))
                .userName(UserName.of(entity.getUserName()))
                .birthDate(Optional.ofNullable(entity.getBirthDate()).map(val -> BirthDate.of(val.toString())).orElse(null))
                .sexName(SexName.of(entity.getSexName()))
                .birthPlaceName(BirthPlaceName.of(entity.getBirthPlaceName()))
                .nickName(Optional.ofNullable(entity.getNickName()).map(val -> NickName.of(val)).orElse(null))
                .assigneeName(Optional.ofNullable(entity.getAssigneeName()).map(val -> AssigneeName.of(val)).orElse(null))
                .photo(Optional.ofNullable(entity.getPhoto()).map(val -> Photo.of(new String(val))).orElse(null))
                .build();

        List<ViewerResponseResource> viewerResponseResourceList = new ArrayList<>();
        viewerResponseResourceList.add(viewerResponseResource);

        // employeeMapper.search返り値
        List<EmployeeEntity> employeeEntityList = new ArrayList<>();
        employeeEntityList.add(entity);

        when(employeeMapper.search(isA(EmployeeEntity.class))).thenReturn(employeeEntityList);
        assertThat(service.search(resource), is(viewerResponseResourceList));

        // ↑長いッ！！　助けて！！

        when(employeeMapper.searchByEmpNo(any())).thenReturn(entity);
        EditorResponseResource editorResponseResource = EditorResponseResource.builder()
                .empNo(EmpNo.of(entity.getEmpNo()))
                .userName(UserName.of(entity.getUserName()))
                .password(Password.of(entity.getPassword()))
                .birthDate(Optional.ofNullable(entity.getBirthDate()).map(val -> BirthDate.of(val.toString())).orElse(null))
                .sexId(SexId.of(Integer.valueOf(entity.getSexId()).toString()))
                .birthPlaceId(BirthPlaceId.of(Integer.valueOf(entity.getBirthPlaceId()).toString()))
                .nickName(Optional.ofNullable(entity.getNickName()).map(val -> NickName.of(val)).orElse(null))
                .assigneeId(Optional.ofNullable(entity.getAssigneeId()).map(val -> AssigneeId.of(Integer.valueOf(val).toString())).orElse(null))
                .photo(Optional.ofNullable(entity.getPhoto()).map(val -> Photo.of(new String(val))).orElse(null))
                .build();

        assertThat(service.searchByEmpNo(EmpNo.of("1")), is(editorResponseResource));
    }
}