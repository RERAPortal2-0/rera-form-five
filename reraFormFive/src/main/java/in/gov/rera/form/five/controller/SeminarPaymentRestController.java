package in.gov.rera.form.five.controller;

import java.util.ArrayList;
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

import in.gov.rera.form.five.common.PaymentTokenNumber;
import in.gov.rera.form.five.common.model.ResponseModel;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.SeminarPaymentDetailsModel;
import in.gov.rera.form.five.model.transaction.PaymentTransactionModel;
import in.gov.rera.form.five.security.AuthSecurity;
import in.gov.rera.form.five.security.AuthUser;
import in.gov.rera.form.five.services.SeminarPaymentService;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("form_five/secure/seminar/payment")
public class SeminarPaymentRestController {
	private static final Logger logger = LogManager.getLogger(SeminarPaymentRestController.class);
	@Autowired
	private Environment env;

	@Autowired
	SeminarPaymentService services;

	@Autowired
	PaymentTransactionModel tmodel;

	/**************************************************************************
	 * getAllProjectPaymentDetails
	 **************************************************************************/

	@GetMapping("/all")
	public ResponseEntity<?> getAllProjectPaymentDetails() {
		List<SeminarPaymentDetailsModel> list = new ArrayList<SeminarPaymentDetailsModel>();
		list = services.getAllPaymentDetail();
		if (list.size() == 0)
			throw new ResourceAccessException(env.getProperty("NOT_FOUND"));
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage(list.size() + " record found.");
		rs.setData(list);
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * saveProjectPaymentDetails
	 **************************************************************************/
	@PostMapping("/save")
	public ResponseEntity<?> saveProjectPaymentDetails(@RequestBody SeminarPaymentDetailsModel entity)
			throws ResourceNotFoundException {
		logger.debug("saveProjectPaymentDetails");
		String flag = "";
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));

		SeminarPaymentDetailsModel pm = services.savePaymentDetail(entity);
		Optional<SeminarPaymentDetailsModel> op = Optional.ofNullable(pm);
		flag = op.isPresent() ? env.getProperty("SUCCESS") : env.getProperty("FAILED");
		ResponseModel rs = new ResponseModel();
		if (flag.equals(env.getProperty("SUCCESS"))) {
			rs.setStatus("200");
			rs.setMessage("");
			rs.setData(pm);
		} else {
			rs.setStatus("300");
			rs.setMessage("some thing went wrong.");
		}
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * saveProjectPaymentDetails
	 **************************************************************************/
	@PostMapping("/modify")
	public ResponseEntity<?> modifyProjectPaymentDetails(@RequestBody SeminarPaymentDetailsModel entity)
			throws ResourceNotFoundException {
		logger.debug("modifyProjectPaymentDetails");
		String flag = "";
		Optional.ofNullable(entity).orElseThrow(() -> new ResourceAccessException(env.getProperty("DATA_INVALID")));
		SeminarPaymentDetailsModel pm = services.updatePaymentDetail(entity);
		Optional<SeminarPaymentDetailsModel> op = Optional.ofNullable(pm);
		flag = op.isPresent() ? env.getProperty("SUCCESS") : env.getProperty("FAILED");
		PaymentTransactionModel t = services.getTransactiondetails(pm);
		ResponseModel rs = new ResponseModel();
		if (flag.equals(env.getProperty("SUCCESS"))) {
			rs.setStatus("200");
			if ("SUCCESS".contentEquals(pm.getStatus())) {
				rs.setMessage("Your payment has been successfully paid and your acknowledge number is "
						+ t.getAknowledgementNo());
			} else if ("BOOKED".contentEquals(pm.getStatus()) || "PENDING".contentEquals(pm.getStatus())) {
				rs.setMessage("Your payment is under settlement.");
			} else {
				rs.setStatus("200");
				rs.setMessage("Your payment is failed. Please try again for payment.");
			}
			rs.setData(t);
		} else {
			rs.setStatus("some thing went wrong. Please contact to administrator.");
		}
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * projectPaymentDetailsById
	 **************************************************************************/
	@GetMapping("/{id}")
	public ResponseEntity<?> getProjectPaymentDetailsById(@PathVariable(value = "id") Long id) {
		SeminarPaymentDetailsModel m = services.getPaymentDetailById(id);
		Optional.ofNullable(m).orElseThrow(() -> new ResourceAccessException(env.getProperty("NOT_FOUND")));
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("Record found.");
		rs.setData(m);
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * projectPaymentDetailsProjectById
	 **************************************************************************/
	@GetMapping("/list-by-seminar-id/{seminarId}")
	public ResponseEntity<ResponseModel> projectPaymentDetailsProjectById(@PathVariable(value = "seminarId") Long seminarId) {
		List<SeminarPaymentDetailsModel> list = new ArrayList<SeminarPaymentDetailsModel>();
		list = services.getPaymentDetailBySeminarId(seminarId);
		if (list.size() == 0)
			throw new ResourceAccessException(env.getProperty("NOT_FOUND"));
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setMessage("Record found.");
		rs.setData(list);
		return ResponseEntity.ok(rs);
	}

	/**************************************************************************
	 * projectPaymentDetails
	 * 
	 * @throws ResourceNotFoundException
	 **************************************************************************/

	@GetMapping("/details/user/{seminarId}")
	public ResponseEntity<?> projectPaymentDetails(@PathVariable(value = "seminarId") Long seminarId, HttpServletRequest req)
			throws ResourceNotFoundException {
		 AuthUser user = (AuthUser) req.getAttribute(AuthSecurity.AUTH_USER_ATTR);
		int flag=0; 
		double paymentAmount=5000;
		System.out.print("Seminar id:" + seminarId);
		SeminarPaymentDetailsModel newModel = new SeminarPaymentDetailsModel();
		List<SeminarPaymentDetailsModel> m = services.getPaymentDetailBySeminarId(seminarId);
		for(SeminarPaymentDetailsModel model :m)
		{
			if(user.getUserId().toString().equals(model.getUserId()) && user.getUserType().equals(model.getUserType()))
			{
				flag=1;
				newModel=model;
			}
		}
		if(flag==1)
		{
		}
		else
		{
			newModel.setAmount(paymentAmount);
			newModel.setSeminarId(seminarId);
			newModel.setUserId(user.getUserId().toString());
			newModel.setUserType(user.getUserType());
			newModel.setUserName(user.getUserName());
			newModel.setEmailId(user.getEmail());
			newModel.setMobileNo(user.getMobile());
			newModel.setTokenNo(PaymentTokenNumber.generateSeminarPayToken());
			newModel = services.savePaymentDetail(newModel);
		}
		PaymentTransactionModel t = services.getTransactiondetails(newModel);
		ResponseModel rs = new ResponseModel();
		rs.setStatus("200");
		rs.setData(newModel);
		return ResponseEntity.ok(rs);
	}

}
