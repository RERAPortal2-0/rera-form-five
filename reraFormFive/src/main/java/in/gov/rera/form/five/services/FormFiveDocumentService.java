package in.gov.rera.form.five.services;

import java.util.List;
import in.gov.rera.form.five.model.FormFiveDocumentModel;

public interface FormFiveDocumentService {

	FormFiveDocumentModel findById(Long id);

	List<FormFiveDocumentModel> findByFormFiveId(Long id);

	FormFiveDocumentModel saveDocument(FormFiveDocumentModel model);

	void remove(Long id);

}
