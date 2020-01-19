package in.gov.rera.form.five.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="FormFiveOtherDocModel")
@Table(name="FORM_FIVE_OTHER_DOCUMENT")
public class FormFiveOtherDocModel implements Serializable {

	private static final long serialVersionUID = 1803590463071163237L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FORM_FIVE_DOC_ID")
	private Long formFiveOtherDocId;
	
	@Column(name="FORM_FIVE_FK")
	private Long formFiveId;
	
	@Column(name="DOC_ID")
	private Long DocId;
	
	@Column(name="DOC_NAME")
    private String DocName;
	
	@Column(name="DOC_UID")
    private String DocUId;

	public Long getFormFiveOtherDocId() {
		return formFiveOtherDocId;
	}

	public void setFormFiveOtherDocId(Long formFiveOtherDocId) {
		this.formFiveOtherDocId = formFiveOtherDocId;
	}

	public Long getFormFiveId() {
		return formFiveId;
	}

	public void setFormFiveId(Long formFiveId) {
		this.formFiveId = formFiveId;
	}

	public Long getDocId() {
		return DocId;
	}

	public void setDocId(Long docId) {
		DocId = docId;
	}

	public String getDocName() {
		return DocName;
	}

	public void setDocName(String docName) {
		DocName = docName;
	}

	public String getDocUId() {
		return DocUId;
	}

	public void setDocUId(String docUId) {
		DocUId = docUId;
	}

	
}
