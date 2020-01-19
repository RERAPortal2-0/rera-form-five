package in.gov.rera.form.five.services;

import java.util.List;

import in.gov.rera.form.five.model.FormFiveOtherDocModel;

public interface OtherDocumentService {

	FormFiveOtherDocModel findById(Long id);

	List<FormFiveOtherDocModel> findByFormFiveId(Long id);

	FormFiveOtherDocModel saveOthDocument(FormFiveOtherDocModel Model);

	void remove(Long id);

}
