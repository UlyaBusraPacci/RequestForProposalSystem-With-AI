package my.rfp.business.abstracts;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import my.rfp.business.requests.CreateRfpRequest;
import my.rfp.business.requests.UpdateRfpRequest;
import my.rfp.business.responses.GetAllRfpsResponse;
import my.rfp.business.responses.GetByIdRfpsResponse;

@RestController
public interface RfpService {
	   List<GetAllRfpsResponse> getAll();
       void add(CreateRfpRequest createRfpRequest);
       GetByIdRfpsResponse getById(int id);
       void update(UpdateRfpRequest updateBrandRequest);
       void delete(int id);
} 
