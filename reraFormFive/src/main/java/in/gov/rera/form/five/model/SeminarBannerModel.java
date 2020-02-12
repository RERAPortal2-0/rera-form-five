package in.gov.rera.form.five.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "SeminarBannerModel")
@Table(name = "TL_BANNER_DETAILS")
public class SeminarBannerModel {

	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "ID") 
	  private Long Id;
	  
	  @Column(name = "SEMINAR_ID_IMG_FK")
	  private Long seminarId;
	  
	  @Column(name = "BANNER_IMAGE_ID")
	  private Long bannerImageId;
	  
	  @Column(name = "BANNER_IMAGE_UID")
	  private String bannerImageUId;
	  
	  @Column(name = "BANNER_IMAGE_NAME")
	  private String fName;

	public Long getId() {
		return Id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
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

	public Long getBannerImageId() {
		return bannerImageId;
	}

	public void setBannerImageId(Long bannerImageId) {
		this.bannerImageId = bannerImageId;
	}

	public String getBannerImageUId() {
		return bannerImageUId;
	}

	public void setBannerImageUId(String bannerImageUId) {
		this.bannerImageUId = bannerImageUId;
	}
	  


}
