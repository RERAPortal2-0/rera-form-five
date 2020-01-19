package in.gov.rera.form.five.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "FormFiveBankDetailsModel")
@Table(name = "TL_FORM_FIVE_BANK_DETAILS")
public class FormFiveBankDetailsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FRM_FIVE_BANK_ID")
	private Long frmFiveBankId;

	@Column(name = "FORM_FIVE_FK")
	private Long formFiveId;

	@Column(name = "BANK_CODE")
	private String bankCode;

	@Column(name = "BANK_NAME",nullable=false, length=512)
	private String bankName;
	
	@Column(name = "BRANCH_NAME" ,nullable=false, length=512)
	private String branchName;

	@Column(name = "ACC_NAME" ,nullable=false, length=512)
	private String accountName;

	@Column(name = "ACC_NO" ,nullable=false, length=512)
	private String accountNumber;

	@Column(name = "ACC_TYPE" ,nullable=false, length=512)
	private String accountType;

	@Column(name = "IFSC_CODE" ,nullable=false, length=512)
	private String ifscCode;

	@Column(name = "OPENING_BAL" ,nullable=false, length=512)
	private String formFiveOpeningBal;

	@Column(name = "OPENING_BALANCE_DATE" ,nullable=false)
	private Date formFiveOpeningBalDate;

	@Column(name = "DEPOSITS" ,nullable=false, length=512)
	private String formFiveDeposit;

	@Column(name = "WITHDRAWALS" ,nullable=false, length=512)
	private String formFiveWithdrawals;

	@Column(name = "CLOSING_BAL" ,nullable=false, length=512)
	private String formFiveClosingBal;

	@Column(name = "CLOSING_BAL_DATE")
	private Date formFiveClosingBalanceDate;

	@Column(name = "STATE_CODE")
	private String stateCode;

	@Column(name = "STATE_NAME")
	private String stateName;

	@Column(name="DATE_OF_ACCOUNT_OPENING" ,nullable=false)
    private String dateOfAccountOpening;
	
	@Column(name = "DISTRICT_CODE")
	private String districtCode;

	@Column(name = "DISTRICT_NAME")
	private String districtName;

	public Long getFrmFiveBankId() {
		return frmFiveBankId;
	}

	public void setFrmFiveBankId(Long frmFiveBankId) {
		this.frmFiveBankId = frmFiveBankId;
	}

	public Long getFormFiveId() {
		return formFiveId;
	}

	public void setFormFiveId(Long formFiveId) {
		this.formFiveId = formFiveId;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public String getFormFiveOpeningBal() {
		return formFiveOpeningBal;
	}

	public void setFormFiveOpeningBal(String formFiveOpeningBal) {
		this.formFiveOpeningBal = formFiveOpeningBal;
	}

	public Date getFormFiveOpeningBalDate() {
		return formFiveOpeningBalDate;
	}

	public void setFormFiveOpeningBalDate(Date formFiveOpeningBalDate) {
		this.formFiveOpeningBalDate = formFiveOpeningBalDate;
	}

	public String getFormFiveDeposit() {
		return formFiveDeposit;
	}

	public void setFormFiveDeposit(String formFiveDeposit) {
		this.formFiveDeposit = formFiveDeposit;
	}

	public String getFormFiveWithdrawals() {
		return formFiveWithdrawals;
	}

	public void setFormFiveWithdrawals(String formFiveWithdrawals) {
		this.formFiveWithdrawals = formFiveWithdrawals;
	}

	public String getFormFiveClosingBal() {
		return formFiveClosingBal;
	}

	public void setFormFiveClosingBal(String formFiveClosingBal) {
		this.formFiveClosingBal = formFiveClosingBal;
	}

	public Date getFormFiveClosingBalanceDate() {
		return formFiveClosingBalanceDate;
	}

	public void setFormFiveClosingBalanceDate(Date formFiveClosingBalanceDate) {
		this.formFiveClosingBalanceDate = formFiveClosingBalanceDate;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getDateOfAccountOpening() {
		return dateOfAccountOpening;
	}

	public void setDateOfAccountOpening(String dateOfAccountOpening) {
		this.dateOfAccountOpening = dateOfAccountOpening;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

}
