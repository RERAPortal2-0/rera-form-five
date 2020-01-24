package in.gov.rera.form.five.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gov.rera.form.five.dao.OtherDocumentDao;
import in.gov.rera.form.five.model.FormFiveOtherDocModel;
import in.gov.rera.form.five.services.OtherDocumentService;

@Service
@Transactional
public class OtherDocumentServiceImpl implements OtherDocumentService { 
	
	@Autowired 
	OtherDocumentDao othDocDao;

	@Override
	public FormFiveOtherDocModel findById(Long id) {
		return othDocDao.findById(id).get();
	}

	@Override
	public List<FormFiveOtherDocModel> findByFormFiveId(Long id) {
		return othDocDao.findByFormFiveId(id);
	}

	@Override
	public FormFiveOtherDocModel saveOthDocument(FormFiveOtherDocModel Model) {
		return othDocDao.save(Model);
	}

	@Override
	public void remove(Long id) {
		othDocDao.deleteById(id);
	}
	
	

}
