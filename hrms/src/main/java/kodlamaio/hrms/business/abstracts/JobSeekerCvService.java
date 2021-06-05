package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.JobSeekerCV;
import kodlamaio.hrms.entities.dtos.CvDetailDto;

public interface JobSeekerCvService {
	public Result add(JobSeekerCV jobSeekerCV);
	public DataResult<List<JobSeekerCV>> getAll();
	
	
	//DataResult<List<CvDetailDto>> getCvtWithDetails();
}
