package my.rfp.entities.rfpMain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rfp_item")
@NoArgsConstructor
public class RfpItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "rfp_id", referencedColumnName = "id", insertable = true, updatable = true)  
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Rfp rfp;
    
    @Column(name = "details", length = 250000)
    private String details;
    
    @Column(name = "response", length = 250000)
    private String response;

    public RfpItem(int id, Rfp rfp, String details, String response) {
        this.id = id;
        this.rfp = rfp;
        this.details = details;
        this.response = response;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rfp getRfp() {
        return rfp;
    }

    public void setRfp(Rfp rfp) {
        this.rfp = rfp;
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
