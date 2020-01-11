package in.gov.rera.form.five.services.Impl;

import java.util.List;

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
	public FormFiveModel findById(Long id) {
		// TODO Auto-generated method stub
		return formFiveDao.findById(id).get();
	}

	@Override
	public FormFiveModel updateFormFive(FormFiveModel formFiveModel) {
		// TODO Auto-generated method stub
		return formFiveDao.save(formFiveModel);
	}

	@Override
	public List<FormFiveModel> findByCaNumber(String caNumber) {
		// TODO Auto-generated method stub
		return formFiveDao.findByCaNumber(caNumber);
	}

	@Override
	public FormFiveModel saveFormFive(FormFiveModel formFiveModel) {
		// TODO Auto-generated method stub
		return formFiveDao.save(formFiveModel);
	}

	@Override
	public List<FormFiveModel> findFormFiveListbyStatus(String status) {
		// TODO Auto-generated method stub
		return formFiveDao.findByStatus(status);
	}
	
	

}
