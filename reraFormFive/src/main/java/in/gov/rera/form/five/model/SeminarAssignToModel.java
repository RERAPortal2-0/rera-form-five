package in.gov.rera.form.five.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "SeminarAssignToModel")
@Table(name = "TL_SEMINAR_ASSIGN_DETAILS")
public class SeminarAssignToModel {

	
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "ID") 
	  private Long Id;
	  
	  @Column(name = "SEMINAR_ID_ASG_FK")
	  private Long seminarId;
	  
	  @Column(name = "ASSIGN")
	  private String assign;

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

	public String getAssign() {
		return assign;
	}

	public void setAssign(String assign) {
		this.assign = assign;
	}

	  

}
