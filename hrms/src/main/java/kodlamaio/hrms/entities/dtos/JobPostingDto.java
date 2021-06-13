package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Company;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.concretes.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobPostingDto {

	
	private JobPosting jobPosting;
	private List<Company> companies;
	private List<Position> positions;
	private List<City> cities;

}
