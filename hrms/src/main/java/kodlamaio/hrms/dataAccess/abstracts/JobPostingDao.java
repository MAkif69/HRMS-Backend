package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.GetJobPostingDtoWithQuery;

@Repository
public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	 
	 List<JobPosting> findAllByisActiveTrue();
	 List<JobPosting> findAllByisActiveTrueOrderByCreatedDateDesc();
	 List<JobPosting> findByIsActiveTrueAndCompany_userId(int userId);
	 
	 @Query("Select new kodlamaio.hrms.entities.dtos.GetJobPostingDtoWithQuery"
			 + "(j.id, c.companyName, p.positionName, j.openPositionNumber, j.createdDate, j.lastApplyDate)"
			 + " From JobPosting j Inner Join j.company c Inner Join j.position p")
	 List<GetJobPostingDtoWithQuery> GetJobPostingDtoWithQuery();
	 
	 //Select j.job_post_id,c.company_name from job_postings j inner join companies c 
	 //on jp.user_id=c.user_id
}
