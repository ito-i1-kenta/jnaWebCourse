package jna.example.training.application.resource;

import lombok.Data;

@Data
public class ViewerResponseEntityResource {
    private String empNo;
    private String name;
    private String positionName;
    private int basicSalary;
    private int postAllowance;
}
