package kodlamaio.hrms.core.utilities.validations;

import org.springframework.stereotype.Service;

@Service
public class FakeMernisValidation {
	
	public boolean MernisControl(String nationalityId , String lastName) {
		
		if (nationalityId.length()==11 || lastName.length()<2) {
			return false;
		}
			return true;
	}
}
