package in.gov.rera.form.five.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

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
import in.gov.rera.form.five.model.FormFiveLogModel;
import in.gov.rera.form.five.security.AuthSecurity;
import in.gov.rera.form.five.security.AuthUser;
import in.gov.rera.form.five.services.FormFiveLogService;
import in.gov.rera.form.five.services.FormFiveService;
import in.gov.rera.form.five.services.ProjectFormFiveService;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/form_five/secure/log")
public class FormFiveLogRestController {
	private static final Logger logger = LogManager.getLogger(FormFiveLogRestController.class);

	@Autowired
	FormFiveLogService logService;
	
	@Autowired
	FormFiveService formFiveService;
	
	@Autowired
	ProjectFormFiveService projectformFiveService;
	
	@Autowired
	Environment env;

	@GetMapping("/get-log-by-form-five-id/{formFiveId}")
	public ResponseEntity<?> getLogDetailsByFormFiveId(@PathVariable(value = "formFiveId") Long formFiveId)
			throws ResourceNotFoundException, IOException, ParseException {
		    List<FormFiveLogModel>  logModel = logService.findByFormFiveId(formFiveId);
		    Optional.of(logModel).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		    ResponseModel rs = new ResponseModel();
			rs.setMessage(env.getProperty("RECORD_FOUND"));
			rs.setStatus("200");
			rs.setData(logModel);
		return ResponseEntity.ok().body(rs);
	}
	
	@GetMapping("/get/{logId}")
	public ResponseEntity<?> getLogDetailsById(@PathVariable(value = "logId") Long logId)
			throws ResourceNotFoundException, IOException, ParseException {
		    FormFiveLogModel logModel = logService.findById(logId);
		    Optional.of(logModel).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		    ResponseModel rs = new ResponseModel();
			rs.setMessage(env.getProperty("RECORD_FOUND"));
			rs.setStatus("200");
			rs.setData(logModel);
		return ResponseEntity.ok().body(rs);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveLogDtl(@RequestBody FormFiveLogModel model, HttpServletRequest req) throws ResourceNotFoundException{
		    Optional.ofNullable(model)
						.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		    AuthUser user = (AuthUser) req.getAttribute(AuthSecurity.AUTH_USER_ATTR);
		    model.setAuthorityId(user.getUserId());
		    model.setAuthorityType(user.getUserType());
		    model.setAuthorityName(user.getUserName());
		    model = logService.saveLog(model);
		    ResponseModel rs = new ResponseModel();
			rs.setMessage(env.getProperty("Log Saved Successfully"));
			rs.setStatus("200");
			rs.setData(model);
		return ResponseEntity.ok().body(rs);
	}
}
