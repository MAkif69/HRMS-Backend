package kodlamaio.hrms.entities.concretes;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="verify_types")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VerifyType extends User{
	
	
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="verify_id")
	//private int verifyId;
	
	//@Column(name="user_id")
	//private int userId;
	
	@NotNull
	@Column(name="verify_type")
	private String verifyType;

}
