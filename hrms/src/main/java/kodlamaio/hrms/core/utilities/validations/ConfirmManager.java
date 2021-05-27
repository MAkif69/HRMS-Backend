package kodlamaio.hrms.core.utilities.validations;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.entities.concretes.Company;

@Service
public class ConfirmManager implements ConfirmAllUserBySystemUser{

	@Override
	public boolean confirmToCompany(Company company) {
		return true; //clicked button by system user.
	}

}
