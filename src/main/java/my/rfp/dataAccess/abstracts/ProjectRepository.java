package my.rfp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import my.rfp.entities.rfpMain.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
