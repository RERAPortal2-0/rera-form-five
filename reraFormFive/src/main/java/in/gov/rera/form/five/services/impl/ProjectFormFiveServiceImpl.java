package in.gov.rera.form.five.services.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import in.gov.rera.form.five.common.RestTamplateUtility;
import in.gov.rera.form.five.dao.ProjectFormFiveDao;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.FormFiveModel;
import in.gov.rera.form.five.model.ProjectFormFiveModel;
import in.gov.rera.form.five.model.ProjectRegistrationModel;
import in.gov.rera.form.five.services.ProjectFormFiveService;
import in.gov.rera.form.five.common.Util;
import in.gov.rera.form.five.constants.ReraConstants;
import in.gov.rera.form.five.controller.FormFiveRestController;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@Service
@Transactional
public class ProjectFormFiveServiceImpl implements ProjectFormFiveService {

	private static final Logger logger = LogManager.getLogger(ProjectFormFiveServiceImpl.class);
	@Autowired
	ProjectFormFiveDao projectFormFiveDao;

	@Value("${URL_PROJECT_REG}")
	String projectRegUrl;

	@Autowired
	Environment env;

	@Override
	public ProjectFormFiveModel findByProjectId(Long projectId, String projectDtlUrl) {
		// TODO Auto-generated method stub
		ProjectFormFiveModel prjFormFiveModel = new ProjectFormFiveModel();
		prjFormFiveModel = projectFormFiveDao.findByProjectId(projectId);
		if (null == prjFormFiveModel) {
			ProjectRegistrationModel project;
			try {
				project = RestTamplateUtility.projectDtl(projectId,projectDtlUrl );
				Optional.of(project).orElseThrow(() -> new ResourceAccessException("NOT FOUND"));
				logger.debug("project details are " + project);
				ProjectFormFiveModel model = new ProjectFormFiveModel();
				model.setProjectId(projectId);
				model.setPromoterName(project.getPromoterName());
				model.setPromoterEmailId(project.getPromoteremailId());
				model.setPromoterMobileNo(project.getPromoterMobileNo());
				model.setProjectName(project.getProjectDetailsModel().getProjectName());
				Calendar startDate = Calendar.getInstance();
				Calendar endDate = Calendar.getInstance();
				String currentFYear="";
				  int year = Calendar.getInstance().get(Calendar.YEAR);

				    int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
				
				    if (month < 3) {
				    	currentFYear = (year - 1) + "-" + year;
				    } else {
				    	currentFYear = year + "-" + (year + 1);
				    }
				   
				    	Date formFiveStartDate= project.getApprovedOn() == null ? project.getProjectDetailsModel().getStartDate() : project.getApprovedOn().getTime();
				    
				    	System.out.println("formFiveStartDate:::::::is::::::::::"+formFiveStartDate);
				    
				System.out.println("current Financial year is " + currentFYear);
				startDate.setTime(project.getProjectDetailsModel().getStartDate());
				System.out.println("project start DAte is "+project.getProjectDetailsModel().getStartDate());
				System.out.println("project end DAte is "+project.getProjectDetailsModel().getCompletionDate());
				System.out.println("project approved DAte is "+project.getApprovedOn());
				
				endDate.setTime(project.getProjectDetailsModel().getCompletionDate());
				List<String> fYearlist = Util.getFinancialYear(startDate, endDate,formFiveStartDate);
				List<FormFiveModel> fList = new ArrayList<FormFiveModel>();
				logger.debug(fYearlist);
				int i=1;
				
				for (String f : fYearlist) {
					FormFiveModel fModel = new FormFiveModel();
					fModel.setFormFiveName("F-"+i);
					fModel.setFormFiveYear(f.substring(5,9));
					fModel.setFinancialYear(f);
					fModel.setProjectId(projectId);
					fModel.setProjectName(project.getProjectDetailsModel().getProjectName());
					fModel.setPromoterName(project.getPromoterName());
					  fModel.setCertFromDate("01-04-"+f.substring(0,4));
					  fModel.setCertToDate("31-03-"+f.substring(5,9));
					 
					if (currentFYear.equals(f))
						fModel.setFinancialYearStatus(ReraConstants.ACTIVE);
					else {
						fModel.setFinancialYearStatus(ReraConstants.INACTIVE);
					}
					fList.add(fModel);
					i++;
				}
				model.setFormFiveList(fList);
				model = saveProjectFormFive(model);
				prjFormFiveModel = model;
			} catch (ResourceNotFoundException e) {
				e.printStackTrace();
			}
		} else {
		}
		return projectFormFiveDao.findByProjectId(projectId);
	}

	@Override
	public ProjectFormFiveModel saveProjectFormFive(ProjectFormFiveModel model) {
		// TODO Auto-generated method stub
		return projectFormFiveDao.save(model);
	}

	@Override
	public ProjectFormFiveModel findById(Long id) {
		// TODO Auto-generated method stub
		return projectFormFiveDao.findById(id).get();
	}

	@Override
	public ProjectFormFiveModel findByProjectId(Long formFiveId) {
		// TODO Auto-generated method stub
		return projectFormFiveDao.findByProjectId(formFiveId);
	}

}
