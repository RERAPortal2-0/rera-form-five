package in.gov.rera.form.five.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity(name = "FormFiveModel")
@Table(name = "TL_FORM_FIVE")
public class FormFiveModel implements Serializable {

	private static final long serialVersionUID = 1803590463071163237L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FORM_FIVE_ID")
	private Long formFiveId;

	@Column(name = "PROJECT_FORM_FIVE_FK")
	private Long projectFormFiveFk;

	@Column(name="PROJECT_FINANCIAL_YEAR")
	private String financialYear;
	
	public String getFinancialYearStatus() {
		return financialYearStatus;
	}

	public void setFinancialYearStatus(String financialYearStatus) {
		this.financialYearStatus = financialYearStatus;
	}

	@Column(name="PROJECT_FINANCIAL_YEAR_STAUTS", length = 50)
	private String financialYearStatus;
	
	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	@Column(name = "PERIOD_UNDER_CERT_FROM_DATE")
	private String certFromDate;

	@Column(name = "PERIOD_UNDER_CERT_TO_DATE")
	private String certToDate;

	@Column(name = "Q_1", length = 5)
	private String question_1;

	@Column(name = "Q_1_1", length = 5)
	private String question_1_1;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "FORM_FIVE_FK")
	private List<FormFiveBankDetailsModel> formFiveBankList;

	@Column(name = "Q_3", length = 15)
	private String question_3;

	@Column(name = "Q_4", length = 5)
	private String question_4;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="FORM_FIVE_FK")
	List<FormFiveQ4_1Model> formFiveQ4_1List;

	@Column(name = "Q_5", length = 5)
	private String question_5;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="FORM_FIVE_FK")
	List<FormFiveQ5_1Model> formFiveQ5_1List;

	@Column(name = "Q_6", length = 10)
	private String question_6;

	@Column(name = "Q_6_1", length = 5)
	private String question_6_1;

	@Column(name = "Q_7", length = 5)
	private String question_7;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="FORM_FIVE_FK")
	List<FormFiveQ7_1Model> projectFormFiveQ7_1List;

	@Column(name = "Q_8", length = 5)
	private String question_8;

	@Column(name = "Q_8_1", length = 5)
	private String question_8_1;

	@Column(name = "Q_8_2", length = 5)
	private String question_8_2;

	@Column(name = "Q_9", length = 5)
	private String question_9;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="FORM_FIVE_FK")
	List<FormFiveQ9_1Model> projectFormFiveQ9_1List;

	@Column(name = "Q_10", length = 5)
	private String question_10;

	@Column(name = "ESTIMATED_COST_OF_PROJECT")
	private String estimatedCostOfProject;
	
	public String getEstimatedCostOfProject() {
		return estimatedCostOfProject;
	}

	public void setEstimatedCostOfProject(String estimatedCostOfProject) {
		this.estimatedCostOfProject = estimatedCostOfProject;
	}

	@Column(name = "Q_10_2", length = 5)
	private String question_10_2;

	@Column(name = "Q_10_3", length = 5)
	private String question_10_3;

	@Column(name = "CA_FRM_NO")
	private String caFrmNo;
	
	@Column(name = "FORM_FIVE_NAME")
	private String formFiveName;
	
	@Column(name = "FORM_FIVE_YEAR")
	private String formFiveYear;

	@Column(name = "CA_FRM_NAME")
	private String caFrmName;

	@Column(name = "CA_UDIN")
	private String caUdinNumber;
	
	@Column(name = "CA_DESIGNATION")
	private String caDesignation;

	public String getCaDesignation() {
		return caDesignation;
	}

	public void setCaDesignation(String caDesignation) {
		this.caDesignation = caDesignation;
	}

	
	public int rafCount;
	
	public void setRafCount(int rafCount) {
		this.rafCount = rafCount;
	}

	public int getRafCount() {
		int count = 0;
		if (getQuestion_1() != null && getQuestion_1().equalsIgnoreCase("NO"))
			count++;
		if (getQuestion_1_1() != null && getQuestion_1_1().equalsIgnoreCase("NO"))
			count++;
		if (getQuestion_3() != null && getQuestion_3().equalsIgnoreCase("NO"))
			count++;
		if (getQuestion_5() != null && getQuestion_5().equalsIgnoreCase("NO"))
			count++;
		if (getQuestion_6_1() != null && getQuestion_6_1().equalsIgnoreCase("YES"))
			count++;
		if (getQuestion_7() != null && getQuestion_7().equalsIgnoreCase("NO"))
			count++;
		if (getQuestion_8_1() != null && getQuestion_8_1().equalsIgnoreCase("NO"))
			count++;
		if (getQuestion_9() != null && getQuestion_9().equalsIgnoreCase("YES"))
			count++;
		if (getQuestion_10_3() != null && getQuestion_10_3().equalsIgnoreCase("YES"))
			count++;
		if (getQuestion_11() != null && getQuestion_11().equalsIgnoreCase("YES"))
			count++;
		return count;
	}

	public String getcWithdrawLimit() {
		return cWithdrawLimit;
	}

	public void setcWithdrawLimit(String cWithdrawLimit) {
		this.cWithdrawLimit = cWithdrawLimit;
	}

	public String getcWithdrawSepAc() {
		return cWithdrawSepAc;
	}

	public void setcWithdrawSepAc(String cWithdrawSepAc) {
		this.cWithdrawSepAc = cWithdrawSepAc;
	}

	public String getEstimatedCost() {
		return estimatedCost;
	}

	public void setEstimatedCost(String estimatedCost) {
		this.estimatedCost = estimatedCost;
	}

	public String getTotLoanEstCost() {
		return totLoanEstCost;
	}

	public String getFormFiveName() {
		return formFiveName;
	}

	public void setFormFiveName(String formFiveName) {
		this.formFiveName = formFiveName;
	}

	public String getFormFiveYear() {
		return formFiveYear;
	}

	public void setFormFiveYear(String formFiveYear) {
		this.formFiveYear = formFiveYear;
	}

	public void setTotLoanEstCost(String totLoanEstCost) {
		this.totLoanEstCost = totLoanEstCost;
	}

	@Column(name = "CA_FORM_CAPACITY")
	private String caFormCapacity;

	@Column(name = "CUMULATIVE_WITH_LIMIT")
	private String cWithdrawLimit;

	@Column(name = "CUMULATIVE_WITH_AC")
	private String cWithdrawSepAc;

	@Column(name = "ESTIMATED_COST")
	private String estimatedCost;

	@Column(name = "TOT_LOAN_EST_COST")
	private String totLoanEstCost;

	public String getCaFormCapacity() {
		return caFormCapacity;
	}

	public void setCaFormCapacity(String caFormCapacity) {
		this.caFormCapacity = caFormCapacity;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="FORM_FIVE_FK")
	List<FormFiveQ10_1Model> projectFormFiveQ10_1List;

	@Column(name = "Q_11", length = 5)
	private String question_11;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="FORM_FIVE_FK")
	private List<FormFiveQ11_1Model> projectFormFiveQ11_1List;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FORM_FIVE_PK")
	private FormFiveQ6_2Model formFiveQ6_2Model;

	@Column(name = "Q_12", length = 5000)
	private String question_12;

	@Column(name = "FIN_YEAR", length = 10)
	private String finYearId;

	@Column(name = "STATUS", length = 25)
	private String status;
	
	@Column(name = "CA_NUMBER") 
	private String caNumber;

	@Column(name = "CA_NANME") 
	private String caName;
	
	@Column(name = "CA_MOBILE_NO") 
	private String caMobileNo;
	
	@Column(name = "CA_EMAIL_ID") 
	private String caEmailId;
	
	public String getCaName() {
		return caName;
	}

	public void setCaName(String caName) {
		this.caName = caName;
	}

	public String getCaMobileNo() {
		return caMobileNo;
	}

	public void setCaMobileNo(String caMobileNo) {
		this.caMobileNo = caMobileNo;
	}

	public String getCaEmailId() {
		return caEmailId;
	}

	public void setCaEmailId(String caEmailId) {
		this.caEmailId = caEmailId;
	}

	@Column(name = "PROMOTER_REMARKS", length = 500)
	private String promoterRemarks;

	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_ON", updatable=false)
	private Calendar createdOn;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifiedOn")
	private java.util.Calendar modifiedOn;
	


	@Column(name = "ESIGNED_ON")
	private Calendar eSignedOn;

	@Column(name = "CAPTION1", length = 500)
	private String caption1;

	@Column(name = "CAPTION2", length = 500)
	private String caption2;

	@Column(name = "CAPTION3", length = 500)
	private String caption3;
	  
	@Column(name = "CUMULATIVE_WITHDRAWL_LIMIT", length = 500)
	private String cumulativeWithdrawalLimit;
	
	@Column(name = "CUMULATIVE_WITHDRAWL_FROM", length = 500)
	private String cumulativeWithdrawalFrom;
	
	public String getCumulativeWithdrawalLimit() {
		return cumulativeWithdrawalLimit;
	}

	public void setCumulativeWithdrawalLimit(String cumulativeWithdrawalLimit) {
		this.cumulativeWithdrawalLimit = cumulativeWithdrawalLimit;
	}

	public String getCumulativeWithdrawalFrom() {
		return cumulativeWithdrawalFrom;
	}

	public void setCumulativeWithdrawalFrom(String cumulativeWithdrawalFrom) {
		this.cumulativeWithdrawalFrom = cumulativeWithdrawalFrom;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="FORM_FIVE_FK")
	FormFiveDocumentModel formFiveDocModel;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="FORM_FIVE_FK")
	List<FormFiveOtherDocModel> formFiveOtherDocList;
	
	@Column(name="PROJECT_NAME")
	private String projectName;
	
	@Column(name="PROMOTER_NAME")
	private String promoterName;
	
	@Column(name="PROJECT_ID")
	private Long projectId;
	
	/*
	 * @JoinColumn(name = "PROJECT_FORM_FIVE_DOC_ID_1") private Document
	 * prjFormFiveDocId1;
	 * 
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "PROJECT_FORM_FIVE_DOC_ID_2") private Document
	 * prjFormFiveDocId2;
	 * 
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "PROJECT_FORM_FIVE_DOC_ID_3") private Document
	 * prjFormFiveDocId3;
	 * 
	 * @OneToOne
	 * 
	 * @JoinColumn(name = "SIGNED_FORM_FIVE_DOC") private Document
	 * signedFormFiveDoc;
	 * 
	 * @Column(name = "OTHER_DOC_CAPTION", length = 500) private String
	 * otherDocCaption;
	 
	  	 
	 
	  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) private
	  List<Document> otherDocumentList;
	 */

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

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public FormFiveDocumentModel getFormFiveDocModel() {
		return formFiveDocModel;
	}

	public void setFormFiveDocModel(FormFiveDocumentModel formFiveDocModel) {
		this.formFiveDocModel = formFiveDocModel;
	}

	public List<FormFiveOtherDocModel> getFormFiveOtherDocList() {
		return formFiveOtherDocList;
	}

	public void setFormFiveOtherDocList(List<FormFiveOtherDocModel> formFiveOtherDocList) {
		this.formFiveOtherDocList = formFiveOtherDocList;
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

	public String geteSignedOnStr() {
		if (eSignedOn != null) {
			SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
			return sf.format(eSignedOn.getTime());
		}
		return null;
	}

	public Calendar geteSignedOn() {
		return eSignedOn;
	}

	public void seteSignedOn(Calendar eSignedOn) {
		this.eSignedOn = eSignedOn;
	}

	public String getFinYearId() {
		return finYearId;
	}

	public void setFinYearId(String finYearId) {
		this.finYearId = finYearId;
	}

	public String getQuestion_1() {
		return question_1;
	}

	public void setQuestion_1(String question_1) {
		this.question_1 = question_1;
	}

	public String getQuestion_1_1() {
		return question_1_1;
	}

	public void setQuestion_1_1(String question_1_1) {
		this.question_1_1 = question_1_1;
	}


	public String getQuestion_3() {
		return question_3;
	}

	public String getCertFromDate() {
		return certFromDate;
	}

	public void setCertFromDate(String certFromDate) {
		this.certFromDate = certFromDate;
	}

	public String getCertToDate() {
		return certToDate;
	}

	public void setCertToDate(String certToDate) {
		this.certToDate = certToDate;
	}

	public void setQuestion_3(String question_3) {
		this.question_3 = question_3;
	}

	public String getQuestion_4() {
		return question_4;
	}

	public void setQuestion_4(String question_4) {
		this.question_4 = question_4;
	}



	public String getQuestion_5() {
		return question_5;
	}

	public void setQuestion_5(String question_5) {
		this.question_5 = question_5;
	}


	public String getQuestion_6() {
		return question_6;
	}

	public void setQuestion_6(String question_6) {
		this.question_6 = question_6;
	}

	public String getQuestion_7() {
		return question_7;
	}

	public void setQuestion_7(String question_7) {
		this.question_7 = question_7;
	}

	public String getQuestion_8() {
		return question_8;
	}

	public void setQuestion_8(String question_8) {
		this.question_8 = question_8;
	}

	public String getQuestion_9() {
		return question_9;
	}

	public void setQuestion_9(String question_9) {
		this.question_9 = question_9;
	}


	public String getQuestion_10() {
		return question_10;
	}

	public void setQuestion_10(String question_10) {
		this.question_10 = question_10;
	}

	public String getQuestion_11() {
		return question_11;
	}

	public void setQuestion_11(String question_11) {
		this.question_11 = question_11;
	}

	public String getQuestion_12() {
		return question_12;
	}

	public void setQuestion_12(String question_12) {
		this.question_12 = question_12;
	}

	public String getQuestion_6_1() {
		return question_6_1;
	}

	public void setQuestion_6_1(String question_6_1) {
		this.question_6_1 = question_6_1;
	}

	public Long getFormFiveId() {
		return formFiveId;
	}

	public void setFormFiveId(Long formFiveId) {
		this.formFiveId = formFiveId;
	}

	public Long getProjectFormFiveFk() {
		return projectFormFiveFk;
	}

	public void setProjectFormFiveFk(Long projectFormFiveFk) {
		this.projectFormFiveFk = projectFormFiveFk;
	}

	public FormFiveQ6_2Model getFormFiveQ6_2Model() {
		return formFiveQ6_2Model;
	}

	public void setFormFiveQ6_2Model(FormFiveQ6_2Model formFiveQ6_2Model) {
		this.formFiveQ6_2Model = formFiveQ6_2Model;
	}

	public List<FormFiveBankDetailsModel> getFormFiveBankList() {
		return formFiveBankList;
	}

	public void setFormFiveBankList(List<FormFiveBankDetailsModel> formFiveBankList) {
		this.formFiveBankList = formFiveBankList;
	}

	public List<FormFiveQ4_1Model> getFormFiveQ4_1List() {
		return formFiveQ4_1List;
	}

	public void setFormFiveQ4_1List(List<FormFiveQ4_1Model> formFiveQ4_1List) {
		this.formFiveQ4_1List = formFiveQ4_1List;
	}

	public List<FormFiveQ5_1Model> getFormFiveQ5_1List() {
		return formFiveQ5_1List;
	}

	public void setFormFiveQ5_1List(List<FormFiveQ5_1Model> formFiveQ5_1List) {
		this.formFiveQ5_1List = formFiveQ5_1List;
	}

	public List<FormFiveQ7_1Model> getProjectFormFiveQ7_1List() {
		return projectFormFiveQ7_1List;
	}

	public void setProjectFormFiveQ7_1List(List<FormFiveQ7_1Model> projectFormFiveQ7_1List) {
		this.projectFormFiveQ7_1List = projectFormFiveQ7_1List;
	}

	public List<FormFiveQ9_1Model> getProjectFormFiveQ9_1List() {
		return projectFormFiveQ9_1List;
	}

	public void setProjectFormFiveQ9_1List(List<FormFiveQ9_1Model> projectFormFiveQ9_1List) {
		this.projectFormFiveQ9_1List = projectFormFiveQ9_1List;
	}

	public List<FormFiveQ10_1Model> getProjectFormFiveQ10_1List() {
		return projectFormFiveQ10_1List;
	}

	public void setProjectFormFiveQ10_1List(List<FormFiveQ10_1Model> projectFormFiveQ10_1List) {
		this.projectFormFiveQ10_1List = projectFormFiveQ10_1List;
	}

	public List<FormFiveQ11_1Model> getProjectFormFiveQ11_1List() {
		return projectFormFiveQ11_1List;
	}

	public void setProjectFormFiveQ11_1List(List<FormFiveQ11_1Model> projectFormFiveQ11_1List) {
		this.projectFormFiveQ11_1List = projectFormFiveQ11_1List;
	}

	public String getCaNumber() {
		return caNumber;
	}

	public void setCaNumber(String caNumber) {
		this.caNumber = caNumber;
	}

	public String getQuestion_8_1() {
		return question_8_1;
	}

	public void setQuestion_8_1(String question_8_1) {
		this.question_8_1 = question_8_1;
	}

	public String getQuestion_8_2() {
		return question_8_2;
	}

	public void setQuestion_8_2(String question_8_2) {
		this.question_8_2 = question_8_2;
	}

	public String getQuestion_10_2() {
		return question_10_2;
	}

	public void setQuestion_10_2(String question_10_2) {
		this.question_10_2 = question_10_2;
	}

	public String getQuestion_10_3() {
		return question_10_3;
	}

	public void setQuestion_10_3(String question_10_3) {
		this.question_10_3 = question_10_3;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPromoterRemarks() {
		return promoterRemarks;
	}

	public void setPromoterRemarks(String promoterRemarks) {
		this.promoterRemarks = promoterRemarks;
	}

	public String getCaption1() {
		return caption1;
	}

	public void setCaption1(String caption1) {
		this.caption1 = caption1;
	}

	public String getCaption2() {
		return caption2;
	}

	public void setCaption2(String caption2) {
		this.caption2 = caption2;
	}

	public String getCaption3() {
		return caption3;
	}

	public void setCaption3(String caption3) {
		this.caption3 = caption3;
	}


	public String getCaFrmNo() {
		return caFrmNo;
	}

	public void setCaFrmNo(String caFrmNo) {
		this.caFrmNo = caFrmNo;
	}

	public String getCaFrmName() {
		return caFrmName;
	}

	public void setCaFrmName(String caFrmName) {
		this.caFrmName = caFrmName;
	}

	public String getCaUdinNumber() {
		return caUdinNumber;
	}

	public void setCaUdinNumber(String caUdinNumber) {
		this.caUdinNumber = caUdinNumber;
	}

	public int getRAFlag() {

		return getRafCount();
	}

	@Column(name = "LAST_UPDATED_ON")
	private Calendar lastUpdatedOn;

	@Column(name = "ACCEPTED_ON")
	private Calendar acceptedOn;

	public Calendar getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Calendar lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	public Calendar getAcceptedOn() {
		return acceptedOn;
	}

	public void setAcceptedOn(Calendar acceptedOn) {
		this.acceptedOn = acceptedOn;
	}


}
