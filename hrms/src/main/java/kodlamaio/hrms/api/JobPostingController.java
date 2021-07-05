package kodlamaio.hrms.api;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.GetJobPostingDtoWithQuery;
import kodlamaio.hrms.entities.dtos.JobPostingDto;



@RestController
@RequestMapping("/api/JopPostings")
@CrossOrigin
public class JobPostingController {

	private JobPostingService jobPostingService;
	
	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll(){
		return this.jobPostingService.getAll();
	}
	
	@GetMapping("/getallActice")
	public DataResult<List<JobPosting>> getAllActive(){
		return this.jobPostingService.getAllByisActiveTrue();
	}
	
	@GetMapping("/getAllByisConfirmedTrue")
	public DataResult<List<JobPosting>> getAllByisConfirmedTrue(){
		return this.jobPostingService.getAllByisConfirmedTrue();
	}
	
	@GetMapping("/getallActiveDesc")
	public DataResult<List<JobPosting>> getAllActiveDesc(){
		return this.jobPostingService.findAllByisActiveTrueOrderBycreatedDateDesc();
	}
	
	@GetMapping("/getallActiveWithId")
	public DataResult<List<JobPosting>> getAllActiveWithId(int userId){
		return this.jobPostingService.findAllisActiveTrueAndByCompany_userId(userId);
	}
//	
//	@GetMapping("/getJobPostWithDetails")
//	public DataResult<JobPostingDto> getJobPostWithDetails(int jobPostingId){
//		return this.jobPostingService.getJobPostWithDetails(jobPostingId);
//	};
	
	@GetMapping("/GetJobPostingDtoWithQuery")
	public DataResult<List<GetJobPostingDtoWithQuery>>  GetJobPostingDtoWithQuery(){
		
		return this.jobPostingService.GetJobPostingDtoWithQuery();
	};
	
	@PostMapping
	public Result add(@RequestBody JobPosting jobPosting) {
		return  this.jobPostingService.add(jobPosting);
	}
	
	@PutMapping("update")
	public Result update(@RequestParam int jobPostingId,@RequestParam boolean isActive) {
		
		return this.jobPostingService.changeActive(jobPostingId, isActive);
		
	}
	
	@PostMapping("/confirmForJobPostings")
	@Transactional
	public Result confirmForJobPostings(int jobPostingId) {
		return this.jobPostingService.confirmForJobPostings(jobPostingId);
	}
}
