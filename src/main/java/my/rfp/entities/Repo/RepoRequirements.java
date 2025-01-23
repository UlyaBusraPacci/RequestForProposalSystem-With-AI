package my.rfp.entities.Repo;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "repo_requirements")
@NoArgsConstructor
public class RepoRequirements {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // Define the relationship with RepoModules (Many requirements can be associated with one module)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", referencedColumnName = "id")
    private RepoModules repoModules;

    @Column(name = "details", length = 250000)
    private String details;

    @Column(name = "response", length = 250000)
    private String response;

    public RepoRequirements(int id, RepoModules repoModules, String details, String response) {
        this.id = id;
        this.repoModules = repoModules;
        this.details = details;
        this.response = response;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RepoModules getRepoModules() {
        return repoModules;
    }

    public void setRepoModules(RepoModules repoModules) {
        this.repoModules = repoModules;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
