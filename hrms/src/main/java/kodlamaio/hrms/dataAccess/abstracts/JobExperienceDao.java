package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.JobExperience;
import kodlamaio.hrms.entities.concretes.cv.School;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {

	List<JobExperience> findByOrderByExperienceIdAsc();
}
