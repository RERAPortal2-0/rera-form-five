package in.gov.rera.form.five.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "SeminarModel")
@Table(name = "TT_SEMINAR")
public class SeminarModel implements Serializable {

	private static final long serialVersionUID = 1803590463071163237L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEMINAR_ID")
	private Long seminarId;

	@Column(name = "SUBJECT")
	private String subject;

	@Column(name = "ORGANISED_BY")
	private String organisedBy;

	@Column(name = "SPONSORS_ID")
	private Long sponsorsId;

	@Column(name = "SPONSORS_UID")
	private String sponsorsUId;

	@Column(name = "SUPPORTED_BY_ID")
	private Long supportedById;

	@Column(name = "SUPPORTED_BY_UID")
	private String supportedByUId;

	@Column(name = "DETAILS")
	private String details;

	@Column(name = "CERTIFICATE_ISSUE")
	private String certificateIssue;

	@Column(name = "SEMINAR_PAYMENT")
	private String seminarPayment;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_ON", updatable = false)
	private Calendar createdOn;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifiedOn")
	private java.util.Calendar modifiedOn;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "SEMINAR_ID_FK")
	private List<SeminarDetailsModel> seminarDetails;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

	@JoinColumn(name = "SEMINAR_ID_SP_FK")
	private List<SpeakerDetailsModel> speakerDetails;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "SEMINAR_ID_IMG_FK")
	private List<SeminarBannerModel> seminarBanner;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "SEMINAR_ID_ASG_FK")
	private List<SeminarAssignToModel> assignTo;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "SEMINAR_PAYMENT_ID_FK")
	private List<SeminarPaymentDetailsModel> paymentList;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "SEMINAR_ID_FEED_FK")
	private List<SeminarFeedbackModel> feedbackList;

	public List<SeminarPaymentDetailsModel> getPaymentList() {
		return paymentList;
	}

	public void setPaymentList(List<SeminarPaymentDetailsModel> paymentList) {
		this.paymentList = paymentList;
	}

	public List<SeminarFeedbackModel> getFeedbackList() {
		return feedbackList;
	}

	public void setFeedbackList(List<SeminarFeedbackModel> feedbackList) {
		this.feedbackList = feedbackList;
	}

	public List<SeminarDetailsModel> getSeminarDetails() {
		return seminarDetails;
	}

	public void setSeminarDetails(List<SeminarDetailsModel> seminarDetails) {
		this.seminarDetails = seminarDetails;
	}

	public List<SpeakerDetailsModel> getSpeakerDetails() {
		return speakerDetails;
	}

	public void setSpeakerDetails(List<SpeakerDetailsModel> speakerDetails) {
		this.speakerDetails = speakerDetails;
	}

	public List<SeminarBannerModel> getSeminarBanner() {
		return seminarBanner;
	}

	public void setSeminarBanner(List<SeminarBannerModel> seminarBanner) {
		this.seminarBanner = seminarBanner;
	}

	public List<SeminarAssignToModel> getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(List<SeminarAssignToModel> assignTo) {
		this.assignTo = assignTo;
	}

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

	public Long getSponsorsId() {
		return sponsorsId;
	}

	public void setSponsorsId(Long sponsorsId) {
		this.sponsorsId = sponsorsId;
	}

	public String getSponsorsUId() {
		return sponsorsUId;
	}

	public void setSponsorsUId(String sponsorsUId) {
		this.sponsorsUId = sponsorsUId;
	}

	public Long getSupportedById() {
		return supportedById;
	}

	public void setSupportedById(Long supportedById) {
		this.supportedById = supportedById;
	}

	public String getSupportedByUId() {
		return supportedByUId;
	}

	public void setSupportedByUId(String supportedByUId) {
		this.supportedByUId = supportedByUId;
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
