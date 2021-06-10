package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.cv.Language;

public interface LanguageDao extends JpaRepository<Language, Integer>{

	List<Language> findByJobSeekerCv_cvId(int cvId);
}
