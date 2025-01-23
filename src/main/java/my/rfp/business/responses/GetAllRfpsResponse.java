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
public class GetAllRfpsResponse {
	private int id;
//	değiştirmeye gerek duymadım 
	private int project_id;
	private String name;  
}
