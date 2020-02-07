package in.gov.rera.form.five.services;

import java.util.List;

import in.gov.rera.form.five.model.SeminarModel;
import in.gov.rera.form.five.model.SeminarPaymentDetailsModel;
import in.gov.rera.form.five.model.transaction.PaymentTransactionModel;


public interface SeminarPaymentService {
    
	SeminarPaymentDetailsModel findById(Long id);
	
	List<SeminarPaymentDetailsModel> findAll();

	void deleteById(Long id);

	List<SeminarPaymentDetailsModel> getAllPaymentDetail();

	SeminarPaymentDetailsModel savePaymentDetail(SeminarPaymentDetailsModel entity);

	SeminarPaymentDetailsModel updatePaymentDetail(SeminarPaymentDetailsModel entity);

	PaymentTransactionModel getTransactiondetails(SeminarPaymentDetailsModel pm);

	SeminarPaymentDetailsModel getPaymentDetailById(Long id);

	List<SeminarPaymentDetailsModel> getPaymentDetailBySeminarId(Long seminarId);
	
}
