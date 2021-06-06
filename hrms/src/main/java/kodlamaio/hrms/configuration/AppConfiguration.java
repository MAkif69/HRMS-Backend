package kodlamaio.hrms.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;


import kodlamaio.hrms.core.utilities.cloudinary.CloudinaryImageService;
import kodlamaio.hrms.core.utilities.cloudinary.CloudinaryManager;



@Configuration
public class AppConfiguration {
	
	  @Bean
	    public Cloudinary cloudinaryService(){
	        return new Cloudinary(ObjectUtils.asMap(
	                "cloud_name", "dvinen1wa",
	                "api_key", "351991955587837",
	                "api_secret", "MX4ySSkshduouAHdWpiV4y6J31A"));
	    }

	    @Bean
	    public CloudinaryImageService cloudinaryImageService(){
	        return new CloudinaryManager(cloudinaryService());
	    }
}
