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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import in.gov.rera.form.five.common.model.ResponseModel;
import in.gov.rera.form.five.common.services.DmsServices;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.FormFiveOtherDocModel;
import in.gov.rera.form.five.services.OtherDocumentService;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/form_five/secure/other-doc")
public class FormFiveOtherDocRestController {
	private static final Logger logger = LogManager.getLogger(FormFiveOtherDocRestController.class);

	@Autowired
	Environment env;
    
	@Autowired
	OtherDocumentService othDocService;
	
	@Autowired
	DmsServices dmsService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveOtherDocument(@RequestBody FormFiveOtherDocModel model) throws ResourceNotFoundException{   
		Optional.ofNullable(model)
						.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		    model = othDocService.saveOthDocument(model);
		    model=dmsService.commitOthDoc(model, env.getProperty("URL_CREATE_VDMS"));
		    model = othDocService.saveOthDocument(model);
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Document Saved Successfully.");
			rs.setStatus("200");
			rs.setData("");
		    return ResponseEntity.ok().body(rs);
	}
	
	
	@PostMapping("/update")
	public ResponseEntity<?> updateOtherDocument(@RequestBody FormFiveOtherDocModel model) throws ResourceNotFoundException{   
		Optional.ofNullable(model)
						.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		    model = othDocService.saveOthDocument(model);
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Document Saved Successfully.");
			rs.setStatus("200");
			rs.setData(model);
		    return ResponseEntity.ok().body(rs);
	}
	
	@DeleteMapping("/delete{id}")
	public ResponseEntity<?> removeOtherDocument(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
		Optional.ofNullable(id)
		.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		othDocService.remove(id);
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Record Deleted");
		rs.setStatus("200");
		return ResponseEntity.ok().body(rs);
	}
	
	@GetMapping("/list{formFiveId}")
	public ResponseEntity<?> getOtherDocList(@PathVariable(value = "formFiveId") Long formFiveId)
			throws ResourceNotFoundException, IOException, ParseException {
		    logger.debug("called id is " + formFiveId);
		    List<FormFiveOtherDocModel>  othDocList = othDocService.findByFormFiveId(formFiveId);
		    Optional.of(othDocList).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Records found.");
			rs.setStatus("200");
			rs.setData(othDocList);
		return ResponseEntity.ok().body(rs);
	}
}
