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

	@Override
	public DataResult<List<JobPosting>> getAllByisActiveTrue() {
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByisActiveTrue(),"Aktif iş ilanları getiridi...");
	}

	@Override
	public DataResult<List<JobPosting>> findAllByisActiveTrueOrderBycreatedDateDesc() {
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByisActiveTrueOrderByCreatedDateDesc()
				,"Aktif işilanları tarihe göre listelendi...");
	}

	@Override
	public DataResult<List<JobPosting>> findAllisActiveTrueAndByCompany_userId(int userId) {
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findByIsActiveTrueAndCompany_userId(userId)
				,"Şirket id ye göre aktif iş ilanları listelendi");
	}

	@Override
	public Result changeActive(int jobPostingId, boolean isActive) { //İş veren ilanın aktiflik durumunu değiştirebilir.
		try {
			JobPosting jobPosting;
			jobPosting = this.jobPostingDao.findById(jobPostingId).get();

			jobPosting.setActive(isActive);

			this.jobPostingDao.save(jobPosting);

			return new SuccessResult("İşlem Başarılı");

		} catch (Exception e) {
			return new ErrorResult("İşlem Başarısız");
		}
	}

}
