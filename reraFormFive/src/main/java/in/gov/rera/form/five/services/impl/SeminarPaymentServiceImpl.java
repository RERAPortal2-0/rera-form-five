package in.gov.rera.form.five.services.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import in.gov.rera.form.five.dao.SeminarPaymentDao;
import in.gov.rera.form.five.model.SeminarPaymentDetailsModel;
import in.gov.rera.form.five.model.transaction.PaymentTransactionModel;
import in.gov.rera.form.five.services.SeminarPaymentService;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
@Service
@Transactional
public class SeminarPaymentServiceImpl implements SeminarPaymentService {

	@Autowired
	SeminarPaymentDao semiDao;

	@Autowired
	PaymentTransactionModel paymentTransactionModel;
	
	@Override
	public SeminarPaymentDetailsModel findById(Long id) {
		return null;
	}

	@Override
	public List<SeminarPaymentDetailsModel> findAll() {
		return null;
	}

	@Override
	public void deleteById(Long id) {
		
	}

	@Override
	public List<SeminarPaymentDetailsModel> getAllPaymentDetail() {
		return (List<SeminarPaymentDetailsModel>) semiDao.findAll();
	}

	@Override
	public SeminarPaymentDetailsModel savePaymentDetail(SeminarPaymentDetailsModel entity) {
		return semiDao.save(entity);
	}

	@Override
	public SeminarPaymentDetailsModel updatePaymentDetail(SeminarPaymentDetailsModel entity) {
		//Optional<ProjectAlterationPaymentDetailsModel> op = dao.findById(entity.getPaymentId());
		SeminarPaymentDetailsModel paymentModel = semiDao.findById(entity.getPaymentId()).get();
			if (paymentModel!=null) {
				if ("SUCCESS".contentEquals(entity.getStatus())) {
					paymentModel.setSbiReferanceNo(entity.getSbiReferanceNo());
					paymentModel.setTokenNo(entity.getTokenNo());
					paymentModel.setStatus(entity.getStatus());
					paymentModel.setTransactionNo(entity.getTransactionNo());
					//projectAppService.saveprojectAppByProject(updatedProject);
				} else if ("BOOKED".contentEquals(entity.getStatus()) || "PENDING".equals(entity.getStatus())) {
					paymentModel.setStatus(entity.getStatus());
				} 
		} 
		return paymentModel;
	}

	@Override
	public PaymentTransactionModel getTransactiondetails(SeminarPaymentDetailsModel pm) {

		try {
			paymentTransactionModel.setPaymentId(pm.getPaymentId());
			paymentTransactionModel.setEmailId(pm.getEmailId());
			paymentTransactionModel.setMobileNo(pm.getMobileNo());
			paymentTransactionModel.setPaymentRemarks("");
			paymentTransactionModel.setProcessId(pm.getSeminarId());
			paymentTransactionModel.setProcessName("SEMINAR");
			paymentTransactionModel.setRedirectUrl("");
			paymentTransactionModel.setSbiReferanceNo(pm.getSbiReferanceNo());
			paymentTransactionModel.setAmount(pm.getAmount());
			paymentTransactionModel.setStatus(pm.getStatus());
			paymentTransactionModel.setTokenNo(pm.getTokenNo());
			paymentTransactionModel.setTransactionNo(pm.getTransactionNo());
			paymentTransactionModel.setUserName(pm.getUserName());
			paymentTransactionModel.setPaymentStatus(pm.getStatus());
		} catch (Exception e) {
			throw new ResourceAccessException("Error : paymentTransactionModel"+e.getMessage());
		}
		return paymentTransactionModel;
	}

	@Override
	public SeminarPaymentDetailsModel getPaymentDetailById(Long id) {
		return semiDao.findById(id).get();
	}

	@Override
	public List<SeminarPaymentDetailsModel> getPaymentDetailBySeminarId(Long seminarId) {
		return semiDao.findBySeminarId(seminarId);
	}
	

	

	
}
