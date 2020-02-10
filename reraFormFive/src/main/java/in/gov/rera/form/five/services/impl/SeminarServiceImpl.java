package in.gov.rera.form.five.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import in.gov.rera.form.five.dao.SeminarDao;
import in.gov.rera.form.five.model.SeminarModel;
import in.gov.rera.form.five.services.SeminarService;


@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@Service
@Transactional
public class SeminarServiceImpl implements SeminarService {

	@Autowired
	SeminarDao semiDao;
	

	/*
	 * @Value("${URL_PROJECT_REG}") String projectRegUrl;
	 */

	@Autowired
	Environment env;

	@Override
	public SeminarModel saveSeminar(SeminarModel model) {
		return semiDao.save(model);
	}

	@Override
	public SeminarModel findById(Long id) {
		return semiDao.findById(id).get();
	}

	@Override
	public List<SeminarModel> findAll() {
		return (List<SeminarModel>) semiDao.findAll();
	}

	@Override
	public void deleteById(Long id) {
		semiDao.deleteById(id);
	}

	@Override
	public List<SeminarModel> findPastSeminar() {
		return semiDao.getPastSeminarList();
	}

	@Override
	public List<SeminarModel> findUpCommingSeminar() {
		return semiDao.getUpCommingSeminarList();
	}

	
}
