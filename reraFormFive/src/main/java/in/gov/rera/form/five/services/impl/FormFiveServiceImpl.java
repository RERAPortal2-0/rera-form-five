package in.gov.rera.form.five.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gov.rera.form.five.dao.FormFiveDao;
import in.gov.rera.form.five.model.FormFiveModel;
import in.gov.rera.form.five.model.transaction.FormFiveDto;
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

	@Override
	public List<FormFiveModel> findAllFormFiveList() {
		return (List<FormFiveModel>) formFiveDao.findAll();
	}

	@Override
	public List<FormFiveModel> findFormFiveListbyFilter(FormFiveDto model) {
		List<FormFiveModel> flterData = new ArrayList<>();
		try {

			String eSignedOn = "%";

			if (!Optional.ofNullable(model.getProjectRegNo()).isPresent()
					|| "".contentEquals(model.getProjectRegNo())) {
				model.setProjectRegNo("%");
			}
			
			if (!Optional.ofNullable(model.getFinancialYear()).isPresent()
					|| "".contentEquals(model.getFinancialYear())) {
				model.setFinancialYear("%");
			}
			//model.setFinancialYear("2019-2020");
			
			if (!Optional.ofNullable(model.getStatus()).isPresent()
					|| "".contentEquals(model.getStatus())) {
				model.setStatus("%");
			}
			if (!Optional.ofNullable(model.getProjectName()).isPresent() || "".contentEquals(model.getProjectName())) {
				model.setProjectName("%");
			}
			if (!Optional.ofNullable(model.getPromoterName()).isPresent() || "".contentEquals(model.getPromoterName())) {
				model.setPromoterName("%");
			}

			

			if (!Optional.ofNullable(model.geteSignedOn()).isPresent()) {
				//model.seteSignedOn("%");
			}

			
		
			flterData = formFiveDao.getProjectWithFilters(model.getFinancialYear(),model.getStatus(), model.getProjectName(), model.getPromoterName(),model.getProjectRegNo());


		} catch (Exception e) {

		}

		return flterData;
	}

	@Override
	public List<FormFiveModel> findByProjectId(Long projectId) {
		return formFiveDao.findByProjectId(projectId);
	}
	
	

}
