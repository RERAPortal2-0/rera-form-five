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
import in.gov.rera.form.five.model.FormFiveModel;
import in.gov.rera.form.five.model.FormFiveQ5_1Model;
import in.gov.rera.form.five.model.FormFiveQ7_1Model;
import in.gov.rera.form.five.services.FormFiveService;
import in.gov.rera.form.five.services.Q7_1Service;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/form_five/secure/seven")
public class Q7_1RestController {
	private static final Logger logger = LogManager.getLogger(Q7_1RestController.class);

	
	@Autowired
	Environment env;

	@Autowired
	Q7_1Service q7Service;
	
	@Autowired
	FormFiveService pServ;
	
	
	@PostMapping("/validateWithdrawExldata")
	public ResponseEntity<?> validateWithdrawExldata(@RequestParam("file") MultipartFile uploadedExcelFile,
			@RequestParam("formFiveId") Long formFiveId,
			 @ModelAttribute("FormFiveQ7_1Model") FormFiveQ7_1Model withDrawlModel
			) throws ResourceNotFoundException, IOException, ParseException{
		    
		XSSFWorkbook depositExl = null;
		try {
		depositExl= new XSSFWorkbook(uploadedExcelFile.getInputStream());
	} catch (Exception e) {
		throw new ResourceNotFoundException("Please upload valid Excel File");
	}
		List<FormFiveQ7_1Model> depositedList= new ArrayList<FormFiveQ7_1Model>();
		XSSFSheet deopsitedSheet = depositExl.getSheetAt(0);
		if(!deopsitedSheet.getSheetName().equalsIgnoreCase("AMOUNT_EXCESS"))
		{
			throw new ResourceNotFoundException(env.getProperty("INVALID_EXCEL_MSG"));
		}
		//
		depositedList = q7Service.validateWithdrawlDtlExl(deopsitedSheet,formFiveId);
		Optional.ofNullable(uploadedExcelFile)
						.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("SUCCESS");
			rs.setStatus("200");
			rs.setData(depositedList);
		return ResponseEntity.ok().body(rs);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveWithdrawlsDtl(@RequestBody List<FormFiveQ7_1Model> depositedList) throws ResourceNotFoundException{   
		Optional.ofNullable(depositedList)
						.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		Long formFiveId = 0L;
		for (FormFiveQ7_1Model model : depositedList)
			formFiveId = model.getFormFiveId();
			System.out.println("form five id is " + formFiveId);
			q7Service.removeAll(formFiveId);
			FormFiveModel pModel = pServ.findById(formFiveId);
			pModel.setProjectFormFiveQ7_1List(depositedList);
			pModel=pServ.saveFormFive(pModel);
			//depositedList = q7Service.saveWithdrawlsDtl(depositedList);
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Saved Successfully.");
			rs.setStatus("200");
			rs.setData(pModel.getProjectFormFiveQ7_1List());
		return ResponseEntity.ok().body(rs);
	}
	
	@GetMapping("/getWithdrawlsDtlByFormFiveId{formFiveId}")
	public ResponseEntity<?> getWithdrawlsDtlByFormFiveId(@PathVariable(value = "formFiveId") Long formFiveId)
			throws ResourceNotFoundException, IOException, ParseException {
		    logger.debug("called id is " + formFiveId);
		    List<FormFiveQ7_1Model>  depositedList = q7Service.findByFormFiveId(formFiveId);
		    Optional.of(depositedList).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Records found.");
			rs.setStatus("200");
			rs.setData(depositedList);
		return ResponseEntity.ok().body(rs);
	}
	
}
