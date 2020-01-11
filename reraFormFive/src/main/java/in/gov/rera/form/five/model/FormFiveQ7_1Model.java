package in.gov.rera.form.five.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "FormFiveQ7_1Model")
@Table(name = "TL_FORM_FIVEQ7_1")
public class FormFiveQ7_1Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRO_FORM_FIVEQ7_1_ID")
	private Long formFiveQ71Id;
	
	@Column(name = "PERIOD_FROM_DATE")
	private String  periodFromDate;
	
	@Column(name = "PERIOD_TO_DATE")
	private String  periodToDate;			
	
	@Column(name = "EXCESS_WITHDRAWAL_AMOUNT")
	private String excessWithdrawalAmt;

	public String getPeriodFromDate() {
		return periodFromDate;
	}

	public void setPeriodFromDate(String periodFromDate) {
		this.periodFromDate = periodFromDate;
	}

	public String getPeriodToDate() {
		return periodToDate;
	}

	public void setPeriodToDate(String periodToDate) {
		this.periodToDate = periodToDate;
	}

	public String getExcessWithdrawalAmt() {
		return excessWithdrawalAmt;
	}

	public void setExcessWithdrawalAmt(String excessWithdrawalAmt) {
		this.excessWithdrawalAmt = excessWithdrawalAmt;
	}

	public Long getFormFiveQ71Id() {
		return formFiveQ71Id;
	}

	public void setFormFiveQ71Id(Long formFiveQ71Id) {
		this.formFiveQ71Id = formFiveQ71Id;
	}

	public Long getFormFiveId() {
		return formFiveId;
	}

	public void setFormFiveId(Long formFiveId) {
		this.formFiveId = formFiveId;
	}

	@Column(name="FORM_FIVE_FK")
	private Long formFiveId;
	
	
	
}
