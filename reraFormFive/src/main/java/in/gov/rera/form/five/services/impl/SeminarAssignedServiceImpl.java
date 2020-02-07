package in.gov.rera.form.five.services.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import in.gov.rera.form.five.dao.SeminarAssignedDao;
import in.gov.rera.form.five.dao.SeminarFeedbackDao;
import in.gov.rera.form.five.model.SeminarAssignToModel;
import in.gov.rera.form.five.model.SeminarFeedbackModel;
import in.gov.rera.form.five.services.SeminarAssignedService;
import in.gov.rera.form.five.services.SeminarFeedbackService;


@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@Service
@Transactional
public class SeminarAssignedServiceImpl implements SeminarAssignedService {

	@Autowired
	SeminarAssignedDao semiDao;

	@Override
	public SeminarAssignToModel saveAssignedTo(SeminarAssignToModel model) {
		return null;
	}

	@Override
	public SeminarAssignToModel findById(Long id) {
		return null;
	}

	@Override
	public List<SeminarAssignToModel> findAll() {
		return null;
	}

	@Override
	public void deleteById(Long id) {
		
	}

	@Override
	public List<SeminarAssignToModel> findBySeminarId(Long id) {
		return semiDao.findBySeminarId(id);
	}

	@Override
	public List<SeminarAssignToModel> findByAssign(String userType) {
		return semiDao.findByAssign(userType);
	}

	
	

	
	
}
