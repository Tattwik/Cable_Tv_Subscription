package tech.csm.service;

import java.util.List;

import tech.csm.model.Provider;

public interface ProviderService {

	List<Provider> getAllProviders();
	Provider getProviderById(Integer providerId);

}
