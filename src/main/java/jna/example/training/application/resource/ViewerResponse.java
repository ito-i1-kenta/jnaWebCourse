package jna.example.training.application.resource;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class ViewerResponse {
    private List<Response> responseList;

    public void factory(List<ViewerResponseResource> viewerResponseResource) {
        this.responseList = viewerResponseResource.stream()
                .map(val -> factoryResponse(val))
                .sorted(Comparator.comparing(Response::getBirthDate, Comparator.nullsLast(Comparator.reverseOrder())))
                .collect(Collectors.toList());
    }

    private Response factoryResponse(ViewerResponseResource resource) {
        return new Response(
                resource.getEmpNo().getEmpNo(),
                resource.getUserName().getUserName(),
                Optional.ofNullable(resource.getBirthDate()).map(val -> val.getBirthDate().toString()).orElse(null),
                resource.getSexName().getSexName(),
                resource.getBirthPlaceName().getBirthPlaceName(),
                Optional.ofNullable(resource.getNickName()).map(val -> val.getNickName()).orElse(null),
                Optional.ofNullable(resource.getAssigneeName()).map(val -> val.getAssigneeName()).orElse("無所属"),
                Optional.ofNullable(resource.getPhoto()).map(val -> val.getPhoto()).orElse(null)
        );
    }

    @Data
    @AllArgsConstructor
    private class Response {
        private String empNo;
        private String userName;
        private String birthDate;
        private String sexName;
        private String birthPlaceName;
        private String nickName;
        private String assigneeName;
        private String photo;
    }

}
