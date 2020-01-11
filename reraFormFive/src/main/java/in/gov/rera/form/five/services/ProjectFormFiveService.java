package in.gov.rera.form.five.services;

import in.gov.rera.form.five.model.ProjectFormFiveModel;;

public interface ProjectFormFiveService {

	ProjectFormFiveModel saveProjectFormFive(ProjectFormFiveModel model);

	ProjectFormFiveModel findByProjectId(Long projectId, String projectDtlUrl);
    
	ProjectFormFiveModel findById(Long id);

	ProjectFormFiveModel findByProjectId(Long formFiveId);
}
