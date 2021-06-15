package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCvDetailDtoWithQuery {

	private int id;
	private String url;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String coverLetter;
	private String schoolName;
	private Date   startDate;
	private Date   graduateYear;
	private String departmentName;
	private String workedWıthCompanyName;
	private Date   experienceStartYear;
	private Date   experienceFinishYear;
	private String languageName;
	private int languageLevel;
	private String github;
	private String lınkedIn;
	private String skillName;
	private String technologyName;
	

}
