package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.cv.School;

public interface SchoolService {

	public Result add(School school);
	public DataResult<List<School>> getAll();
	
	public SuccessDataResult<List<School>> findAllByschoolIdOrderByGraduateYear(int schoolId);
	public SuccessDataResult<List<School>> findByOrderByschoolIdAsc();
	
}
