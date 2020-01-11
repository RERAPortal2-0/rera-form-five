package in.gov.rera.form.five.common.services.impl;

import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import in.gov.rera.form.five.common.model.DmsModel;
import in.gov.rera.form.five.common.services.DmsServices;
import in.gov.rera.form.five.model.FormFiveDocumentModel;
import in.gov.rera.form.five.model.FormFiveOtherDocModel;

@Service
public class DmsServiceImpl implements DmsServices {

	@Override
	public FormFiveOtherDocModel commitOthDoc(FormFiveOtherDocModel model, String url) {

		DmsModel dmsModel = new DmsModel();
		try {
			if (model.getDocUId() == null && model.getDocId() != null) {
				dmsModel.setFolderId(model.getFormFiveId().toString());
				dmsModel.setDocumentId(model.getDocId());
				dmsModel.setDocumentType("FORM-FIVE-OTHER-DOC");
				DmsModel comitPandoc = UserRestTemplateServices.saveDoc(dmsModel, url);
				Optional.ofNullable(comitPandoc)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				model.setDocUId(comitPandoc.getUid());
				model.setDocId(comitPandoc.getDocumentId());
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		return model;
	}

	@Override
	public FormFiveDocumentModel commitDoc(FormFiveDocumentModel model, String url) {
		DmsModel dmsModel = new DmsModel();
		try {
			if (model.getBalanceSheetDocUId() == null && model.getBalanceSheetDocId() != null) {
				dmsModel.setFolderId(model.getFormFiveId().toString());
				dmsModel.setDocumentId(model.getBalanceSheetDocId());
				dmsModel.setDocumentType("FORM-FIVE-DOC");
				DmsModel comitPandoc = UserRestTemplateServices.saveDoc(dmsModel, url);
				Optional.ofNullable(comitPandoc)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				model.setBalanceSheetDocUId(comitPandoc.getUid());
				model.setBalanceSheetDocId(comitPandoc.getDocumentId());
			}
			if (model.getProfitLossDocUId() == null && model.getProfitLossDocId() != null) {
				dmsModel.setFolderId(model.getFormFiveId().toString());
				dmsModel.setDocumentId(model.getProfitLossDocId());
				dmsModel.setDocumentType("FORM-FIVE-DOC");
				DmsModel comitPandoc = UserRestTemplateServices.saveDoc(dmsModel, url);
				Optional.ofNullable(comitPandoc)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				model.setProfitLossDocUId(comitPandoc.getUid());
				model.setProfitLossDocId(comitPandoc.getDocumentId());
			}
			if (model.getCashFlowDocUId() == null && model.getCashFlowDocId() != null) {
				dmsModel.setFolderId(model.getFormFiveId().toString());
				dmsModel.setDocumentId(model.getCashFlowDocId());
				dmsModel.setDocumentType("FORM-FIVE-DOC");
				DmsModel comitPandoc = UserRestTemplateServices.saveDoc(dmsModel, url);
				Optional.ofNullable(comitPandoc)
						.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
				model.setCashFlowDocUId(comitPandoc.getUid());
				model.setCashFlowDocId(comitPandoc.getDocumentId());
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		return model;
	}
}
