package kodlamaio.hrms.entities.concretes.cv;

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
@Table(name="coverletters")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerCv"})
public class CoverLetter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="letter_id")
	private int letterId;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@OneToMany(mappedBy = "coverLetter")
	private List<JobSeekerCV> jobSeekerCv;
}
