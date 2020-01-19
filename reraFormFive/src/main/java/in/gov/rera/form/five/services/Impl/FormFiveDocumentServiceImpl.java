package in.gov.rera.form.five.services.Impl;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import in.gov.rera.form.five.dao.FormFiveDocumentDao;
import in.gov.rera.form.five.model.FormFiveDocumentModel;
import in.gov.rera.form.five.services.FormFiveDocumentService;

@Service
@Transactional
public class FormFiveDocumentServiceImpl implements FormFiveDocumentService { 
	
	@Autowired 
	FormFiveDocumentDao fDocDao;

	@Override
	public FormFiveDocumentModel findById(Long id) {
		return fDocDao.findById(id).get();
	}

	@Override
	public List<FormFiveDocumentModel> findByFormFiveId(Long id) {
		return  fDocDao.findByFormFiveId(id);
	}

	@Override
	public FormFiveDocumentModel saveDocument(FormFiveDocumentModel model) {
		FormFiveDocumentModel m=null;
		if(Optional.ofNullable(model).isPresent()) {
			m=fDocDao.save(model);
		}else { 
			throw new ResourceAccessException("Not found.");
		}
		return m;
	}

	@Override
	public void remove(Long id) {
	}

	
	
	

}
