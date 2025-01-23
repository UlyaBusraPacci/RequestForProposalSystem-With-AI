package my.rfp.entities.Repo;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "repo_modules")
@NoArgsConstructor
public class RepoModules {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", length = 250000)
    private String name;

  
    @OneToMany(mappedBy = "repoModules", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RepoRequirements> requirements;

    public RepoModules(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RepoRequirements> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<RepoRequirements> requirements) {
        this.requirements = requirements;
    }
}
