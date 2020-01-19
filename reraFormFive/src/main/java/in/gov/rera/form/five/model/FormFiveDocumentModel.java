package in.gov.rera.form.five.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="FormFiveDocumentModel")
@Table(name="FORM_FIVE_DOCUMENT")
public class FormFiveDocumentModel implements Serializable {

	private static final long serialVersionUID = 1803590463071163237L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FORM_FIVE_DOC_ID")
	private Long formFiveDocId;
	
	@Column(name="FORM_FIVE_FK")
	private Long formFiveId;
	
	@Column(name="BALANCE_SHEET_DOC_ID")
	private Long balanceSheetDocId;
	
	@Column(name="BALANCE_SHEET_DOC_NAME")
    private String balanceSheetDocName;
	
	@Column(name="BALANCE_SHEET_DOC_UID")
    private String balanceSheetDocUId;

	@Column(name="PROFIT_LOSS_DOC_ID")
	private Long profitLossDocId;
	
	@Column(name="PROFIT_LOSS_DOC_NAME")
    private String profitLossDocName;
	
	@Column(name="PROFIT_LOSS_DOC_UID")
    private String profitLossDocUId;	
	
	@Column(name="CASH_FLOW_DOC_ID")
	private Long cashFlowDocId;
	
	@Column(name="CASH_FLOW_DOC_NAME")
    private String cashFlowDocName;
	
	@Column(name="CASH_FLOW_DOC_UID")
    private String cashFlowDocUId;

	public Long getFormFiveDocId() {
		return formFiveDocId;
	}

	public void setFormFiveDocId(Long formFiveDocId) {
		this.formFiveDocId = formFiveDocId;
	}

	public Long getFormFiveId() {
		return formFiveId;
	}

	public void setFormFiveId(Long formFiveId) {
		this.formFiveId = formFiveId;
	}

	public Long getBalanceSheetDocId() {
		return balanceSheetDocId;
	}

	public void setBalanceSheetDocId(Long balanceSheetDocId) {
		this.balanceSheetDocId = balanceSheetDocId;
	}

	public String getBalanceSheetDocName() {
		return balanceSheetDocName;
	}

	public void setBalanceSheetDocName(String balanceSheetDocName) {
		this.balanceSheetDocName = balanceSheetDocName;
	}

	public String getBalanceSheetDocUId() {
		return balanceSheetDocUId;
	}

	public void setBalanceSheetDocUId(String balanceSheetDocUId) {
		this.balanceSheetDocUId = balanceSheetDocUId;
	}

	public Long getProfitLossDocId() {
		return profitLossDocId;
	}

	public void setProfitLossDocId(Long profitLossDocId) {
		this.profitLossDocId = profitLossDocId;
	}

	public String getProfitLossDocName() {
		return profitLossDocName;
	}

	public void setProfitLossDocName(String profitLossDocName) {
		this.profitLossDocName = profitLossDocName;
	}

	public String getProfitLossDocUId() {
		return profitLossDocUId;
	}

	public void setProfitLossDocUId(String profitLossDocUId) {
		this.profitLossDocUId = profitLossDocUId;
	}

	public Long getCashFlowDocId() {
		return cashFlowDocId;
	}

	public void setCashFlowDocId(Long cashFlowDocId) {
		this.cashFlowDocId = cashFlowDocId;
	}

	public String getCashFlowDocName() {
		return cashFlowDocName;
	}

	public void setCashFlowDocName(String cashFlowDocName) {
		this.cashFlowDocName = cashFlowDocName;
	}

	public String getCashFlowDocUId() {
		return cashFlowDocUId;
	}

	public void setCashFlowDocUId(String cashFlowDocUId) {
		this.cashFlowDocUId = cashFlowDocUId;
	}
	
}
