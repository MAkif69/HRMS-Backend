package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.cloudinary.CloudinaryImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ImageDao;
import kodlamaio.hrms.entities.concretes.cv.Image;

@Service
public class ImageManager implements ImageService{

	
	private ImageDao imageDao;
	private CloudinaryImageService cloudinaryImageService;
	
	@Autowired
	public ImageManager(ImageDao imageDao,CloudinaryImageService cloudinaryImageService) {
		super();
		this.imageDao = imageDao;
		this.cloudinaryImageService = cloudinaryImageService;
	}

	@Override
	public Result add(Image image) {
		this.imageDao.save(image);
		return new SuccessResult("Fotoğraf eklendi");
	}

	@Override
	public DataResult<List<Image>> getAll() {
		
		return new SuccessDataResult<List<Image>>(this.imageDao.findAll(),"Fotoğraflar görüntülendi");
	}

	@Override
	public Result addCloudinary(Image image, MultipartFile file) {
		
		Map<String, String> result = (Map<String, String>) this.cloudinaryImageService.save(file).getData();
        String url = result.get("url");
        image.setUrl(url);        
       add(image);
       return new SuccessResult("Fotoğraf başarıyla yüklendi.");
	}

	@Override
	public DataResult<List<Image>> findByJobSeekerCV_cvId(int CvId) {
		
		return new SuccessDataResult<List<Image>>(imageDao.findByjobseekerCv_CvId(CvId),"Fotoğraf Id ye göre getirildi...");
	}
	
	
}
