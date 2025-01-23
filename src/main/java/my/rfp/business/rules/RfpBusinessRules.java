package my.rfp.business.rules;

import java.util.Optional;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import my.rfp.controllers.RfpControllers;
import my.rfp.dataAccess.abstracts.RfpRepository;
import my.rfp.entities.rfpMain.Rfp;
import my.rfp.ai.AiMain;

@AllArgsConstructor
@Service
public class RfpBusinessRules {

	private RfpRepository rfpRepository;
//	private AiMain aiMain;
	
	public Rfp checkIfRfpExistsById(int id){
        Optional<Rfp> rfp = rfpRepository.findById(id);

        if(!rfp.isPresent()){
            throw new RuntimeException("ID is invalid because RFP does not exists");
        }

        return rfp.get();
    }

}
