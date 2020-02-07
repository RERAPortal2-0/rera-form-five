package in.gov.rera.form.five.services;

import java.util.List;
import in.gov.rera.form.five.model.SeminarAssignToModel;


public interface SeminarAssignedService {

	SeminarAssignToModel saveAssignedTo(SeminarAssignToModel model);
    
	SeminarAssignToModel findById(Long id);
	
	List<SeminarAssignToModel> findAll();

	void deleteById(Long id);

	List<SeminarAssignToModel> findBySeminarId(Long id);

	List<SeminarAssignToModel> findByAssign(String userType);
	
	
}
