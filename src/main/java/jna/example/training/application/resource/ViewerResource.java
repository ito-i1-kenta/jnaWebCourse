package jna.example.training.application.resource;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ViewerResource {
    private ViewerSearchConditionResource viewerSearchConditionResource;
    private List<ViewerResponseResource> viewerResponseResource;

}
