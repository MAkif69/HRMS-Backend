package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.WorkTimeTypeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkTimeType;


@RestController
@RequestMapping("/api/WorkTimeTypes")
public class WorkTimeTypeController {

	private WorkTimeTypeService workTimeTypeService;

	public WorkTimeTypeController(WorkTimeTypeService workTimeTypeService) {
		super();
		this.workTimeTypeService = workTimeTypeService;
	}
	
	
	@PostMapping
	public Result add(@RequestBody WorkTimeType workTimeType) {
		return this.workTimeTypeService.add(workTimeType);
	}
	
	@GetMapping("/getall")
	public DataResult<List<WorkTimeType>> getAll(){
		return this.workTimeTypeService.getAll();
	};
}
