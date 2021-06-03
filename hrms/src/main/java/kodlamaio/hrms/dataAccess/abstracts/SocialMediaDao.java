package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.SocialMedia;

public interface SocialMediaDao extends JpaRepository<SocialMedia, Integer>{

}
