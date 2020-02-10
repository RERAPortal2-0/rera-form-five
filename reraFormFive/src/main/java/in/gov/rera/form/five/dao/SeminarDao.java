package in.gov.rera.form.five.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import in.gov.rera.form.five.model.SeminarModel;

@Repository
public interface SeminarDao extends CrudRepository<SeminarModel, Long> {
	
	@Query(nativeQuery = true, value="Select p.* from tt_seminar p  order by p.event_start_date desc")
	List<SeminarModel> getAllSeminarList();
	
	@Query(nativeQuery = true, value="Select p.* from tt_seminar p where STR_TO_DATE(p.event_end_date, '%Y-%m-%d') < CURDATE() order by p.event_start_date desc")
	List<SeminarModel> getPastSeminarList();
	
	@Query(nativeQuery = true, value="Select p.* from tt_seminar p where STR_TO_DATE(p.event_start_date, '%Y-%m-%d') >= CURDATE() order by p.event_start_date desc")
	List<SeminarModel> getUpCommingSeminarList();
}
