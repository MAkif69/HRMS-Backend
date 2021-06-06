package kodlamaio.hrms.dataAccess.abstracts;



import org.springframework.data.jpa.repository.JpaRepository;



import kodlamaio.hrms.entities.concretes.cv.JobSeekerCV;



public interface JobSeekerCvDao extends JpaRepository<JobSeekerCV, Integer> {

	
	//JobSeekerCV findByCvId(int cv_id);
	
	
	/*@Query("Select new kodlamaio.hrms.entities.dtos.CvDetailDto"
            + "(js.FirstName, js.LastName, cvl.coverLatter, sch.schoolName"
            + ",dep.departmentName, sch.startDate, sch.graduateYear"
            + ",jbe.workedWıthCompanyName, jbe.experienceStartYear, jbe.experienceFinishYear"
            + ",lang.languageName, langl.languageLevel, skl.skillName, skl.technologyName"
            + ",sm.github, sm.lınkedIn)"
            + "From JobSeekerCv jsc "
            + "Inner Join jsc.JobSeeker js"
            + "Inner Join jsc.CoverLetter cvl"
            + "Inner Join jsc.School sch"
            + "Inner Join jsc.JobExperience jbe"
            + "Inner Join jsc.Language lang"
            + "Inner Join jsc.LanguageLevel langl"
            + "Inner Join jsc.Skill skl"
            + "Inner Join jsc.SocialMedia sm"
            + "Inner Join jsc.Department dep")
   List<CvDetailDto> getCvtWithDetails();*/ 
}
