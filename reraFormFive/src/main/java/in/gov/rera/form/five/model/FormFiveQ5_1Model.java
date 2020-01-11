package in.gov.rera.form.five.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "FormFiveQ5_1Model")
@Table(name = "TL_FORM_FIVEQ5_1")

public class FormFiveQ5_1Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRO_FORM_FIVEQ5_1_ID")
	private Long projectFormFiveQ51Id;

	
	@Column(name = "PERIOD_FROM_DATE")
	private String  periodFromDate;
	
	@Column(name = "PERIOD_TO_DATE")
	private String  periodToDate;	
	
	@Column(name="FORM_FIVE_FK")
	private Long formFiveId;
	
	@Column(name = "AMOUNT_NOT_DEPOSITED", columnDefinition = "Double default '0'")
	private String amountNotDeposited;
	
	public Long getFormFiveId() {
		return formFiveId;
	}

	public void setFormFiveId(Long formFiveId) {
		this.formFiveId = formFiveId;
	}

	public Long getProjectFormFiveQ51Id() {
		return projectFormFiveQ51Id;
	}

	public void setProjectFormFiveQ51Id(Long projectFormFiveQ51Id) {
		this.projectFormFiveQ51Id = projectFormFiveQ51Id;
	}

	public String getPeriodFromDate() {
		return periodFromDate;
	}

	public String getAmountNotDeposited() {
		return amountNotDeposited;
	}

	public void setAmountNotDeposited(String amountNotDeposited) {
		this.amountNotDeposited = amountNotDeposited;
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


		
	
}
