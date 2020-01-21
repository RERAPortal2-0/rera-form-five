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
import in.gov.rera.form.five.model.FormFiveQ10_1Model;
import in.gov.rera.form.five.services.Q10_1Service;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/form_five/secure/ten")
public class Q10_1RestController {
	private static final Logger logger = LogManager.getLogger(Q10_1RestController.class);

	@Autowired
	Environment env;

	@Autowired
	Q10_1Service q10Service;
	
	@PostMapping("/validate-loanamt-exldata")
	public ResponseEntity<?> validateLoanAmtExldata(@RequestParam("file") MultipartFile uploadedExcelFile,
			@RequestParam("formFiveId") Long formFiveId,
			 @ModelAttribute("FormFiveQ10_1Model") FormFiveQ10_1Model withDrawlModel
			) throws ResourceNotFoundException, IOException, ParseException{ 
		XSSFWorkbook depositExl = new XSSFWorkbook(uploadedExcelFile.getInputStream());
		List<FormFiveQ10_1Model> depositedList= new ArrayList<FormFiveQ10_1Model>();
		XSSFSheet deopsitedSheet = depositExl.getSheetAt(0);
		if(!deopsitedSheet.getSheetName().equalsIgnoreCase("10.1_SHEET"))
		{
			throw new ResourceNotFoundException(env.getProperty("INVALID_EXCEL_MSG"));
		}
		depositedList = q10Service.validateLoanDtlExl(deopsitedSheet,formFiveId);
		Optional.ofNullable(uploadedExcelFile)
						.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("SUCCESS");
			rs.setStatus("200");
			rs.setData(depositedList);
		return ResponseEntity.ok().body(rs);
	}
	
	@Transactional
	@PostMapping("/save")
	public ResponseEntity<?> saveLoanAmtDtl(@RequestBody List<FormFiveQ10_1Model> loanList) throws ResourceNotFoundException{   
		Optional.ofNullable(loanList)
						.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		Long formFiveId=0L;    
		for(FormFiveQ10_1Model model:loanList)
		    formFiveId= model.getFormFiveId();
		    q10Service.removeAll(formFiveId);
		    loanList = q10Service.saveLoanDtl(loanList);
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Saved Successfully.");
			rs.setStatus("200");
			rs.setData(loanList);
		return ResponseEntity.ok().body(rs);
	}
	
	@GetMapping("/form-five-id{formFiveId}")
	public ResponseEntity<?> getLoanAmtByFormFiveId(@PathVariable(value = "formFiveId") Long formFiveId)
			throws ResourceNotFoundException, IOException, ParseException {
		    logger.debug("called id is " + formFiveId);
		    List<FormFiveQ10_1Model>  loanList = q10Service.findByFormFiveId(formFiveId);
		    Optional.of(loanList).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Records found.");
			rs.setStatus("200");
			rs.setData(loanList);
		return ResponseEntity.ok().body(rs);
	}
	
}
