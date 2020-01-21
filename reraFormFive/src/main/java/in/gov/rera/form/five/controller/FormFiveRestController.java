package in.gov.rera.form.five.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
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
import in.gov.rera.form.five.model.FormFiveModel;
import in.gov.rera.form.five.model.ProjectFormFiveModel;
import in.gov.rera.form.five.model.transaction.UserTransactionModel;
import in.gov.rera.form.five.notification.MailContents;
import in.gov.rera.form.five.notification.NotificationUtil;
import in.gov.rera.form.five.notification.SmsContents;
import in.gov.rera.form.five.notification.SmsNotification;
import in.gov.rera.form.five.services.FormFiveService;
import in.gov.rera.form.five.services.ProjectFormFiveService;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/form_five/secure/form-five")
public class FormFiveRestController {
	private static final Logger logger = LogManager.getLogger(FormFiveRestController.class);

	@Autowired
	FormFiveService formFiveService;
	
	@Autowired
	ProjectFormFiveService projectformFiveService;
	
	@Autowired
	Environment env;
	
	
	/* @Autowired NotificationUtil notifcationServices; */
	 

	@GetMapping("/getFormFiveById{formFiveId}")
	public ResponseEntity<?> getFormFiveDtlById(@PathVariable(value = "formFiveId") Long formFiveId)
			throws ResourceNotFoundException, IOException, ParseException {
		    logger.debug("called id is " + formFiveId);
		    FormFiveModel  formFiveModel = formFiveService.findById(formFiveId);
		    Optional.of(formFiveModel).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Records found.");
			rs.setStatus("200");
			rs.setData(formFiveModel);
		return ResponseEntity.ok().body(rs);
	}
	
	@GetMapping("/esigned-form-five-list/{financialYear}")
	public ResponseEntity<?> getEsignedFormFiveList(@PathVariable(value = "financialYear") String financialYear)
			throws ResourceNotFoundException, IOException, ParseException {
		List<FormFiveModel>  eSignedformFiveList = new ArrayList<FormFiveModel>();
		List<FormFiveModel>  formFiveList = formFiveService.findFormFiveListbyFinancialYear(financialYear);
		    for(FormFiveModel m:formFiveList)
		    {
		    	if("SUBMITTED".equals(m.getStatus()))
		    	{
		    		eSignedformFiveList.add(m);
		    	}
		    }
		    ResponseModel rs = new ResponseModel();
		    if(eSignedformFiveList.size()>0)
		    {
		    	rs.setMessage("Data found.");
				rs.setStatus("200");
				rs.setData(eSignedformFiveList);
		    }
		    else
		    {
		    	rs.setMessage("No data found");
				rs.setStatus("404");
				rs.setData("");
		    }
		return ResponseEntity.ok().body(rs);
	}
	
	@GetMapping("/pending-form-five-list/{financialYear}")
	public ResponseEntity<?> getPendingFormFiveList(@PathVariable(value = "financialYear") String financialYear)
			throws ResourceNotFoundException, IOException, ParseException {
		List<FormFiveModel>  eSignedformFiveList = new ArrayList<FormFiveModel>();
		List<FormFiveModel>  formFiveList = formFiveService.findFormFiveListbyFinancialYear(financialYear);
		    for(FormFiveModel m:formFiveList)
		    {
		    	if("SUBMITTED".equals(m.getStatus()) && "ACTIVE".equals(m.getFinancialYearStatus()))
		    	{
		    		eSignedformFiveList.add(m);
		    	}
		    }
		    ResponseModel rs = new ResponseModel();
		    if(eSignedformFiveList.size()>0)
		    {
		    	rs.setMessage("Data found.");
				rs.setStatus("200");
				rs.setData(eSignedformFiveList);
		    }
		    else
		    {
		    	rs.setMessage("No data found");
				rs.setStatus("404");
				rs.setData("");
		    }
			
		return ResponseEntity.ok().body(rs);
	}
	
	@GetMapping("/defaulter-form-five-list/{financialYear}")
	public ResponseEntity<?> getDefaulterFormFiveList(@PathVariable(value = "financialYear") String financialYear)
			throws ResourceNotFoundException, IOException, ParseException {
		List<FormFiveModel>  eSignedformFiveList = new ArrayList<FormFiveModel>();
		List<FormFiveModel>  formFiveList = formFiveService.findFormFiveListbyFinancialYear(financialYear);
		    for(FormFiveModel m:formFiveList)
		    {
		    	if(!"SUBMITTED".equals(m.getStatus()) && "INACTIVE".equals(m.getFinancialYearStatus()))
		    	{
		    		eSignedformFiveList.add(m);
		    	}
		    }
		    ResponseModel rs = new ResponseModel();
		    if(eSignedformFiveList.size()>0)
		    {
		    	rs.setMessage("Data found.");
				rs.setStatus("200");
				rs.setData(eSignedformFiveList);
		    }
		    else
		    {
		    	rs.setMessage("No data found");
				rs.setStatus("404");
				rs.setData("");
		    }
		return ResponseEntity.ok().body(rs);
	}
	
	
	@GetMapping("/getFormFiveListByCaNo{caNumber}")
	public ResponseEntity<?> getFormFiveListByCaNo(@PathVariable(value = "caNumber") String caNumber)
			throws ResourceNotFoundException, IOException, ParseException {
		    logger.debug("called id is " + caNumber);    
		    ProjectFormFiveModel pModel= new ProjectFormFiveModel();
		    List<FormFiveModel> formFiveList = formFiveService.findByCaNumber(caNumber);
		    List<UserTransactionModel> assignedFFiveList= new ArrayList<UserTransactionModel>();
		    for(FormFiveModel fModel:formFiveList)
		    {
		       System.out.println(pModel.getProjectId());
		       UserTransactionModel model= new UserTransactionModel();
		       if(!"REJECTED".equals(fModel.getStatus())) {
		       model.setCaNo(fModel.getCaNumber());
		       model.setCertFromDate(fModel.getCertFromDate());
		       model.setCertToDate(fModel.getCertToDate());
		       model.setFormFiveId(fModel.getFormFiveId());
		       model.setFormFiveStatus(fModel.getStatus());
		       model.setProjectName(fModel.getProjectName());
		       model.setPromoterName(fModel.getPromoterName());
		       assignedFFiveList.add(model);
		       }
		    }
		    Optional.of(assignedFFiveList).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Records found.");
			rs.setStatus("200");
			rs.setData(assignedFFiveList);
		return ResponseEntity.ok().body(rs);
	}
	
	
	@PostMapping("/updateFormFive")
	public ResponseEntity<?> updateFormFive(@RequestBody FormFiveModel formFiveModel) throws ResourceNotFoundException{
		    Optional.ofNullable(formFiveModel)
						.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		    formFiveModel = formFiveService.updateFormFive(formFiveModel);
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Records found.");
			rs.setStatus("200");
			rs.setData(formFiveModel);
		return ResponseEntity.ok().body(rs);
	}
	
	@PostMapping("/update-statusById/{id}/{status}")
	public ResponseEntity<?> formOneUpdateStatusById(
			@PathVariable(value="id") Long id,
			@PathVariable(value="status") String status) throws ResourceNotFoundException {
        logger.info("call FormFiveRestController.formFiveUpdateStatusById(),<STATUS>");
        Optional.ofNullable(id) 
				.orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
        FormFiveModel formFive = formFiveService.findById(id);
        Optional.ofNullable(formFive).orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
        formFive.setStatus(status);
        formFive= formFiveService.saveFormFive(formFive);
        if(formFive.getStatus().equals("ACCEPTED")){
          //notifcationServices.sendEmail( MailContents.acceptanceMailToPromoter(formFive));
		  //notifcationServices.sendEmail(MailContents.acceptanceMailToCA(formFive));
		  
		  //notifcationServices.sendSms(SmsContents.acceptanceSmsToPromoter(formFive)); 
		 
		  //notifcationServices.sendSms(SmsContents.acceptanceSmsToCA(formFive));
        }
        ResponseModel response = new ResponseModel();
        response.setStatus(env.getProperty("SUCCESS"));
        response.setMessage("Form Five Status Updated");
        response.setData(formFive);
        logger.info("call FormOneRestController.formOneUpdateStatusById() , <END>");
	return ResponseEntity.ok().body(response);
   }
}
