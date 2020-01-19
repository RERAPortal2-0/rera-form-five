package in.gov.rera.form.five.services;

import java.text.ParseException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.FormFiveModel;
import in.gov.rera.form.five.model.FormFiveQ4_1Model;

public interface Q4_1Service {

	FormFiveQ4_1Model findById(Long id);

	List<FormFiveQ4_1Model> findByFormFiveId(Long id);

	List<FormFiveQ4_1Model> validateCaDtlExl(XSSFSheet caDtlExl,FormFiveModel pModel) throws ResourceNotFoundException, ParseException;

	List<FormFiveQ4_1Model> saveCADtl(List<FormFiveQ4_1Model> caDtlList);

	public Integer  removeAll(Long formFiveId);

}
