package in.gov.rera.form.five.notification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class MailContents {
	private static final Logger logger = LogManager.getLogger(MailContents.class);
	
	/*
	 * public static EmailNotification
	 * formOneAssignmentMailToArchitect(ProjectAlterationModel model) {
	 * logger.debug("formOneAssignmentMailToArchitect::Start"); EmailNotification
	 * email = new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form One Assigment");
	 * email.setSendTo(model.getFormOneModel().getEmailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formOneAssignmentMailToArchitect to Architect the details  are below: \n\n"
	 * ); sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Promoter Name: ").append(model.getPromoterName()).append(" \n\n");
	 * sb.append("Promoter Emaild: ").append(model.getPromoteremailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formOneAssignmentMailToArchitect::end"); return email; } public
	 * static EmailNotification formOneRejectMailToArchitect(ProjectAlterationModel
	 * model) { logger.debug("formOneRejectMailToArchitect::start");
	 * EmailNotification email = new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form One Assigment");
	 * email.setSendTo(model.getFormOneModel().getEmailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formOneRejectMailToArchitect to Architect the details  are below: \n\n"
	 * ); sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Promoter Name: ").append(model.getPromoterName()).append(" \n\n");
	 * sb.append("Promoter Emaild: ").append(model.getPromoteremailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formOneRejectMailToArchitect::end"); return email; } public
	 * static EmailNotification formOneUploadMailToArchitect(ProjectAlterationModel
	 * model) { logger.debug("formOneUploadMailToArchitect::start");
	 * EmailNotification email = new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form One Assigment");
	 * email.setSendTo(model.getFormOneModel().getEmailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formOneUploadMailToArchitect to Architect the details  are below: \n\n"
	 * ); sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Promoter Name: ").append(model.getPromoterName()).append(" \n\n");
	 * sb.append("Promoter Emaild: ").append(model.getPromoteremailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formOneUploadMailToArchitect::end"); return email; } public
	 * static EmailNotification
	 * formOneInprogressMailToArchitect(ProjectAlterationModel model) {
	 * logger.debug("formOneInprogressMailToArchitect::start"); EmailNotification
	 * email = new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form One Assigment");
	 * email.setSendTo(model.getFormOneModel().getEmailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formOneInprogressMailToArchitect to Architect the details  are below: \n\n"
	 * ); sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Promoter Name: ").append(model.getPromoterName()).append(" \n\n");
	 * sb.append("Promoter Emaild: ").append(model.getPromoteremailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formOneInprogressMailToArchitect::end"); return email; }
	 * 
	 * public static EmailNotification formOneAssignmentMail(ProjectAlterationModel
	 * model) { logger.debug("formOneAssignmentMail::start"); EmailNotification
	 * email = new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form One Assigment");
	 * email.setSendTo(model.getPromoteremailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("ProjectformOneAssignmentMail to Architect the details of Architech are below: \n\n"
	 * ); sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Architect Name: ").append(model.getFormOneModel().getArchitectName
	 * ()).append(" \n\n");
	 * sb.append("Email Id: ").append(model.getFormOneModel().getEmailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formOneAssignmentMail::end"); return email; }
	 * 
	 * public static EmailNotification formOneRejectMail(ProjectAlterationModel
	 * model) { logger.debug("formOneRejectMail::start"); EmailNotification email =
	 * new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form One Assigment");
	 * email.setSendTo(model.getPromoteremailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formOneRejectMail  the details of Architech are below: \n\n"
	 * ); sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Architect Name: ").append(model.getFormOneModel().getArchitectName
	 * ()).append(" \n\n");
	 * sb.append("Email Id: ").append(model.getFormOneModel().getEmailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString()); logger.debug("formOneRejectMail::end");
	 * return email; }
	 * 
	 * public static EmailNotification formOneUploadMail(ProjectAlterationModel
	 * model) { logger.debug("formOneUploadMail::start"); EmailNotification email =
	 * new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form One Assigment");
	 * email.setSendTo(model.getPromoteremailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formOneUploadMail  the details of Architech are below: \n\n"
	 * ); sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Architect Name: ").append(model.getFormOneModel().getArchitectName
	 * ()).append(" \n\n");
	 * sb.append("Email Id: ").append(model.getFormOneModel().getEmailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString()); logger.debug("formOneUploadMail::end");
	 * return email;
	 * 
	 * }
	 * 
	 * public static EmailNotification formOneInprogressMail(ProjectAlterationModel
	 * model) { logger.debug("formOneInprogressMail::start"); EmailNotification
	 * email = new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form One Assigment");
	 * email.setSendTo(model.getPromoteremailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formOneInprogressMail  the details of Architech are below: \n\n"
	 * ); sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Architect Name: ").append(model.getFormOneModel().getArchitectName
	 * ()).append(" \n\n");
	 * sb.append("Email Id: ").append(model.getFormOneModel().getEmailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formOneInprogressMail::end"); return email;
	 * 
	 * } public static EmailNotification
	 * formTwoAssignmentMailToEngineer(ProjectAlterationModel model) {
	 * logger.debug("formTwoAssignmentMailToEngineer::start"); EmailNotification
	 * email = new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form One Assigment");
	 * email.setSendTo(model.getFormTwoModel().getEmailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formTwoAssignmentMailToEngineer to Engineer the details  are below: \n\n"
	 * ); sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Promoter Name: ").append(model.getPromoterName()).append(" \n\n");
	 * sb.append("Promoter Emaild: ").append(model.getPromoteremailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formTwoAssignmentMailToEngineer::end"); return email; } public
	 * static EmailNotification formTwoRejectMailToEngineer(ProjectAlterationModel
	 * model) { logger.debug("formTwoRejectMailToEngineer::start");
	 * EmailNotification email = new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form One Assigment");
	 * email.setSendTo(model.getFormTwoModel().getEmailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formTwoRejectMailToEngineer to Engineer the details  are below: \n\n"
	 * ); sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Promoter Name: ").append(model.getPromoterName()).append(" \n\n");
	 * sb.append("Promoter Emaild: ").append(model.getPromoteremailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formTwoRejectMailToEngineer::end"); return email; } public
	 * static EmailNotification formTwoUploadMailToEngineer(ProjectAlterationModel
	 * model) { logger.debug("formTwoUploadMailToEngineer::start");
	 * EmailNotification email = new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form One Assigment");
	 * email.setSendTo(model.getFormTwoModel().getEmailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formTwoUploadMailToEngineer to Engineer the details  are below: \n\n"
	 * ); sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Promoter Name: ").append(model.getPromoterName()).append(" \n\n");
	 * sb.append("Promoter Emaild: ").append(model.getPromoteremailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formTwoUploadMailToEngineer::end"); return email; } public
	 * static EmailNotification
	 * formTwoInprogressMailToEngineer(ProjectAlterationModel model) {
	 * logger.debug("formTwoInprogressMailToEngineer::start"); EmailNotification
	 * email = new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form Two Assigment");
	 * email.setSendTo(model.getFormTwoModel().getEmailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formTwoInprogressMailToEngineer to Engineer the details  are below: \n\n"
	 * ); sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Promoter Name: ").append(model.getPromoterName()).append(" \n\n");
	 * sb.append("Promoter Emaild: ").append(model.getPromoteremailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formTwoInprogressMailToEngineer::end"); return email; }
	 * 
	 * public static EmailNotification formTwoAssignmentMail(ProjectAlterationModel
	 * model) { logger.debug("formTwoAssignmentMail::start"); EmailNotification
	 * email = new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form Two Assigment");
	 * email.setSendTo(model.getPromoteremailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formTwoAssignmentMail  the details of Engineer are below: \n\n"
	 * ); sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Engineer Name: ").append(model.getFormTwoModel().getFirstName()).
	 * append(" \n\n");
	 * sb.append("Email Id: ").append(model.getFormOneModel().getEmailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formTwoAssignmentMail::end"); return email;
	 * 
	 * }
	 * 
	 * public static EmailNotification formTwoRejectMail(ProjectAlterationModel
	 * model) { logger.debug("formTwoRejectMail::start"); EmailNotification email =
	 * new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form Two Assigment");
	 * email.setSendTo(model.getPromoteremailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formTwoRejectMail  the details of Engineer are below: \n\n");
	 * sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Engineer Name: ").append(model.getFormTwoModel().getFirstName()).
	 * append(" \n\n");
	 * sb.append("Email Id: ").append(model.getFormOneModel().getEmailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString()); logger.debug("formTwoRejectMail::end");
	 * return email;
	 * 
	 * }
	 * 
	 * public static EmailNotification formTwoUploadMail(ProjectAlterationModel
	 * model) { logger.debug("formTwoUploadMail::start"); EmailNotification email =
	 * new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form TWo Assigment");
	 * email.setSendTo(model.getPromoteremailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formTwoUploadMail  the details of Engineer are below: \n\n");
	 * sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Engineer Name: ").append(model.getFormTwoModel().getFirstName()).
	 * append(" \n\n");
	 * sb.append("Email Id: ").append(model.getFormOneModel().getEmailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString()); logger.debug("formTwoUploadMail::end");
	 * return email;
	 * 
	 * }
	 * 
	 * public static EmailNotification formTwoInprogressMail(ProjectAlterationModel
	 * model) { logger.debug("formTwoInprogressMail::start"); EmailNotification
	 * email = new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form Two Assigment");
	 * email.setSendTo(model.getPromoteremailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formTwoInprogressMail  the details of Engineer are below: \n\n"
	 * ); sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Engineer Name: ").append(model.getFormTwoModel().getFirstName()).
	 * append(" \n\n");
	 * sb.append("Email Id: ").append(model.getFormOneModel().getEmailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formTwoInprogressMail::end"); return email;
	 * 
	 * } public static EmailNotification
	 * formThreeAssignmentMailToCA(ProjectAlterationModel model) {
	 * logger.debug("formThreeAssignmentMailToCA::start"); EmailNotification email =
	 * new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form Three Assigment");
	 * email.setSendTo(model.getFormThreeModel().getEmailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formThreeAssignmentMailToCA to CA the details  are below: \n\n"
	 * ); sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Promoter Name: ").append(model.getPromoterName()).append(" \n\n");
	 * sb.append("Promoter Emaild: ").append(model.getPromoteremailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formThreeAssignmentMailToCA::end"); return email; } public
	 * static EmailNotification formThreeRejectMailToCA(ProjectAlterationModel
	 * model) { logger.debug("formThreeRejectMailToCA::start"); EmailNotification
	 * email = new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form Three Assigment");
	 * email.setSendTo(model.getFormThreeModel().getEmailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formThreeRejectMailToCA to CA the details  are below: \n\n");
	 * sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Promoter Name: ").append(model.getPromoterName()).append(" \n\n");
	 * sb.append("Promoter Emaild: ").append(model.getPromoteremailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formThreeRejectMailToCA::end"); return email; } public static
	 * EmailNotification formThreeUploadMailToCA(ProjectAlterationModel model) {
	 * logger.debug("formThreeUploadMailToCA::start"); EmailNotification email = new
	 * EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form Three Assigment");
	 * email.setSendTo(model.getFormThreeModel().getEmailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formThreeUploadMailToCA to CA the details  are below: \n\n");
	 * sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Promoter Name: ").append(model.getPromoterName()).append(" \n\n");
	 * sb.append("Promoter Emaild: ").append(model.getPromoteremailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formThreeUploadMailToCA::end"); return email; } public static
	 * EmailNotification formThreeInprogressMailToCA(ProjectAlterationModel model) {
	 * logger.debug("formThreeInprogressMailToCA::start"); EmailNotification email =
	 * new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form Three Assigment");
	 * email.setSendTo(model.getFormThreeModel().getEmailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formThreeInprogressMailToCA to CA the details  are below: \n\n"
	 * ); sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("Promoter Name: ").append(model.getPromoterName()).append(" \n\n");
	 * sb.append("Promoter Emaild: ").append(model.getPromoteremailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formThreeInprogressMailToCA::end"); return email; }
	 * 
	 * public static EmailNotification
	 * formThreeAssignmentMail(ProjectAlterationModel model) {
	 * logger.debug("formThreeAssignmentMail::start"); EmailNotification email = new
	 * EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form Three Assigment");
	 * email.setSendTo(model.getPromoteremailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formThreeAssignmentMail  the details of CA are below: \n\n");
	 * sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("CA Name: ").append(model.getFormThreeModel().getFirstName()).
	 * append(" \n\n");
	 * sb.append("Email Id: ").append(model.getFormOneModel().getEmailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formThreeAssignmentMail::end"); return email;
	 * 
	 * }
	 * 
	 * public static EmailNotification formThreeRejectMail(ProjectAlterationModel
	 * model) { logger.debug("formThreeRejectMail::start"); EmailNotification email
	 * = new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form Three Assigment");
	 * email.setSendTo(model.getPromoteremailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n");
	 * sb.append("Project formThreeRejectMail  the details of CA are below: \n\n");
	 * sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("CA Name: ").append(model.getFormThreeModel().getFirstName()).
	 * append(" \n\n");
	 * sb.append("Email Id: ").append(model.getFormOneModel().getEmailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formThreeRejectMail::end"); return email;
	 * 
	 * }
	 * 
	 * public static EmailNotification formThreeUploadMail(ProjectAlterationModel
	 * model) { logger.debug("formThreeUploadMail::start"); EmailNotification email
	 * = new EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form Three Assigment");
	 * email.setSendTo(model.getPromoteremailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n");
	 * sb.append("Project formThreeUploadMail  the details of CA are below: \n\n");
	 * sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("CA Name: ").append(model.getFormThreeModel().getFirstName()).
	 * append(" \n\n");
	 * sb.append("Email Id: ").append(model.getFormOneModel().getEmailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formThreeUploadMail::end"); return email;
	 * 
	 * }
	 * 
	 * public static EmailNotification
	 * formThreeInprogressMail(ProjectAlterationModel model) {
	 * logger.debug("formThreeInprogressMail::Start"); EmailNotification email = new
	 * EmailNotification();
	 * email.setSubject("GujRERA Project Alteration Form Three Assigment");
	 * email.setSendTo(model.getPromoteremailId());
	 * email.setProcessName(ReraConstants.PROJECT_ALT); email.setSendAsOtp("N");
	 * StringBuilder sb = new StringBuilder();
	 * sb.append("Dear ").append(model.getPromoterName()).append("\n\n"); sb.
	 * append("Project formThreeInprogressMail  the details of CA are below: \n\n");
	 * sb.append("Project Name: ").append(model.getProjectDetailModel().
	 * getProjectName()).append(" \n\n");
	 * sb.append("CA Name: ").append(model.getFormThreeModel().getFirstName()).
	 * append(" \n\n");
	 * sb.append("Email Id: ").append(model.getFormOneModel().getEmailId()).
	 * append(" \n\n"); sb.append("Regards: \n").append("Gujarat RERA \n\n\n");
	 * email.setBodyContent(sb.toString());
	 * logger.debug("formThreeInprogressMail::end"); return email;
	 * 
	 * }
	 */
}
