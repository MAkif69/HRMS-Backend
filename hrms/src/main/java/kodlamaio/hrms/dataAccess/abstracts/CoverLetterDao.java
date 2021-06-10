package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.CoverLetter;


public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer>{

	List<CoverLetter> findByJobSeekerCv_cvId(int cvId);
}
