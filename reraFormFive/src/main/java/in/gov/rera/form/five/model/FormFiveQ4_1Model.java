package in.gov.rera.form.five.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "FormFiveQ4_1Model")
@Table(name = "TL_FORM_FIVEQ4_1")

public class FormFiveQ4_1Model{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRO_FORM_FIVEQ4_1_ID")
	private Long projectFormFiveQ41Id;
	
	@Column(name = "CA_NAME")
	private String caName;
	
	@Column(name = "CA_NUMBER")
	private String caNumber;
	
	@Column(name = "DATE_OF_CERTIFICATE")
	private String  dateCertificate;
	
	public String getDateCertificate() {
		return dateCertificate;
	}

	public void setDateCertificate(String dateCertificate) {
		this.dateCertificate = dateCertificate;
	}

	public Long getFormFiveId() {
		return formFiveId;
	}

	public void setFormFiveId(Long formFiveId) {
		this.formFiveId = formFiveId;
	}

	@Column(name="FORM_FIVE_FK")
	private Long formFiveId;

	public Long getProjectFormFiveQ41Id() {
		return projectFormFiveQ41Id;
	}

	public void setProjectFormFiveQ41Id(Long projectFormFiveQ41Id) {
		this.projectFormFiveQ41Id = projectFormFiveQ41Id;
	}

	public String getCaName() {
		return caName;
	}

	public void setCaName(String caName) {
		this.caName = caName;
	}

	public String getCaNumber() {
		return caNumber;
	}

	public void setCaNumber(String caNumber) {
		this.caNumber = caNumber;
	}


	
	

	






			
}
