package jna.example.training.application.resource;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class EditorResponse {
    private Response response;

    public void factory(EditorResponseResource responseResource) {
        this.response = factoryResponse(responseResource);
    }

    private Response factoryResponse(EditorResponseResource resource) {
        return new Response(
                resource.getEmpNo().getEmpNo(),
                resource.getUserName().getUserName(),
                resource.getPassword().getPassword(),
                Optional.ofNullable(resource.getBirthDate()).map(val -> val.getBirthDate().toString()).orElse(null),
                resource.getSexId().getSex(),
                resource.getBirthPlaceId().getBirthPlace(),
                Optional.ofNullable(resource.getNickName()).map(val -> val.getNickName()).orElse(null),
                resource.getAssigneeId().getAssignee(),
                resource.getUnitPrice().getUnitPrice(),
                resource.getPositionId().getPositionId(),
                Optional.ofNullable(resource.getPhoto()).map(val -> val.getPhoto()).orElse(null)
        );
    }

    @Data
    @AllArgsConstructor
    private class Response {
        private String empNo;
        private String userName;
        private String password;
        private String birthDate;
        private int sexId;
        private int birthPlaceId;
        private String nickName;
        private int assigneeId;
        private String unitPrice;
        private int positionId;
        private String photo;
    }

}
