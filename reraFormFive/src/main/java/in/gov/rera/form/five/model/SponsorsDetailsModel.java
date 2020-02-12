package in.gov.rera.form.five.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "SponsorsDetailsModel")
@Table(name = "TL_SPONSORS_DETAILS")
public class SponsorsDetailsModel {

	
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "ID") 
	  private Long Id;
	  
	  @Column(name = "SEMINAR_ID_SPONSOR_FK")
	  private Long seminarId;
	  
	  @Column(name = "SPONSOR_IMAGE_ID")
	  private Long sponsorsId;
	  
	  @Column(name = "SPONSOR_IMAGE_UID")
	  private String sponsorsUId;
	  
	  @Column(name = "SPONSOR_IMAGE_NAME")
	  private String fName;
	  
	  @Column(name = "NAME")
	  private String sponsorsName;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
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

	public Long getSponsorsId() {
		return sponsorsId;
	}

	public void setSponsorsId(Long sponsorsId) {
		this.sponsorsId = sponsorsId;
	}

	public String getSponsorsUId() {
		return sponsorsUId;
	}

	public void setSponsorsUId(String sponsorsUId) {
		this.sponsorsUId = sponsorsUId;
	}

	public String getSponsorsName() {
		return sponsorsName;
	}

	public void setSponsorsName(String sponsorsName) {
		this.sponsorsName = sponsorsName;
	}

	
}
