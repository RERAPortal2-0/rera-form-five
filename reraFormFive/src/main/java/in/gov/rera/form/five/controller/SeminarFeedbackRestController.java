package in.gov.rera.form.five.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

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
import in.gov.rera.form.five.common.model.ResponseModel;
import in.gov.rera.form.five.common.services.DmsServices;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.SeminarFeedbackModel;
import in.gov.rera.form.five.model.SeminarModel;
import in.gov.rera.form.five.security.AuthSecurity;
import in.gov.rera.form.five.security.AuthUser;
import in.gov.rera.form.five.services.SeminarFeedbackService;
import in.gov.rera.form.five.services.SeminarService;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/form_five/secure/seminar/feedback")
public class SeminarFeedbackRestController {

	@Autowired
	SeminarFeedbackService semiService;

	@Autowired Environment env;

	@GetMapping("/get-by-id/{id}")
	public ResponseEntity<ResponseModel> getSeminarFeedbackDetailsById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException, IOException {
		SeminarFeedbackModel model = semiService.findById(id);
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Records found");
		rs.setStatus("200");
		rs.setData(model);
		return ResponseEntity.ok().body(rs);
	}
	
	@GetMapping("/get-by-seminar-id/{id}")
	public ResponseEntity<ResponseModel> getSeminarDetailsById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException, IOException {
		List<SeminarFeedbackModel> list = semiService.findBySeminarId(id);
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Records found");
		rs.setStatus("200");
		rs.setData(list);
		return ResponseEntity.ok().body(rs);
	}
	 
	@GetMapping("/get-all")
	public ResponseEntity<ResponseModel> getAllFeedbackList()
			throws ResourceNotFoundException, IOException {
		List<SeminarFeedbackModel> list = semiService.findAll();
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Records found.");
		rs.setStatus("200");
		rs.setData(list);
		return ResponseEntity.ok().body(rs);
	}
	
	@PostMapping("/save")
	public ResponseEntity<ResponseModel> saveFeedback(@RequestBody SeminarFeedbackModel model, HttpServletRequest req)
			throws ResourceNotFoundException {
		Optional.ofNullable(model)
				.orElseThrow(() -> new ResourceNotFoundException("NOT FOUND"));
		 AuthUser user = (AuthUser) req.getAttribute(AuthSecurity.AUTH_USER_ATTR);
         model.setUserId(user.getUserId().toString());
         model.setUserType(user.getUserType());
         model.setUserName(user.getUserName());
         model.setEmailId(user.getEmail());
         model.setMobileNo(user.getMobile());
		model=semiService.saveFeedback(model); 
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Data submitted Successfully.");
		rs.setStatus("200");
		rs.setData(model);
		return ResponseEntity.ok().body(rs);
	}
	
	@PostMapping("/delete/{id}")
	public ResponseEntity<ResponseModel> deleteFeedbackDtl(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException {
		Optional.ofNullable(id).orElseThrow(() -> new ResourceNotFoundException("ID NOT FOUND"));
		semiService.deleteById(id);
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Records Deleted.");
		rs.setStatus("200");
		rs.setData("Feedback Details Deleted Successfully");
		return ResponseEntity.ok().body(rs);
	}
}
