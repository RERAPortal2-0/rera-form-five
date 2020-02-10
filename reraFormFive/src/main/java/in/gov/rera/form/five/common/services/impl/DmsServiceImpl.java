package in.gov.rera.form.five.common.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import in.gov.rera.form.five.common.model.DmsModel;
import in.gov.rera.form.five.common.services.DmsServices;
import in.gov.rera.form.five.model.FormFiveDocumentModel;
import in.gov.rera.form.five.model.FormFiveOtherDocModel;
import in.gov.rera.form.five.model.SeminarBannerModel;
import in.gov.rera.form.five.model.SeminarModel;
import in.gov.rera.form.five.model.SpeakerDetailsModel;
import in.gov.rera.form.five.model.SponsorsDetailsModel;
import in.gov.rera.form.five.model.SupportedDetailsModel;

@Service
public class DmsServiceImpl implements DmsServices {

	@Override
	public FormFiveOtherDocModel commitOthDoc(FormFiveOtherDocModel model, String url) {

		DmsModel dmsModel = new DmsModel();
		try {
			if (model.getDocId() != null) {
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

	@Override
	public SeminarModel commitSeminarDoc(SeminarModel model,String url) {
		DmsModel dmsModel = new DmsModel();
		try {
			List<SponsorsDetailsModel> sponList = new ArrayList<>();
			for (SponsorsDetailsModel m : model.getSponsorsIdList()) {
				if (m.getSponsorsUId() == null && m.getSponsorsId() != null) {
					dmsModel.setFolderId(m.getId().toString());
					dmsModel.setDocumentId(m.getSponsorsId());
					dmsModel.setDocumentType("AUTH-SEMINAR-SPONSOR-DOC");
					DmsModel comitPandoc = UserRestTemplateServices.saveDoc(dmsModel, url);
					Optional.ofNullable(comitPandoc)
							.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
					m.setSponsorsUId(comitPandoc.getUid());
					m.setSponsorsId(comitPandoc.getDocumentId());
				}
				sponList.add(m);
			}
			model.setSponsorsIdList(sponList);
			
			List<SupportedDetailsModel> supList = new ArrayList<>();
			for (SupportedDetailsModel m : model.getSupportedIdList()) {
				if (m.getSupportedByUId() == null && m.getSupportedById() != null) {
					dmsModel.setFolderId(m.getId().toString());
					dmsModel.setDocumentId(m.getSupportedById());
					dmsModel.setDocumentType("AUTH-SEMINAR-SUPPORTED-DOC");
					DmsModel comitPandoc = UserRestTemplateServices.saveDoc(dmsModel, url);
					Optional.ofNullable(comitPandoc)
							.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
					m.setSupportedByUId(comitPandoc.getUid());
					m.setSupportedById(comitPandoc.getDocumentId());
				}
				supList.add(m);
			}
			model.setSupportedIdList(supList);
			
			List<SeminarBannerModel> bannerList = new ArrayList<>();
			for (SeminarBannerModel m : model.getSeminarBanner()) {
				if (m.getBannerImageUId() == null && m.getBannerImageId() != null) {
					dmsModel.setFolderId(m.getId().toString());
					dmsModel.setDocumentId(m.getBannerImageId());
					dmsModel.setDocumentType("AUTH-SEMINAR-BANNER-DOC");
					DmsModel comitPandoc = UserRestTemplateServices.saveDoc(dmsModel, url);
					Optional.ofNullable(comitPandoc)
							.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
					m.setBannerImageUId(comitPandoc.getUid());
					m.setBannerImageId(comitPandoc.getDocumentId());
				}
				bannerList.add(m);
			}
			model.setSeminarBanner(bannerList);
			 
			List<SpeakerDetailsModel> speakerList = new ArrayList<>();
			for (SpeakerDetailsModel m : model.getSpeakerDetails()) {
				if (m.getSpeakerImageUId() == null && m.getSpeakerImageId() != null) {
					dmsModel.setFolderId(m.getId().toString());
					dmsModel.setDocumentId(m.getSpeakerImageId());
					dmsModel.setDocumentType("AUTH-SEMINAR-SPEAKER-DOC");
					DmsModel comitPandoc = UserRestTemplateServices.saveDoc(dmsModel, url);
					Optional.ofNullable(comitPandoc)
							.orElseThrow(() -> new ResourceAccessException("There are some issue in document commit."));
					m.setSpeakerImageUId(comitPandoc.getUid());
					m.setSpeakerImageId(comitPandoc.getDocumentId());
				}
				speakerList.add(m);
			}
			model.setSpeakerDetails(speakerList);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return model;
	}
	
	
	
}
