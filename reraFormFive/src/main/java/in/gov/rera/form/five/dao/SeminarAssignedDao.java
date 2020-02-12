package in.gov.rera.form.five.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.gov.rera.form.five.model.SeminarAssignToModel;



@Repository
public interface SeminarAssignedDao extends CrudRepository<SeminarAssignToModel, Long> {
	
	List<SeminarAssignToModel> findBySeminarId(Long seminarId);
	
	@Query(nativeQuery = true, value="Select p.* from tl_seminar_assign_details p where p.assign=?1 order by p.seminar_id_asg_fk desc")
	List<SeminarAssignToModel> findByAssign(String usreType);
}
