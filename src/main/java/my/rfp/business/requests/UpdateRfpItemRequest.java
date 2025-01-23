package my.rfp.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.rfp.entities.rfpMain.Rfp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateRfpItemRequest {
	 private int id;
	 private Rfp rfp;
	 private String details;
	 private String response;
}
