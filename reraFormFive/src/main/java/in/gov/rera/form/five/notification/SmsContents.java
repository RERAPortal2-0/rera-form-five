package in.gov.rera.form.five.notification;

import in.gov.rera.form.five.constants.ReraConstants;
import in.gov.rera.form.five.model.AuthUserModel;
import in.gov.rera.form.five.model.FormFiveModel;
import in.gov.rera.form.five.model.ProjectFormFiveModel;
import in.gov.rera.form.five.model.SeminarPaymentDetailsModel;

public class SmsContents {

	public static SmsNotification acceptanceSmsToPromoter(ProjectFormFiveModel formFive) {
		SmsNotification sms = new SmsNotification();
		sms.setMobileNo(formFive.getPromoterMobileNo());
		sms.setProcessName(ReraConstants.FORMFIVE);
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(formFive.getPromoterName())
				.append(" Your Project Form Five is accepted. \n GujRERA");
		sms.setMessage(sb.toString());
		return sms;
	}
	
	public static SmsNotification acceptanceSmsToCA(FormFiveModel formFive) {
		SmsNotification sms = new SmsNotification();
		sms.setMobileNo(formFive.getCaMobileNo());
		sms.setProcessName(ReraConstants.FORMFIVE);
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(formFive.getCaName())
				.append(" You have accepted Form Five. \n GujRERA");
		sms.setMessage(sb.toString());
		return sms;
	}

	public static SmsNotification assignSmsToPromoter(ProjectFormFiveModel m) {
		SmsNotification sms = new SmsNotification();
		sms.setMobileNo(m.getPromoterMobileNo());
		sms.setProcessName(ReraConstants.FORMFIVE);
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(m.getPromoterName())
				.append(" Your Project Form Five is assigned. \n GujRERA");
		sms.setMessage(sb.toString());
		return sms;
	}

	public static SmsNotification assignSmsToCA(FormFiveModel formFive) {
		SmsNotification sms = new SmsNotification();
		sms.setMobileNo(formFive.getCaMobileNo());
		sms.setProcessName(ReraConstants.FORMFIVE);
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(formFive.getCaName())
				.append(" Form Five is assigned to you. \n GujRERA");
		sms.setMessage(sb.toString());
		return sms;
	}

	public static SmsNotification submitSmsToPromoter(ProjectFormFiveModel m) {
		SmsNotification sms = new SmsNotification();
		sms.setMobileNo(m.getPromoterMobileNo());
		sms.setProcessName(ReraConstants.FORMFIVE);
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(m.getPromoterName())
				.append(" Your Project Form Five is submitted by CA. \n GujRERA");
		sms.setMessage(sb.toString());
		return sms;
	}

	public static SmsNotification submitSmsToCA(FormFiveModel formFive) {
		SmsNotification sms = new SmsNotification();
		sms.setMobileNo(formFive.getCaMobileNo());
		sms.setProcessName(ReraConstants.FORMFIVE);
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(formFive.getCaName())
				.append(" Form Five is submitted by you. \n GujRERA");
		sms.setMessage(sb.toString());
		return sms;
	}

	public static SmsNotification reAssignSmsToPromoter(ProjectFormFiveModel m) {
		// TODO Auto-generated method stub
		return null;
	}

	public static SmsNotification reAssignSmsToCA(FormFiveModel formFive) {
		// TODO Auto-generated method stub
		return null;
	}

	public static SmsNotification seminarAssignToSms(AuthUserModel m) {
		SmsNotification sms = new SmsNotification();
		sms.setMobileNo(m.getMobile_no());
		sms.setProcessName(ReraConstants.RERA_SEMINAR);
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(m.getUser_name())
				.append(" RERA Seminar is assigned to you. \n GujRERA");
		sms.setMessage(sb.toString());
		return sms;
	}

	public static SmsNotification seminarRegistrationSms(SeminarPaymentDetailsModel paymentModel) {
		SmsNotification sms = new SmsNotification();
		sms.setMobileNo(paymentModel.getMobileNo());
		sms.setProcessName(ReraConstants.RERA_SEMINAR);
		StringBuilder sb = new StringBuilder();
		sb.append("Dear ").append(paymentModel.getUserName())
				.append(" Your regisrtaion is successfull in RERA Seminar \n GujRERA");
		sms.setMessage(sb.toString());
		return sms;
	}
}
