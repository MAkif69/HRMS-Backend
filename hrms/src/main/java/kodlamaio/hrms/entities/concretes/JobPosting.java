package kodlamaio.hrms.entities.concretes;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_postings")
@AllArgsConstructor
@NoArgsConstructor
public class JobPosting {
	
	
	@Id
	@Column(name="job_postId")
	@GeneratedValue
	private int jobPostingId;
	
	@Column(name="position_name")
	private String PositionName;
	
	@Column(name="job_description")
	private String jobDescription;
	
	@Column(name="city_name")
	private String CityName;
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="open_positionNnumber")
	private int openPositionNumber;
	
	@Column(name="last_applyDate")
	private LocalDate lastApplyDate;
	
	@Column(name="is_active")
	private boolean isActive;
	
	 @ManyToOne()
	 @JoinColumn(name = "position_id")
	 private Position position;
	 
	 @ManyToOne()
	 @JoinColumn(name = "user_id")
	 private Company company;
}
