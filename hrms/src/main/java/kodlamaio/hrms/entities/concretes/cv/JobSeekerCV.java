package kodlamaio.hrms.entities.concretes.cv;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import kodlamaio.hrms.entities.concretes.JobSeeker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_seeker_cv")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerCv"})
public class JobSeekerCV {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cv_id")
	private int cvId;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@Column(name="github_account")
	private String github;
	
	@Column(name="lınkedIn_account")
	private String lınkedIn;
	
	@ManyToOne()
	@JoinColumn(name = "school_id")
	private School school;
		
	@ManyToOne()
	@JoinColumn(name = "language_id")
	private Language language;
	
	@ManyToOne()
	@JoinColumn(name = "experience_id")
	private JobExperience jobExperience;
	
	@ManyToOne()
	@JoinColumn(name = "skill_id")
	private Skill skill;
	
	@ManyToOne()
	@JoinColumn(name = "image_id")
	private Image image;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private JobSeeker jobSeeker;
	
}
