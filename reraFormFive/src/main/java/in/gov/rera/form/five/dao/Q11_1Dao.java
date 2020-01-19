package in.gov.rera.form.five.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.gov.rera.form.five.model.FormFiveQ11_1Model;

@Repository
public interface Q11_1Dao extends CrudRepository<FormFiveQ11_1Model, Long> {
	List<FormFiveQ11_1Model> findByFormFiveId(Long id);
	public int deleteByFormFiveId(Long formFiveId);
}
