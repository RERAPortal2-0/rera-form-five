package in.gov.rera.form.five.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.gov.rera.form.five.model.FormFiveQ7_1Model;

@Repository
public interface Q7_1Dao extends CrudRepository<FormFiveQ7_1Model, Long> {
	List<FormFiveQ7_1Model> findByFormFiveId(Long id);

	public int deleteByFormFiveId(Long formFiveId);
}
