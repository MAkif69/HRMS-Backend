package kodlamaio.hrms.entities.dtos;

import java.util.Date;
import java.util.List;

import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.cv.CoverLetter;
import kodlamaio.hrms.entities.concretes.cv.Department;
import kodlamaio.hrms.entities.concretes.cv.Image;
import kodlamaio.hrms.entities.concretes.cv.JobExperience;
import kodlamaio.hrms.entities.concretes.cv.JobSeekerCV;
import kodlamaio.hrms.entities.concretes.cv.Language;
import kodlamaio.hrms.entities.concretes.cv.LanguageLevel;
import kodlamaio.hrms.entities.concretes.cv.School;
import kodlamaio.hrms.entities.concretes.cv.Skill;
import kodlamaio.hrms.entities.concretes.cv.SocialMedia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDetailDto {

//	private int userId;
//	private String firstName;	
//	private String lastName;
	
	//private JobSeekerCV jobSeekerCV;
	private JobSeeker jobSeeker;
	private List<School> school;
	private List<Department> department;
	private List<JobExperience> jobExperience;
	private List<Language> language;
	private List<LanguageLevel> languageLevel;
//	private List<Image> image;
	private List<SocialMedia> socialMedia;
	private List<Skill> skill;
	private List<CoverLetter> coverLetter;
}
