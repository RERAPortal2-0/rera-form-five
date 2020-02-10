package in.gov.rera.form.five.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "SeminarDetailsModel")
@Table(name = "TL_SEMINAR_DETAILS")
public class SeminarDetailsModel {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "ID") 
	  private Long Id;
	  
	  @Column(name = "SEMINAR_ID_FK")
	  private Long seminarId;
	  
	  @Column(name = "SEMINAR_TITLE")
	  private String seminarTitle;
	  
	  @Column(name = "SEMINAR_DATE")
	  private String seminarDate;
	  
	  @Column(name = "SEMINAR_START_TIME")
	  private String seminarStartTime;
	  
	  @Column(name = "SEMINAR_END_TIME")
	  private String seminarEndTime;
	  
	  @Column(name = "SEMINAR_ADDRESS")
	  private String seminarAddress;
	  
	  @Column(name = "SEMINAR_PIN_CODE")
	  private String pincode;
	  
	  @Column(name = "STATE_NAME")
	  private String stateName;
	  
	  @Column(name = "STATE_CODE")
	  private String stateCode;
	  
	  @Column(name = "DISTRICT_NAME")
	  private String districtName;
	  
	  @Column(name = "DISTRICT_CODE")
	  private String districtCode;
	  
	  @Column(name = "TALUKA_NAME")
	  private String talukaName;
	  
	  @Column(name = "GOOGLE_LAT")
	  private String googleLat;
	  
	  @Column(name = "GOOGLE_LNG")
	  private String googleLng;

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getTalukaName() {
		return talukaName;
	}

	public void setTalukaName(String talukaName) {
		this.talukaName = talukaName;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getSeminarId() {
		return seminarId;
	}

	public void setSeminarId(Long seminarId) {
		this.seminarId = seminarId;
	}

	public String getSeminarTitle() {
		return seminarTitle;
	}

	public void setSeminarTitle(String seminarTitle) {
		this.seminarTitle = seminarTitle;
	}

	public String getSeminarDate() {
		return seminarDate;
	}

	public void setSeminarDate(String seminarDate) {
		this.seminarDate = seminarDate;
	}

	public String getSeminarStartTime() {
		return seminarStartTime;
	}

	public void setSeminarStartTime(String seminarStartTime) {
		this.seminarStartTime = seminarStartTime;
	}

	public String getSeminarEndTime() {
		return seminarEndTime;
	}

	public void setSeminarEndTime(String seminarEndTime) {
		this.seminarEndTime = seminarEndTime;
	}

	public String getSeminarAddress() {
		return seminarAddress;
	}

	public void setSeminarAddress(String seminarAddress) {
		this.seminarAddress = seminarAddress;
	}

	public String getGoogleLat() {
		return googleLat;
	}

	public void setGoogleLat(String googleLat) {
		this.googleLat = googleLat;
	}

	public String getGoogleLng() {
		return googleLng;
	}

	public void setGoogleLng(String googleLng) {
		this.googleLng = googleLng;
	}

	  
	 

}
