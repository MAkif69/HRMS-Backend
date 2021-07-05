package kodlamaio.hrms.business.abstracts;

import java.util.List;



import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.JobPostingDto;
import kodlamaio.hrms.entities.dtos.GetJobPostingDtoWithQuery;
import kodlamaio.hrms.entities.dtos.JobPostingAddDto;

public interface JobPostingService {
	
	public Result add(JobPostingAddDto jobPostingAddDto);
	
	public DataResult<List<JobPosting>> getAll();
	
	Result changeActive(int jobPostingId,boolean isActive);
	
	Result confirmForJobPostings(int jobPostingId);
	
	DataResult<List<JobPosting>> getAllByisActiveTrue();
	DataResult<List<JobPosting>> getAllByisConfirmedTrue();
	DataResult<List<JobPosting>> findAllByisActiveTrueOrderBycreatedDateDesc();
	DataResult<List<JobPosting>> findAllisActiveTrueAndByCompany_userId(int userId);
	
	DataResult<JobPostingDto> getJobPostWithDetails(int jobPostingId);
	
	DataResult<List<GetJobPostingDtoWithQuery>> GetJobPostingDtoWithQuery();
	
	

}
