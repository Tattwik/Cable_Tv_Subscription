package tech.csm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.csm.model.Provider;
import tech.csm.repo.ProviderRepo;

@Service
public class RroviderServiceImpl implements ProviderService {

	@Autowired
	private ProviderRepo providerRepo;
	
	@Override
	public List<Provider> getAllProviders() {
		
		return providerRepo.findAll();
	}

	@Override
	public Provider getProviderById(Integer providerId) {
		
		return providerRepo.findById(providerId).get();
	}

}
