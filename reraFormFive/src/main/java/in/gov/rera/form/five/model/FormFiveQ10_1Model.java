package in.gov.rera.form.five.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "FormFiveQ10_1Model")
@Table(name = "TL_FORM_FIVEQ10_1")

public class FormFiveQ10_1Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRO_FORM_FIVEQ10_1_ID")
	private Long projectFormFiveQ101Id;
	
	@Column(name = "LANDER_NAME_TYPE")
	private String landerNameType;
	
	@Column(name = "SANCTION_LOAN_AMT")
	private String sanctionLoanAmt;
	
	@Column(name = "SANCTION_DATE")
	private String sanctionDate;
	
	@Column(name = "OUTSTANDING_LOAN")
	private String outStandingLoan;
		
	@Column(name = "COLLATERAL_MORTGAGE_DELS")
	private String collateralMortgateDls;
	
	@Column(name="FORM_FIVE_FK")
	private Long formFiveId;

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

	public String getSanctionLoanAmt() {
		return sanctionLoanAmt;
	}

	public void setSanctionLoanAmt(String sanctionLoanAmt) {
		this.sanctionLoanAmt = sanctionLoanAmt;
	}

	public String getSanctionDate() {
		return sanctionDate;
	}

	public void setSanctionDate(String sanctionDate) {
		this.sanctionDate = sanctionDate;
	}

	public String getOutStandingLoan() {
		return outStandingLoan;
	}

	public void setOutStandingLoan(String outStandingLoan) {
		this.outStandingLoan = outStandingLoan;
	}

	public String getCollateralMortgateDls() {
		return collateralMortgateDls;
	}

	public void setCollateralMortgateDls(String collateralMortgateDls) {
		this.collateralMortgateDls = collateralMortgateDls;
	}

	public Long getFormFiveId() {
		return formFiveId;
	}

	public void setFormFiveId(Long formFiveId) {
		this.formFiveId = formFiveId;
	}

	

			
}
