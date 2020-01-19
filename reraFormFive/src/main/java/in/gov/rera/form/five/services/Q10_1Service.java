package in.gov.rera.form.five.services;

import java.text.ParseException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.FormFiveQ10_1Model;

public interface Q10_1Service {

	FormFiveQ10_1Model findById(Long id);

	List<FormFiveQ10_1Model> findByFormFiveId(Long id);

	List<FormFiveQ10_1Model> validateLoanDtlExl(XSSFSheet loanExl,Long formFiveId) throws ResourceNotFoundException, ParseException;

	List<FormFiveQ10_1Model> saveLoanDtl(List<FormFiveQ10_1Model> loanModel);

	void removeAll(Long formFiveId);

}
