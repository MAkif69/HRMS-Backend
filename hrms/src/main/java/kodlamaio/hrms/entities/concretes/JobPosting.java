package kodlamaio.hrms.entities.concretes;


import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_postings")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class JobPosting {
	
	
	@Id
	@Column(name="job_postId")
	@JsonIgnore
	@GeneratedValue
	private int jobPostingId;
	
	
	@Column(name="job_description")
	private String jobDescription;
	
	
	@Column(name="max_salary")
	private double maxSalary;
	
	@Column(name="min_salary")
	private double minSalary;
	
	@Column(name="open_positionNnumber")
	private int openPositionNumber;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@JsonIgnore
	@Column(name="created_date")
	private Date createdDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name="last_applyDate")
	private Date lastApplyDate;
	
	@Column(name="is_active")
	@JsonIgnore
	private boolean isActive;
	
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "position_id")
	private Position position;
	 
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "user_id")
	private Company company;
	 
	@ManyToOne()
	@JsonIgnore
	@JoinColumn(name = "city_id")
	private City city;
	
}
