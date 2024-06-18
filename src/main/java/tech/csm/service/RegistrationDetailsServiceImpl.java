package tech.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import tech.csm.model.RegistrationDetails;
import tech.csm.repo.RegistrationDetailsRepo;

@Service
public class RegistrationDetailsServiceImpl implements RegistrationDetailsService {

	@Autowired
	private RegistrationDetailsRepo registrationDetailsRepo;
	
	@Override
	public RegistrationDetails saveRegistration(RegistrationDetails registrationDetails) {
		
		return registrationDetailsRepo.save(registrationDetails);
	}

	@Override
	public List<RegistrationDetails> getAllRegistrationDetails() {
		
		return registrationDetailsRepo.findByIsDelete("NO");
	}

	@Override
	public List<RegistrationDetails> getAllRegistrationByProviderId(Integer pId) {
		
		return registrationDetailsRepo.findByProviderId(pId);
	}

	@Override
	@Transactional
	public void deleteRegistraion(Integer regdId) {
		registrationDetailsRepo.updateRegistraion(regdId);
		
	}

	@Override
	public RegistrationDetails getRegistraionById(Integer regdId) {
		
		return registrationDetailsRepo.findById(regdId).get();
	}

}
