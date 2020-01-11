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


@Entity(name = "ProjectFormFiveModel")
@Table(name = "TT_PROJECT_FORM_FIVE")
public class ProjectFormFiveModel implements Serializable{
	private static final long serialVersionUID = 1803590463071163237L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROJECT_FORM_FIVE_ID")
	private Long prjFormFiveId;

	@Column(name = "PROJECT_ID")
	private Long projectId;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "PROJECT_FORM_FIVE_FK")
	private List<FormFiveModel> formFiveList;
	
	@Column(name="PROJECT_NAME")
	private String projectName;
	
	@Column(name="PROMOTER_NAME")
	private String promoterName;
	
	@Column(name="PROMOTER_EMAIL_ID")
	private String promoterEmailId;
	
	public String getPromoterEmailId() {
		return promoterEmailId;
	}

	public void setPromoterEmailId(String promoterEmailId) {
		this.promoterEmailId = promoterEmailId;
	}

	public String getPromoterMobileNo() {
		return promoterMobileNo;
	}

	public void setPromoterMobileNo(String promoterMobileNo) {
		this.promoterMobileNo = promoterMobileNo;
	}

	@Column(name="PROMOTER_MOBILE_NO")
	private String promoterMobileNo;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_ON")
	private Calendar createdOn;

	public Long getPrjFormFiveId() {
		return prjFormFiveId;
	}

	public void setPrjFormFiveId(Long prjFormFiveId) {
		this.prjFormFiveId = prjFormFiveId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public List<FormFiveModel> getFormFiveList() {
		return formFiveList;
	}

	public void setFormFiveList(List<FormFiveModel> formFiveList) {
		this.formFiveList = formFiveList;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getPromoterName() {
		return promoterName;
	}

	public void setPromoterName(String promoterName) {
		this.promoterName = promoterName;
	}

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}
	
}
