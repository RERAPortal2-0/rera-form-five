package in.gov.rera.form.five.controller;

import java.io.IOException;
import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import in.gov.rera.form.five.common.RestTamplateUtility;
import in.gov.rera.form.five.common.model.ResponseModel;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.FormFiveModel;
import in.gov.rera.form.five.model.ProjectFormFiveModel;
import in.gov.rera.form.five.model.ProjectRegistrationModel;
import in.gov.rera.form.five.services.ProjectFormFiveService;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/form_five/secure")
public class FormFiveRestController {
	private static final Logger logger = LogManager.getLogger(FormFiveRestController.class);

	@Autowired
	ProjectFormFiveService projectFormFiveService;
	@Autowired
	Environment env;

	@GetMapping("/financial-year/list{id}")
	public ResponseEntity<?> getAllFormFiveDate(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException, IOException, ParseException {
		    System.out.println("called id is " + id);
		    ResponseModel rs = new ResponseModel();
		    ProjectFormFiveModel prjFormFiveModel = null;
			prjFormFiveModel = projectFormFiveService.findByProjectId(id);
			rs.setMessage("Records found.");
			rs.setStatus("200");
			rs.setData(prjFormFiveModel);
		return ResponseEntity.ok().body(rs);
	}
}
