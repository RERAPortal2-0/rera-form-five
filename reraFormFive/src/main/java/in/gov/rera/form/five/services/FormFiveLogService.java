package in.gov.rera.form.five.services;

import java.util.List;

import in.gov.rera.form.five.model.FormFiveBankDetailsModel;
import in.gov.rera.form.five.model.FormFiveLogModel;

public interface FormFiveLogService {

	FormFiveLogModel findById(Long id);

	List<FormFiveLogModel> findByFormFiveId(Long id);

	FormFiveLogModel saveLog(FormFiveLogModel model);
}
