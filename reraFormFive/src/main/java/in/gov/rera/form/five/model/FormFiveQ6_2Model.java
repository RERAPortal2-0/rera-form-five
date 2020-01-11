package in.gov.rera.form.five.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "FormFiveQ6_2Model")
@Table(name = "TL_FORM_FIVEQ6_2")

public class FormFiveQ6_2Model{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRO_FORM_FIVEQ6_2_ID")
	private Long projectFormFiveQ62Id;
	
	@Column(name = "NUMBER_OF_BOOKED_UNITS")
	private String numberOfBookedUnits;
	
	@Column(name = "AMT_COLLECTED_BOOKING")
	private String amtCollectedBooking;
	
	@Column(name = "TOTAL_CONSIDER_BOOKING")
	private String totalConsiderBooking;

	@Column(name="FORM_FIVE_PK")
	private Long formFiveId;
	
	public Long getFormFiveId() {
		return formFiveId;
	}

	public void setFormFiveId(Long formFiveId) {
		this.formFiveId = formFiveId;
	}

	public Long getProjectFormFiveQ62Id() {
		return projectFormFiveQ62Id;
	}

	public void setProjectFormFiveQ62Id(Long projectFormFiveQ62Id) {
		this.projectFormFiveQ62Id = projectFormFiveQ62Id;
	}

	public String getNumberOfBookedUnits() {
		return numberOfBookedUnits;
	}

	public void setNumberOfBookedUnits(String numberOfBookedUnits) {
		this.numberOfBookedUnits = numberOfBookedUnits;
	}

	public String getAmtCollectedBooking() {
		return amtCollectedBooking;
	}

	public void setAmtCollectedBooking(String amtCollectedBooking) {
		this.amtCollectedBooking = amtCollectedBooking;
	}

	public String getTotalConsiderBooking() {
		return totalConsiderBooking;
	}

	public void setTotalConsiderBooking(String totalConsiderBooking) {
		this.totalConsiderBooking = totalConsiderBooking;
	}

	
		
	
}
