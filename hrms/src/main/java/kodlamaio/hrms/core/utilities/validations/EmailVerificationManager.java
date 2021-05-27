package kodlamaio.hrms.core.utilities.validations;

import org.springframework.stereotype.Service;

@Service
public class EmailVerificationManager implements VerificationServiceWithEmail {

	@Override
	public boolean verificationMailSending(String eMail) {
		if (!eMail.contains("@")) {
			return false;
		}
		return true;
	}

}
