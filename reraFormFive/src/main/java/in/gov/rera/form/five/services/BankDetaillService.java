package in.gov.rera.form.five.services;

import java.util.List;

import in.gov.rera.form.five.model.FormFiveBankDetailsModel;

public interface BankDetaillService {

	FormFiveBankDetailsModel findById(Long id);

	FormFiveBankDetailsModel updateBankDetail(FormFiveBankDetailsModel bankModel);

	List<FormFiveBankDetailsModel> findByFormFiveId(Long id);

	FormFiveBankDetailsModel saveBankDtl(FormFiveBankDetailsModel bankModel);

	void deleteBankDetail(Long bankId);
}
