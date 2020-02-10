package in.gov.rera.form.five.services;

import java.util.List;

import in.gov.rera.form.five.model.SeminarModel;
import in.gov.rera.form.five.model.transaction.SeminarDto;


public interface SeminarService {

	SeminarModel saveSeminar(SeminarModel model);
    
	SeminarModel findById(Long id);
	
	List<SeminarModel> findAll();

	void deleteById(Long id);

	List<SeminarModel> findPastSeminar();

	List<SeminarModel> findUpCommingSeminar();

	List<SeminarDto> getSeminarDto(List<SeminarModel> upList);
	
	


	
}
