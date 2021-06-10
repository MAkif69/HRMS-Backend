package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.CoverLetter;
import kodlamaio.hrms.entities.concretes.cv.JobExperience;

public interface CoverLetterService {

	public Result add(CoverLetter coverLetter);
	public DataResult<List<CoverLetter>> getAll();
	
	DataResult<List<CoverLetter>> findByJobSeekerCv_cvId(int cvId);
}
