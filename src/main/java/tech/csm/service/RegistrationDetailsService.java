package tech.csm.service;

import java.util.List;

import tech.csm.model.RegistrationDetails;

public interface RegistrationDetailsService {

	RegistrationDetails saveRegistration(RegistrationDetails registrationDetails);

	List<RegistrationDetails> getAllRegistrationDetails();

	List<RegistrationDetails> getAllRegistrationByProviderId(Integer pId);

	void deleteRegistraion(Integer regdId);

	RegistrationDetails getRegistraionById(Integer regdId);

}
