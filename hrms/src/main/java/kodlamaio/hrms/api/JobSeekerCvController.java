package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities.concretes.cv.JobSeekerCV;
import kodlamaio.hrms.entities.concretes.cv.SocialMedia;
import kodlamaio.hrms.entities.dtos.CvDetailDto;
import kodlamaio.hrms.entities.dtos.GetCvDetailDtoWithQuery;
import kodlamaio.hrms.entities.dtos.GetCvInfoSummary;

@RestController
@RequestMapping("/api/JobSeekerCvs")
@CrossOrigin
public class JobSeekerCvController {

	private JobSeekerCvService jobSeekerCvService;

	@Autowired
	public JobSeekerCvController(JobSeekerCvService jobSeekerCvService) {
		super();
		this.jobSeekerCvService = jobSeekerCvService;
	}
	
	@PostMapping
	public Result add(@RequestBody JobSeekerCV jobSeekerCV) {
		return this.jobSeekerCvService.add(jobSeekerCV);
	}
	
//	@GetMapping("/getall")
//	public DataResult<List<JobSeekerCV>> getAll(){
//		return this.jobSeekerCvService.getAll();
//	};
	
//	
//	@GetMapping("/getCvWithDetails")
//	public DataResult<CvDetailDto> getCvWithDetails(int userId){
//		return this.jobSeekerCvService.getCvWithDetails(userId);
//	};

	@GetMapping("/GetCvDetailDtoWithQuery")
	public DataResult<List<GetCvDetailDtoWithQuery>> GetCvDetailDtoWithQuery(){
		return this.jobSeekerCvService.GetCvDetailDtoWithQuery();
	}
	
	@GetMapping("/GetCvInfoSummary")
	public DataResult<List<GetCvInfoSummary>> GetCvInfoSummary(){
		return this.jobSeekerCvService.GetCvInfoSummary();
	}
}
