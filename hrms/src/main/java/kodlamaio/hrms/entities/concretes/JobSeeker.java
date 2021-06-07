package kodlamaio.hrms.entities.concretes;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import kodlamaio.hrms.entities.concretes.cv.Image;
import kodlamaio.hrms.entities.concretes.cv.JobSeekerCV;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_seekers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings","jobSeekerCv"})
public class JobSeeker extends User{
	
	@NotNull
	@Column(name="first_name")
	private String firstName;
	
	@NotNull
	@Column(name="last_name")
	private String lastName;
	
	@NotNull
	@Column(name="nationality_id")
	private String nationalityId;
	
	@NotNull
	@Column(name="birth_date")
	private Date   birthDate;
	
	@NotNull
	@Column(name="verify")
	private boolean verify;
	
	@OneToMany(mappedBy = "jobSeeker")
	private List<JobSeekerCV> jobSeekerCv;
	
	@OneToOne(mappedBy = "jobSeeker", optional = false, fetch = FetchType.LAZY)
	private Image image;

	//@Column(name="verify_id")
	//private int verifyId;
	
	//@NotNull
	//@OneToOne(fetch = FetchType.LAZY, targetEntity = VerifyType.class)
	//@JoinColumn(name="verify_id")
	//private VerifyType verifyType;
		
}
