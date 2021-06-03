package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SchoolDao;
import kodlamaio.hrms.entities.concretes.cv.School;

@Service
public class SchoolManager implements SchoolService {
	
	private SchoolDao schoolDao;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		super();
		this.schoolDao = schoolDao;
	}
	
	
	@Override
	public Result add(School school) {
		
		this.schoolDao.save(school);
		return new SuccessResult("Okul başarıyla eklendi");
	}


	@Override
	public DataResult<List<School>> getAll() {
		
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(),"Okullar listelendi");
	}


	@Override
	public SuccessDataResult<List<School>> findAllByschoolIdOrderByGraduateYear(int schoolId) {
		
		return new SuccessDataResult<List<School>>(this.schoolDao.findAllByschoolIdOrderByGraduateYear(schoolId),"Id ye göre listelendi");
	}


	@Override
	public SuccessDataResult<List<School>> findByOrderByschoolIdAsc() {
		
		return new SuccessDataResult<List<School>>(this.schoolDao.findByOrderBySchoolIdAsc(),"Mezuniyet yılına göre listelendi");
	}



}
