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
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date  dateCertificate;
	
	/*
	 * @ManyToOne
	 * 
	 * @JoinColumn(name="QUARTER_ID") private UserQuarterDetailsModel
	 * userQuarterModel;
	 */
	
	@ManyToOne
	@JoinColumn(name="PROJECT_FORM_FIVE_ID")
	private FormFiveModel formFiveModel;

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

	public Date getDateCertificate() {
		return dateCertificate;
	}
	
	
	public String getDateCertificateStr() {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");		
		if(	null!=dateCertificate)
			return sf.format(dateCertificate);
			
			return null;
	}
	
	

	public void setDateCertificate(Date dateCertificate) {
		this.dateCertificate = dateCertificate;
	}




			
}
