package in.gov.rera.form.five.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.gov.rera.form.five.model.FormFiveQ5_1Model;

@Repository
public interface Q5_1Dao extends CrudRepository<FormFiveQ5_1Model, Long> {
	List<FormFiveQ5_1Model> findByFormFiveId(Long id);

	public int deleteByFormFiveId(Long formFiveId);
}
