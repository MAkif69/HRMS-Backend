package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
public class Company extends User {
	
	@NotNull
	@Column(name="company_name")
	private String companyName;
	
	@NotNull
	@Column(name="website")
	private String website;
	
	@NotNull
	@Column(name="phone")
	private int phone;
	
	@NotNull
	@Column(name="verify")
	private boolean verify; 
	
}
