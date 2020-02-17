package in.gov.rera.form.five.notification;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import in.gov.rera.form.five.common.RestTamplateUtility;
import in.gov.rera.form.five.constants.ReraConstants;
import in.gov.rera.form.five.model.AuthUserModel;
import in.gov.rera.form.five.model.FormFiveModel;
import in.gov.rera.form.five.model.ProjectFormFiveModel;
import in.gov.rera.form.five.model.SeminarAssignToModel;
import in.gov.rera.form.five.model.SeminarModel;
import in.gov.rera.form.five.model.SeminarPaymentDetailsModel;

public class MailContents {
	private static final Logger logger = LogManager.getLogger(MailContents.class);

	public static EmailNotification acceptanceMailToCA(FormFiveModel model) {
		logger.debug("Form Five Acceptance mail ::Start");
		EmailNotification email = new EmailNotification();
		email.setSubject("GujRERA Project Form Five Acceptance");
		email.setSendTo(model.getCaEmailId());
		email.setProcessName(ReraConstants.FORM_FIVE);
		email.setSendAsOtp("N");
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(model.getCaName()).append("\n\n");
		sb.append("You have accepted Project Form Five: \n\n");
		sb.append("Project Name: ").append(model.getProjectName()).append(" \n\n");
		sb.append("Promoter Name: ").append(model.getPromoterName()).append(" \n\n");
		sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
		email.setBodyContent(sb.toString());
		logger.debug("Form Five Acceptance mail::end");
		return email;
	}
	
	  public static EmailNotification acceptanceMailToPromoter(ProjectFormFiveModel model, FormFiveModel formFive) {
	  logger.debug("formOneRejectMailToArchitect::start"); EmailNotification email
	  = new EmailNotification();
	  email.setSubject("GujRERA Project Form Five Accepted");
	  email.setSendTo(model.getPromoterEmailId());
	  email.setProcessName(ReraConstants.FORM_FIVE); email.setSendAsOtp("N");
	  StringBuilder sb = new StringBuilder();
	  sb.append("Dear ").append(formFive.getPromoterName()).append("\n\n"); sb.
	  append("Your Project Form Five is accepted by CA, details are below: \n\n"
	  ); sb.append("CA Number: ").append(formFive.getCaNumber()).append(" \n\n");
	  sb.append("CA Name: ").append(formFive.getCaName()).append(" \n\n");
	  sb.append("CA Emaild: ").append(formFive.getCaEmailId()).
	  append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	  email.setBodyContent(sb.toString());
	  logger.debug("formOneRejectMailToArchitect::end"); return email; }

	public static EmailNotification assignMailToPromoter(ProjectFormFiveModel m, FormFiveModel formFive) {
		 logger.debug("formOneRejectMailToArchitect::start"); EmailNotification email
		  = new EmailNotification();
		  email.setSubject("GujRERA Project Form Five Assigned");
		  email.setSendTo(m.getPromoterEmailId());
		  email.setProcessName(ReraConstants.FORM_FIVE); email.setSendAsOtp("N");
		  StringBuilder sb = new StringBuilder();
		  sb.append("Dear ").append(formFive.getPromoterName()).append("\n\n"); sb.
		  append("You have assigned Project Form five CA detail are below: \n\n"
		  ); sb.append("CA Number: ").append(formFive.getCaNumber()).append(" \n\n");
		  sb.append("CA Name: ").append(formFive.getCaName()).append(" \n\n");
		  sb.append("CA Emaild: ").append(formFive.getCaEmailId()).
		  append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
		  email.setBodyContent(sb.toString());
		  logger.debug("formOneRejectMailToArchitect::end"); return email; 
	}

	public static EmailNotification assignMailToCA(FormFiveModel formFive) {
		logger.debug("Form Five Acceptance mail ::Start");
		EmailNotification email = new EmailNotification();
		email.setSubject("GujRERA Project Form Five Assigned");
		email.setSendTo(formFive.getCaEmailId());
		email.setProcessName(ReraConstants.FORM_FIVE);
		email.setSendAsOtp("N");
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(formFive.getCaName()).append("\n\n");
		sb.append("Project Form Five is assigned to you: \n\n");
		sb.append("Project Name: ").append(formFive.getProjectName()).append(" \n\n");
		sb.append("Promoter Name: ").append(formFive.getPromoterName()).append(" \n\n");
		sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
		email.setBodyContent(sb.toString());
		logger.debug("Form Five Acceptance mail::end");
		return email;
	}

	public static EmailNotification submitMailToPromoter(ProjectFormFiveModel m, FormFiveModel formFive) {
		 logger.debug("formOneRejectMailToArchitect::start"); EmailNotification email
		  = new EmailNotification();
		  email.setSubject("GujRERA Project Form Five Submitted By CA");
		  email.setSendTo(m.getPromoterEmailId());
		  email.setProcessName(ReraConstants.FORM_FIVE); email.setSendAsOtp("N");
		  StringBuilder sb = new StringBuilder();
		  sb.append("Dear ").append(formFive.getPromoterName()).append("\n\n"); sb.
		  append("Project Form Five is submitted by CA: \n\n"
		  ); sb.append("CA Number: ").append(formFive.getCaNumber()).append(" \n\n");
		  sb.append("CA Name: ").append(formFive.getCaName()).append(" \n\n");
		  sb.append("CA Emaild: ").append(formFive.getCaEmailId()).
		  append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
		  email.setBodyContent(sb.toString());
		  logger.debug("formOneRejectMailToArchitect::end"); return email; 
	}

	public static EmailNotification submitMailToCA(FormFiveModel formFive) {
		logger.debug("Form Five Acceptance mail ::Start");
		EmailNotification email = new EmailNotification();
		email.setSubject("GujRERA Project Form Five Submitted");
		email.setSendTo(formFive.getCaEmailId());
		email.setProcessName(ReraConstants.FORM_FIVE);
		email.setSendAsOtp("N");
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(formFive.getCaName()).append("\n\n");
		sb.append("Project Form Five is Submitted by You: \n\n");
		sb.append("Project Name: ").append(formFive.getProjectName()).append(" \n\n");
		sb.append("Promoter Name: ").append(formFive.getPromoterName()).append(" \n\n");
		sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
		email.setBodyContent(sb.toString());
		logger.debug("Form Five Acceptance mail::end");
		return email;
	}

	public static EmailNotification reAssignMailToPromoter(ProjectFormFiveModel m, FormFiveModel formFive) {
		// TODO Auto-generated method stub
		return null;
	}

	public static EmailNotification reAssignMailToCA(FormFiveModel formFive) {
		// TODO Auto-generated method stub
		return null;
	}


	public static EmailNotification seminarAssignToMail(AuthUserModel user,SeminarModel semiModel) {
		logger.debug("Assign Seminar Mail Start");
		EmailNotification email = new EmailNotification();
		email.setSubject("GujRERA Seminar Assignment");
		email.setSendTo(user.getUser_email());
		email.setProcessName(ReraConstants.RERA_SEMINAR);
		email.setSendAsOtp("N");
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(user.getUser_name()).append("\n\n");
		sb.append("RERA Seminar is assigned to you: \n\n");
		sb.append("Seminar Name: ").append(semiModel.getSubject()).append(" \n\n");
		sb.append("Seminar Organised By: ").append(semiModel.getOrganisedBy()).append(" \n\n");
		sb.append("Seminar Start Date: ").append(semiModel.getEventStartDate()).append(" \n\n");
		sb.append("Seminar End Date: ").append(semiModel.getEventEndDate()).append(" \n\n");
		sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
		email.setBodyContent(sb.toString());
		logger.debug("Assign Seminar Mail Start::end");
		return email;
	}

	public static EmailNotification seminarRegistrationMail(SeminarPaymentDetailsModel paymentModel) {
		logger.debug("Seminar Registration Mail Start");
		EmailNotification email = new EmailNotification();
		email.setSubject("GujRERA Seminar Registration");
		email.setSendTo(paymentModel.getEmailId());
		email.setProcessName(ReraConstants.RERA_SEMINAR);
		email.setSendAsOtp("N");
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(paymentModel.getUserName()).append("\n\n");
		sb.append("You are Registrated in RERA Seminar: \n\n");
		sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
		email.setBodyContent(sb.toString());
		logger.debug("Seminar Registration Mail Start::end");
		return email;
	}
}
