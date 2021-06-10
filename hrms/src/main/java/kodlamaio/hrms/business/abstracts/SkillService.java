package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.School;
import kodlamaio.hrms.entities.concretes.cv.Skill;

public interface SkillService {
       public Result add(Skill skill);
       public DataResult<List<Skill>> getAll();
       
   	DataResult<List<Skill>> findByJobSeekerCv_cvId(int cvId);
}
