package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Company;

public interface CompanyService {
	
	public Result register(Company company);
	public DataResult<List<Company>> getAll();
	
	
	DataResult<List<Company>> findByJobPostings_jobPostingId(int jobPostingId);
}
