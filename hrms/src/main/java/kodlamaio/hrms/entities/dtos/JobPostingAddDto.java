package kodlamaio.hrms.entities.dtos;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingAddDto {
	
	private int cityId;
	private int companyId;
	private int positionId;
	private int workTimeId;
	private int workTypeId;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date createdDate;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date lastApplyDate;
	private String jobDescription;
	private double maxSalary;
	private double minSalary;
	private int openPositionNumber;
}
