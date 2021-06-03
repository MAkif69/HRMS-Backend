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
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="social_medias")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerCv"})
public class SocialMedia {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="social_id")
	private int socialId;
	
	@NotNull
	@Column(name="github_account")
	private String github;
	
	@NotNull
	@Column(name="lınkedIn_account")
	private String lınkedIn;
	
	@OneToMany(mappedBy = "socialMedia")
	private List<JobSeekerCV> jobSeekerCv;
}
