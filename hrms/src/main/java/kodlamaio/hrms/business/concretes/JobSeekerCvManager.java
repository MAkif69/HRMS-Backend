package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCvDao;
import kodlamaio.hrms.entities.concretes.cv.JobSeekerCV;
import kodlamaio.hrms.entities.dtos.CvDetailDto;

@Service
public class JobSeekerCvManager implements JobSeekerCvService {

	@Autowired
	private JobSeekerCvDao jobSeekerCvDao;

	public JobSeekerCvManager(JobSeekerCvDao jobSeekerCvDao) {
		super();
		this.jobSeekerCvDao = jobSeekerCvDao;
	}

	@Override
	public Result add(JobSeekerCV jobSeekerCV) {
		this.jobSeekerCvDao.save(jobSeekerCV);
		return new SuccessResult("Cv oluşturuldu");
	}

	@Override
	public DataResult<List<JobSeekerCV>> getAll() {
		
		return new SuccessDataResult<List<JobSeekerCV>>(this.jobSeekerCvDao.findAll(),"CV listelendi.");
	}

}
