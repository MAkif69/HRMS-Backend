package kodlamaio.hrms.core.utilities.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentityChecker implements IdentityCheckService{

	private FakeMernisValidation fakeMernisValidation;
	
	@Autowired
	public IdentityChecker(FakeMernisValidation fakeMernisValidation) {
		super();
		this.fakeMernisValidation = fakeMernisValidation;
	}
	
	
	@Override
	public boolean MernisControl(String nationalityId, String lastName) {
		if (fakeMernisValidation.MernisControl(nationalityId, lastName)) {
			return false;
		}
		return true;
	}


	

}
