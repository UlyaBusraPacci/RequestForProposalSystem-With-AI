package my.rfp.business.abstracts;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import my.rfp.business.requests.CreateRfpItemRequest;
import my.rfp.business.requests.UpdateRfpItemRequest;
import my.rfp.business.responses.GetAllRfpItemsResponse;
import my.rfp.business.responses.GetByIdRfpItemResponse;

@RestController
public interface RfpItemService {
	  List<GetAllRfpItemsResponse> getAll();
      void add(CreateRfpItemRequest createRfpItemRequest);
      GetByIdRfpItemResponse getById(int id);
      void update(UpdateRfpItemRequest updateRfpItemRequest);
      void delete(int id);
}
