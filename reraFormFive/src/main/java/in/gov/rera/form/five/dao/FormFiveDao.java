package in.gov.rera.form.five.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.rera.form.five.model.FormFiveModel;

@Repository
public interface FormFiveDao extends CrudRepository<FormFiveModel, Long> {
	
	List<FormFiveModel> findByCaNumber(String caNumber);

	List<FormFiveModel> findByStatus(String status);
	
	List<FormFiveModel> findByFinancialYear(String financialYear);
	
	
}
