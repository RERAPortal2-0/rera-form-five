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
	
	@Column(name = "TOTAL_CONSIDERATION", columnDefinition = "Double default '0'")
	private Long totalConsideration;
	
	@Column(name = "AMT_RECEIVED_IN_EXCESS", columnDefinition = "Double default '0'")
	private Long amtReceivedInExcess;
	
	@ManyToOne
	@JoinColumn(name="PROJECT_FORM_FIVE_ID")
	private FormFiveModel formFiveModel;

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	public Long getTotalConsideration() {
		return totalConsideration;
	}

	public void setTotalConsideration(Long totalConsideration) {
		this.totalConsideration = totalConsideration;
	}

	public Long getAmtReceivedInExcess() {
		return amtReceivedInExcess;
	}

	public void setAmtReceivedInExcess(Long amtReceivedInExcess) {
		this.amtReceivedInExcess = amtReceivedInExcess;
	}


}
