package in.gov.rera.form.five.services.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.gov.rera.form.five.dao.BankDetailsDao;
import in.gov.rera.form.five.model.FormFiveBankDetailsModel;
import in.gov.rera.form.five.services.BankDetaillService;

@Service
@Transactional
public class BankDetailServiceImpl implements BankDetaillService { 
	
	@Autowired 
	BankDetailsDao bankDao;

	@Override
	public FormFiveBankDetailsModel findById(Long id) {
		return bankDao.findById(id).get();
	}

	@Override
	public FormFiveBankDetailsModel updateBankDetail(FormFiveBankDetailsModel bankModel) {
		return bankDao.save(bankModel);
	}

	@Override
	public List<FormFiveBankDetailsModel> findByFormFiveId(Long id) {
		return bankDao.findByFormFiveId(id);
	}

	@Override
	public FormFiveBankDetailsModel saveBankDtl(FormFiveBankDetailsModel bankModel) {
		return bankDao.save(bankModel);
	}

	@Override
	public void deleteBankDetail(Long bankId) {
		bankDao.deleteById(bankId);
	}

	@Override
	public List<FormFiveBankDetailsModel> findAllBank() {
		return (List<FormFiveBankDetailsModel>) bankDao.findAll();
	}


	
	

}
