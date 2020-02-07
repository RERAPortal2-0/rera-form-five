package in.gov.rera.form.five.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.rera.form.five.model.SeminarFeedbackModel;
import in.gov.rera.form.five.model.SeminarPaymentDetailsModel;



@Repository
public interface SeminarPaymentDao extends CrudRepository<SeminarPaymentDetailsModel, Long> {
	
	List<SeminarPaymentDetailsModel> findBySeminarId(Long seminarId);
}
