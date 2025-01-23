package my.rfp.business.rules;

import java.util.Optional;

import org.springframework.stereotype.Component;

import my.rfp.dataAccess.abstracts.RfpItemRepository;
import my.rfp.entities.rfpMain.RfpItem;

@Component
public class RfpItemBusinessRules {

	private RfpItemRepository rfpItemRepository;
	
	public RfpItemBusinessRules(RfpItemRepository rfpItemRepository) {
		this.rfpItemRepository = rfpItemRepository;
	}

	public RfpItem checkIfRfpItemExistsById(int id) {

		 Optional<RfpItem> item1 = rfpItemRepository.findById(id);

	        if(!item1.isPresent()){
	            throw new RuntimeException("ID is invalid because RFP does not exists");
	        }

	        return item1.get();	
	}

}
