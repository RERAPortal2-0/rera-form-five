package in.gov.rera.form.five.model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

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
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date certFromDate;

	@Column(name = "PERIOD_UNDER_CERT_TO_DATE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date certToDate;

	@Column(name = "Q_1", length = 5)
	private String question_1;

	@Column(name = "Q_1_1", length = 5)
	private String question_1_1;

	@OneToMany
	@JoinColumn(name = "Q_2_PRO_FORM_FIVE_BANK_ID")
	private List<FormFiveModel> FormFiveBankld;

	@Column(name = "Q_3", length = 15)
	private String question_3;

	@Column(name = "Q_4", length = 5)
	private String question_4;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<FormFiveQ4_1Model> formFiveQ4_1Model;

	@Column(name = "Q_5", length = 5)
	private String question_5;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<FormFiveQ5_1Model> formFiveQ5_1Model;

	@Column(name = "Q_6", length = 10)
	private String question_6;

	@Column(name = "Q_6_1", length = 5)
	private String question_6_1;

	@Column(name = "Q_7", length = 5)
	private String question_7;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<FormFiveQ7_1Model> projectFormFiveQ7_1Model;

	@Column(name = "Q_8", length = 5)
	private String question_8;

	@Column(name = "Q_8_1", length = 5)
	private String question_8_1;

	@Column(name = "Q_8_2", length = 5)
	private String question_8_2;

	@Column(name = "Q_9", length = 5)
	private String question_9;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<FormFiveQ9_1Model> projectFormFiveQ9_1Model;

	@Column(name = "Q_10", length = 5)
	private String question_10;

	@Column(name = "Q_10_2", length = 5)
	private String question_10_2;

	@Column(name = "Q_10_3", length = 5)
	private String question_10_3;

	@Column(name = "CA_FORM_NO")
	private String caFormNo;

	@Column(name = "CA_FORM_NAME")
	private String caFormName;

	@Column(name = "CA_UDIN")
	private String caUdiNumber;

	public int getRafCount() {
		int count = 0;
		if (getQuestion_1() != null && getQuestion_1().equals("NO"))
			count++;
		if (getQuestion_1_1() != null && getQuestion_1_1().equals("NO"))
			count++;
		if (getQuestion_3() != null && getQuestion_3().equals("NO"))
			count++;
		if (getQuestion_5() != null && getQuestion_5().equals("NO"))
			count++;
		if (getQuestion_6_1() != null && getQuestion_6_1().equals("YES"))
			count++;
		if (getQuestion_7() != null && getQuestion_7().equals("NO"))
			count++;
		if (getQuestion_8_1() != null && getQuestion_8_1().equals("NO"))
			count++;
		if (getQuestion_9() != null && getQuestion_9().equals("YES"))
			count++;
		if (getQuestion_10_3() != null && getQuestion_10_3().equals("YES"))
			count++;
		if (getQuestion_11() != null && getQuestion_11().equals("YES"))
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

	public String getCaFormNo() {
		return caFormNo;
	}

	public void setCaFormNo(String caFormNo) {
		this.caFormNo = caFormNo;
	}

	public String getCaFormName() {
		return caFormName;
	}

	public void setCaFormName(String caFormName) {
		this.caFormName = caFormName;
	}

	public String getCaFormCapacity() {
		return caFormCapacity;
	}

	public void setCaFormCapacity(String caFormCapacity) {
		this.caFormCapacity = caFormCapacity;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<FormFiveQ10_1Model> projectFormFiveQ10_1Model;

	@Column(name = "Q_11", length = 5)
	private String question_11;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<FormFiveQ11_1Model> projectFormFiveQ11_1;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PRO_FORM_FIVEQ6_2_ID")
	private FormFiveQ6_2Model formFiveQ6_2Model;

	@Column(name = "Q_12", length = 5000)
	private String question_12;

	@Column(name = "FIN_YEAR", length = 10)
	private String finYearId;

	@Column(name = "STATUS", length = 25)
	private String status;
	
	@Column(name = "CA_NUMBER") 
	private String caNumber;

	@Column(name = "PROMOTER_REMARKS", length = 500)
	private String promoterRemarks;

	@Column(name = "CREATED_ON")
	private Calendar createdOn;

	@Column(name = "SIGNED_ON")
	private Calendar signedOn;

	@Column(name = "CAPTION1", length = 500)
	private String caption1;

	@Column(name = "CAPTION2", length = 500)
	private String caption2;

	@Column(name = "CAPTION3", length = 500)
	private String caption3;

	/*
	 * @OneToOne
	 * 
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
	 * 	 */
	/*
	 * @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) private
	 * List<Document> otherDocumentList;
	 */


	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	public Calendar getSignedOn() {
		return signedOn;
	}

	public String getSignedOnStr() {
		if (signedOn != null) {
			SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
			return sf.format(signedOn.getTime());
		}
		return null;
	}

	public void setSignedOn(Calendar signedOn) {
		this.signedOn = signedOn;
	}

	public String getFinYearId() {
		return finYearId;
	}

	public void setFinYearId(String finYearId) {
		this.finYearId = finYearId;
	}




	public Date getCertFromDate() {
		return certFromDate;
	}

	public String getCertFromDateStr() {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		if (null != certFromDate)
			return sf.format(certFromDate);

		return null;
	}

	public void setCertFromDate(Date certFromDate) {
		this.certFromDate = certFromDate;
	}

	public Date getCertToDate() {
		return certToDate;
	}

	public String getCertToDateStr() {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		if (null != certToDate)
			return sf.format(certToDate);

		return null;
	}

	public void setCertToDate(Date certToDate) {
		this.certToDate = certToDate;
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

	public List<FormFiveModel> getFormFiveBankld() {
		return FormFiveBankld;
	}

	public void setFormFiveBankld(List<FormFiveModel> formFiveBankld) {
		FormFiveBankld = formFiveBankld;
	}

	public List<FormFiveQ4_1Model> getFormFiveQ4_1Model() {
		return formFiveQ4_1Model;
	}

	public void setFormFiveQ4_1Model(List<FormFiveQ4_1Model> formFiveQ4_1Model) {
		this.formFiveQ4_1Model = formFiveQ4_1Model;
	}

	public List<FormFiveQ5_1Model> getFormFiveQ5_1Model() {
		return formFiveQ5_1Model;
	}

	public void setFormFiveQ5_1Model(List<FormFiveQ5_1Model> formFiveQ5_1Model) {
		this.formFiveQ5_1Model = formFiveQ5_1Model;
	}

	public List<FormFiveQ7_1Model> getProjectFormFiveQ7_1Model() {
		return projectFormFiveQ7_1Model;
	}

	public void setProjectFormFiveQ7_1Model(List<FormFiveQ7_1Model> projectFormFiveQ7_1Model) {
		this.projectFormFiveQ7_1Model = projectFormFiveQ7_1Model;
	}

	public List<FormFiveQ9_1Model> getProjectFormFiveQ9_1Model() {
		return projectFormFiveQ9_1Model;
	}

	public void setProjectFormFiveQ9_1Model(List<FormFiveQ9_1Model> projectFormFiveQ9_1Model) {
		this.projectFormFiveQ9_1Model = projectFormFiveQ9_1Model;
	}

	public List<FormFiveQ10_1Model> getProjectFormFiveQ10_1Model() {
		return projectFormFiveQ10_1Model;
	}

	public void setProjectFormFiveQ10_1Model(List<FormFiveQ10_1Model> projectFormFiveQ10_1Model) {
		this.projectFormFiveQ10_1Model = projectFormFiveQ10_1Model;
	}

	public List<FormFiveQ11_1Model> getProjectFormFiveQ11_1() {
		return projectFormFiveQ11_1;
	}

	public void setProjectFormFiveQ11_1(List<FormFiveQ11_1Model> projectFormFiveQ11_1) {
		this.projectFormFiveQ11_1 = projectFormFiveQ11_1;
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




	public int getRAFlag() {
		int raf = 0;

		return raf;
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

	public String getCaUdiNumber() {
		return caUdiNumber;
	}

	public void setCaUdiNumber(String caUdiNumber) {
		this.caUdiNumber = caUdiNumber;
	}

}
