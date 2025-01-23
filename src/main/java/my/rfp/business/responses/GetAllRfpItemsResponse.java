package my.rfp.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetAllRfpItemsResponse {
	 private int id;
	 private int rfp_id;
	 private String details;
	 private String response;
}
