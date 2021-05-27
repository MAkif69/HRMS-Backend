package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validations.IdentityCheckService;
import kodlamaio.hrms.core.utilities.validations.VerificationServiceWithEmail;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities.concretes.JobSeeker;


@Service
public class JobSeekerManager implements JobSeekerService{

	private JobSeekerDao jobSeekerDao;
	private IdentityCheckService identityCheckerService;
	private VerificationServiceWithEmail verificationforMail;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, IdentityCheckService identityCheckService,
			VerificationServiceWithEmail verificationforMail) {
		
		this.identityCheckerService = identityCheckService;
		this.jobSeekerDao = jobSeekerDao;
		this.verificationforMail=verificationforMail;
	}
	

	@Override
	public Result register(JobSeeker jobSeeker) {
		if (!this.nullOrEmptyBlockCheck(jobSeeker)) {
			return new ErrorResult("Tüm alanları eksiksiz şekilde doldurunuz.");
		}else if(!this.checkIfEMailExists(jobSeeker)) {
			return new ErrorResult("Email adresi kullanımda.");
		}else if(!this.checkIfNationalityIdExists(jobSeeker)) {
			return new ErrorResult("TC numarası mevcut.");
		}else if(!this.checkIfPasswordAgain(jobSeeker)) {
			return new ErrorResult("Parolalar farklı.Lütfen tekrar giriniz");
		}else if(!identityCheckerService.MernisControl(jobSeeker.getNationalityId(),jobSeeker.getLastName())){
			return new ErrorResult("Kimlik bilgileri hatalı !");
		}else if(!verificationforMail.verificationMailSending(jobSeeker.getEMail())){
				return new ErrorResult("Mail adresiniz doğrulanamadı.");
		}else {
			this.jobSeekerDao.save(jobSeeker);
			return new SuccessResult("Kullanıcı eklendi");
		}
	
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Data listelendi");
	}
	
	
//My Business Codes
	
	  boolean nullOrEmptyBlockCheck(JobSeeker jobSeeker) {
		  
		if (jobSeeker.getFirstName().isEmpty() 
				|| jobSeeker.getLastName().isEmpty() 
				|| jobSeeker.getEMail().isEmpty() 
				|| jobSeeker.getNationalityId().isEmpty() 
				|| jobSeeker.getPassword().isEmpty()|| jobSeeker.getBirthDate().equals(null))
				
		{
			return false;
		} 
		else 
		{
			return true;
		}

	}
	  
	  boolean checkIfEMailExists(JobSeeker jobSeeker) {
		  
			if( jobSeekerDao.existsByeMailIs(jobSeeker.getEMail())) {
				
				return false;
				
				}  
			
			  return true;
			  
			}
		  
		  
	  boolean checkIfNationalityIdExists(JobSeeker jobSeeker) {
			  
			 if (jobSeekerDao.existsByNationalityIdIs(jobSeeker.getNationalityId())) {
				
				 return false;
			 }
			 
			 return true;
		  }
		  
	  boolean checkIfPasswordAgain(JobSeeker jobSeeker) {
			  
			  if(!jobSeeker.getPassword().contains(jobSeeker.getEnterPasswordAgain())) {
				 
				  return false;
			  }
			  
			  return true;
		  }

}