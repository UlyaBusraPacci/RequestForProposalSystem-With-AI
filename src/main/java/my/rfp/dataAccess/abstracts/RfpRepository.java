package my.rfp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import my.rfp.entities.rfpMain.Rfp;

@Repository
public interface RfpRepository extends JpaRepository<Rfp, Integer>{

}
 