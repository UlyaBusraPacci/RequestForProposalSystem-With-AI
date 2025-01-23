package my.rfp.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.rfp.business.abstracts.RfpItemService;
import my.rfp.business.requests.CreateRfpItemRequest;
import my.rfp.business.requests.UpdateRfpItemRequest;
import my.rfp.business.responses.GetAllRfpItemsResponse;
import my.rfp.business.responses.GetAllRfpsResponse;
import my.rfp.business.responses.GetByIdRfpItemResponse;
import my.rfp.core.utilities.mappers.ModelMapperService;
import my.rfp.dataAccess.abstracts.RfpItemRepository;
import my.rfp.dataAccess.abstracts.RfpRepository;
import my.rfp.entities.rfpMain.Rfp;
import my.rfp.entities.rfpMain.RfpItem;

@Service
public class RfpItemManager implements RfpItemService{

	private final RfpItemRepository rfpItemRepository;
	private final ModelMapperService modelMapperService;
	 
	@Autowired
	private RfpRepository rfpRepository;

	@Autowired
	public RfpItemManager(RfpItemRepository rfpItemRepository, ModelMapperService modelMapperService) {
		super();
		this.rfpItemRepository = rfpItemRepository;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<GetAllRfpItemsResponse> getAll() {
		 List<RfpItem> itemss = rfpItemRepository.findAll();
	     List<GetAllRfpItemsResponse> response = new ArrayList<>();
	     
	     for (RfpItem item : itemss) {
	        GetAllRfpItemsResponse getAllRfpItemsResponse = new GetAllRfpItemsResponse();
	        getAllRfpItemsResponse.setId(item.getId());
//	        getAllRfpItemsResponse.setRfp_id(item.getRfp());
	        getAllRfpItemsResponse.setDetails(item.getDetails());
	        getAllRfpItemsResponse.setResponse(item.getResponse());

	        response.add(getAllRfpItemsResponse);

	     }
	     
		return response;
	}

	@Override
	public void add(CreateRfpItemRequest createRfpItemRequest) {
		RfpItem rfpItem =this.modelMapperService.forRequest().map(createRfpItemRequest, RfpItem.class);

//		Rfp rfp = rfpItem.getRfp();
//	        if (rfp != null && rfp.getId() == 0) {
//	            // Rfp henüz veritabanına kaydedilmemişse, önce Rfp'yi kaydet
//	            rfp = rfpRepository.save(rfp);
//	            rfpItem.setRfp(rfp);
//	        }
//	        
//	        else {
//	        	System.out.println("böyle bir id yok");
//	        }
		this.rfpItemRepository.save(rfpItem);
	}

	@Override
	public GetByIdRfpItemResponse getById(int id) {
		RfpItem rfpItem =this.rfpItemRepository.findById(id).orElseThrow();
		GetByIdRfpItemResponse response =this.modelMapperService.forResponse().map(rfpItem, GetByIdRfpItemResponse.class);
		
		return response;
	}

	@Override
	public void update(UpdateRfpItemRequest updateRfpItemRequest) {
		RfpItem rfpItem = this.modelMapperService.forRequest().map(updateRfpItemRequest, RfpItem.class);
		this.rfpItemRepository.save(rfpItem);		
	}
//	@Override
//	public void update(UpdateRfpItemRequest updateRfpItemRequest) {
//	    RfpItem existingRfpItem = rfpItemRepository.findById(updateRfpItemRequest.getId())
//	        .orElseThrow(() -> new RuntimeException("RfpItem not found with id: " + updateRfpItemRequest.getId()));
//
//	    System.out.println("Existing RfpItem: " + existingRfpItem); // Debug log
//
//	    existingRfpItem.setRfp(updateRfpItemRequest.getRfp());
//	    existingRfpItem.setDetails(updateRfpItemRequest.getDetails());
//	    existingRfpItem.setResponse(updateRfpItemRequest.getResponse());
//
//	    System.out.println("Updated RfpItem: " + existingRfpItem); // Debug log
//
//	    rfpItemRepository.save(existingRfpItem);
//	}

	@Override
	public void delete(int id) {
		this.rfpItemRepository.deleteById(id);		
	}

}
