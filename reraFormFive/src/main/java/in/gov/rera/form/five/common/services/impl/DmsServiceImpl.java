package in.gov.rera.form.five.common.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import in.gov.rera.form.five.common.model.DmsModel;
import in.gov.rera.form.five.common.services.DmsServices;



@Service
public class DmsServiceImpl implements DmsServices{

	@Override
	public DmsModel commitDoc(DmsModel model,String url) {
		return UserRestTemplateServices.saveDoc(model,url);
	}

	@Override
	public List<DmsModel> commitDoc(List<DmsModel> model,String url) {
		List<DmsModel> b =new ArrayList<DmsModel>();
		
		for(int i=0;i<model.size();i++) {
			b.add(UserRestTemplateServices.saveDoc(model.get(i),url));
		}
		return b;
	}
}
