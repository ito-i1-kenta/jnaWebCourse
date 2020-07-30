package jna.example.training.domain.service;

import jna.example.training.application.resource.SalaryViewerRequest;
import jna.example.training.application.resource.SalaryViewerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static org.thymeleaf.util.StringUtils.isEmpty;

@Service
@AllArgsConstructor
public class SalaryService {
    private final RestTemplate restTemplate;

    public SalaryViewerResponse getSalaryApi(SalaryViewerRequest request){
        if(isEmpty(request.getEmpNo()) || isEmpty(request.getPassword()) ){
            return new SalaryViewerResponse();
        }
        String url = "http://localhost:9090/api/viewer/"+request.getEmpNo()+"/"+request.getPassword();
        return restTemplate.getForObject(url, SalaryViewerResponse.class);

    }
}
