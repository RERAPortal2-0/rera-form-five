package in.gov.rera.form.five.model.transaction;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
public class PaymentTransactionModel implements Serializable {

	private static final long serialVersionUID = -8616903762245074717L;

	/*
	 * paymentTokenNo: reqAmount: reqPenaltyAmount reqTotalAmount: processName:
	 * registraionType: processId: redirectUrl: userName: mobileNo: emailId:
	 * paymentRemarks:
	 */
	private Long paymentId;

	private Long processId;

	private String processName;

	private String registraionType;

	private String promoterId;

	private String userName;

	private String mobileNo;

	private String emailId;

	private String redirectUrl;

	private Double amount;

	private Double penaltyAmount;

	private Double totalProjectAmount;

	private String sbiReferanceNo;

	private String transactionNo;

	private String tokenNo;

	private String status;

	private String paymentRemarks;

	private String aknowledgementNo;

	private String paymentStatus;

	private Date projectSubmission;
	
	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Long getProcessId() {
		return processId;
	}

	public void setProcessId(Long processId) {
		this.processId = processId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getRegistraionType() {
		return registraionType;
	}

	public void setRegistraionType(String registraionType) {
		this.registraionType = registraionType;
	}

	public String getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(String promoterId) {
		this.promoterId = promoterId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getRedirectUrl() {
		return redirectUrl;
	}

	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getPenaltyAmount() {
		return penaltyAmount;
	}

	public void setPenaltyAmount(Double penaltyAmount) {
		this.penaltyAmount = penaltyAmount;
	}

	public Double getTotalProjectAmount() {
		return totalProjectAmount;
	}

	public void setTotalProjectAmount(Double totalProjectAmount) {
		this.totalProjectAmount = totalProjectAmount;
	}

	public String getSbiReferanceNo() {
		return sbiReferanceNo;
	}

	public void setSbiReferanceNo(String sbiReferanceNo) {
		this.sbiReferanceNo = sbiReferanceNo;
	}

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getTokenNo() {
		return tokenNo;
	}

	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPaymentRemarks() {
		return paymentRemarks;
	}

	public void setPaymentRemarks(String paymentRemarks) {
		this.paymentRemarks = paymentRemarks;
	}

	public String getAknowledgementNo() {
		return aknowledgementNo;
	}

	public void setAknowledgementNo(String aknowledgementNo) {
		this.aknowledgementNo = aknowledgementNo;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	public void setProjectSubmission(Date projectSubmission) {
		this.projectSubmission = projectSubmission;
	}
	public Date getProjectSubmission() {
		return projectSubmission;
	}

}
