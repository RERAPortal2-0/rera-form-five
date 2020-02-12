package in.gov.rera.form.five.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "SupportedDetailsModel")
@Table(name = "TL_SUPPORTED_DETAILS")
public class SupportedDetailsModel {

	
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "ID") 
	  private Long Id;
	  
	  @Column(name = "SEMINAR_ID_SUPPORTED_FK")
	  private Long seminarId;
	  
	  @Column(name = "SUPPORTED_IMAGE_ID")
	  private Long supportedById;
	  
	  @Column(name = "SUPPORTED_IMAGE_UID")
	  private String supportedByUId;
	  
	  @Column(name = "SUPPORTED_IMAGE_NAME")
	  private String fName;

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	@Column(name = "NAME")
	  private String supportedByName;

	public String getSupportedByUId() {
		return supportedByUId;
	}

	public void setSupportedByUId(String supportedByUId) {
		this.supportedByUId = supportedByUId;
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

	public Long getSupportedById() {
		return supportedById;
	}

	public void setSupportedById(Long supportedById) {
		this.supportedById = supportedById;
	}


	public String getSupportedByName() {
		return supportedByName;
	}

	public void setSupportedByName(String supportedByName) {
		this.supportedByName = supportedByName;
	}
	  


}
