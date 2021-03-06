package in.gov.rera.form.five.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity(name = "PromoterDevloperDetailsModel")
@Table(name = "TL_PROMOTOR_ASSOCIATE_REG")
public class PromoterDevloperDetailsModel implements Serializable {
	private static final long serialVersionUID = 1463124430214748765L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRM_ASSOCIATE_ID")
	private Long id;

	@Column(name = "PRJ_REG_ID_DVLPR_FK")
	private Long prjRegId;

	@Column(name = "PRJ_PRMOTER_ID")
	private Long promoterId;

	@Column(name = "PASC_FNAME")
	private String associateFirstName;

	@Column(name = "PASC_MNAME")
	private String associateMiddleName;

	@Column(name = "PASC_LNAME")
	private String associateLastName;

	@Column(name = "PASC_PAN")
	private String associatePan;
	@Column(name = "PASC_ADDRESS")
	private String associateAddress;
	@Column(name = "PASC_TALUKA_CODE")
	private String assocaiteTalukaCode;
	@Column(name = "PASC_TALUKA_NAME")
	private String assocaiteTalukaName;
	@Column(name = "PASC_DISTRICT_CODE")
	private String assocaiteDistrictCode;

	@Column(name = "PASC_DISTRICT_NAME")
	private String assocaiteDistrictName;
	@Column(name = "PASC_SATE_CODE")
	private String assocaiteStateCode;
	@Column(name = "PASC_STATE_NAME")
	private String assocaiteStateName;
	@Column(name = "PASC_PINCODE")
	private String assocaitePinCode;
	@Column(name = "PASC_PHOTO_ID")
	private Long assocaitePhotographId;
	@Column(name = "PASC_PHOTO_UID")
	private String assocaitePhotographUId;
	@Column(name = "PASC_MOBNO")
	private String assocaiteMobileNumber;
	@Column(name = "PASC_EMAILID")
	private String assocaiteEmailId;
	@Column(name = "PASC_ADHAR")
	private String assocaiteADHARNumber;

	// document
	@Column(name = "PASC_pANColorPDFId")
	private Long assocaitePANColorPDFId;
	@Column(name = "PASC_pANColorPDFUId")
	private String assocaitePANColorPDFUId;

	@Column(name = "PASC_PHOTODOCId")
	private Long assocaitePhtoId;
	@Column(name = "PASC_PHOTO_DOCUId")
	private String assocaitePhotoUId;

	@Column(name = "PASC_ADHARCOLORPDFID")
	private Long assocaiteADHARId;
	@Column(name = "PASC_ADHARCOLORPDFUID")
	private String assocaiteADHARPDFUId;

	@Column(name = "PASC_CERTIFICATEID")
	private Long assocaiteCertificateId;
	@Column(name = "PASC_CERTIFICATEUID")
	private String assocaiteCertificateUId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPromoterId() {
		return promoterId;
	}

	public void setPromoterId(Long promoterId) {
		this.promoterId = promoterId;
	}

	public String getAssociateFirstName() {
		return associateFirstName;
	}

	public void setAssociateFirstName(String associateFirstName) {
		this.associateFirstName = associateFirstName;
	}

	public String getAssociateMiddleName() {
		return associateMiddleName;
	}

	public void setAssociateMiddleName(String associateMiddleName) {
		this.associateMiddleName = associateMiddleName;
	}

	public String getLastName() {
		return associateLastName;
	}

	public void setLastName(String associateLastName) {
		this.associateLastName = associateLastName;
	}

	public String getAssociatePan() {
		return associatePan;
	}

	public void setAssociatePan(String associatePan) {
		this.associatePan = associatePan;
	}

	public String getAssociateAddress() {
		return associateAddress;
	}

	public void setAssociateAddress(String associateAddress) {
		this.associateAddress = associateAddress;
	}

	public String getAssocaiteTalukaCode() {
		return assocaiteTalukaCode;
	}

	public void setAssocaiteTalukaCode(String assocaiteTalukaCode) {
		this.assocaiteTalukaCode = assocaiteTalukaCode;
	}

	public String getAssocaiteTalukaName() {
		return assocaiteTalukaName;
	}

	public void setAssocaiteTalukaName(String assocaiteTalukaName) {
		this.assocaiteTalukaName = assocaiteTalukaName;
	}

	public String getAssocaiteDistrictCode() {
		return assocaiteDistrictCode;
	}

	public void setAssocaiteDistrictCode(String assocaiteDistrictCode) {
		this.assocaiteDistrictCode = assocaiteDistrictCode;
	}

	public String getAssocaiteDistrictName() {
		return assocaiteDistrictName;
	}

	public void setAssocaiteDistrictName(String assocaiteDistrictName) {
		this.assocaiteDistrictName = assocaiteDistrictName;
	}

	public String getAssocaiteStateCode() {
		return assocaiteStateCode;
	}

	public void setAssocaiteStateCode(String assocaiteStateCode) {
		this.assocaiteStateCode = assocaiteStateCode;
	}

	public String getAssocaiteStateName() {
		return assocaiteStateName;
	}

	public void setAssocaiteStateName(String assocaiteStateName) {
		this.assocaiteStateName = assocaiteStateName;
	}

	public String getAssocaitePinCode() {
		return assocaitePinCode;
	}

	public void setAssocaitePinCode(String assocaitePinCode) {
		this.assocaitePinCode = assocaitePinCode;
	}

	public Long getAssocaitePhotographId() {
		return assocaitePhotographId;
	}

	public void setAssocaitePhotographId(Long assocaitePhotographId) {
		this.assocaitePhotographId = assocaitePhotographId;
	}

	public String getAssocaitePhotographUId() {
		return assocaitePhotographUId;
	}

	public void setAssocaitePhotographUId(String assocaitePhotographUId) {
		this.assocaitePhotographUId = assocaitePhotographUId;
	}

	public String getAssocaiteMobileNumber() {
		return assocaiteMobileNumber;
	}

	public void setAssocaiteMobileNumber(String assocaiteMobileNumber) {
		this.assocaiteMobileNumber = assocaiteMobileNumber;
	}

	public String getAssocaiteEmailId() {
		return assocaiteEmailId;
	}

	public void setAssocaiteEmailId(String assocaiteEmailId) {
		this.assocaiteEmailId = assocaiteEmailId;
	}

	public String getAssocaiteADHARNumber() {
		return assocaiteADHARNumber;
	}

	public void setAssocaiteADHARNumber(String assocaiteADHARNumber) {
		this.assocaiteADHARNumber = assocaiteADHARNumber;
	}

	public Long getAssocaitePANColorPDFId() {
		return assocaitePANColorPDFId;
	}

	public void setAssocaitePANColorPDFId(Long assocaitePANColorPDFId) {
		this.assocaitePANColorPDFId = assocaitePANColorPDFId;
	}

	public String getAssocaitePANColorPDFUId() {
		return assocaitePANColorPDFUId;
	}

	public void setAssocaitePANColorPDFUId(String assocaitePANColorPDFUId) {
		this.assocaitePANColorPDFUId = assocaitePANColorPDFUId;
	}

	public String getAssociateLastName() {
		return associateLastName;
	}

	public void setAssociateLastName(String associateLastName) {
		this.associateLastName = associateLastName;
	}

	public Long getAssocaitePhtoId() {
		return assocaitePhtoId;
	}

	public void setAssocaitePhtoId(Long assocaitePhtoId) {
		this.assocaitePhtoId = assocaitePhtoId;
	}

	public String getAssocaitePhotoUId() {
		return assocaitePhotoUId;
	}

	public void setAssocaitePhotoUId(String assocaitePhotoUId) {
		this.assocaitePhotoUId = assocaitePhotoUId;
	}

	public Long getAssocaiteADHARId() {
		return assocaiteADHARId;
	}

	public void setAssocaiteADHARId(Long assocaiteADHARId) {
		this.assocaiteADHARId = assocaiteADHARId;
	}

	public String getAssocaiteADHARPDFUId() {
		return assocaiteADHARPDFUId;
	}

	public void setAssocaiteADHARPDFUId(String assocaiteADHARPDFUId) {
		this.assocaiteADHARPDFUId = assocaiteADHARPDFUId;
	}

	public Long getAssocaiteCertificateId() {
		return assocaiteCertificateId;
	}

	public void setAssocaiteCertificateId(Long assocaiteCertificateId) {
		this.assocaiteCertificateId = assocaiteCertificateId;
	}

	public String getAssocaiteCertificateUId() {
		return assocaiteCertificateUId;
	}

	public void setAssocaiteCertificateUId(String assocaiteCertificateUId) {
		this.assocaiteCertificateUId = assocaiteCertificateUId;
	}

	public Long getPrjRegId() {
		return prjRegId;
	}

	public void setPrjRegId(Long prjRegId) {
		this.prjRegId = prjRegId;
	}

}
