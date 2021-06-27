package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkTimeType;
import kodlamaio.hrms.entities.concretes.WorkType;

@RestController
@RequestMapping("/api/WorkTypes")
public class WorkTypeController {

	private WorkTypeService workTypeService;

	public WorkTypeController(WorkTypeService workTypeService) {
		super();
		this.workTypeService = workTypeService;
	}
	
	@PostMapping
	public Result add(@RequestBody WorkType workType) {
		return this.workTypeService.add(workType);
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkType>> getAll(){
		return this.workTypeService.getAll();
	};
	
}
