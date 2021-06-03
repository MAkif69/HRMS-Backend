package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.DepartmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.Department;
import kodlamaio.hrms.entities.concretes.cv.School;

@RestController
@RequestMapping("/api/Departments")
public class DepartmentController {
	
	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}

	@PostMapping
	public Result add(@RequestBody Department department) {
		return this.departmentService.add(department);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Department>> getAll(){
		return this.departmentService.getAll();
	};
}
