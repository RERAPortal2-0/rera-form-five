package in.gov.rera.form.five.services;

import java.util.List;

import in.gov.rera.form.five.model.FormFiveModel;
import in.gov.rera.form.five.model.transaction.FormFiveDto;

public interface FormFiveService {

	FormFiveModel findById(Long id);

	FormFiveModel updateFormFive(FormFiveModel formFiveModel);

	List<FormFiveModel> findByCaNumber(String caNumber);

	FormFiveModel saveFormFive(FormFiveModel formFiveModel);

	List<FormFiveModel> findFormFiveListbyStatus(String status);

	List<FormFiveModel> findFormFiveListbyFinancialYear(String financialYear);

	List<FormFiveModel> findAllFormFiveList();

	List<FormFiveModel> findFormFiveListbyFilter(FormFiveDto model);

	List<FormFiveModel> findByProjectId(Long projectId);
}
