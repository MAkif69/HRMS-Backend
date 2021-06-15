package kodlamaio.hrms.entities.dtos;





import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetJobPostingDtoWithQuery {

	private int id;
	private String companyName;
	private String positionName;
	private int openPositionNumber;
	private Date createdDate;
	private Date lastApplyDate;
}
