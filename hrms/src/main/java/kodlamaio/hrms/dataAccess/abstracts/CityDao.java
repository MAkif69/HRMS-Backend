package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer> {

	List<City> findByJobPostings_jobPostingId(int jobPostingId);
	
	City getBycityId(int cityId);
}
