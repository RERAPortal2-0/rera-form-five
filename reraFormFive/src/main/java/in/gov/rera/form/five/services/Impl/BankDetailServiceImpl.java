package in.gov.rera.form.five.services.Impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gov.rera.form.five.dao.BankDetailsDao;
import in.gov.rera.form.five.dao.FormFiveDao;
import in.gov.rera.form.five.model.FormFiveBankDetailsModel;
import in.gov.rera.form.five.model.FormFiveModel;
import in.gov.rera.form.five.services.BankDetaillService;
import in.gov.rera.form.five.services.FormFiveService;

@Service
@Transactional
public class BankDetailServiceImpl implements BankDetaillService { 
	
	@Autowired 
	BankDetailsDao bankDao;

	@Override
	public FormFiveBankDetailsModel findById(Long id) {
		// TODO Auto-generated method stub
		return bankDao.findById(id).get();
	}

	@Override
	public FormFiveBankDetailsModel updateBankDetail(FormFiveBankDetailsModel bankModel) {
		// TODO Auto-generated method stub
		return bankDao.save(bankModel);
	}

	@Override
	public List<FormFiveBankDetailsModel> findByFormFiveId(Long id) {
		// TODO Auto-generated method stub
		return bankDao.findByFormFiveId(id);
	}

	@Override
	public FormFiveBankDetailsModel saveBankDtl(FormFiveBankDetailsModel bankModel) {
		// TODO Auto-generated method stub
		return bankDao.save(bankModel);
	}

	@Override
	public void deleteBankDetail(Long bankId) {
		// TODO Auto-generated method stub
		bankDao.deleteById(bankId);
	}


	
	

}
