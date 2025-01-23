package my.rfp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import my.rfp.ai.AiMain;
import my.rfp.business.abstracts.RfpItemService;
import my.rfp.business.requests.CreateRfpItemRequest;
import my.rfp.business.requests.UpdateRfpItemRequest;
import my.rfp.business.responses.GetAllRfpItemsResponse;
import my.rfp.business.responses.GetByIdRfpItemResponse;
import my.rfp.business.rules.RfpItemBusinessRules;


@RestController 
@RequestMapping("/api/rpfItems")
public class RfpItemControllers {
	
List<GetAllRfpItemsResponse> items;
	
	private RfpItemService rfpItemService;
//	private GetByIdRfpItemResponse getByIdRfpItemResponse;
	private RfpItemBusinessRules projectBusinessRules;
	private AiMain aiMain;
	
	@Autowired
	public RfpItemControllers(RfpItemService rfpItemService, AiMain aiMain ,RfpItemBusinessRules projectBusinessRules) {
		this.rfpItemService = rfpItemService;
		this.projectBusinessRules = projectBusinessRules;
		this.aiMain=aiMain;
//		this.getByIdRfpItemResponse=getByIdRfpItemResponse;
	}
	
	@GetMapping("/allRfpItems")
	public List<GetAllRfpItemsResponse> getAllRfps(){
		items=rfpItemService.getAll();
		
		 for (int i = 0; i < items.size(); i++) {
			  System.out.println(items.get(i).getId());
			  System.out.println(items.get(i).getRfp_id());
			  System.out.println(items.get(i).getDetails());
			  System.out.println(items.get(i).getResponse());

		 }
			return items;
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateRfpItemRequest createRfpItemRequest) {
		
		System.out.println("createRfpItemRequest hermes1: "+createRfpItemRequest);
//		CreateRfpItemRequest test=new CreateRfpItemRequest();
//		test.setResponse(createRfpItemRequest.getResponse());
		String response1= createRfpItemRequest.getResponse();
		System.out.println(response1);
		if(response1=="" ) {
			aiMain.checkIfResponseExists(createRfpItemRequest.getDetails(),createRfpItemRequest);
//			System.out.println(createRfpItemRequest);
		}
		else {
			this.rfpItemService.add(createRfpItemRequest);
			System.out.println("elseeee");
		}
//		this.rfpItemService.add(createRfpItemRequest);	
	}
	
	@GetMapping("/{id}")
	public GetByIdRfpItemResponse getById(@PathVariable int id) {
		 projectBusinessRules.checkIfRfpItemExistsById(id);
		 return rfpItemService.getById(id);
	}
	
	@PatchMapping("/{id}")
	public void update(@RequestBody() UpdateRfpItemRequest updateRfpItemRequest) {
		projectBusinessRules.checkIfRfpItemExistsById(updateRfpItemRequest.getId());
		rfpItemService.update(updateRfpItemRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.rfpItemService.delete(id);
	}
}
