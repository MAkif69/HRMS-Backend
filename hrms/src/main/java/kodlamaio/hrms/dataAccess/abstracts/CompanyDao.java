package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.Company;

public interface CompanyDao extends JpaRepository<Company, Integer> {
	
	boolean existsByeMailIs(String eMail);
	
	List<Company> findByJobPostings_jobPostingId(int jobPostingId);
}
