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
@Table(name="language_levels")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerCv"})
public class LanguageLevel {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="language_level_id")
	private int langId;
	
	@Column(name="language_level")
	private int languageLevel;
	
	@OneToMany(mappedBy = "languageLevel")
	private List<JobSeekerCV> jobSeekerCv;
}
