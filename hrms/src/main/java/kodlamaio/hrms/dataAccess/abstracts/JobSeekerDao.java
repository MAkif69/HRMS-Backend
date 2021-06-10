package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.dtos.CvDetailDto;

public interface JobSeekerDao extends JpaRepository<JobSeeker, Integer>{
	
	
	boolean existsByeMailIs(String eMail);
	boolean existsByNationalityIdIs(String nationalityId);
	
	
//	@Query("Select kodlamaio.hrms.entities.dtos.CvDetailDto"
//			+"(js.firstName,js.lastName)"
//			+"(From JobSeeker js)")
//	DataResult<CvDetailDto> findById(int userId);
}
