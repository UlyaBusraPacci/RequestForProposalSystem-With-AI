package my.rfp.business.rules;

import java.util.Optional;

import org.springframework.stereotype.Component;

import my.rfp.dataAccess.abstracts.ProjectRepository;
import my.rfp.entities.rfpMain.Project;

@Component
public class ProjectBusinessRules {
	
	private ProjectRepository projectRepository;

	public ProjectBusinessRules(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public Project checkIfProjectExistsById(int id) {
		
        Optional<Project> project = projectRepository.findById(id);

        if(!project.isPresent()){
            throw new RuntimeException("ID is invalid because RFP does not exists");
        }

        return project.get();		
	}

}
