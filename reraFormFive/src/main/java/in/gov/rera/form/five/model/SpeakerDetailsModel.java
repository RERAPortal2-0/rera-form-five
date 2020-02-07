package in.gov.rera.form.five.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "SpeakerDetailsModel")
@Table(name = "TL_SPEAKER_DETAILS")
public class SpeakerDetailsModel {

	
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "ID") 
	  private Long Id;
	  
	  @Column(name = "SEMINAR_ID_SP_FK")
	  private Long seminarId;
	  
	  @Column(name = "SPEAKER_IMAGE_ID")
	  private Long speakerImageId;
	  
	  @Column(name = "SPEAKER_IMAGE_UID")
	  private String speakerImageUId;
	  
	  @Column(name = "NAME")
	  private String name;
	  
	  @Column(name = "DESIGNATION")
	  private String designation;

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

	public Long getSpeakerImageId() {
		return speakerImageId;
	}

	public void setSpeakerImageId(Long speakerImageId) {
		this.speakerImageId = speakerImageId;
	}

	public String getSpeakerImageUId() {
		return speakerImageUId;
	}

	public void setSpeakerImageUId(String speakerImageUId) {
		this.speakerImageUId = speakerImageUId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	  
	  

	  
	 

}
