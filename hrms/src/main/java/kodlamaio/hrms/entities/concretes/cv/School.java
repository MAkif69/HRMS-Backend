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
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="schools")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerCv"})
public class School {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="school_id")
	private int schoolId;
	
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="department")
	private String department;
	
	@NotNull
	@Column(name="start_date")
	private Date   startDate;
	
	@Column(name="graduate_year")
	private Date   graduateYear;
	
	
	@OneToMany(mappedBy = "school")
	private List<JobSeekerCV> jobSeekerCv;
}
