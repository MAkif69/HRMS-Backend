package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings","jobSeekerCv"})
public class Position {
	
	@Id
	@GeneratedValue
	@Column(name="position_id")
	private int positionId;
	
	@Column(name="position_name")
	private String positionName;
	
	@OneToMany(mappedBy = "position")
	private List<JobPosting> jobPostings;
}
