package kodlamaio.hrms.entities.concretes.cv;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="images")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerCv"})
public class Image {
 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="image_id")
	private int imageId;
	
	@Column(name="url")
	private String url;
	
	@Column(name="created_date")
	private LocalDate createdDate;
	
	
	//@OneToMany(mappedBy = "image")
	//private List<JobSeekerCV> jobSeekerCv;
	@OneToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "id")
	private JobSeekerCV jobseekerCv;
}
