package in.gov.rera.form.five.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.gov.rera.form.five.model.SeminarAssignToModel;



@Repository
public interface SeminarAssignedDao extends CrudRepository<SeminarAssignToModel, Long> {
	
	List<SeminarAssignToModel> findBySeminarId(Long seminarId);
	List<SeminarAssignToModel> findByAssign(String usreType);
}
