package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.Language;
import kodlamaio.hrms.entities.concretes.cv.School;

public interface LanguageService {
	
	public Result add(Language language);
	public DataResult<List<Language>> getAll();
	
	DataResult<List<Language>> findByJobSeekerCv_cvId(int cvId);
}
