package in.gov.rera.form.five.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
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
import in.gov.rera.form.five.common.model.ResponseModel;
import in.gov.rera.form.five.common.services.DmsServices;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.SeminarModel;
import in.gov.rera.form.five.services.SeminarService;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("form_five/secure/seminar")
public class SeminarRestController {

	@Autowired
	SeminarService semiService;

	@Autowired
	DmsServices dmsServ;
	
    @Autowired
    Environment env;
	 
	@GetMapping("/get-by-id{id}")
	public ResponseEntity<ResponseModel> getSeminarDetailsById(@PathVariable(value = "id") Long id)
			throws ResourceNotFoundException, IOException {
		SeminarModel model = semiService.findById(id);
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Records found.");
		rs.setStatus("200");
		rs.setData(model);
		return ResponseEntity.ok().body(rs);
	}
	 
	@GetMapping("/get-all")
	public ResponseEntity<ResponseModel> getAllSeminarList()
			throws ResourceNotFoundException, IOException {
		List<SeminarModel> list = semiService.findAll();
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Records found.");
		rs.setStatus("200");
		rs.setData(list);
		return ResponseEntity.ok().body(rs);
	}
	
	
	@GetMapping("/get-past-seminar")
	public ResponseEntity<ResponseModel> getAllPastSeminarList() throws ResourceNotFoundException, IOException {
		List<SeminarModel> list = semiService.findPastSeminar();
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Records found.");
		rs.setStatus("200");
		rs.setData(list);
		return ResponseEntity.ok().body(rs);
	}
	 
	@GetMapping("/get-upcomming-seminar")
	public ResponseEntity<ResponseModel> getAllCommingSeminarList() throws ResourceNotFoundException, IOException {
		List<SeminarModel> list = semiService.findUpCommingSeminar();
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Records found.");
		rs.setStatus("200");
		rs.setData(list);
		return ResponseEntity.ok().body(rs);
	}
	
	@PostMapping("/save")
	public ResponseEntity<ResponseModel> saveSeminar(@RequestBody SeminarModel model)
			throws ResourceNotFoundException {
		Optional.ofNullable(model)
				.orElseThrow(() -> new ResourceNotFoundException("NOT FOUND"));
		model=semiService.saveSeminar(model); 
		model = dmsServ.commitSeminarDoc(model,env.getProperty("URL_CREATE_VDMS"));
		model = semiService.saveSeminar(model);
		ResponseModel rs = new ResponseModel();
		rs.setMessage("Data submitted Successfully.");
		rs.setStatus("200");
		rs.setData(model);
		return ResponseEntity.ok().body(rs);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteSeminarDtl(@PathVariable(value = "id") Long id) throws ResourceNotFoundException{
		    Optional.ofNullable(id).orElseThrow(() -> new ResourceNotFoundException(env.getProperty("DATA_INVALID")));
		    semiService.deleteById(id);
		    ResponseModel rs = new ResponseModel();
			rs.setMessage("Deleted Successfully");
			rs.setStatus("200");
			rs.setData("");
		return ResponseEntity.ok().body(rs);
	}
}
