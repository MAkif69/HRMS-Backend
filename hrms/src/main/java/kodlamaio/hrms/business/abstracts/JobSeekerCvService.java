package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.JobSeekerCV;
import kodlamaio.hrms.entities.dtos.CvDetailDto;
import kodlamaio.hrms.entities.dtos.GetCvDetailDtoWithQuery;
import kodlamaio.hrms.entities.dtos.GetCvInfoSummary;

public interface JobSeekerCvService {
	public Result add(JobSeekerCV jobSeekerCV);
	public DataResult<List<JobSeekerCV>> getAll();
	
	//DataResult<JobSeekerCV> getBycvId(int cvId);
	
	
	//DataResult<List<CvDetailDto>> getCvtWithDetails();
	
	DataResult<CvDetailDto> getCvWithDetails(int userId);
	
	DataResult<List<GetCvDetailDtoWithQuery>> GetCvDetailDtoWithQuery();
	
	DataResult<List<GetCvInfoSummary>> GetCvInfoSummary();
}
