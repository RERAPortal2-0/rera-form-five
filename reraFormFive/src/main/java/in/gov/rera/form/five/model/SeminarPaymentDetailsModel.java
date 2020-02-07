package in.gov.rera.form.five.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity(name = "SeminarPaymentDetailsModel")
@Table(name = "TL_SEMINAR_PAYMENT")
public class SeminarPaymentDetailsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PPY_ID")
	private Long paymentId;

	@Column(name = "SEMINAR_PAYMENT_ID_FK")
	private Long seminarId;

	@Column(name = "PAYMENT_AMOUNT", columnDefinition = "Double default '0'")
	private Double amount;

	@Column(name = "PPY_SBI_REFNO")
	private String sbiReferanceNo;

	@Column(name = "TRANSACTION_NO")
	private String transactionNo;

	@Column(name = "TOKEN_ON")
	private String tokenNo;

	@Column(name = "STATUS")
	private String status;
	
	@Column(name = "USER_ID")
	private String userId;
	
	@Column(name = "USER_TYPE")
	private String userType;
	
	@Column(name = "MOBILE_NO")
	private String mobileNo;
	
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@Column(name = "USER_NAME")
	private String userName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getSeminarId() {
		return seminarId;
	}

	public void setSeminarId(Long seminarId) {
		this.seminarId = seminarId;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
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

}
