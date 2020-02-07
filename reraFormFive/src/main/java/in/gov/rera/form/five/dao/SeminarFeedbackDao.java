package in.gov.rera.form.five.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.rera.form.five.model.FormFiveQ5_1Model;
import in.gov.rera.form.five.model.SeminarFeedbackModel;



@Repository
public interface SeminarFeedbackDao extends CrudRepository<SeminarFeedbackModel, Long> {
	
	List<SeminarFeedbackModel> findBySeminarId(Long seminarId);
}
