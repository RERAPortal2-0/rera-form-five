package in.gov.rera.form.five.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.gov.rera.form.five.common.model.ResponseModel;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.SeminarAssignToModel;
import in.gov.rera.form.five.model.SeminarModel;
import in.gov.rera.form.five.security.AuthSecurity;
import in.gov.rera.form.five.security.AuthUser;
import in.gov.rera.form.five.services.SeminarAssignedService;
import in.gov.rera.form.five.services.SeminarService;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/form_five/secure/seminar/assign")
public class SeminarAssignRestController {

	@Autowired
	SeminarAssignedService service;
	
	@Autowired
	SeminarService semiService;

	@Autowired Environment env;

	
	
	@GetMapping("/user")
	public ResponseEntity<ResponseModel> getSeminarDetailsById(HttpServletRequest req)
			throws ResourceNotFoundException, IOException {
		AuthUser user = (AuthUser) req.getAttribute(AuthSecurity.AUTH_USER_ATTR);
		List<SeminarAssignToModel> list = service.findByAssign(user.getUserType());
		List<SeminarModel> seminarList = new ArrayList<>();
		for(SeminarAssignToModel l:list)
		{
			SeminarModel m = new SeminarModel();
			m = semiService.findById(l.getSeminarId());
			seminarList.add(m);		
		}
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Records found");
		rs.setStatus("200");
		rs.setData(seminarList);
		return ResponseEntity.ok().body(rs);
	}
	 
	
	
}
