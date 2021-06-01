package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	
	public Result add(JobPosting jobPosting);
	
	public DataResult<List<JobPosting>> getAll();
	
	 DataResult<List<JobPosting>> getAllByisActiveTrue();
	 DataResult<List<JobPosting>> findAllByisActiveTrueOrderBycreatedDateDesc();
	 DataResult<List<JobPosting>> findAllisActiveTrueAndByCompany_userId(int userId);
}
