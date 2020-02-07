package in.gov.rera.form.five.common;

import java.util.Date;
public class PaymentTokenNumber {

	public static String SEMINAR_TOKEN_STARTWITH = "SEMI";

	private static long number = 1l;
	public static String uniqeCode() {
		StringBuffer sb = new StringBuffer();
		long l = new Date().getTime();
		while (l > 0) {
			int x = (int) (l % 35);
			l = l / 61;
			sb.append(charCode.charAt(x));
		}
		return sb.toString();
	}


	public static void main(String[] args) {
		PaymentTokenNumber.generateSeminarPayToken();
	}

	private static final String charCode = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	public static String generateSeminarPayToken() {
		StringBuffer sb = new StringBuffer("SEMI");
		sb.append(uniqeCode());
		String str = "" + (number % 1000);
		while (str.length() < 3) {
			str = "0" + str;
		}
		number++;
		sb.append(str);
		System.out.println("Feedback Payment Token No is "+sb.toString());
		return sb.toString();
	}
}
