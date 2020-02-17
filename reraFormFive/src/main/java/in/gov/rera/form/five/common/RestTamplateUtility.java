package in.gov.rera.form.five.common;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.AuthUserModel;
import in.gov.rera.form.five.model.CAModel;
import in.gov.rera.form.five.model.ProjectRegistrationModel;


public class RestTamplateUtility {
	

	/*
	 * public static List<Object> getBlocksNamelistT(Long projectId,String url) {
	 * RestTemplate restTemplate = new RestTemplate(); ResponseEntity<List<Object>>
	 * projectList = restTemplate.exchange(url+ projectId, HttpMethod.GET, null, new
	 * ParameterizedTypeReference<List<ProjectBlocksModel>>() { });
	 * List<ProjectBlocksModel> projectListObj = projectList.getBody();
	 * 
	 * return projectListObj; }
	 */

	/*
	 * public static List<ProjectBlocksModel> getBlocksNamelist(Long
	 * projectId,String url) { RestTemplate restTemplate = new RestTemplate();
	 * 
	 * ResponseEntity<List<ProjectBlocksModel>> projectList =
	 * restTemplate.exchange(url + projectId, HttpMethod.GET, null, new
	 * ParameterizedTypeReference<List<ProjectBlocksModel>>() { });
	 * List<ProjectBlocksModel> projectListObj = projectList.getBody(); return
	 * projectListObj; }
	 */

	public static ProjectRegistrationModel projectDtl(Long projectId,String url) throws ResourceNotFoundException {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<ProjectRegistrationModel> object = restTemplate.exchange(url + projectId, HttpMethod.GET, null,
				new ParameterizedTypeReference<ProjectRegistrationModel>() {
				});
		return object.getBody();
	}

	public static CAModel caDtl(String caNumber,String url) throws ResourceNotFoundException {
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CAModel> object = restTemplate.exchange(url + caNumber, HttpMethod.GET, null,
				new ParameterizedTypeReference<CAModel>() {
				});
		return object.getBody();
	}
	/*
	 * public static void main(String[] args) throws ResourceNotFoundException {
	 * System.out.println(projectDtl(1L, "http://15.206.175.42/project_reg/1")); }
	 */

	public static List<AuthUserModel> getUserListByType(String assign,String url) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<AuthUserModel> object = restTemplate.exchange(url + assign, HttpMethod.GET, null,
				new ParameterizedTypeReference<AuthUserModel>() {
				});
		return (List<AuthUserModel>) object.getBody();
	}
	
	/*
	 * public static ProjectRegistrationModel projectDtlP(Long projectId,String url)
	 * throws ResourceNotFoundException {
	 * 
	 * RestTemplate restTemplate = new RestTemplate();
	 * ResponseEntity<ProjectRegistrationModel> projectList =
	 * restTemplate.exchange(url + projectId, HttpMethod.GET, null, new
	 * ParameterizedTypeReference<ProjectRegistrationModel>() { });
	 * ProjectRegistrationModel projectListObj = projectList.getBody(); return
	 * projectListObj;
	 
	}*/
	
	/*
	 * public static DmsModel saveDoc(DmsModel entity,String url) {
	 * System.out.println("saveDoc :URL_CREATE_VDMS"); RestTemplate restTemplate =
	 * new RestTemplate(); DmsModel document = restTemplate.postForObject(url,
	 * entity, DmsModel.class); return document;
	 * 
	 * }
	 */

}