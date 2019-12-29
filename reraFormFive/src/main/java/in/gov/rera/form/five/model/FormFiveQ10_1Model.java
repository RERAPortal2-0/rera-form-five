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


@Entity(name = "FormFiveQ10_1Model")
@Table(name = "TL_FORM_FIVEQ10_1")

public class FormFiveQ10_1Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRO_FORM_FIVEQ10_1_ID")
	private Long projectFormFiveQ101Id;
	
	@Column(name = "LANDER_NAME_TYPE")
	private String landerNameType;
	
	@Column(name = "SANCTION_LOAN_AMT", columnDefinition = "Double default '0'")
	private Long sanctionLoanAmt;
	
	@Column(name = "SANCTION_DATE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date sanctionDate;
	
	@Column(name = "OUTSTANDING_LOAN", columnDefinition = "Double default '0'")
	private Long outStandingLoan;
		
	@Column(name = "COLLATERAL_MORTGAGE_DELS")
	private String collateralMortgateDls;
	
	@ManyToOne
	@JoinColumn(name="PROJECT_FORM_FIVE_ID")
	private FormFiveModel formFiveModel;

	public Long getProjectFormFiveQ101Id() {
		return projectFormFiveQ101Id;
	}

	public void setProjectFormFiveQ101Id(Long projectFormFiveQ101Id) {
		this.projectFormFiveQ101Id = projectFormFiveQ101Id;
	}

	public String getLanderNameType() {
		return landerNameType;
	}

	public void setLanderNameType(String landerNameType) {
		this.landerNameType = landerNameType;
	}

	public Long getSanctionLoanAmt() {
		return sanctionLoanAmt;
	}

	public void setSanctionLoanAmt(Long sanctionLoanAmt) {
		this.sanctionLoanAmt = sanctionLoanAmt;
	}

	public Date getSanctionDate() {
		return sanctionDate;
	}

	public String getSanctionDateStr() {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");		
		if(	null!=sanctionDate)
			return sf.format(sanctionDate);
			
			return null;
	}
	
	public void setSanctionDate(Date sanctionDate) {
		this.sanctionDate = sanctionDate;
	}

	public Long getOutStandingLoan() {
		return outStandingLoan;
	}

	public void setOutStandingLoan(Long outStandingLoan) {
		this.outStandingLoan = outStandingLoan;
	}

	public String getCollateralMortgateDls() {
		return collateralMortgateDls;
	}

	public void setCollateralMortgateDls(String collateralMortgateDls) {
		this.collateralMortgateDls = collateralMortgateDls;
	}


			
}
