package in.gov.rera.form.five.services;

import java.util.List;

import in.gov.rera.form.five.model.ProjectFormFiveModel;;

public interface ProjectFormFiveService {


	ProjectFormFiveModel saveProjectFormFive(ProjectFormFiveModel model);

	ProjectFormFiveModel findByProjectId(Long projectId);

}
