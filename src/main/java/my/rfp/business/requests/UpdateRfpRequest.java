package my.rfp.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.rfp.entities.rfpMain.Project;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRfpRequest {
	private int id;
//	// object olarak istenmiyorsa bunu aç diğer dosyalarda da
//	private int project_id;
	private Project project;

	private String name;
}
