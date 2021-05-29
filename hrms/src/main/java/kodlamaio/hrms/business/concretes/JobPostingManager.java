package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService{

	private JobPostingDao jobPostingDao;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(JobPosting jobPosting) {
		if (!CheckMandatoryRules(jobPosting)) {
			return new ErrorResult("Lütfen zorunlu alanları giriniz..");
		} else {
			this.jobPostingDao.save(jobPosting);
			return new SuccessResult("İş ilanı eklandi.");
		}
		
	}
	
//My business codes
	
	 boolean CheckMandatoryRules(JobPosting jobPosting) {
		  
			if (
					 jobPosting.getJobDescription().isEmpty() 
					
					|| jobPosting.getOpenPositionNumber() == 0
					)
					
			{
				return false;
			} 
			else 
			{
				return true;
			}

		}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(),"Data listelendi");
	}

}
