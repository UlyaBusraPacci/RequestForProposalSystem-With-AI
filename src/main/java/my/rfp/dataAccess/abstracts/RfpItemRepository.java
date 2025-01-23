package my.rfp.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import my.rfp.entities.rfpMain.RfpItem;


public interface RfpItemRepository extends JpaRepository<RfpItem, Integer> {

}
