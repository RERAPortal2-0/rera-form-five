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
import in.gov.rera.form.five.model.FormFiveDocumentModel;
import in.gov.rera.form.five.model.FormFiveModel;
import in.gov.rera.form.five.services.FormFiveDocumentService;
import in.gov.rera.form.five.services.FormFiveService;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/form_five/secure/doc")
public class FormFiveDocumentRestController {
	private static final Logger logger = LogManager.getLogger(FormFiveDocumentRestController.class);

	@Autowired
	Environment env;
    
	@Autowired
	FormFiveService formFiveService;
	
	@Autowired
	FormFiveDocumentService docService;
	
	@Autowired
	DmsServices dmsService;
	
	@PostMapping("/save")
	public ResponseEntity<?> saveOtherDocument(@RequestBody FormFiveDocumentModel model) throws ResourceNotFoundException{   
		Optional.ofNullable(model)
						.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		    FormFiveModel formFiveModel = formFiveService.findById(model.getFormFiveId());
		    formFiveModel.setFormFiveDocModel(model);
		    formFiveModel= formFiveService.saveFormFive(formFiveModel);
		    model=dmsService.commitDoc(formFiveModel.getFormFiveDocModel(), env.getProperty("URL_CREATE_VDMS"));
		    formFiveModel.getFormFiveDocModel().setBalanceSheetDocName("UPDATED");
		    formFiveModel.setFormFiveDocModel(model);
		    formFiveModel = formFiveService.saveFormFive(formFiveModel);
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Document Saved Successfully.");
			rs.setStatus("200");
			rs.setData(formFiveModel);
		    return ResponseEntity.ok().body(rs);
		    
	}
	
	
	@PostMapping("/update")
	public ResponseEntity<?> updateDocument(@RequestBody FormFiveDocumentModel model) throws ResourceNotFoundException{   
		Optional.ofNullable(model)
						.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		   
		    FormFiveModel formFiveModel = formFiveService.findById(model.getFormFiveId());
		    model = docService.saveDocument(model);
		    formFiveModel.setFormFiveDocModel(model);
		    formFiveModel = formFiveService.saveFormFive(formFiveModel);
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Document Saved Successfully.");
			rs.setStatus("200");
			rs.setData(formFiveModel);
		    return ResponseEntity.ok().body(rs);
	}
	
	@DeleteMapping("/delete{id}")
	public ResponseEntity<?> removeOtherDocument(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
		Optional.ofNullable(id)
		.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		docService.remove(id);
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Record Deleted");
		rs.setStatus("200");
		return ResponseEntity.ok().body(rs);
	}
	
	@GetMapping("/all{formFiveId}")
	public ResponseEntity<?> getOtherDocList(@PathVariable(value = "formFiveId") Long formFiveId)
			throws ResourceNotFoundException, IOException, ParseException {
		    logger.debug("called id is " + formFiveId);
		    Optional.of(formFiveId).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		    List<FormFiveDocumentModel>  docList = docService.findByFormFiveId(formFiveId);
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Records found.");
			rs.setStatus("200");
			rs.setData(docList);
		return ResponseEntity.ok().body(rs);
	}
}
