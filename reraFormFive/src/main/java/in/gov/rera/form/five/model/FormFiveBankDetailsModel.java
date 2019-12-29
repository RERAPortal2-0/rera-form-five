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

@Entity(name = "FormFiveBankDetailsModel")
@Table(name = "TL_FORM_FIVE_BANK_DETAILS")
public class FormFiveBankDetailsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FRM_FIVE_BANK_ID")
	private Long frmFiveBankId;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="BANK_ID") private BankModel bankModel;
	 */
	
	@Column(name = "BANK_CODE")
	private String bankCode;
	
	@Column(name = "BRANCH_NAME")
	private String branchName;
	
	@Column(name = "ACC_NAME")
	private String accountName;
	
	@Column(name = "ACC_NO")
	private String accountNumber;	
	
	@Column(name = "ACC_TYPE")
	private String accountType;
	
	@Column(name = "IFSC_CODE")
	private String ifscCode;
	
	@Column(name = "OPENING_BAL")
	private String formFiveBOpeningBal;
	
	@Column(name = "OPENING_BAL_DATE")
	private Date formFiveBOpeningBalDate;
	
	@Column(name = "OPENING_BALANCE_DATE")
	private Date formFiveOpeningBalDate;
	
	@Column(name = "DEPOSITS")
	private String formFiveBDeposit;
	
	@Column(name = "WITHDRAWALS")
	private String formFiveBWithdrawals;
	
	public Date getFormFiveOpeningBalDate() {
		return formFiveOpeningBalDate;
	}




	public void setFormFiveOpeningBalDate(Date formFiveOpeningBalDate) {
		this.formFiveOpeningBalDate = formFiveOpeningBalDate;
	}
	@Column(name = "CLOSING_BAL")
	private String formFiveBClosingBal;
	
	@Column(name = "CLOSING_BAL_DATE")
	private Date formFiveClosingBalanceDate;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name = "STATE") private StateUtModel BState;
	 * 
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="DISTRICT_ID") private DistrictModel districtModel;
	 */



	public String getformFiveBOpeningBalDateStr() {
		if(formFiveBOpeningBalDate!=null){
			SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
			return	sf.format(formFiveBOpeningBalDate);
		}
		return null;
	}
	
	public String getformFiveOpeningBalDateStr() {
		if(formFiveOpeningBalDate!=null){
			SimpleDateFormat sf=new SimpleDateFormat("dd/MM/yyyy");
			return	sf.format(formFiveOpeningBalDate);
		}
		return null;
	}
	
	
	



	public Long getFrmFiveBankId() {
		return frmFiveBankId;
	}
	public void setFrmFiveBankId(Long frmFiveBankId) {
		this.frmFiveBankId = frmFiveBankId;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
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
	public String getFormFiveBOpeningBal() {
		return formFiveBOpeningBal;
	}
	public void setFormFiveBOpeningBal(String formFiveBOpeningBal) {
		this.formFiveBOpeningBal = formFiveBOpeningBal;
	}
	public Date getFormFiveBOpeningBalDate() {
		return formFiveBOpeningBalDate;
	}
	public void setFormFiveBOpeningBalDate(Date formFiveBOpeningBalDate) {
		this.formFiveBOpeningBalDate = formFiveBOpeningBalDate;
	}
	public String getFormFiveBDeposit() {
		return formFiveBDeposit;
	}
	public void setFormFiveBDeposit(String formFiveBDeposit) {
		this.formFiveBDeposit = formFiveBDeposit;
	}
	public String getFormFiveBWithdrawals() {
		return formFiveBWithdrawals;
	}
	public void setFormFiveBWithdrawals(String formFiveBWithdrawals) {
		this.formFiveBWithdrawals = formFiveBWithdrawals;
	}
	public String getFormFiveBClosingBal() {
		return formFiveBClosingBal;
	}
	public void setFormFiveBClosingBal(String formFiveBClosingBal) {
		this.formFiveBClosingBal = formFiveBClosingBal;
	}
	public Date getFormFiveClosingBalanceDate() {
		return formFiveClosingBalanceDate;
	}
	
	public String getFormFiveClosingBalanceDateStr() {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		
		if(	null!=formFiveClosingBalanceDate)
			return sf.format(formFiveClosingBalanceDate);
			
			return null;
	}
	
	public void setFormFiveClosingBalanceDate(Date formFiveClosingBalanceDate) {
		this.formFiveClosingBalanceDate = formFiveClosingBalanceDate;
	}
	
	
}
