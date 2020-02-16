package in.gov.rera.form.five.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import in.gov.rera.form.five.model.FormFiveQ4_1Model;
import in.gov.rera.form.five.services.FormFiveService;
import in.gov.rera.form.five.services.Q4_1Service;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/form_five/secure/four")
public class Q4_1RestController {
	private static final Logger logger = LogManager.getLogger(Q4_1RestController.class);

	@Autowired
	Environment env;

	@Autowired
	Q4_1Service q4Service;

	@Autowired
	FormFiveService pService;

	@PostMapping("/validate-ca-exldata")
	public ResponseEntity<?> validateCaExlDtl(@RequestParam("file") MultipartFile uploadedExcelFile,
			@RequestParam("formFiveId") Long formFiveId, @ModelAttribute("caModel") FormFiveQ4_1Model caModel)
			throws ResourceNotFoundException, IOException, ParseException {
		XSSFWorkbook caDtlExl = null;
		try {
			caDtlExl = new XSSFWorkbook(uploadedExcelFile.getInputStream());
		} catch (Exception e) {
			throw new ResourceNotFoundException("Please upload valid Excel File");
		}
		List<FormFiveQ4_1Model> caDtlList = new ArrayList<FormFiveQ4_1Model>();
		XSSFSheet caSheet = caDtlExl.getSheetAt(0);
		if (!caSheet.getSheetName().equalsIgnoreCase("CA_DETAILS")) {
			throw new ResourceNotFoundException(env.getProperty("INVALID_EXCEL_MSG"));
		}
		FormFiveModel pModel = new FormFiveModel();
		pModel = pService.findById(formFiveId);
		Optional.ofNullable(pModel)
				.orElseThrow(() -> new ResourceNotFoundException("FORM FIVE ID IS NOT FOUND"));
		caDtlList = q4Service.validateCaDtlExl(caSheet, pModel,env.getProperty("USER_REG_CA"));
		Optional.ofNullable(uploadedExcelFile)
				.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		ResponseModel rs = new ResponseModel();
		rs.setMessage("SUCCESS");
		rs.setStatus("200");
		rs.setData(caDtlList);
		return ResponseEntity.ok().body(rs);
	}

	@PostMapping("/save")
	public ResponseEntity<?> saveCaDtl(@RequestBody List<FormFiveQ4_1Model> caDtlList)
			throws ResourceNotFoundException {
		System.out.println("saveCaDtl::::::::::: Called");
		Optional.ofNullable(caDtlList)
				.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		Long formFiveId = 0L;
		for (FormFiveQ4_1Model model : caDtlList)
			formFiveId = model.getFormFiveId();
		System.out.println("form five id is " + formFiveId);
		q4Service.removeAll(formFiveId);
		caDtlList = q4Service.saveCADtl(caDtlList);
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Saved Successfully.");
		rs.setStatus("200");
		rs.setData(caDtlList);
		return ResponseEntity.ok().body(rs);
	}

	@GetMapping("/get-ca-dtl/{formFiveId}")
	public ResponseEntity<?> getCADetailsByFormFiveId(@PathVariable(value = "formFiveId") Long formFiveId)
			throws ResourceNotFoundException, IOException, ParseException {
		logger.debug("called id is " + formFiveId);
		List<FormFiveQ4_1Model> caDtlList = q4Service.findByFormFiveId(formFiveId);
		Optional.of(caDtlList).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Records found.");
		rs.setStatus("200");
		rs.setData(caDtlList);
		return ResponseEntity.ok().body(rs);
	}

	@DeleteMapping("/remove-all/{formFiveId}")
	public ResponseEntity<?> removeCADetailsByFormFiveId(@PathVariable(value = "formFiveId") Long formFiveId) {
		q4Service.removeAll(formFiveId);
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Records found.");
		rs.setStatus("200");
		return ResponseEntity.ok().body(rs);
	}
}
