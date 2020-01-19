package in.gov.rera.form.five.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.gov.rera.form.five.model.FormFiveOtherDocModel;

@Repository
public interface OtherDocumentDao extends CrudRepository<FormFiveOtherDocModel, Long> {
	List<FormFiveOtherDocModel> findByFormFiveId(Long id);
}
