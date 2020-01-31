package in.gov.rera.form.five.controller;

import java.io.Console;
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
import in.gov.rera.form.five.model.FormFiveQ4_1Model;
import in.gov.rera.form.five.model.FormFiveQ5_1Model;
import in.gov.rera.form.five.services.Q5_1Service;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/form_five/secure/five")
public class Q5_1RestController {
	private static final Logger logger = LogManager.getLogger(Q5_1RestController.class);

	
	@Autowired
	Environment env;

	@Autowired
	Q5_1Service q5Service;
	
	@PostMapping("/validateDepositExldata")
	public ResponseEntity<?> validateDepositExlDtl(@RequestParam("file") MultipartFile uploadedExcelFile,
			@RequestParam("formFiveId") Long formFiveId,
			 @ModelAttribute("depositedModel") FormFiveQ5_1Model depositedModel
			) throws ResourceNotFoundException, IOException, ParseException{
		    System.out.println("form five id is "+formFiveId);
		    XSSFWorkbook depositExl=null;
		    try {    
		 depositExl = new XSSFWorkbook(uploadedExcelFile.getInputStream());
		} catch (Exception e) {
			throw new ResourceNotFoundException("Please upload valid Excel File");
		}
		List<FormFiveQ5_1Model> depositedList= new ArrayList<FormFiveQ5_1Model>();
		XSSFSheet deopsitedSheet = depositExl.getSheetAt(0);
		if(!deopsitedSheet.getSheetName().equalsIgnoreCase("5.1_SHEET"))
		{
			throw new ResourceNotFoundException(env.getProperty("INVALID_EXCEL_MSG"));
		}
		depositedList = q5Service.validateDepositDtlExl(deopsitedSheet,formFiveId);
		Optional.ofNullable(uploadedExcelFile)
						.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("SUCCESS");
			rs.setStatus("200");
			rs.setData(depositedList);
		return ResponseEntity.ok().body(rs);
	}
	
	@Transactional
	@PostMapping("/saveDepositDtl")
	public ResponseEntity<?> saveDepositDtl(@RequestBody List<FormFiveQ5_1Model> depositedList) throws ResourceNotFoundException{
		System.out.println("saveCaDtl::::::::::: Called");    
		Optional.ofNullable(depositedList)
						.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		Long formFiveId = 0L;
		for (FormFiveQ5_1Model model : depositedList)
			formFiveId = model.getFormFiveId();
			System.out.println("form five id is " + formFiveId);
			q5Service.removeAll(formFiveId);
		    depositedList = q5Service.saveDepositDtl(depositedList);
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Saved Successfully.");
			rs.setStatus("200");
			rs.setData(depositedList);
		return ResponseEntity.ok().body(rs);
	}
	
	@GetMapping("/getDepositDtlByFormFiveId{formFiveId}")
	public ResponseEntity<?> getDepositDetailsByFormFiveId(@PathVariable(value = "formFiveId") Long formFiveId)
			throws ResourceNotFoundException, IOException, ParseException {
		    logger.debug("called id is " + formFiveId);
		    List<FormFiveQ5_1Model>  depositedList = q5Service.findByFormFiveId(formFiveId);
		    Optional.of(depositedList).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Records found.");
			rs.setStatus("200");
			rs.setData(depositedList);
		return ResponseEntity.ok().body(rs);
	}
	
}
