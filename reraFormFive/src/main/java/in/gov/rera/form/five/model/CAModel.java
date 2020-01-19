package in.gov.rera.form.five.model;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.sun.istack.NotNull;

@Entity(name = "CAModel")
@Table(name = "TT_CA_REG")
public class CAModel implements Serializable {

	private static final long serialVersionUID = 1463124437645744569L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CA_ID")
	private Long id;

	// @NotBlank(message="CA MemberShip Number shuold not be blank.")
	@Column(name = "CA_ICAI_MEM_NO")
	private Long caMemberShipNumber;

	@NotNull
	@Column(name = "CA_ENROLL_DATE")
	private Date enrollDate;

	@NotEmpty(message = "Fist Name shuold not be blank.")
	@Column(name = "CA_FIRST_NAME")
	private String firstName;

	@Column(name = "CA_MID_NAME")
	private String middleName;

	@NotBlank(message = "Last Name shuold not be blank.")
	@Column(name = "CA_LAST_NAME")
	private String lastName;

	// @NotBlank(message="Birtday date shuold not be blank.")
	@Column(name = "CA_BIRTH_DATE")
	private Calendar birthDate;

	@NotBlank(message = "Pan No shuold not be blank.")
	@Column(name = "CA_PAN_NO")
	private String panNo;

	@Column(name = "CA_COP_DATE")
	private Date copDate;

	@NotBlank(message = "Email shuold not be blank.")
	@Email(message = "Email should be in proper formate.")
	@Column(name = "CA_EMAILID")
	private String emailId;

	@NotBlank(message = "Mobile number is required.")
	@Size(max = 10, message = "Mobile number should have 10 digit")
	@Column(name = "CA_MOBILENO")
	private String mobileNo;

	@Column(name = "CA_STATUS")
	private String status;

	@Column(name = "LOGIN_ID")
	private String loginId;

	/* office address */

	@Column(name = "CA_OFFADDR")
	private String officeAddress;
	@Column(name = "CA_OFFADDR2")
	private String officeAddress2;

	@Column(name = "CA_OFFSTATE_CODE")
	private String officeStateCode;

	@Column(name = "CA_OFFSTATE_NAME")
	private String officeStateName;

	@Column(name = "CA_OFFDIST_CODE")
	private String oficeDistictCode;

	@Column(name = "CA_OFFDIST_NAME")
	private String oficeDistictName;

	@Column(name = "CA_OFFTALUKA_CODE")
	private String officeTalukaCode;

	@Column(name = "CA_OFFTALUKA_NAME")
	private String officeTalukaName;

	@Column(name = "CA_OFFPIN_CODE")
	private Long officePinCode;

	/* Residential */

	@Column(name = "CA_RSDNTADDR")
	private String residentAddress;

	@Column(name = "CA_RSDNTADDR2")
	private String residentAddress2;

	@Column(name = "CA_RSDNTSTATE_CODE")
	private String residentStateCode;

	@Column(name = "CA_RSDNTSTATE_NAME")
	private String residentStateName;

	@Column(name = "CA_RSDNTDIST_CODE")
	private String residentDistictCode;

	@Column(name = "CA_RSDNTDIST_NAME")
	private String residentDistictName;

	@Column(name = "CA_RSDNTTALUKA_CODE")
	private String residentTalukaCode;

	@Column(name = "CA_RSDNTTALUKA_NAME")
	private String residentTalukaName;

	@Column(name = "CA_RSDNTPIN_CODE")
	private Long residentPinCode;

	/* documents */
	@Column(name = "CA_PROFILE_ID")
	private Long profileId;
	@Column(name = "CA_PROFILE_UID")
	private String profileUId;

	@Column(name = "CA_MEM_CERT_ID")
	private Long membershipCertId;

	@Column(name = "CA_MEM_CERT_UID")
	private String membershipCertUId;

	@Column(name = "CA_PANDOC_ID")
	private Long panColorDocId;

	@Column(name = "CA_PANDOC_UID")
	private String panColorDocUId;

	@Column(name = "CA_AADHARDOC_ID")
	private String aadharCardId;

	@Column(name = "CA_AADHARDOC_UID")
	private String aadharCardUId;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CA_REG_DATE")
	private Date regDate;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CA_MODIFIED_ON")
	private Date modifiedOn;

	@Column(name = "CA_MODIFIED_BY")
	private String modifiedBy;

	public String getOfficeStateCode() {
		return officeStateCode;
	}

	public void setOfficeStateCode(String officeStateCode) {
		this.officeStateCode = officeStateCode;
	}

	public String getOfficeStateName() {
		return officeStateName;
	}

	public void setOfficeStateName(String officeStateName) {
		this.officeStateName = officeStateName;
	}

	public String getOficeDistictCode() {
		return oficeDistictCode;
	}

	public void setOficeDistictCode(String oficeDistictCode) {
		this.oficeDistictCode = oficeDistictCode;
	}

	public String getOficeDistictName() {
		return oficeDistictName;
	}

	public void setOficeDistictName(String oficeDistictName) {
		this.oficeDistictName = oficeDistictName;
	}

	public String getOfficeTalukaCode() {
		return officeTalukaCode;
	}

	public void setOfficeTalukaCode(String officeTalukaCode) {
		this.officeTalukaCode = officeTalukaCode;
	}

	public String getOfficeTalukaName() {
		return officeTalukaName;
	}

	public void setOfficeTalukaName(String officeTalukaName) {
		this.officeTalukaName = officeTalukaName;
	}

	public String getResidentStateCode() {
		return residentStateCode;
	}

	public void setResidentStateCode(String residentStateCode) {
		this.residentStateCode = residentStateCode;
	}

	public String getResidentStateName() {
		return residentStateName;
	}

	public void setResidentStateName(String residentStateName) {
		this.residentStateName = residentStateName;
	}

	public String getResidentDistictCode() {
		return residentDistictCode;
	}

	public void setResidentDistictCode(String residentDistictCode) {
		this.residentDistictCode = residentDistictCode;
	}

	public String getResidentDistictName() {
		return residentDistictName;
	}

	public void setResidentDistictName(String residentDistictName) {
		this.residentDistictName = residentDistictName;
	}

	public String getResidentTalukaCode() {
		return residentTalukaCode;
	}

	public void setResidentTalukaCode(String residentTalukaCode) {
		this.residentTalukaCode = residentTalukaCode;
	}

	public String getResidentTalukaName() {
		return residentTalukaName;
	}

	public void setResidentTalukaName(String residentTalukaName) {
		this.residentTalukaName = residentTalukaName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCaMemberShipNumber() {
		return caMemberShipNumber;
	}

	public void setCaMemberShipNumber(Long caMemberShipNumber) {
		this.caMemberShipNumber = caMemberShipNumber;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public String getPanNo() {
		return panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	public Date getCopDate() {
		return copDate;
	}

	public void setCopDate(Date copDate) {
		this.copDate = copDate;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Long getOfficePinCode() {
		return officePinCode;
	}

	public void setOfficePinCode(Long officePinCode) {
		this.officePinCode = officePinCode;
	}

	public String getResidentAddress() {
		return residentAddress;
	}

	public void setResidentAddress(String residentAddress) {
		this.residentAddress = residentAddress;
	}

	public Long getResidentPinCode() {
		return residentPinCode;
	}

	public void setResidentPinCode(Long residentPinCode) {
		this.residentPinCode = residentPinCode;
	}

	public Long getMembershipCertId() {
		return membershipCertId;
	}

	public void setMembershipCertId(Long membershipCertId) {
		this.membershipCertId = membershipCertId;
	}

	public String getMembershipCertUId() {
		return membershipCertUId;
	}

	public void setMembershipCertUId(String membershipCertUId) {
		this.membershipCertUId = membershipCertUId;
	}

	public Long getPanColorDocId() {
		return panColorDocId;
	}

	public void setPanColorDocId(Long panColorDocId) {
		this.panColorDocId = panColorDocId;
	}

	public String getPanColorDocUId() {
		return panColorDocUId;
	}

	public void setPanColorDocUId(String panColorDocUId) {
		this.panColorDocUId = panColorDocUId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getOfficeAddress2() {
		return officeAddress2;
	}

	public void setOfficeAddress2(String officeAddress2) {
		this.officeAddress2 = officeAddress2;
	}

	public String getResidentAddress2() {
		return residentAddress2;
	}

	public void setResidentAddress2(String residentAddress2) {
		this.residentAddress2 = residentAddress2;
	}

	public String getAadharCardId() {
		return aadharCardId;
	}

	public void setAadharCardId(String aadharCardId) {
		this.aadharCardId = aadharCardId;
	}

	public String getAadharCardUId() {
		return aadharCardUId;
	}

	public void setAadharCardUId(String aadharCardUId) {
		this.aadharCardUId = aadharCardUId;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getProfileUId() {
		return profileUId;
	}

	public void setProfileUId(String profileUId) {
		this.profileUId = profileUId;
	}

}
