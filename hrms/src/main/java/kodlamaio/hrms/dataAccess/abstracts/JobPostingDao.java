package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	 
	 List<JobPosting> findAllByisActiveTrue();
	 List<JobPosting> findAllByisActiveTrueOrderByCreatedDateDesc();
	 List<JobPosting> findAllByuser_idAndisActiveTrue(int user_id);
}
