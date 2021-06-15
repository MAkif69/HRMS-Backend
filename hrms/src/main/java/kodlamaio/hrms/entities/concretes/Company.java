package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="companies")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
public class Company extends User {
	
	@NotNull
	@Column(name="company_name")
	private String companyName;
	
	@NotNull
	@JsonIgnore
	@Column(name="website")
	private String website;
	
	@NotNull
	@JsonIgnore
	@Column(name="phone")
	private String phone;
	
	@NotNull
	@JsonIgnore
	@Column(name="verify")
	private boolean verify; 
	
	@OneToMany(mappedBy = "company")
	private List<JobPosting> jobPostings;
}
