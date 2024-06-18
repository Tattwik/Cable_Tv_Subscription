package tech.csm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tech.csm.model.RegistrationDetails;

@Repository
public interface RegistrationDetailsRepo extends JpaRepository<RegistrationDetails,Integer> {

	@Query("from RegistrationDetails where provider.providerId=:pId")
	List<RegistrationDetails> findByProviderId(Integer pId);

	List<RegistrationDetails> findByIsDelete(String isDelete);

	
	@Modifying
	@Query("update RegistrationDetails set isDelete='YES' where registrationId=:regdId")
	void updateRegistraion(Integer regdId);
	
}
