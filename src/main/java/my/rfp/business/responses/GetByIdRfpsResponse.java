package my.rfp.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.rfp.entities.rfpMain.Project;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class GetByIdRfpsResponse {
	private int id;
//	private int project_id;
	private Project project;
	private String name;
}
