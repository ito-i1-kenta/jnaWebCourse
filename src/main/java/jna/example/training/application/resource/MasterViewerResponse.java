package jna.example.training.application.resource;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class MasterViewerResponse {
    private List<Response> responseList;

    public void factory(List<MasterViewerResponseResource> masterViewerResponseResource){
        this.responseList = masterViewerResponseResource.stream()
                .map(val->factoryResponse(val))
                .sorted(Comparator.comparing(Response::getAssigneeId))
                .collect(Collectors.toList());
    }

    private Response factoryResponse(MasterViewerResponseResource resource){
        return new Response(
                resource.getAssigneeId().getAssignee(),
                resource.getAssigneeName().getAssigneeName()
        );
    }

    @Data
    @AllArgsConstructor
    private class Response{
        private int assigneeId;
        private String assigneeName;
    }

}
