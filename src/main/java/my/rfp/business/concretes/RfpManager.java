package my.rfp.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.rfp.business.abstracts.RfpService;
import my.rfp.business.requests.CreateRfpRequest;
import my.rfp.business.requests.UpdateRfpRequest;
import my.rfp.business.responses.GetAllRfpsResponse;
import my.rfp.business.responses.GetByIdRfpsResponse;
import my.rfp.core.utilities.mappers.ModelMapperService;
import my.rfp.dataAccess.abstracts.RfpRepository;
import my.rfp.entities.rfpMain.Rfp;

@Service
public class RfpManager implements RfpService {

    private final RfpRepository rfpRepository;
	private final ModelMapperService modelMapperService;

    @Autowired
    public RfpManager(RfpRepository rfpRepository, ModelMapperService modelMapperService) {
        this.rfpRepository = rfpRepository;
        this.modelMapperService = modelMapperService;

    }

    @Override
    public List<GetAllRfpsResponse> getAll() {
        List<Rfp> rfps = rfpRepository.findAll();
        List<GetAllRfpsResponse> response = new ArrayList<>();

        for (Rfp rfp : rfps) {
            GetAllRfpsResponse getAllRfpsResponse = new GetAllRfpsResponse();
            getAllRfpsResponse.setId(rfp.getId());
            getAllRfpsResponse.setName(rfp.getName());
//            getAllRfpsResponse.setProject_id(rfp.getProject().getId());


            response.add(getAllRfpsResponse);
        }

        return response;
    }

	@Override
	public void add(CreateRfpRequest createRfpRequest) {
		Rfp rfp =this.modelMapperService.forRequest().map(createRfpRequest, Rfp.class);
		this.rfpRepository.save(rfp);
	}

	@Override
	public GetByIdRfpsResponse getById(int id) {
		Rfp rfp =this.rfpRepository.findById(id).orElseThrow();
		
		GetByIdRfpsResponse response =this.modelMapperService.forResponse().map(rfp, GetByIdRfpsResponse.class);
		
		return response;
	}

	@Override
	public void update(UpdateRfpRequest updateRfpRequest) {
		Rfp rfp = this.modelMapperService.forRequest().map(updateRfpRequest, Rfp.class);
		this.rfpRepository.save(rfp);
	}

	@Override
	public void delete(int id) {
		this.rfpRepository.deleteById(id);
	}
    
	
    
}
