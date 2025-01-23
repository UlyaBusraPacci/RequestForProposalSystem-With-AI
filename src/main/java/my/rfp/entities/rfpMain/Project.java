package my.rfp.entities.rfpMain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="project")
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name="name", length = 250000)
    private String name;
    
    @Column(name="status", length = 250)
    private String status;
    
    @Column(name="create_date")
    private Date createDate;
   
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Rfp> rfps;
    
    public Project(int id, String name, String status, Date createDate) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createDate = createDate;
    }
    
    // Getters and setters
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    
    public List<Rfp> getRfps() {
        return rfps;
    }

    public void setRfps(List<Rfp> rfps) {
        this.rfps = rfps;
    }
}
