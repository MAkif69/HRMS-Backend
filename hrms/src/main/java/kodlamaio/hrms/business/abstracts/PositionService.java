package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.Position;

public interface PositionService {
	
	public Result add(Position position);
	DataResult<List<Position>> getAll();;
	
	DataResult<List<Position>> findByJobPostings_jobPostingId(int jobPostingId);
}
