package in.gov.rera.form.five.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import in.gov.rera.form.five.common.model.ResponseModel;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.FormFiveBankDetailsModel;
import in.gov.rera.form.five.services.BankDetaillService;
import in.gov.rera.form.five.services.FormFiveService;
import in.gov.rera.form.five.services.ProjectFormFiveService;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/form_five/secure/bank")
public class BankDetailRestController {
	private static final Logger logger = LogManager.getLogger(BankDetailRestController.class);

	@Autowired
	BankDetaillService bankService;
	
	@Autowired
	FormFiveService formFiveService;
	
	@Autowired
	ProjectFormFiveService projectformFiveService;
	
	@Autowired
	Environment env;

	@GetMapping("/getBankDtlByFormFiveId{formFiveId}")
	public ResponseEntity<?> getBankDetailsByFormFiveId(@PathVariable(value = "formFiveId") Long formFiveId)
			throws ResourceNotFoundException, IOException, ParseException {
		    List<FormFiveBankDetailsModel>  bankModel = bankService.findByFormFiveId(formFiveId);
		    Optional.of(bankModel).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		    ResponseModel rs = new ResponseModel();
			rs.setMessage(env.getProperty("RECORD_FOUND"));
			rs.setStatus("200");
			rs.setData(bankModel);
		return ResponseEntity.ok().body(rs);
	}
	
	
	@GetMapping("/getBankDtlById{bankId}")
	public ResponseEntity<?> getBankDetailsById(@PathVariable(value = "bankId") Long bankId)
			throws ResourceNotFoundException, IOException, ParseException {
		    FormFiveBankDetailsModel bankModel = bankService.findById(bankId);
		    Optional.of(bankModel).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		    ResponseModel rs = new ResponseModel();
			rs.setMessage(env.getProperty("RECORD_FOUND"));
			rs.setStatus("200");
			rs.setData(bankModel);
		return ResponseEntity.ok().body(rs);
	}
	
	@PostMapping("/saveFormFiveBankDtl")
	public ResponseEntity<?> saveBankDtl(@RequestBody FormFiveBankDetailsModel bankModel) throws ResourceNotFoundException{
		    Optional.ofNullable(bankModel)
						.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		    bankModel = bankService.saveBankDtl(bankModel);
		    ResponseModel rs = new ResponseModel();
			rs.setMessage(env.getProperty("RECORD_FOUND"));
			rs.setStatus("200");
			rs.setData(bankModel);
		return ResponseEntity.ok().body(rs);
	}
	
	@PostMapping("/updateFormFiveBankDtl")
	public ResponseEntity<?> updateBankDtl(@RequestBody FormFiveBankDetailsModel bankModel) throws ResourceNotFoundException{
		    Optional.ofNullable(bankModel)
						.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		    bankModel = bankService.updateBankDetail(bankModel);
		    ResponseModel rs = new ResponseModel();
			rs.setMessage(env.getProperty("RECORD_FOUND"));
			rs.setStatus("200");
			rs.setData(bankModel);
		return ResponseEntity.ok().body(rs);
	}
	
	@PostMapping("/deleteFormFiveBankDtl{frmFiveBankId}")
	public ResponseEntity<?> deleteBankDtl(@PathVariable(value = "frmFiveBankId") Long frmFiveBankId) throws ResourceNotFoundException{
		    Optional.ofNullable(frmFiveBankId).orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		    bankService.deleteBankDetail(frmFiveBankId);
		    ResponseModel rs = new ResponseModel();
			rs.setMessage(env.getProperty("RECORD_FOUND"));
			rs.setStatus("200");
			rs.setData("Bank Details Deleted Successfully");
		return ResponseEntity.ok().body(rs);
	}
	
}
