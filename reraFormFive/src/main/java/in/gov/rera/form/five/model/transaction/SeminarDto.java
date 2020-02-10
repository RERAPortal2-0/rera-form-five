package in.gov.rera.form.five.model.transaction;

import java.util.Calendar;

public class SeminarDto  {

	private Long seminarId;

	private String subject;

	private String organisedBy;
	
	private String eventStartDate;
	
	private String eventEndDate;
	
	private String paymentFlag;

	private String details;

	private String certificateIssue;

	private String seminarPayment;

	private Calendar createdOn;

	private java.util.Calendar modifiedOn;

	public Long getSeminarId() {
		return seminarId;
	}

	public void setSeminarId(Long seminarId) {
		this.seminarId = seminarId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getOrganisedBy() {
		return organisedBy;
	}

	public void setOrganisedBy(String organisedBy) {
		this.organisedBy = organisedBy;
	}

	public String getEventStartDate() {
		return eventStartDate;
	}

	public void setEventStartDate(String eventStartDate) {
		this.eventStartDate = eventStartDate;
	}

	public String getEventEndDate() {
		return eventEndDate;
	}

	public void setEventEndDate(String eventEndDate) {
		this.eventEndDate = eventEndDate;
	}

	public String getPaymentFlag() {
		return paymentFlag;
	}

	public void setPaymentFlag(String paymentFlag) {
		this.paymentFlag = paymentFlag;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getCertificateIssue() {
		return certificateIssue;
	}

	public void setCertificateIssue(String certificateIssue) {
		this.certificateIssue = certificateIssue;
	}

	public String getSeminarPayment() {
		return seminarPayment;
	}

	public void setSeminarPayment(String seminarPayment) {
		this.seminarPayment = seminarPayment;
	}

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	public java.util.Calendar getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(java.util.Calendar modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

}
