package in.gov.rera.form.five.services;

import java.text.ParseException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.FormFiveQ11_1Model;

public interface Q11_1Service {

	FormFiveQ11_1Model findById(Long id);

	List<FormFiveQ11_1Model> findByFormFiveId(Long id);

	List<FormFiveQ11_1Model> validateLoanDtlExl(XSSFSheet formExl,Long formFiveId) throws ResourceNotFoundException, ParseException;

	List<FormFiveQ11_1Model> saveLoanDtl(List<FormFiveQ11_1Model> Model);

	void removeAll(Long formFiveId);

}
