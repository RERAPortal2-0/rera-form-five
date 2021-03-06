package in.gov.rera.form.five.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import in.gov.rera.form.five.common.RestTamplateUtility;
import in.gov.rera.form.five.common.Util;
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
public class ProjectFormFiveRestController {
	private static final Logger logger = LogManager.getLogger(ProjectFormFiveRestController.class);

	@Autowired
	ProjectFormFiveService projectFormFiveService;
	@Autowired
	Environment env;

	@GetMapping("/financial-year/list{projectId}")
	public ResponseEntity<?> getAllFormFiveDate(@PathVariable(value = "projectId") Long projectId)
			throws ResourceNotFoundException, IOException, ParseException {
		    logger.debug("called id is " + projectId);
		    ProjectFormFiveModel prjFormFiveModel = new ProjectFormFiveModel();
		    prjFormFiveModel=projectFormFiveService.findByProjectId(projectId,env.getProperty("URL_PROJECT_REG"));
		    Optional.of(prjFormFiveModel).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Records found.");
			rs.setStatus("200");
			rs.setData(prjFormFiveModel);
		return ResponseEntity.ok().body(rs);
	}
	
	/*
	 * @GetMapping("/project-dtl{id}") public ResponseEntity<?>
	 * getProjectDtl(@PathVariable(value = "id") Long id) throws
	 * ResourceNotFoundException, IOException, ParseException {
	 * logger.debug("called id is " + id); ProjectFormFiveModel prjFormFiveModel =
	 * new ProjectFormFiveModel();
	 * prjFormFiveModel=projectFormFiveService.findById(id);
	 * Optional.of(prjFormFiveModel).orElseThrow(() -> new
	 * ResourceAccessException(env.getProperty("NOT_FOUND"))); ResponseModel rs =
	 * new ResponseModel(); rs.setMessage("Records found."); rs.setStatus("200");
	 * rs.setData(prjFormFiveModel); return ResponseEntity.ok().body(rs); }
	 */
	
}
