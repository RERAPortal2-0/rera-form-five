package in.gov.rera.form.five.services;

import java.text.ParseException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.FormFiveQ9_1Model;

public interface Q9_1Service {

	FormFiveQ9_1Model findById(Long id);

	List<FormFiveQ9_1Model> findByFormFiveId(Long id);

	List<FormFiveQ9_1Model> validateReceivedAmtDtlExl(XSSFSheet withdrawlslExl,Long formFiveId) throws ResourceNotFoundException, ParseException;

	List<FormFiveQ9_1Model> saveWithdrawlsDtl(List<FormFiveQ9_1Model> withdrawlslExl);

	void removeAll(Long formFiveId);

}
