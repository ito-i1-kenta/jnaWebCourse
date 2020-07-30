package jna.example.training.application.resource;

import lombok.Data;

import java.util.List;

@Data
public class SalaryViewerResponse {
    private List<ViewerResponseEntityResource> responseEntityList;

}

