package in.gov.rera.form.five.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "FormFiveQ9_1Model")
@Table(name = "TL_FORM_FIVEQ9_1")

public class FormFiveQ9_1Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FORM_FIVEQ9_1_ID")
	private Long formFiveQ91Id;
	
	@Column(name = "UNIT_NUMBER")
	private String unitNumber;
	
	@Column(name = "TOTAL_CONSIDERATION")
	private String totalConsideration;
	
	@Column(name = "AMT_RECEIVED_IN_EXCESS")
	private String amtReceivedInExcess;
	
	public Long getFormFiveQ91Id() {
		return formFiveQ91Id;
	}

	public void setFormFiveQ91Id(Long formFiveQ91Id) {
		this.formFiveQ91Id = formFiveQ91Id;
	}

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	public String getTotalConsideration() {
		return totalConsideration;
	}

	public void setTotalConsideration(String totalConsideration) {
		this.totalConsideration = totalConsideration;
	}

	public String getAmtReceivedInExcess() {
		return amtReceivedInExcess;
	}

	public void setAmtReceivedInExcess(String amtReceivedInExcess) {
		this.amtReceivedInExcess = amtReceivedInExcess;
	}


	@Column(name="FORM_FIVE_FK")
	private Long formFiveId;

	public Long getFormFiveId() {
		return formFiveId;
	}

	public void setFormFiveId(Long formFiveId) {
		this.formFiveId = formFiveId;
	}

	

}
