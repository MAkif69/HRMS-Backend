package kodlamaio.hrms.entities.dtos;

import java.util.Date;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDetailDto {

	private int cvId;
	private String firstName;	
	private String lastName;
	private String coverLetter;
	private String schoolName;
	private String departmentName;
	private Date   startDate;
	private Date   graduateYear;
	private String workedWıthCompanyName;
	private Date experienceStartYear;
	private Date experienceFinishYear;
	private String languageName;
	private int languageLevel;
	private String skillName;
	private String technologyName;
	private String github;
	private String lınkedIn;
}
