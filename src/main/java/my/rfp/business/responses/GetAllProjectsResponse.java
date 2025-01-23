package my.rfp.business.responses;
import java.util.Date;

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
public class GetAllProjectsResponse {
	private int id;
	private String name;
	private String status;
	private Date createDate;
}
