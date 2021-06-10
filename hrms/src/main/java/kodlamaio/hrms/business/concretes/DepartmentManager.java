package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.DepartmentService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.DepartmentDao;
import kodlamaio.hrms.entities.concretes.cv.Department;

@Service
public class DepartmentManager implements DepartmentService {

	private DepartmentDao departmentDao;

	@Autowired
	public DepartmentManager(DepartmentDao departmentDao) {
		super();
		this.departmentDao = departmentDao;
	}

	@Override
	public Result add(Department department) {
		this.departmentDao.save(department);
		return new SuccessResult("Eğitimi alınan bölüm eklendi.");
	}

	@Override
	public DataResult<List<Department>> getAll() {
		
		return new  SuccessDataResult<List<Department>>(this.departmentDao.findAll(),"Bölümler listelendi");
	}

	@Override
	public DataResult<List<Department>> findByJobSeekerCv_cvId(int cvId) {
		
		return new SuccessDataResult<List<Department>>(this.departmentDao.findByJobSeekerCv_cvId(cvId));
	};
	
}
