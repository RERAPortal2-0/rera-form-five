package in.gov.rera.form.five.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.gov.rera.form.five.model.FormFiveModel;

@Repository
public interface FormFiveDao extends CrudRepository<FormFiveModel, Long> {
	
	

}
