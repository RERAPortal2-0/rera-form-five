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
import in.gov.rera.form.five.model.FormFiveQ9_1Model;
import in.gov.rera.form.five.services.FormFiveService;
import in.gov.rera.form.five.services.Q9_1Service;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/form_five/secure/que-nine")
public class Q9_1RestController {
	private static final Logger logger = LogManager.getLogger(Q9_1RestController.class);

	@Autowired
	Environment env;

	@Autowired
	Q9_1Service q9Service;
	
	@Autowired
	FormFiveService pServ;
	
	
	@PostMapping("/validate-received-exldata")
	public ResponseEntity<?> validateAmtReceivedExldata(@RequestParam("file") MultipartFile uploadedExcelFile,
			@RequestParam("formFiveId") Long formFiveId,
			 @ModelAttribute("FormFiveQ9_1Model") FormFiveQ9_1Model withDrawlModel
			) throws ResourceNotFoundException, IOException, ParseException{
		    
		XSSFWorkbook depositExl = new XSSFWorkbook(uploadedExcelFile.getInputStream());
		List<FormFiveQ9_1Model> depositedList= new ArrayList<FormFiveQ9_1Model>();
		XSSFSheet deopsitedSheet = depositExl.getSheetAt(0);
		if(!deopsitedSheet.getSheetName().equalsIgnoreCase("AMOUNT_RECEIVED"))
		{
			throw new ResourceNotFoundException(env.getProperty("INVALID_EXCEL_MSG"));
		}
		depositedList = q9Service.validateReceivedAmtDtlExl(deopsitedSheet,formFiveId);
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
	public ResponseEntity<?> saveAmtReceivedDtl(@RequestBody List<FormFiveQ9_1Model> AmtReceivedList) throws ResourceNotFoundException{   
		Optional.ofNullable(AmtReceivedList)
						.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		Long formFiveId=0L;
		for(FormFiveQ9_1Model model :AmtReceivedList)
		    	formFiveId= model.getFormFiveId();
		    	q9Service.removeAll(formFiveId);
		    	FormFiveModel pModel = new FormFiveModel();
		    	pModel = pServ.findById(formFiveId);
		    	pModel.setProjectFormFiveQ9_1List(AmtReceivedList);
		    	pModel = pServ.saveFormFive(pModel);
		    //AmtReceivedList = q9Service.saveWithdrawlsDtl(AmtReceivedList);
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Saved Successfully.");
			rs.setStatus("200");
			rs.setData(pModel.getProjectFormFiveQ9_1List());
		return ResponseEntity.ok().body(rs);
	}
	
	@GetMapping("/form-five-id{formFiveId}")
	public ResponseEntity<?> getAmtReceivedDtlByFormFiveId(@PathVariable(value = "formFiveId") Long formFiveId)
			throws ResourceNotFoundException, IOException, ParseException {
		    logger.debug("called id is " + formFiveId);
		    List<FormFiveQ9_1Model>  AmtReceivedList = q9Service.findByFormFiveId(formFiveId);
		    Optional.of(AmtReceivedList).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Records found.");
			rs.setStatus("200");
			rs.setData(AmtReceivedList);
		return ResponseEntity.ok().body(rs);
	}
	
}
