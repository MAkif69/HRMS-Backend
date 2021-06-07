package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import kodlamaio.hrms.entities.concretes.cv.Image;
import kodlamaio.hrms.entities.concretes.cv.JobSeekerCV;

@RestController
@RequestMapping("/api/images")
public class ImageController {

	private ImageService imageService;

	public ImageController(ImageService imageService) {
		super();
		this.imageService = imageService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody MultipartFile file, @RequestParam int userId)
	{
		Image image =new Image();
		JobSeeker jobSeeker =new JobSeeker();
		jobSeeker.setUserId(userId);
		image.setJobSeeker(jobSeeker);
		
		return this.imageService.addCloudinary(image,file);
	}
	
	@GetMapping("/getall")
	public DataResult<List<Image>> getAll(){
		return this.imageService.getAll();
	};
	
}
