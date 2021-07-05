package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPostingDao;
import kodlamaio.hrms.entities.concretes.JobPosting;
import kodlamaio.hrms.entities.dtos.GetJobPostingDtoWithQuery;
import kodlamaio.hrms.entities.dtos.JobPostingDto;

@Service
public class JobPostingManager implements JobPostingService{

	private JobPostingDao jobPostingDao;
	private CityService cityServie;
	private PositionService positionService;
	private CompanyService companyService;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao,CityService cityServie,PositionService positionService,CompanyService companyService) {
		super();
		this.jobPostingDao = jobPostingDao;
		this.cityServie=cityServie;
		this.positionService=positionService;
		this.companyService=companyService;
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
	

	@Override
	public DataResult<List<JobPosting>> getAll() {
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll(),"Data listelendi");
	}

	@Override
	public DataResult<List<JobPosting>> getAllByisActiveTrue() {
		
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByisActiveTrue(),"Aktif iş ilanları getiridi...");
	}
	
	@Override
	public DataResult<List<JobPosting>> getAllByisConfirmedTrue() {
	
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAllByisConfirmedTrue(),"İş ilanları listelendi...");
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
	
	@Override
	public DataResult<JobPostingDto> getJobPostWithDetails(int jobPostingId) {
		
		JobPostingDto jobPostingDto = new JobPostingDto();
		
		jobPostingDto.setJobPosting(this.jobPostingDao.findById(jobPostingId).get());
		jobPostingDto.setCities(this.cityServie.findByJobPostings_jobPostingId(jobPostingId).getData());
		jobPostingDto.setPositions(this.positionService.findByJobPostings_jobPostingId(jobPostingId).getData());
		jobPostingDto.setCompanies(this.companyService.findByJobPostings_jobPostingId(jobPostingId).getData());
		
		return new SuccessDataResult<JobPostingDto>(jobPostingDto,"İş ilanı ayrıntısı ile listelendi...");
		
		
	}
	
	@Override
	public DataResult<List<GetJobPostingDtoWithQuery>> GetJobPostingDtoWithQuery(){
		
		return new SuccessDataResult<List<GetJobPostingDtoWithQuery>>(this.jobPostingDao.GetJobPostingDtoWithQuery(),"İlanlar listelendi...");
	}
	

	@Override
	public Result confirmForJobPostings(int jobPostingId) {
		this.jobPostingDao.confirmForJobPostings(jobPostingId);
		return new SuccessResult("İş ilanı personel tarafından onaylandı.");
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



}
