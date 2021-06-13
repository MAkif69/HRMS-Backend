package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CompanyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validations.ConfirmAllUserBySystemUser;
import kodlamaio.hrms.core.utilities.validations.VerificationServiceWithEmail;
import kodlamaio.hrms.dataAccess.abstracts.CompanyDao;
import kodlamaio.hrms.entities.concretes.City;
import kodlamaio.hrms.entities.concretes.Company;
import kodlamaio.hrms.entities.concretes.JobSeeker;

@Service
public class CompanyManager implements CompanyService{
	
	private CompanyDao companyDao;
	private VerificationServiceWithEmail verificationforMail;
	private ConfirmAllUserBySystemUser confirmToUser;
    
	@Autowired
	public CompanyManager(CompanyDao companyDao, VerificationServiceWithEmail verificationforMail
			                                   , ConfirmAllUserBySystemUser confirmToUser) {
	
		this.companyDao = companyDao;
		this.verificationforMail = verificationforMail;
		this.confirmToUser=confirmToUser;
	}

	@Override
	public Result register(Company company) {
		if (!this.nullOrEmptyBlockCheck(company)) {
			return new ErrorResult("Tüm alanarı eksiksiz şekilde doldurunuz");
		}else if(!this.checkIfEMailExists(company)) {
			return new ErrorResult("Email adresi kullanımda");
		}else if(!this.checkEmailIsCompatibleWithDomain(company)) {
			return new ErrorResult("Mail adresi domain ile eşleşmiyor.");
		}else if(!this.checkIfPasswordAgain(company)) {
			return new ErrorResult("Parolalar farklı.Lütfen tekrar giriniz");
		}else if(!verificationforMail.verificationMailSending(company.getEMail())) {
			return new ErrorResult("Mail adresiniz doğrulanamadı.");
		}else if(!confirmToUser.confirmToCompany(company)) {
			return new ErrorResult("Şirket kayıt işlemi onaylanmadı.Lütfen İK ile ieltişime geçiniz...");
		}else {
			companyDao.save(company);
			return new SuccessResult("Kullanıcı eklendi");
		}
		
	}

	@Override
	public DataResult<List<Company>> getAll() {
		return new SuccessDataResult<List<Company>>(this.companyDao.findAll(), "Data listelendi.");
	}
	
	@Override
	public DataResult<List<Company>> findByJobPostings_jobPostingId(int jobPostingId) {
		
		return new SuccessDataResult<List<Company>>(this.companyDao.findByJobPostings_jobPostingId(jobPostingId));
	}
	
	
//My Business Codes
	  boolean nullOrEmptyBlockCheck(Company company) {
		  
			if (company.getCompanyName().isEmpty()
					|| company.getWebsite().isEmpty()
					|| company.getPhone().isEmpty()
					|| company.getEMail().isEmpty()
					|| company.getPassword().isEmpty())
					
			{
				return false;
			} 
			else 
			{
				return true;
			}

		}
	  
	  boolean checkIfEMailExists(Company company) {
		  
			if( companyDao.existsByeMailIs(company.getEMail())) {
				
				return false;
				
				}  
			
			  return true;
			  
			}
	 
	  boolean checkEmailIsCompatibleWithDomain(Company company) {
		  String[] isEmailCompatible = company.getEMail().split("@", 2); //@ işaretinden iki ayrı parçaya böler
		  String webSite = company.getWebsite().substring(4); // www. kısmından sonrasını alır
		  
		  if (!isEmailCompatible[1].equals(webSite)) {
			return false;
		}
		  return true;
	  }
	  
	  
	  boolean checkIfPasswordAgain(Company company) {
		  
		  if(!company.getPassword().contains(company.getEnterPasswordAgain())) {
			 
			  return false;
		  }
		  
		  return true;
	  }



}
