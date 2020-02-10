package in.gov.rera.form.five.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.gov.rera.form.five.model.FormFiveModel;

@Repository
public interface FormFiveDao extends CrudRepository<FormFiveModel, Long> {
	
	List<FormFiveModel> findByCaNumber(String caNumber);

	List<FormFiveModel> findByStatus(String status);
	
	List<FormFiveModel> findByFinancialYear(String financialYear);

	//@Query(nativeQuery = true, value="Select p.* from tl_form_five p where p.project_financial_year LIKE %?1% and  p.status LIKE %?2% and p.project_Name LIKE %?3% and p.promoter_Name LIKE %?4% and p.project_reg_no LIKE %?5% and p.promoter_status='ACCEPTED' and (p.authority_status!='REJECTED' or p.authority_status is null)")
	@Query(nativeQuery = true, value="Select p.* from tl_form_five p where p.project_financial_year LIKE %?1% and  p.status LIKE %?2%  and p.promoter_status='ACCEPTED' and (p.authority_status!='REJECTED' or p.authority_status is null)")
	List<FormFiveModel> getProjectWithFilters(String financialYear,String status, String projectName, String promoterName, String projectRegNo);
	
	List<FormFiveModel> findByProjectId(Long projectId);
}
