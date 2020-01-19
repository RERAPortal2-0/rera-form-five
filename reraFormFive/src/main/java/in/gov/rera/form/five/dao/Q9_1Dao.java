package in.gov.rera.form.five.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.gov.rera.form.five.model.FormFiveQ9_1Model;

@Repository
public interface Q9_1Dao extends CrudRepository<FormFiveQ9_1Model, Long> {
	List<FormFiveQ9_1Model> findByFormFiveId(Long id);
	public int deleteByFormFiveId(Long formFiveId);
}
