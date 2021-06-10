package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.JobExperience;
import kodlamaio.hrms.entities.concretes.cv.School;

public interface JobExperienceService {
 
	public Result add(JobExperience jobExperience);
	public DataResult<List<JobExperience>> getAll();	
	
	public DataResult<List<JobExperience>> findByOrderByExperienceIdAsc();
	DataResult<List<JobExperience>> findByJobSeekerCv_cvId(int cvId);
}
