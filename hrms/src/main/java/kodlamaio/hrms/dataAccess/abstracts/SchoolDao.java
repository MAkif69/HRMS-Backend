package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.School;

public interface SchoolDao extends JpaRepository<School, Integer>{

		List<School> findAllByschoolIdOrderByGraduateYear(int schoolId);
		List<School> findByOrderBySchoolIdAsc();
		
		List<School> findByJobSeekerCv_cvId(int cvId);
}
