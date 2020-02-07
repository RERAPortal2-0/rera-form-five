package in.gov.rera.form.five.services;

import java.util.List;
import in.gov.rera.form.five.model.SeminarFeedbackModel;


public interface SeminarFeedbackService {

	SeminarFeedbackModel saveFeedback(SeminarFeedbackModel model);
    
	SeminarFeedbackModel findById(Long id);
	
	List<SeminarFeedbackModel> findAll();

	void deleteById(Long id);

	List<SeminarFeedbackModel> findBySeminarId(Long id);
	
	


	
}
