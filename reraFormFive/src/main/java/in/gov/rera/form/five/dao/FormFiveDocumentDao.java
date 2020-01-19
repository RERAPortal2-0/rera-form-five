package in.gov.rera.form.five.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.gov.rera.form.five.model.FormFiveDocumentModel;

@Repository
public interface FormFiveDocumentDao extends CrudRepository<FormFiveDocumentModel, Long> {
	List<FormFiveDocumentModel> findByFormFiveId(Long id);
}
