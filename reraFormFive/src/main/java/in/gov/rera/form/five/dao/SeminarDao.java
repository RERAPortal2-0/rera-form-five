package in.gov.rera.form.five.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.gov.rera.form.five.model.SeminarModel;

@Repository
public interface SeminarDao extends CrudRepository<SeminarModel, Long> {
	
	@Query(nativeQuery = true, value="Select p.* from tt_seminar p where STR_TO_DATE(p.event_end_date, '%Y-%m-%d') < CURDATE()")
	List<SeminarModel> getPastSeminarList();
	
	@Query(nativeQuery = true, value="Select p.* from tt_seminar p where STR_TO_DATE(p.event_start_date, '%Y-%m-%d') >= CURDATE()")
	List<SeminarModel> getUpCommingSeminarList();
}
