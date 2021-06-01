package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobPostings"})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name="user_id")
	private int userId;
	
	@NotNull
	@Column(name="email")
	private String eMail;
	
	@NotNull
	@Column(name="password")
	private String password;
	
	private String enterPasswordAgain;
	
}
