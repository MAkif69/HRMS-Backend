package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.Department;
import kodlamaio.hrms.entities.concretes.cv.School;

public interface DepartmentService {
	
	public Result add(Department department);
	public DataResult<List<Department>> getAll();
	
	DataResult<List<Department>> findByJobSeekerCv_cvId(int cvId);
}
