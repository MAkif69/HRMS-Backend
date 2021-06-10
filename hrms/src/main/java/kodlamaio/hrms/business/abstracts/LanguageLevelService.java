package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.cv.LanguageLevel;

public interface LanguageLevelService {
	
	public Result add(LanguageLevel languageLevel);
	
	DataResult<List<LanguageLevel>> findByJobSeekerCv_cvId(int cvId);
}	
