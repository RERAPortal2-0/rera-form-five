package in.gov.rera.form.five.services.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gov.rera.form.five.dao.FormFiveDao;
import in.gov.rera.form.five.model.FormFiveModel;
import in.gov.rera.form.five.services.FormFiveService;

@Service
@Transactional
public class FormFiveServiceImpl implements FormFiveService { 
	
	@Autowired 
	FormFiveDao formFiveDao;

	@Override
	public FormFiveModel FindByformFiveId(Long id) {
		// TODO Auto-generated method stub
		return formFiveDao.findById(id).get();
	}
	
	

}
