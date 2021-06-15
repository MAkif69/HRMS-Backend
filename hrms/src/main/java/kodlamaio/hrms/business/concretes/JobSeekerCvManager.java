package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CoverLetterService;
import kodlamaio.hrms.business.abstracts.DepartmentService;
import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.business.abstracts.JobSeekerCvService;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.LanguageLevelService;
import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.business.abstracts.SkillService;
import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCvDao;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.cv.JobSeekerCV;
import kodlamaio.hrms.entities.dtos.CvDetailDto;
import kodlamaio.hrms.entities.dtos.GetCvDetailDtoWithQuery;

@Service
public class JobSeekerCvManager implements JobSeekerCvService {

//	@Autowired
//	private JobSeekerCvDao jobSeekerCvDao;
//
//	public JobSeekerCvManager(JobSeekerCvDao jobSeekerCvDao) {
//		super();
//		this.jobSeekerCvDao = jobSeekerCvDao;
//	}
	
	@Autowired
	private JobSeekerCvDao jobSeekerCvDao;
	private JobSeekerDao jobSeekerDao;
	private CoverLetterService coverLetterService;
	private DepartmentService departmentService;
	private ImageService imageService;
	private JobExperienceService jobExperienceService;
	private JobPostingService jobPostingService;
	private JobSeekerService jobSeekerService;
	private LanguageService languageService;
	private LanguageLevelService languageLevelService;
	private SchoolService schoolService;
	private SkillService skillService;
	private SocialMediaService socialMediaService;
	

	public JobSeekerCvManager(JobSeekerDao jobSeekerDao, CoverLetterService coverLetterService,
			DepartmentService departmentService, ImageService imageService, JobExperienceService jobExperienceService,
			JobPostingService jobPostingService, JobSeekerService jobSeekerService, LanguageService languageService,
			LanguageLevelService languageLevelService, SchoolService schoolService, SkillService skillService,
			SocialMediaService socialMediaService,JobSeekerCvDao jobSeekerCvDao) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.coverLetterService = coverLetterService;
		this.departmentService = departmentService;
		this.imageService = imageService;
		this.jobExperienceService = jobExperienceService;
		this.jobPostingService = jobPostingService;
		this.jobSeekerService = jobSeekerService;
		this.languageService = languageService;
		this.languageLevelService = languageLevelService;
		this.schoolService = schoolService;
		this.skillService = skillService;
		this.socialMediaService = socialMediaService;
		this.jobSeekerCvDao=jobSeekerCvDao;
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

	@Override
	public DataResult<CvDetailDto> getCvWithDetails(int userId) {
		CvDetailDto cvDetailDto = new CvDetailDto();
		cvDetailDto.setJobSeeker(this.jobSeekerDao.findById(userId).get());
		cvDetailDto.setSchool(this.schoolService.findByJobSeekerCv_cvId(userId).getData());
		cvDetailDto.setDepartment(this.departmentService.findByJobSeekerCv_cvId(userId).getData());
		cvDetailDto.setJobExperience(this.jobExperienceService.findByJobSeekerCv_cvId(userId).getData());
		cvDetailDto.setLanguage(this.languageService.findByJobSeekerCv_cvId(userId).getData());
		cvDetailDto.setLanguageLevel(this.languageLevelService.findByJobSeekerCv_cvId(userId).getData());
		cvDetailDto.setSocialMedia(this.socialMediaService.findByJobSeekerCv_cvId(userId).getData());
		cvDetailDto.setSkill(this.skillService.findByJobSeekerCv_cvId(userId).getData());
		cvDetailDto.setCoverLetter(this.coverLetterService.findByJobSeekerCv_cvId(userId).getData());
		
		return new SuccessDataResult<CvDetailDto>(cvDetailDto,"Cv ayrıntısı ile listelendi...");
	}

	@Override
	public DataResult<List<GetCvDetailDtoWithQuery>> GetCvDetailDtoWithQuery(){
		
		return new SuccessDataResult<List<GetCvDetailDtoWithQuery>>(this.jobSeekerCvDao.GetCvDetailDtoWithQuery());
	};

}
