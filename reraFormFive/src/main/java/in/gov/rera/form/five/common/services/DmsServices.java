package in.gov.rera.form.five.common.services;

import java.util.List;
import in.gov.rera.form.five.common.model.DmsModel;
import in.gov.rera.form.five.model.FormFiveDocumentModel;
import in.gov.rera.form.five.model.FormFiveOtherDocModel;
import in.gov.rera.form.five.model.SeminarModel;



public interface DmsServices {

	public FormFiveOtherDocModel commitOthDoc(FormFiveOtherDocModel model,String url);
	public FormFiveDocumentModel commitDoc(FormFiveDocumentModel model,String url);
	public SeminarModel commitSeminarDoc(SeminarModel model,String url);
}
