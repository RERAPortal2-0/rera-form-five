package in.gov.rera.form.five.services.impl;

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
		return formFiveDao.findById(id).get();
	}

	@Override
	public FormFiveModel updateFormFive(FormFiveModel formFiveModel) {
		return formFiveDao.save(formFiveModel);
	}

	@Override
	public List<FormFiveModel> findByCaNumber(String caNumber) {
		return formFiveDao.findByCaNumber(caNumber);
	}

	@Override
	public FormFiveModel saveFormFive(FormFiveModel formFiveModel) {
		return formFiveDao.save(formFiveModel);
	}

	@Override
	public List<FormFiveModel> findFormFiveListbyStatus(String status) {
		return formFiveDao.findByStatus(status);
	}

	@Override
	public List<FormFiveModel> findFormFiveListbyFinancialYear(String financialYear) {
		return formFiveDao.findByFinancialYear(financialYear);
	}
	
	

}
