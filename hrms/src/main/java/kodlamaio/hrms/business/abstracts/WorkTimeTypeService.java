package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.WorkTimeType;
import kodlamaio.hrms.entities.concretes.cv.SocialMedia;

public interface WorkTimeTypeService {

	public Result add(WorkTimeType workTimeType);
	
	DataResult<List<WorkTimeType>> getAll();
}
