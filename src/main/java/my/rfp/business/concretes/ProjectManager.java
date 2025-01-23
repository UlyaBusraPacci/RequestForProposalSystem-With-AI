package my.rfp.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.rfp.business.abstracts.ProjectService;
import my.rfp.business.requests.CreateProjectRequest;
import my.rfp.business.requests.UpdateProjectRequest;
import my.rfp.business.responses.GetAllProjectsResponse;
import my.rfp.business.responses.GetAllRfpItemsResponse;
import my.rfp.business.responses.GetByIdProjectsResponse;
import my.rfp.core.utilities.mappers.ModelMapperService;
import my.rfp.dataAccess.abstracts.ProjectRepository;
import my.rfp.entities.rfpMain.Project;
import my.rfp.entities.rfpMain.RfpItem;

@Service
public class ProjectManager implements ProjectService{

	private final ProjectRepository projectRepository;
	private final ModelMapperService modelMapperService;

	@Autowired
	public ProjectManager(ProjectRepository projectRepository, ModelMapperService modelMapperService) {
		super();
		this.projectRepository = projectRepository;
		this.modelMapperService = modelMapperService;
	}
	

	@Override
	public List<GetAllProjectsResponse> getAll() {
		 List<Project> projects = projectRepository.findAll();
	     List<GetAllProjectsResponse> response = new ArrayList<>();
	     
	     for (Project project : projects) {
		        GetAllProjectsResponse getAllProjectsResponse = new GetAllProjectsResponse();
		        getAllProjectsResponse.setId(project.getId());
//		        getAllRfpItemsResponse.setRfp_id(item.getRfp());
		        getAllProjectsResponse.setName(project.getName());
		        getAllProjectsResponse.setStatus(project.getStatus());

		        response.add(getAllProjectsResponse);

		     }
	     
		return response;
	}

	@Override
	public void add(CreateProjectRequest createProjectRequest) {
		Project project =this.modelMapperService.forRequest().map(createProjectRequest, Project.class);
		this.projectRepository.save(project);
	}

	@Override
	public GetByIdProjectsResponse getById(int id) {
		Project project =this.projectRepository.findById(id).orElseThrow();
	GetByIdProjectsResponse response =this.modelMapperService.forResponse().map(project, GetByIdProjectsResponse.class);
	
		return response;
	}

	@Override
	public void update(UpdateProjectRequest updateProjectRequest) {
		Project project = this.modelMapperService.forRequest().map(updateProjectRequest, Project.class);
		this.projectRepository.save(project);
		
	}

	@Override
	public void delete(int id) {
		this.projectRepository.deleteById(id);		
	}

}
