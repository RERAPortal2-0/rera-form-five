package in.gov.rera.form.five.model.transaction;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;

public class FormFiveDto implements Serializable {

	private static final long serialVersionUID = 1803590463071163237L;

	private Long formFiveId;
	private Long projectFormFiveFk;
	private String financialYear;

	private String certFromDate;

	private String certToDate;

	private String question_1;

	private String question_1_1;

	private String question_3;

	private String question_4;

	private String question_5;

	private String question_6;

	private String question_6_1;

	private String question_7;

	private String question_8;

	private String question_8_1;

	private String question_8_2;

	private String question_9;

	private String question_10;

	private String estimatedCostOfProject;

	private String question_10_2;

	private String question_10_3;

	private String caFrmNo;

	private String formFiveName;

	private String formFiveYear;

	private String caFrmName;

	private String caUdinNumber;

	private String caDesignation;

	private String question_11;

	private String question_12;

	private String finYearId;
	private String status;
	private String caNumber;
	private String caName;
	private String caMobileNo;
	private String caEmailId;

	private String promoterRemarks;

	private Calendar createdOn;

	private java.util.Calendar modifiedOn;

	private Calendar eSignedOn;

	private String caption1;

	private String caption2;

	private String caption3;

	private String cumulativeWithdrawalLimit;

	private String cumulativeWithdrawalFrom;

	private String projectName;

	private String promoterName;

	private Long projectId;

	private String projectRegNo;
	
	public String getProjectRegNo() {
		return projectRegNo;
	}

	public void setProjectRegNo(String projectRegNo) {
		this.projectRegNo = projectRegNo;
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

	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
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

	public String getQuestion_6_1() {
		return question_6_1;
	}

	public void setQuestion_6_1(String question_6_1) {
		this.question_6_1 = question_6_1;
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

	public String getEstimatedCostOfProject() {
		return estimatedCostOfProject;
	}

	public void setEstimatedCostOfProject(String estimatedCostOfProject) {
		this.estimatedCostOfProject = estimatedCostOfProject;
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

	public String getCaFrmNo() {
		return caFrmNo;
	}

	public void setCaFrmNo(String caFrmNo) {
		this.caFrmNo = caFrmNo;
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

	public String getCaDesignation() {
		return caDesignation;
	}

	public void setCaDesignation(String caDesignation) {
		this.caDesignation = caDesignation;
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

	public String getFinYearId() {
		return finYearId;
	}

	public void setFinYearId(String finYearId) {
		this.finYearId = finYearId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCaNumber() {
		return caNumber;
	}

	public void setCaNumber(String caNumber) {
		this.caNumber = caNumber;
	}

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

	public String getPromoterRemarks() {
		return promoterRemarks;
	}

	public void setPromoterRemarks(String promoterRemarks) {
		this.promoterRemarks = promoterRemarks;
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

	public Calendar geteSignedOn() {
		return eSignedOn;
	}

	public void seteSignedOn(Calendar eSignedOn) {
		this.eSignedOn = eSignedOn;
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

}
