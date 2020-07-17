package jna.example.training.domain.service;

import jna.example.training.application.resource.EditorResponseResource;
import jna.example.training.application.resource.ViewerResource;
import jna.example.training.application.resource.ViewerResponseResource;
import jna.example.training.domain.object.*;
import jna.example.training.infrastructure.entity.EmployeeEntity;
import jna.example.training.infrastructure.mapper.EmployeeMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ViewerService {

    private final EmployeeMapper employeeMapper;

    /**
     * 社員情報検索
     */
    public List<ViewerResponseResource> search(ViewerResource resource) {
        EmployeeEntity entity = resource.getViewerSearchConditionResource().toEntity();

        List<EmployeeEntity> result = employeeMapper.search(entity);

        return result.stream().map(val -> searchFactory(val)).collect(Collectors.toList());
    }

    /**
     * 社員情報検索（社員番号）
     */
    public EditorResponseResource searchById(EmpNo empNo) {

        EmployeeEntity result = employeeMapper.searchById(empNo.getEmpNo());

        ViewerResponseResource resource = searchFactory(result);
        return EditorResponseResource.builder()
                .empNo(EmpNo.of(result.getEmpNo()))
                .userName(UserName.of(result.getUserName()))
                .password(Password.of(result.getPassword()))
                .birthDate(Optional.ofNullable(result.getBirthDate()).map(val -> BirthDate.of(val.toString())).orElse(null))
                .sexId(SexId.of(Integer.valueOf(result.getSexId()).toString()))
                .birthPlaceId(BirthPlaceId.of(Integer.valueOf(result.getBirthPlaceId()).toString()))
                .nickName(Optional.ofNullable(result.getNickName()).map(val -> NickName.of(val)).orElse(null))
                .assigneeId(Optional.ofNullable(result.getAssigneeId()).map(val -> AssigneeId.of(Integer.valueOf(val).toString())).orElse(null))
                .photo(Optional.ofNullable(result.getPhoto()).map(val -> Photo.of(new String(val))).orElse(null))
                .build();

    }

    private ViewerResponseResource searchFactory(EmployeeEntity entity) {
        return ViewerResponseResource.builder()
                .empNo(EmpNo.of(entity.getEmpNo()))
                .userName(UserName.of(entity.getUserName()))
                .birthDate(Optional.ofNullable(entity.getBirthDate()).map(val -> BirthDate.of(val.toString())).orElse(null))
                .sexName(SexName.of(entity.getSexName()))
                .birthPlaceName(BirthPlaceName.of(entity.getBirthPlaceName()))
                .nickName(Optional.ofNullable(entity.getNickName()).map(val -> NickName.of(val)).orElse(null))
                .assigneeName(Optional.ofNullable(entity.getAssigneeName()).map(val -> AssigneeName.of(val)).orElse(null))
                .photo(Optional.ofNullable(entity.getPhoto()).map(val -> Photo.of(new String(val))).orElse(null))
                .build();
    }

}
