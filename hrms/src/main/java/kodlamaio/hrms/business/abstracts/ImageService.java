package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cv.Image;

public interface ImageService {

	Result add(Image image);
	DataResult<List<Image>> getAll();
	
	
	
	Result addCloudinary(Image image,MultipartFile file);
	DataResult<List<Image>> findByJobSeekerCV_cvId(int cvId);
}
