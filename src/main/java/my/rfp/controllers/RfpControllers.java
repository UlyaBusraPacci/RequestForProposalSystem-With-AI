package my.rfp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import my.rfp.ai.AiMain;
import my.rfp.business.abstracts.RfpService;
import my.rfp.business.requests.CreateRfpRequest;
import my.rfp.business.requests.UpdateRfpRequest;
import my.rfp.business.responses.GetAllRfpsResponse;
import my.rfp.business.responses.GetByIdRfpsResponse;
import my.rfp.business.rules.RfpBusinessRules;

@RestController // do not forget that , if you do , you can not see funcs on swagger
@RequestMapping("/api/rfps")
public class RfpControllers {
	
	List<GetAllRfpsResponse> rfp1;
	
//	@Autowired // bunu koymadığımda 500 hata
	private RfpService rfpService;
	private GetByIdRfpsResponse getByIdRfpsResponse;
	private AiMain aiMain;
	private RfpBusinessRules rfpBusinessRules;
	  @Autowired
	    public RfpControllers(RfpService rfpService, RfpBusinessRules rfpBusinessRules,AiMain aiMain) {
	        this.rfpService = rfpService;
	        this.rfpBusinessRules = rfpBusinessRules;
	        this.getByIdRfpsResponse= getByIdRfpsResponse;
	        this.aiMain=aiMain;
	    }
	@GetMapping("/allRfps")
	public List<GetAllRfpsResponse> getAllRfps(){
		rfp1=rfpService.getAll();
		
		 for (int i = 0; i < rfp1.size(); i++) {
			  System.out.println(rfp1.get(i).getId());
			  System.out.println(rfp1.get(i).getProject_id());
			  System.out.println(rfp1.get(i).getName());
		 }
			return rfp1;
	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateRfpRequest createRfpRequest) {
//		aiMain.checkIfRfprequirement_descriptionExists(createRfpRequest.getRequirement_description(),createRfpRequest);
// // the old vers , switch silinmiş bu açılmış hali yani
		  this.rfpService.add(createRfpRequest);
		
	}
	
	@GetMapping("/{id}")
	public GetByIdRfpsResponse getById(@PathVariable int id) {
		 rfpBusinessRules.checkIfRfpExistsById(id);
		 return rfpService.getById(id);
	}
	
	@PatchMapping("/{id}")
	public void update(@RequestBody() UpdateRfpRequest updateRfpRequest) {
		rfpBusinessRules.checkIfRfpExistsById(updateRfpRequest.getId());
		rfpService.update(updateRfpRequest);

	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.rfpService.delete(id);
	}
	 
}
