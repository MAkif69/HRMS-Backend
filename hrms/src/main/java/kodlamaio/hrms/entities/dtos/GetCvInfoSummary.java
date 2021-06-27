package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCvInfoSummary {

	private int id;
	private String firstName;
	private String lastName;
	private String schoolName;
	private String departmentName;
	private Date   graduateYear;
}
