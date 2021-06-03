package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.Department;

public interface DepartmentDao extends JpaRepository<Department, Integer>{
	
}
