package in.gov.rera.form.five.services.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import in.gov.rera.form.five.dao.FormFiveLogDao;
import in.gov.rera.form.five.model.FormFiveLogModel;
import in.gov.rera.form.five.services.FormFiveLogService;

@Service
@Transactional
public class FormFiveLogServiceImpl implements FormFiveLogService { 
	
	@Autowired 
	FormFiveLogDao logDao;

	@Override
	public FormFiveLogModel findById(Long id) {
		return logDao.findById(id).get();
	}

	@Override
	public List<FormFiveLogModel> findByFormFiveId(Long id) {
		return logDao.findByFormFiveId(id);
	}

	@Override
	public FormFiveLogModel saveLog(FormFiveLogModel model) {
		return logDao.save(model);
	}

	


	
	

}
