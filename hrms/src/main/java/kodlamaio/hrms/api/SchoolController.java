package kodlamaio.hrms.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.School;

@RestController
@RequestMapping("/api/Schools")
public class SchoolController {

	private SchoolService schoolService;

	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<School>> getAll(){
		return this.schoolService.getAll();
	};
	
	@GetMapping("/findAllByschoolIdOrderByGraduateYear")
	public DataResult<List<School>> findAllByschoolIdOrderByGraduateYear(int schoolId){
		return this.schoolService.findAllByschoolIdOrderByGraduateYear(schoolId);
	};
	
	@GetMapping("/findAllByschoolIdOrderByGraduateYearDesc")
	public DataResult<List<School>> findAllByschoolIdOrderByGraduateYearDesc(){
		return this.schoolService.findByOrderByschoolIdAsc();
	};
		
	@PostMapping
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}
}
