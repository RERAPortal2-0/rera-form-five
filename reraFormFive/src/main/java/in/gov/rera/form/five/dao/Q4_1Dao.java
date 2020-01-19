package in.gov.rera.form.five.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.rera.form.five.model.FormFiveQ4_1Model;

@Repository
public interface Q4_1Dao extends CrudRepository<FormFiveQ4_1Model, Long> {
	List<FormFiveQ4_1Model> findByFormFiveId(Long id);
	public Integer deleteByFormFiveId (Long formFiveId); 
}
