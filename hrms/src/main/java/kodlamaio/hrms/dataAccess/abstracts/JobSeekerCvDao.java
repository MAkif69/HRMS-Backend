package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.cv.JobSeekerCV;

public interface JobSeekerCvDao extends JpaRepository<JobSeekerCV, Integer> {

}
