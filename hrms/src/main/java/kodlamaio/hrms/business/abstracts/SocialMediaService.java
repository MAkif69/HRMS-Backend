package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.cv.SocialMedia;

public interface SocialMediaService {

	public Result add(SocialMedia socialMedia);
	public DataResult<List<SocialMedia>> getAll();
	
	DataResult<List<SocialMedia>> findByJobSeekerCv_cvId(int cvId);
}
