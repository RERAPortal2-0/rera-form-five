package in.gov.rera.form.five.services.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import in.gov.rera.form.five.dao.SeminarFeedbackDao;
import in.gov.rera.form.five.model.SeminarFeedbackModel;
import in.gov.rera.form.five.services.SeminarFeedbackService;


@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@Service
@Transactional
public class SeminarFeedbackServiceImpl implements SeminarFeedbackService {

	@Autowired
	SeminarFeedbackDao semiDao;

	@Override
	public SeminarFeedbackModel saveFeedback(SeminarFeedbackModel model) {
		return semiDao.save(model);
	}

	@Override
	public SeminarFeedbackModel findById(Long id) {
		return semiDao.findById(id).get();
	}

	@Override
	public List<SeminarFeedbackModel> findAll() {
		return  (List<SeminarFeedbackModel>) semiDao.findAll();
	}

	@Override
	public void deleteById(Long id) {
		semiDao.deleteById(id);
	}

	@Override
	public List<SeminarFeedbackModel> findBySeminarId(Long id) {
		return semiDao.findBySeminarId(id);
	}
	

	
	
}
