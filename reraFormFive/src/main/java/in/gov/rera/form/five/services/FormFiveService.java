package in.gov.rera.form.five.services;

import java.util.List;

import in.gov.rera.form.five.model.FormFiveModel;

public interface FormFiveService {

	FormFiveModel findById(Long id);

	FormFiveModel updateFormFive(FormFiveModel formFiveModel);

	List<FormFiveModel> findByCaNumber(String caNumber);

	FormFiveModel saveFormFive(FormFiveModel formFiveModel);

	List<FormFiveModel> findFormFiveListbyStatus(String status);

	List<FormFiveModel> findFormFiveListbyFinancialYear(String financialYear);
}
