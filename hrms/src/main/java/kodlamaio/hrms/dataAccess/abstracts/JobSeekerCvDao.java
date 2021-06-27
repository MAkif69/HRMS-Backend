package kodlamaio.hrms.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.cv.JobSeekerCV;
import kodlamaio.hrms.entities.dtos.GetCvDetailDtoWithQuery;
import kodlamaio.hrms.entities.dtos.GetCvInfoSummary;



public interface JobSeekerCvDao extends JpaRepository<JobSeekerCV, Integer> {
	
	@Query("Select new kodlamaio.hrms.entities.dtos.GetCvDetailDtoWithQuery"
			+"(jc.id, ım.url, js.firstName, js.lastName, js.birthDate, c.coverLetter, s.schoolName, s.startDate, s.graduateYear, d.departmentName,"
			+" e.workedWıthCompanyName, e.experienceStartYear, e.experienceFinishYear, l.languageName, le.languageLevel, sm.github,"
			+ " sm.lınkedIn, sk.skillName, sk.technologyName)"
			+"From JobSeekerCV jc Inner Join jc.jobSeeker js Inner Join jc.coverLetter c Inner Join jc.school s "
			+"Inner Join jc.department d Inner Join jc.jobExperience e Inner Join jc.language l Inner Join jc.languageLevel le "
			+"Inner Join jc.socialMedia sm Inner Join jc.skill sk Inner Join js.image ım")
	List<GetCvDetailDtoWithQuery> GetCvDetailDtoWithQuery();
	
	
	@Query("Select new kodlamaio.hrms.entities.dtos.GetCvInfoSummary"
			+"(jc.id, js.firstName, js.lastName, s.schoolName, d.departmentName, s.graduateYear)"
			+"From JobSeekerCV jc Inner Join jc.jobSeeker js Inner Join jc.school s Inner Join jc.department d ")
	List<GetCvInfoSummary> GetCvInfoSummary();
}
