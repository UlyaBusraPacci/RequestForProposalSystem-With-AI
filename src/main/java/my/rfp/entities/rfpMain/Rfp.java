package my.rfp.entities.rfpMain;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rfp")
@NoArgsConstructor
//@AllArgsConstructor
public class Rfp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "id",insertable = true, updatable = true)  
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Project project;
    
    @Column(name = "name", length = 250000)
    private String name;

//    @OneToMany(mappedBy = "rfp", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<RfpItem> rfpItems;
    
    public Rfp(int id, Project project, String name) {
		super();
		this.id = id;
		this.project = project;
		this.name = name;
	}
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	
}
