package my.rfp.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import my.rfp.entities.rfpMain.Project;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateRfpRequest {
  
	private int id;
	private Project project;
	private String name;

}
