package in.gov.rera.form.five.services;

import java.text.ParseException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.FormFiveQ7_1Model;

public interface Q7_1Service {

	FormFiveQ7_1Model findById(Long id);

	List<FormFiveQ7_1Model> findByFormFiveId(Long id);

	List<FormFiveQ7_1Model> validateWithdrawlDtlExl(XSSFSheet withdrawlslExl,Long formFiveId) throws ResourceNotFoundException, ParseException;

	List<FormFiveQ7_1Model> saveWithdrawlsDtl(List<FormFiveQ7_1Model> withdrawlslExl);


	void removeAll(Long formFiveId);

}
