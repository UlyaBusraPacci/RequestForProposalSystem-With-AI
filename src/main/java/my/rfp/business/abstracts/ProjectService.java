package my.rfp.business.abstracts;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import my.rfp.business.requests.CreateProjectRequest;
import my.rfp.business.requests.UpdateProjectRequest;
import my.rfp.business.responses.GetAllProjectsResponse;
import my.rfp.business.responses.GetByIdProjectsResponse;



@RestController
public interface ProjectService {
	  List<GetAllProjectsResponse> getAll();
      void add(CreateProjectRequest createProjectRequest);
      GetByIdProjectsResponse getById(int id);
      void update(UpdateProjectRequest updateProjectRequest);
      void delete(int id);
}
