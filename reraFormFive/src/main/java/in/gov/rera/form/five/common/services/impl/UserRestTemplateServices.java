package in.gov.rera.form.five.common.services.impl;

import org.springframework.web.client.RestTemplate;

import in.gov.rera.form.five.common.model.DmsModel;






public class UserRestTemplateServices {
	

	

	public static DmsModel saveDoc(DmsModel entity,String url) {
		System.out.println("saveDoc :"+url);
		RestTemplate restTemplate = new RestTemplate();
		DmsModel document = restTemplate.postForObject(url, entity,DmsModel.class);
		return document;
	}
}
