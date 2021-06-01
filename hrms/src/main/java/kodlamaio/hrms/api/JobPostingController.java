package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;



@RestController
@RequestMapping("/api/JopPostings")
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
	
	@GetMapping("/getallActiveDesc")
	public DataResult<List<JobPosting>> getAllActiveDesc(){
		return this.jobPostingService.findAllByisActiveTrueOrderBycreatedDateDesc();
	}
	
	@GetMapping("/getallActiveWithId")
	public DataResult<List<JobPosting>> getAllActiveWithId(int userId){
		return this.jobPostingService.findAllisActiveTrueAndByCompany_userId(userId);
	}
	
	
	@PostMapping
	public Result add(@RequestBody JobPosting jobPosting) {
		return  this.jobPostingService.add(jobPosting);
	}
}
