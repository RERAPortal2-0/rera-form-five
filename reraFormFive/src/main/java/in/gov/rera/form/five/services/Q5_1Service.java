package in.gov.rera.form.five.services;

import java.text.ParseException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.FormFiveQ5_1Model;
public interface Q5_1Service {

	FormFiveQ5_1Model findById(Long id);

	List<FormFiveQ5_1Model> findByFormFiveId(Long id);

	List<FormFiveQ5_1Model> validateDepositDtlExl(XSSFSheet depositDtlExl,Long formFiveId) throws ResourceNotFoundException, ParseException;

	List<FormFiveQ5_1Model> saveDepositDtl(List<FormFiveQ5_1Model> depositDtlList);

	void removeAll(Long formFiveId);

}
