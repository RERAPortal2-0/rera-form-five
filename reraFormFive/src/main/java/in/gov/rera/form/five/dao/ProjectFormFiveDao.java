package in.gov.rera.form.five.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.rera.form.five.model.ProjectFormFiveModel;

@Repository
public interface ProjectFormFiveDao extends CrudRepository<ProjectFormFiveModel, Long> {
	
	ProjectFormFiveModel findByProjectId(Long projectId);
	ProjectFormFiveModel save(Long projectId);
}
