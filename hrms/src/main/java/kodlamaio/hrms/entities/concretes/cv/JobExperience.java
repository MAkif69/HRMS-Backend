package kodlamaio.hrms.entities.concretes.cv;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_experiences")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerCv"})
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="experience_id")
	private int experienceId;
	
	@Column(name="worked_with_company")
	private String workedWıthCompanyName;
	
	//çalışılan pozisyon pozisyon tablosundan pozisyon ismi gelecek
	
	@Column(name="experience_start_year")
	private Date experienceStartYear;
	
	@Column(name="experience_finish_year")
	private Date experienceFinishYear;
	
	@OneToMany(mappedBy = "jobExperience")
	private List<JobSeekerCV> jobSeekerCv;
}
