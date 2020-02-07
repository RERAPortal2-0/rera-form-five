package in.gov.rera.form.five.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.gov.rera.form.five.model.SeminarModel;



@Repository
public interface SeminarDao extends CrudRepository<SeminarModel, Long> {
	
	//SeminarModel findByClauseCode(String clauseCode);

	
}
