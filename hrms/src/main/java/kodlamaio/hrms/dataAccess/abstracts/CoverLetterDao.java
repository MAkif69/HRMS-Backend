package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.CoverLetter;

public interface CoverLetterDao extends JpaRepository<CoverLetter, Integer>{

}
