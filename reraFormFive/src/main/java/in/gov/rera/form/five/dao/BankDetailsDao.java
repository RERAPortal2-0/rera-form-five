package in.gov.rera.form.five.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.rera.form.five.model.FormFiveBankDetailsModel;

@Repository
public interface BankDetailsDao extends CrudRepository<FormFiveBankDetailsModel, Long> {
	
	List<FormFiveBankDetailsModel> findByFormFiveId(Long id);

	
}
