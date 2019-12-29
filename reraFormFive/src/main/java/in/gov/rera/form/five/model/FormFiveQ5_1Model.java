package in.gov.rera.form.five.model;



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity(name = "FormFiveQ5_1Model")
@Table(name = "TL_FORM_FIVEQ5_1")

public class FormFiveQ5_1Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRO_FORM_FIVEQ5_1_ID")
	private Long projectFormFiveQ51Id;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="QUARTER_ID") private UserQuarterDetailsModel
	 * userQuarterModel;
	 */
	
	@Column(name = "PERIOD_FROM_DATE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date  periodFromDate;
	
	@Column(name = "PERIOD_TO_DATE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date  periodToDate;	
	
	@Column(name = "AMOUNT_NOT_DEPOSITED", columnDefinition = "Double default '0'")
	private Long amountNotDeposited;
	

	@ManyToOne
	@JoinColumn(name="PROJECT_FORM_FIVE_ID")
	private FormFiveModel formFiveModel;
	
	public Long getProjectFormFiveQ51Id() {
		return projectFormFiveQ51Id;
	}

	public void setProjectFormFiveQ51Id(Long projectFormFiveQ51Id) {
		this.projectFormFiveQ51Id = projectFormFiveQ51Id;
	}

	/*
	 * public UserQuarterDetailsModel getUserQuarterModel() { return
	 * userQuarterModel; }
	 * 
	 * public void setUserQuarterModel(UserQuarterDetailsModel userQuarterModel) {
	 * this.userQuarterModel = userQuarterModel; }
	 */
	public Date getPeriodFromDate() {
		return periodFromDate;
	}
	
	public String getPeriodFromDateStr() {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		
		if(	null!=periodFromDate)
			return sf.format(periodFromDate);
			
			return null;
	}

	public void setPeriodFromDate(Date periodFromDate) {
		this.periodFromDate = periodFromDate;
	}

	public Date getPeriodToDate() {
		return periodToDate;
	}

	public String getPeriodToDateStr() {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		
		if(	null!=periodToDate)
			return sf.format(periodToDate);
			
			return null;
	}
	
	public void setPeriodToDate(Date periodToDate) {
		this.periodToDate = periodToDate;
	}

	public Long getAmountNotDeposited() {
		return amountNotDeposited;
	}

	public void setAmountNotDeposited(Long amountNotDeposited) {
		this.amountNotDeposited = amountNotDeposited;
	}

		
	
}
