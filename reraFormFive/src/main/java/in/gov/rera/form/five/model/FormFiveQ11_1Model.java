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


@Entity(name = "FormFiveQ11_1Model")
@Table(name = "TL_FORM_FIVEQ11_1")

public class FormFiveQ11_1Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRO_FORM_FIVEQ11_1_ID")
	private Long projectFormFiveQ111Id;
	
	@Column(name = "FORM1_APPLICABLE")
	private String form1ApplicableId;
	
	@Column(name = "FORM_TITLE")
	private String formTitle;
	
	@Column(name = "CERTIFY_PROFESSIONAL_FORM1")
	private String certifyProfessionalForm;
	
	@Column(name = "DATE_OF_ISSUANCE_FORM")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dateOfIssuanceForm;

	@Column(name = "DETLS_OF_DESCREAPNCE_FORM1")
	private String detlsOfDescrepanceForm;
	
	public Long getProjectFormFiveQ111Id() {
		return projectFormFiveQ111Id;
	}

	public void setProjectFormFiveQ111Id(Long projectFormFiveQ111Id) {
		this.projectFormFiveQ111Id = projectFormFiveQ111Id;
	}

	
	public String getDateOfIssuanceFormStr() {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");		
		if(	null!=dateOfIssuanceForm)
			return sf.format(dateOfIssuanceForm);
			
			return null;
	}

	public String getForm1ApplicableId() {
		return form1ApplicableId;
	}

	public void setForm1ApplicableId(String form1ApplicableId) {
		this.form1ApplicableId = form1ApplicableId;
	}

	public String getFormTitle() {
		return formTitle;
	}

	public void setFormTitle(String formTitle) {
		this.formTitle = formTitle;
	}

	public String getCertifyProfessionalForm() {
		return certifyProfessionalForm;
	}

	public void setCertifyProfessionalForm(String certifyProfessionalForm) {
		this.certifyProfessionalForm = certifyProfessionalForm;
	}

	public Date getDateOfIssuanceForm() {
		return dateOfIssuanceForm;
	}

	public void setDateOfIssuanceForm(Date dateOfIssuanceForm) {
		this.dateOfIssuanceForm = dateOfIssuanceForm;
	}

	public String getDetlsOfDescrepanceForm() {
		return detlsOfDescrepanceForm;
	}

	public void setDetlsOfDescrepanceForm(String detlsOfDescrepanceForm) {
		this.detlsOfDescrepanceForm = detlsOfDescrepanceForm;
	}

	
}
