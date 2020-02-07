package in.gov.rera.form.five.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "SeminarFeedbackModel")
@Table(name = "TL_SEMINAR_FEEDBACK_DETAILS")
public class SeminarFeedbackModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long Id;

	@Column(name = "SEMINAR_ID_FEED_FK")
	private Long seminarId;

	@Column(name = "FEEDBACK_TXT")
	private String feedbackTxt;

	@Column(name = "FEEDBACK_RATING")
	private String feedbackRating;

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

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getSeminarId() {
		return seminarId;
	}

	public void setSeminarId(Long seminarId) {
		this.seminarId = seminarId;
	}

	public String getFeedbackTxt() {
		return feedbackTxt;
	}

	public void setFeedbackTxt(String feedbackTxt) {
		this.feedbackTxt = feedbackTxt;
	}

	public String getFeedbackRating() {
		return feedbackRating;
	}

	public void setFeedbackRating(String feedbackRating) {
		this.feedbackRating = feedbackRating;
	}

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

}
