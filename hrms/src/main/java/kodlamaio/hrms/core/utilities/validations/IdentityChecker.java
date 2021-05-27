package kodlamaio.hrms.core.utilities.validations;

public class IdentityChecker implements IdentityCheckService{

	private FakeMernisValidation fakeMernisValidation;
	
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
