package in.gov.rera.form.five.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.multipart.MultipartFile;
import in.gov.rera.form.five.common.model.ResponseModel;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.FormFiveQ11_1Model;
import in.gov.rera.form.five.services.Q11_1Service;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/form_five/secure/eleven")
public class Q11_1RestController {
	private static final Logger logger = LogManager.getLogger(Q11_1RestController.class);

	@Autowired
	Environment env;

	@Autowired
	Q11_1Service q11Service;
	
	@PostMapping("/validateDiscrepancyExldata")
	public ResponseEntity<?> validateDiscrepancyExldata(@RequestParam("file") MultipartFile uploadedExcelFile,
			@RequestParam("formFiveId") Long formFiveId,
			 @ModelAttribute("FormFiveQ11_1Model") FormFiveQ11_1Model withDrawlModel
			) throws ResourceNotFoundException, IOException, ParseException{
		XSSFWorkbook depositExl=null;    
		try {
		depositExl = new XSSFWorkbook(uploadedExcelFile.getInputStream());
	} catch (Exception e) {
		throw new ResourceNotFoundException("Please upload valid Excel File");
	}
		List<FormFiveQ11_1Model> depositedList= new ArrayList<FormFiveQ11_1Model>();
		XSSFSheet deopsitedSheet = depositExl.getSheetAt(0);
		if(!deopsitedSheet.getSheetName().equalsIgnoreCase("11.1_SHEET"))
		{
			throw new ResourceNotFoundException(env.getProperty("INVALID_EXCEL_MSG"));
		}
		depositedList = q11Service.validateLoanDtlExl(deopsitedSheet,formFiveId);
		Optional.ofNullable(uploadedExcelFile)
						.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("SUCCESS");
			rs.setStatus("200");
			rs.setData(depositedList);
		return ResponseEntity.ok().body(rs);
	}
	
	@Transactional
	@PostMapping("/saveDiscrepancyDtl")
	public ResponseEntity<?> saveDiscrepancyDtl(@RequestBody List<FormFiveQ11_1Model> discrepancyList) throws ResourceNotFoundException{   
		Optional.ofNullable(discrepancyList)
						.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		
		    Long formFiveId=0L;
		    for(FormFiveQ11_1Model model:discrepancyList)
		    	formFiveId = model.getFormFiveId();
		    	q11Service.removeAll(formFiveId);
		    	discrepancyList = q11Service.saveLoanDtl(discrepancyList);
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Saved Successfully.");
			rs.setStatus("200");
			rs.setData(discrepancyList);
		return ResponseEntity.ok().body(rs);
	}
	
	@GetMapping("/form-five-id{formFiveId}")
	public ResponseEntity<?> getDiscrepancyByFormFiveId(@PathVariable(value = "formFiveId") Long formFiveId)
			throws ResourceNotFoundException, IOException, ParseException {
		    logger.debug("called id is " + formFiveId);
		    List<FormFiveQ11_1Model>  loanList = q11Service.findByFormFiveId(formFiveId);
		    Optional.of(loanList).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Records found.");
			rs.setStatus("200");
			rs.setData(loanList);
		return ResponseEntity.ok().body(rs);
	}
	
}
