package in.gov.rera.form.five.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.gov.rera.form.five.model.FormFiveQ10_1Model;

@Repository
public interface Q10_1Dao extends CrudRepository<FormFiveQ10_1Model, Long> {
	List<FormFiveQ10_1Model> findByFormFiveId(Long id);
	public int deleteByFormFiveId(Long formFiveId);
}
