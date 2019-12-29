package in.gov.rera.form.five.services.Impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import in.gov.rera.form.five.common.RestTamplateUtility;
import in.gov.rera.form.five.dao.ProjectFormFiveDao;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.ProjectFormFiveModel;
import in.gov.rera.form.five.model.ProjectRegistrationModel;
import in.gov.rera.form.five.services.ProjectFormFiveService;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@Service
@Transactional
public class ProjectFormFiveServiceImpl implements ProjectFormFiveService { 
	
	@Autowired 
	ProjectFormFiveDao projectFormFiveDao;

	@Value("${URL_PROJECT_REG}")
	String projectRegUrl;
	
	@Autowired
	Environment env;
	
	@Override
	public ProjectFormFiveModel findByProjectId(Long projectId) {
		// TODO Auto-generated method stub
		
		ProjectFormFiveModel prjFormFiveModel=projectFormFiveDao.findByProjectId(projectId);
		
		System.out.println("form five model is "+prjFormFiveModel);
		if(null!=prjFormFiveModel) {
			ProjectRegistrationModel project;
			try {
				project = RestTamplateUtility.projectDtl(projectId, env.getProperty("URL_PROJECT_REG"));
				System.out.println("project details are "+project);
				ProjectFormFiveModel model =new ProjectFormFiveModel();
				model.setProjectId(projectId);
				model.setPromoterName(project.getPromoterName());
				model.setPromoterEmailId(project.getPromoteremailId());
				model.setPromoterMobileNo(project.getPromoterMobileNo());
				model.setProjectName(project.getProjectDetailsModel().getProjectName());
				//model = projectFormFiveService.saveProjectFormFive(model);
				prjFormFiveModel=model;
				System.out.println("project Start date is "+project.getProjectDetailsModel().getStartDate());
				System.out.println("project end date is "+project.getProjectDetailsModel().getCompletionDate());
			} catch (ResourceNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("inside if block project details are ");
		}
		
		return projectFormFiveDao.findByProjectId(projectId);
	}
	@Override
	public ProjectFormFiveModel saveProjectFormFive(ProjectFormFiveModel model) {
		// TODO Auto-generated method stub
		return projectFormFiveDao.save(model);
	}
	
}
