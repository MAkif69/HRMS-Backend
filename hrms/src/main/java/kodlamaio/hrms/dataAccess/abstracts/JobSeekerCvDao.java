package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import kodlamaio.hrms.entities.concretes.cv.JobSeekerCV;
import kodlamaio.hrms.entities.dtos.CvDetailDto;


public interface JobSeekerCvDao extends JpaRepository<JobSeekerCV, Integer> {

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
