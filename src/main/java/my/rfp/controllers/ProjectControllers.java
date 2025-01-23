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
import my.rfp.business.abstracts.ProjectService;
import my.rfp.business.requests.CreateProjectRequest;
import my.rfp.business.requests.UpdateProjectRequest;
import my.rfp.business.responses.GetAllProjectsResponse;
import my.rfp.business.responses.GetByIdProjectsResponse;
import my.rfp.business.rules.ProjectBusinessRules;

@RestController 
@RequestMapping("/api/projects")
public class ProjectControllers {
	
	List<GetAllProjectsResponse> project1;
	
	private ProjectService projectService;
//	private GetByIdProjectsResponse getByIdProjectsResponse;
	private ProjectBusinessRules projectBusinessRules;
	
	@Autowired
	public ProjectControllers( ProjectService projectService, ProjectBusinessRules projectBusinessRules) {
		this.projectService = projectService;
		this.projectBusinessRules = projectBusinessRules;
	}
	
	
	@GetMapping("/allProjects")
	public List<GetAllProjectsResponse> getAllRfps(){
		project1=projectService.getAll();
		
		 for (int i = 0; i < project1.size(); i++) {
			  System.out.println(project1.get(i).getId());
			  System.out.println(project1.get(i).getName());
			  System.out.println(project1.get(i).getStatus());
			  System.out.println(project1.get(i).getCreateDate());

		 }
			return project1;
	}
	
	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody() @Valid() CreateProjectRequest createProjectRequest) {
		  this.projectService.add(createProjectRequest);
		
	}
	
	@GetMapping("/{id}")
	public GetByIdProjectsResponse getById(@PathVariable int id) {
		 projectBusinessRules.checkIfProjectExistsById(id);
		 return projectService.getById(id);
	}
	
	@PatchMapping("/{id}")
	public void update(@RequestBody() UpdateProjectRequest updateProjectRequest) {
		projectBusinessRules.checkIfProjectExistsById(updateProjectRequest.getId());
		projectService.update(updateProjectRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.projectService.delete(id);
	}
}
