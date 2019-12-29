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
	private Long numberOfBookedUnits;
	
	@Column(name = "AMT_COLLECTED_BOOKING")
	private Long amtCollectedBooking;
	
	@Column(name = "TOTAL_CONSIDER_BOOKING")
	private Long totalConsiderBooking;

	public Long getProjectFormFiveQ62Id() {
		return projectFormFiveQ62Id;
	}

	public void setProjectFormFiveQ62Id(Long projectFormFiveQ62Id) {
		this.projectFormFiveQ62Id = projectFormFiveQ62Id;
	}

	public Long getNumberOfBookedUnits() {
		return numberOfBookedUnits;
	}

	public void setNumberOfBookedUnits(Long numberOfBookedUnits) {
		this.numberOfBookedUnits = numberOfBookedUnits;
	}

	public Long getAmtCollectedBooking() {
		return amtCollectedBooking;
	}

	public void setAmtCollectedBooking(Long amtCollectedBooking) {
		this.amtCollectedBooking = amtCollectedBooking;
	}

	public Long getTotalConsiderBooking() {
		return totalConsiderBooking;
	}

	public void setTotalConsiderBooking(Long totalConsiderBooking) {
		this.totalConsiderBooking = totalConsiderBooking;
	}
		
	
}
