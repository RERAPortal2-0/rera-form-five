package in.gov.rera.form.five.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.gov.rera.form.five.model.FormFiveLogModel;

@Repository
public interface FormFiveLogDao extends CrudRepository<FormFiveLogModel, Long> {
	
	List<FormFiveLogModel> findByFormFiveId(Long id);

	
}
