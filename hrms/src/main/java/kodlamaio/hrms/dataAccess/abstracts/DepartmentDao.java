package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.Department;
import kodlamaio.hrms.entities.concretes.cv.School;

public interface DepartmentDao extends JpaRepository<Department, Integer>{
	
	List<Department> findByJobSeekerCv_cvId(int cvId);
}
