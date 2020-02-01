package in.gov.rera.form.five.services.impl;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import in.gov.rera.form.five.common.RestTamplateUtility;
import in.gov.rera.form.five.exception.ResourceNotFoundException;
import in.gov.rera.form.five.model.CAModel;
import in.gov.rera.form.five.model.FormFiveBankDetailsModel;
import in.gov.rera.form.five.model.FormFiveModel;
import in.gov.rera.form.five.model.FormFiveQ10_1Model;
import in.gov.rera.form.five.model.FormFiveQ11_1Model;
import in.gov.rera.form.five.model.FormFiveQ4_1Model;
import in.gov.rera.form.five.model.FormFiveQ5_1Model;
import in.gov.rera.form.five.model.FormFiveQ7_1Model;
import in.gov.rera.form.five.model.FormFiveQ9_1Model;
import in.gov.rera.form.five.model.ProjectRegistrationModel;

@PropertySource(ignoreResourceNotFound = true, value = "classpath:message/common.properties")
public class GenerateFormFivePDF {
	// public static final String IMAGE1 =
	// "../../../../../resources/images/reralogo.jpg";

	@Autowired
	Environment env;

	private static final Logger LOGGER = LogManager.getLogger(GenerateFormFivePDF.class);

	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD);
	private static Font smallNormal = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.NORMAL);

	public static final Font FONT = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, GrayColor.GRAYWHITE);

	private static String contextPath = null;
	 protected static String caLogoPath = null;
	private FormFiveModel formFive;
	private PdfWriter writer;
	private Document document;
	private ProjectRegistrationModel project;
	private CAModel caDtl;
	//private String fontPath;
	private static Long formFiveId;
	public static byte[] caImage;
	// NumberFormat india = NumberFormat.getCurrencyInstance(new Locale("en",
	// "IN"));
	DecimalFormat fmt = new DecimalFormat("##,##,###");

	public GenerateFormFivePDF(FormFiveModel formFive,Long projectRegId,String prjDtlUrl,String caDtlUrl, byte[] bt) throws ResourceNotFoundException {
		this.formFive = formFive;
		//IMAGE1=reraLogoPath;
		//this.caLogoPath=caImage;
		this.caImage=bt;
			this.project = RestTamplateUtility.projectDtl(projectRegId,prjDtlUrl );
			this.caDtl = RestTamplateUtility.caDtl(formFive.getCaNumber(),caDtlUrl );
	}

	public void generateFormFive(HttpServletResponse response) throws Exception {
		// response.setContentType("application/pdf");
		// response.setHeader("Content-Disposition",
		// "attachment;filename=formfivedoc.pdf");
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;filename=" + "Form-5" + ".pdf");
		OutputStream out = response.getOutputStream();
		generatePdf(out);
		out.close();
	}

	public File generateFormFive(Document document2, FormFiveModel formFiveModel) throws Exception {
		LOGGER.debug("generateProjectCertificate()::2:: IS STARTED");
		File pdf = File.createTempFile("certFile", ".pdf");
		LOGGER.debug("generateProjectCertificate()::2::" + pdf);
		OutputStream out = new FileOutputStream(pdf);
		generatePdf(out);
		return pdf;
	}

	public void generatePdf(OutputStream out) throws Exception {
		// fontPath = ProjectCertificateUtil.getContext();
		// LOGGER.debug("generatePdf() STARTED:::"+ fontPath);
		// BaseFont base = BaseFont.createFont(fontPath, BaseFont.WINANSI,true);
		// LOGGER.debug("generatePdf()::::" + base); Font font = new Font(base,13f,
		// Font.BOLD); // , BaseColor.(0,32,96) font.setColor(96, 35, 32);
		LOGGER.debug("static block of ProjectAlterationCertificate is started");
		// ResourceBundle rb = ResourceBundle.getBundle("common.properties");
		// fontPath = env.getProperty("FONT_PATH");
		// caLogoPath = "../../../../../resources/images/reralogo.jpg";
		//IMAGE1 = "../../../../../resources/images/reralogo.jpg";
		// LOGGER.debug("Font path::" + fontPath);
		LOGGER.debug("static block of ProjectAlterationCertificate is ended");

		Font font = new Font(Font.FontFamily.TIMES_ROMAN, 12f, Font.NORMAL);
		Font font2 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

		// new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		Font font3 = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		Font font4 = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
		Font fontUL = new Font(Font.FontFamily.TIMES_ROMAN, 10f, Font.UNDERLINE); // Font font5 = new Font(base, 09f,
																					// Font.NORMAL);
		Font fontQ6 = new Font(Font.FontFamily.TIMES_ROMAN, 11f, Font.ITALIC); // Font font7 = new Font(base,
																				// 09f,Font.BOLD); //
																				// font7.setColor(192,0,0);
		String caFirmName = "___________________";
		String caFirmNo = "_____________________";
		String caDesg = "_______________________";
		boolean isFirmExist = true;
		if (formFive.getCaFrmName() != null && formFive.getCaFrmName().trim().length() > 2) {
			caFirmName = "";
			caFirmName = formFive.getCaFrmName().toString();

		} else {
			isFirmExist = false;
		}
		if (formFive.getCaFrmNo() != null && formFive.getCaFrmNo().trim().length() > 2) {
			caFirmNo = "";
			caFirmNo = formFive.getCaFrmNo().toString();
		}

		if (formFive.getCaFormCapacity() != null && formFive.getCaFormCapacity().trim().length() > 2) {
			caDesg = "";
			caDesg = formFive.getCaFormCapacity().toString();

		} else {
			isFirmExist = false;
		}

		this.document = new Document();
		this.writer = PdfWriter.getInstance(this.document, out);
		this.document.setPageSize(PageSize.A4);
		this.document.setMargins(40, 40, 40, 40);
		this.writer.setPageEvent(new RedBorder());

		this.document.open();

		
		/*
		 * PdfContentByte cb = writer.getDirectContentUnder();
		 * document.add(getWatermarkedImage(cb, Image.getInstance(IMAGE1), "Bruno"));
		 * PdfContentByte canvas1 = writer.getDirectContentUnder();
		 */
		 
		  
	       PdfContentByte canvas1 = writer.getDirectContentUnder();
	     
	        Image image = Image.getInstance(caImage);
	        image.setAbsolutePosition(45f, 730f);
	        image.scaleAbsolute(90, 65);
	        canvas1.saveState();
	        PdfGState state = new PdfGState();
	        canvas1.setGState(state);
	        canvas1.addImage(image);
	        canvas1.restoreState();
		  
		
		/*
		 * PdfContentByte canvas = writer.getDirectContent(); Rectangle rect = new
		 * Rectangle(20, 20, 580, 830); rect.setBorder(Rectangle.BOX);
		 * rect.setBorderColor(new BaseColor(192, 0, 0)); rect.setBorderWidth(5);
		 * canvas.rectangle(rect);
		 */
		 
		 

		String header3 = "To,";
		String header4 = "REGISTRATION CERTIFICATE OF PROJECT";
		String header5 = "[See Rule 6(1)]";

		if (formFive.getCaFrmName() != null && formFive.getCaFrmName().trim().length() > 2
				&& formFive.getCaFrmNo() != null && formFive.getCaFrmNo().trim().length() > 2) {
			addParaRT(caFirmName.toUpperCase() + "(" + formFive.getCaFrmNo().toUpperCase() + ")", font4);

		} else if (formFive.getCaFrmName() != null && formFive.getCaFrmName().trim().length() > 2) {
			addParaRT(caFirmName.toUpperCase(), font4);

		}

		addParaRT(formFive.getCaName().toUpperCase() + "(" + formFive.getCaNumber() + ")", font4);
		
		  if(caDtl.getOfficeTalukaName()!=null){
		  addParaRT(caDtl.getOfficeAddress() + ",\n" +
			caDtl.getOfficeTalukaName() + "," +
			caDtl.getOficeDistictName() + "," +
		  caDtl.getOfficePinCode(), font4); } else {
		  addParaRT(caDtl.getOfficeAddress() + "\n" + "," +
				  caDtl.getOficeDistictName() + "," +
				  caDtl.getOfficePinCode(), font4); } addParaRT("Email: " +
		  caDtl.getEmailId() + ",   Mobile: " +
		  caDtl.getMobileNo(), font4);
		 
		Paragraph pr2 = new Paragraph(" ", font2);
		pr2.setAlignment(Paragraph.ALIGN_CENTER);
		LineSeparator line = new LineSeparator();
		line.setOffset(-2);
		pr2.add(line);
		document.add(pr2);

		addLineBreak();
		LOGGER.debug("generatePdf():::: header ");
		Paragraph pr = new Paragraph("     Form 5   ", font);
		pr.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(pr);

		addParaCenter("[Regulation 4 read with section 4(2)(l)(D)]", font2);
		addParaCenter("ANNUAL REPORT ON STATEMENT OF ACCOUNTS", font2);
		addLineBreak();
		String content = null;
		Paragraph par = addPara(null, "I/We ", font4);

		addPara("To,", font2);

		
		  addPara(this.project.getPromoterName() , font4);
		/*
		 * addPara(this.project.getProjectDetailsModel().get + ", " +
		 * this.project.getPromoterDetailsModel().getAddressLine2(), font4);
		 * 
		 * addPara(this.project.getPromoterDetailsModel().getDistrictModel().
		 * getDistrictName() + ", " +
		 * this.project.getPromoterDetailsModel().getDistrictModel().getStateUtModel().
		 * getStateUtName() + " " +
		 * this.project.getPromoterDetailsModel().getPinCode(),font4);
		 */
		 

		addLineBreak();
		addLineBreak();

		par = addPara(null, "I/We ", font4);

		
		  if (!isFirmExist) { par = addPara(par, formFive.getCaName().toUpperCase(),
		  fontUL);
		  
		  } else {
		 
		
		  par = addPara(par, formFive.getCaName() .toUpperCase() + " " +
		  caDesg.toUpperCase() + " of " + caFirmName.toUpperCase(), fontUL); } par =
		  addPara(par,
		  " the auditor, have examined books of accounts and all the relevant records of "
		  , font4); par = addPara(par,
		  this.project.getPromoterName().toUpperCase(),
		  fontUL); par = addPara(par, " having PAN no. ", font4);
		  //par = addPara(par,this.project.getPromoterDetailsModel().getPanNo(), fontUL);
		  par =
		  addPara(par, " related to ", font4); par = addPara(par,
		  this.project.getProjectDetailsModel().getProjectName().toUpperCase(),
		  fontUL); 
		  //par = addPara(par, " project (RERA registration no. ", font4);
		  //par =		  addPara(par, this.project.getProjRegNo() , fontUL); par =
		  addPara(par, " ) having site address as ", font4);
		  
		  par = addPara(par, this.project.getProjectDetailsModel().getProjectAddress() +
		  ", " + this.project.getProjectDetailsModel().getProjectAddress2() + " " +
		  this.project.getProjectDetailsModel().getDistName() +
		  ", " +
		  this.project.getProjectDetailsModel().getStateName().toUpperCase(), fontUL); par = addPara(par,
		  " for year ending on ", font4); par = addPara(par,
		  formFive.getCertToDate(), fontUL); par = addPara(par, " .", font4);
		 

		document.add(par);

		addPara(content, font4);

		addLineBreak();
		addLineBreak();

		content = "We have conducted our engagement and examination in accordance with the Standards on Auditing, Guidance Note on Reports or Certificates for Special  Purpose "
				+ "and other applicable authoritative pronouncements issued by the Institute of Chartered Accountants of India. We confirm our compliance to all such applicable "
				+ "pronouncements and with the ethical requirements of the Code of Ethics issued by the Institute of Chartered Accountants of India.";
		addPara(content, font4);

		addLineBreak();
		addLineBreak();

		content = " to prepare, produce and maintain all"
				+ " accounting and other relevant supporting records and documents required for the purpose of this certificate. This responsibility includes the design, "
				+ "implementation and maintenance of necessary and appropriate internal control commensurate with the nature and size of entity.";
		par = addPara(null, "It is the primary responsibility of the Management of ", font4);
		 par=addPara(par,this.project.getPromoterName().toUpperCase(),fontUL);
		par = addPara(par, content, font4);
		document.add(par);

		addLineBreak();
		addLineBreak();

		 content = "Period under Certificate: from " +
		 this.formFive.getCertFromDate() + " to " +
		 this.formFive.getCertToDate(); 
		 addPara(content, font3); addLineBreak();

		content = "1. Whether separate RERA Bank Account has been opened as envisaged in Gujarat RERA Bank Account Direction,2019?";
		addPara(content, fontQ6);

		addParaRT(this.formFive.getQuestion_1().toUpperCase(), font3);

		if (this.formFive.getQuestion_1().equalsIgnoreCase("NO")) {
			content = "   1.1.  Whether the existing operational bank account was made known at the time of application for registration as RERA Bank Account?";
			addPara(content, fontQ6);
                
			addParaRT(this.formFive.getQuestion_1_1().toUpperCase(), font3);
		}

		addLineBreak();

		content = "2. Details of RERA Bank Account as registered with Gujarat RERA (mention all the bank accounts if there has been a change in Bank Account registered "
				+ "with RERA)";
		addPara(content, fontQ6);

		addLineBreak();
		PdfPTable table = new PdfPTable(2);
		table.setHeaderRows(0);
		table.setWidthPercentage(91);
		table.spacingBefore();
		table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

		int b = 1;
		for (FormFiveBankDetailsModel bnk : this.formFive.getFormFiveBankList()) {
			table.addCell(createCell("Sr. No.", font3));
			table.addCell(createCell("" + b, font3));
			table.addCell(createCell("Bank Name", font3));
			table.addCell(createCell(bnk.getBankName(), fontQ6));

			table.addCell(createCell("Branch Name", font3));
			table.addCell(createCell(bnk.getBranchName(), fontQ6));

			table.addCell(createCell("Account Name", font3));
			table.addCell(createCell(bnk.getAccountName(), fontQ6));

			table.addCell(createCell("Account Number", font3));
			table.addCell(createCell(bnk.getAccountNumber(), fontQ6));

			table.addCell(createCell("Type of Account", font3));
			table.addCell(createCell(bnk.getAccountType(), fontQ6));

			table.addCell(createCell("IFSC Code", font3));
			table.addCell(createCell(bnk.getIfscCode(), fontQ6));

			table.addCell(createCell("Date of Account Opening", font3));
			table.addCell(createCell(bnk.getDateOfAccountOpening(), fontQ6));

			table.addCell(createCell("Opening Balance Date", font3));
			table.addCell(createCell(String.valueOf(bnk.getFormFiveOpeningBalDate()), fontQ6));

			table.addCell(createCell("Opening Balance ", font3));
			table.addCell(createCell(bnk.getFormFiveOpeningBal().toString(), fontQ6));

			table.addCell(createCell("Deposit during the period ", font3));
			table.addCell(createCell(bnk.getFormFiveDeposit(), fontQ6));

			table.addCell(createCell("Withdrawal during the period ", font3));
			table.addCell(createCell(bnk.getFormFiveWithdrawals(), fontQ6));

			table.addCell(createCell("Closing Balance " + formFive.getCertToDate(), font3));
			table.addCell(createCell(bnk.getFormFiveClosingBal(), fontQ6));

			b++;
		}

		document.add(table);

		addLineBreak();

		content = "3. In case of change in RERA Bank Account as indicated above, whether due approval following prescribed documentation was taken"
				+ " from Gujarat RERA under the Gujarat RERA Bank Account Direction, 2018?";
		addPara(content, fontQ6);

		addParaRT(this.formFive.getQuestion_3().toUpperCase(), font3);

		addLineBreak();

		content = "4. Whether any of the Form 3 issued during the certificate period mandated deposit of 100% of the money collected from the booking of the "
				+ " project units (refer point 5 of Additional Information for Ongoing Project of Form 3)?";
		addPara(content, fontQ6);

		addParaRT(this.formFive.getQuestion_4().toUpperCase(), font3);

		if (this.formFive.getQuestion_4().equalsIgnoreCase("YES")) {

			content = "   4.1. If Yes, please mention the certificate date and name of certifying Chartered Accountant.";
			addPara(content, fontQ6);
			addLineBreak();

			table = new PdfPTable(3);
			table.setWidthPercentage(91);
			table.spacingBefore();
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

			table.addCell(createCell("Sr.No.", font3));
			table.addCell(createCell("CA Name", font3));
			table.addCell(createCell("CA Number", font3));
			table.addCell(createCell("Date of Certificate", font3));

			int x = 1;
			for (FormFiveQ4_1Model md : this.formFive.getFormFiveQ4_1List()) {
				table.addCell(createCell("" + x, fontQ6));
				table.addCell(createCell(md.getCaName(), fontQ6));
				table.addCell(createCell(md.getCaNumber(), fontQ6));
				table.addCell(createCell(md.getDateCertificate(), fontQ6));
				x++;
			}

			document.add(table);

		}
		addLineBreak();

		content = "5. Whether the required proportion of money collected from the allottees of the project units(as indicated in Form 3) deposited in the RERA"
				+ " Bank Account?";
		addPara(content, fontQ6);

		addParaRT(this.formFive.getQuestion_5().toUpperCase(), font3);

		if (this.formFive.getQuestion_5().equalsIgnoreCase("NO")) {

			content = "   5.1. If No, please mention the amount not deposited under the above non-compliance.";
			addPara(content, fontQ6);

			addLineBreak();
			table = new PdfPTable(3);
			table.setWidthPercentage(91);
			table.spacingBefore();
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

			table.addCell(createCell("Sr.No.", font3));
			table.addCell(createCell("Period(DD/MM/YYYY)", font3));
			table.addCell(createCell("Amount not deposited", font3));

			int x = 1;
			for (FormFiveQ5_1Model md : this.formFive.getFormFiveQ5_1List()) {
				table.addCell(createCell("" + x, fontQ6));
				table.addCell(createCell(md.getPeriodFromDate() + "  to  " + md.getPeriodToDate(), fontQ6));
				table.addCell(createCell(md.getAmountNotDeposited() + "", fontQ6));

				x++;
			}

			document.add(table);
		}

		addLineBreak();

		content = "6. Whether the project registration is as New or Ongoing project?";
		addPara(content, fontQ6);

		addParaRT(this.formFive.getQuestion_6().toUpperCase(), font3);

		if (this.formFive.getQuestion_6().equalsIgnoreCase("NEW")) {
			content = "    6.1. In case of New Project Registration, whether there was any booking taken prior to project registration?";
			addPara(content, fontQ6);

			addParaRT(this.formFive.getQuestion_6_1().toUpperCase(), font3);

			if (this.formFive.getQuestion_6_1().equalsIgnoreCase("YES")) {
				content = "    6.2. if Yes, please provide details as below:";
				addPara(content, fontQ6);

				content = "        6.2.1. Number of such units booked :-"
						+ this.formFive.getFormFiveQ6_2Model().getNumberOfBookedUnits();
				addPara(content, fontQ6);

				content = "        6.2.2. Amount collected from such bookings :-"
						+ this.formFive.getFormFiveQ6_2Model().getAmtCollectedBooking();
				addPara(content, fontQ6);

				content = "        6.2.3. Total consideration of such bookings :-"
						+ this.formFive.getFormFiveQ6_2Model().getTotalConsiderBooking();
				addPara(content, fontQ6);

			}

		}

		addLineBreak();

		content = "7. Whether all amounts withdrawn from RERA Bank Account were within the withdrawal limit as certified under the relevant form 3 issued"
				+ " during the reporting period?";
		addPara(content, fontQ6);
		if(this.formFive.getcWithdrawLimit()!=null) {
		addPara("   Cumulative withdrawal limit on 31st March as at Sr. No. 6 of Form-3 (Rs.): "
				+ this.formFive.getcWithdrawLimit(), fontQ6);
		}
		addPara("   Cumulative withdrawal from separate A/C till 31st March (Rs.): "
				+ this.formFive.getcWithdrawSepAc(), fontQ6);
		addParaRT(this.formFive.getQuestion_7().toUpperCase(), font3);

		if (this.formFive.getQuestion_7().equalsIgnoreCase("NO")) {
			content = "    7.1. If No, please provide below details:";
			addPara(content, fontQ6);

			addLineBreak();
			table = new PdfPTable(3);
			table.setWidthPercentage(91);
			table.spacingBefore();
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

			table.addCell(createCell("Sr.No.", font3));
			table.addCell(createCell("Period(DD/MM/YYYY)", font3));
			table.addCell(createCell("Amount of Excess Withdrawals", font3));

			int x = 1;
			for (FormFiveQ7_1Model md : this.formFive.getProjectFormFiveQ7_1List()) {
				table.addCell(createCell("" + x, fontQ6));
				table.addCell(createCell(md.getPeriodFromDate() + "  to  " + md.getPeriodToDate(), fontQ6));
				table.addCell(createCell(md.getExcessWithdrawalAmt() + "", fontQ6));

				x++;
			}

			document.add(table);

		}
		addLineBreak();

		content = "8. Whether any fixed deposit was created out of funds deposited in RERA Account?";
		addPara(content, fontQ6);

		addParaRT(this.formFive.getQuestion_8().toUpperCase(), font3);

		if (this.formFive.getQuestion_8().equalsIgnoreCase("YES")) {
			content = "     8.1.  If Yes, whether the fixed deposit is created with the same RERA account bank branch in compliance with para 5(ii) of Gujarat"
					+ " RERA Bank Account Direction, 2018?";
			addPara(content, fontQ6);
			addParaRT(this.formFive.getQuestion_8_1().toUpperCase(), font3);

			content = "     8.2.  If Yes to 8 above, whether any lien is created on such fixed deposit in violation of para 5(ii) of Gujarat RERA"
					+ " Bank Account Direction, 2018 ?";
			addPara(content, fontQ6);
			addParaRT(this.formFive.getQuestion_8_2().toUpperCase(), font3);

		}

		addLineBreak();

		content = "9. Whether there has been any instance of receipt of consideration in excess of 10% of apartment value without entering into a"
				+ " registered Agreement for Sale?";
		addPara(content, fontQ6);

		addParaRT(this.formFive.getQuestion_9().toUpperCase(), font3);

		if (this.formFive.getQuestion_9().equalsIgnoreCase("YES")) {

			content = "    9.1. If yes, please provide the information as below:";
			addPara(content, font3);
			addLineBreak();

			table = new PdfPTable(4);
			table.setWidthPercentage(91);
			table.spacingBefore();
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

			table.addCell(createCell("Sr.No.", font3));
			table.addCell(createCell("Unit Number", font3));
			table.addCell(createCell("Total Consideration", font3));
			table.addCell(createCell("Amount received in excess of 10% till registered ATS executed", font3));

			int x = 1;
			for (FormFiveQ9_1Model md : this.formFive.getProjectFormFiveQ9_1List()) {
				table.addCell(createCell("" + x, fontQ6));
				table.addCell(createCell(md.getUnitNumber() + "", fontQ6));
				table.addCell(createCell(md.getTotalConsideration() + "", fontQ6));
				table.addCell(createCell(md.getAmtReceivedInExcess() + "", fontQ6));
				x++;
			}
			document.add(table);
		}

		addLineBreak();

		content = "10. Whether the project is executed by availing any loans/borrowing?";
		addPara(content, fontQ6);
		if(this.formFive.getEstimatedCost()!=null) {
		addPara("   Estimated cost of Project (Rs.): " + this.formFive.getEstimatedCost(), fontQ6);
		}
		addParaRT(this.formFive.getQuestion_10().toUpperCase(), font3);

		String formFiveYear="";
		if(this.formFive.getFormFiveYear()!=null)
		{
			int fYear = Integer.parseInt(this.formFive.getFormFiveYear());
			formFiveYear=String.valueOf(fYear-1);
		}
		
	
		
		if (this.formFive.getQuestion_10().equalsIgnoreCase("YES")) {
			content = "     10.1. If yes, please provide details as below:";

			addPara(content, fontQ6);

			table = new PdfPTable(6);
			table.setWidthPercentage(91);
			table.spacingBefore();
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(createCell("Sr.No.", font3));
			table.addCell(createCell("Name & Type of Lender", font3));
			table.addCell(createCell("Amount of Loan Sanction(Rs)", font3));
			table.addCell(createCell("Sanction Date", font3));
			table.addCell(createCell("Loan outstanding as on 31st March "+formFiveYear+" (Rs.)", font3));
			table.addCell(createCell("Collatera/Mortgeage details", font3));
			int x = 1;
			for (FormFiveQ10_1Model md : this.formFive.getProjectFormFiveQ10_1List()) {
				table.addCell(createCell("" + x, fontQ6));
				table.addCell(createCell(md.getLanderNameType() + "", fontQ6));
				table.addCell(createCell(md.getSanctionLoanAmt() + "", fontQ6));
				table.addCell(createCell(md.getSanctionDate() + "", fontQ6));
				table.addCell(createCell(md.getOutStandingLoan() + "", fontQ6));
				table.addCell(createCell(md.getCollateralMortgateDls() + "", fontQ6));
				x++;
			}
			addLineBreak();
			document.add(table);
if(this.formFive.getTotLoanEstCost()!=null) {
			addPara("     Total loan as % of Estimated cost of Project mentioned above: "
					+ this.formFive.getTotLoanEstCost() + "%", fontQ6);
}
			content = "     10.2. Whether the financial encumbrance is reported to Gujarat RERA?";
			addPara(content, fontQ6);

			addParaRT(this.formFive.getQuestion_10_2().toUpperCase(), font3);

			if (this.formFive.getQuestion_10_2().equalsIgnoreCase("YES")) {
				content = "     10.3. If yes to 10.2 above, whether promoter has mortgaged or created a charge on any booked unit?";
				addPara(content, fontQ6);

				addParaRT(this.formFive.getQuestion_10_3().toUpperCase(), font3);

			}

		}

		addLineBreak();

		content = "11. Whether any discrepancy noticed in forms 1, 2 and 3 with reference to their issuance in accordance with the RERA"
				+ " Act, rules and regulations?";
		addPara(content, fontQ6);

		addParaRT(this.formFive.getQuestion_11().toUpperCase(), font3);

		if (this.formFive.getQuestion_11().equalsIgnoreCase("YES")) {

			content = "      11.1.  If yes, please provide the details as below:";
			addPara(content, fontQ6);
			addLineBreak();

			table = new PdfPTable(5);
			table.setWidthPercentage(91);
			table.spacingBefore();
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

			table.addCell(createCell("Sr.No.", font3));
			table.addCell(createCell("Form 1/2/3", font3));

			table.addCell(createCell("Certifying Professional", font3));
			table.addCell(createCell("Date of Issuance", font3));
			table.addCell(createCell("Details of discrepancy", font3));
			int x = 1;
			for (FormFiveQ11_1Model q11 : this.formFive.getProjectFormFiveQ11_1List()) {
				table.addCell(createCell("" + x, fontQ6));

				table.addCell(createCell(q11.getFormTitle(), fontQ6));

				table.addCell(createCell(q11.getCertifyProfessionalForm() + "", fontQ6));
				table.addCell(createCell(q11.getDateOfIssuanceForm() + "", fontQ6));
				table.addCell(createCell(q11.getDetlsOfDescrepanceForm(), fontQ6));
				x++;
			}

			document.add(table);

		}

		addLineBreak();

		content = "12. Please specify any other things which are not covered above.(Maximum 200 words)";
		addPara(content, fontQ6);

		pr = new Paragraph(this.formFive.getQuestion_12(), font4);
		pr.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(pr);

		addLineBreak();
		addLineBreak();

		
		  content =
		  "I/We have obtainted all necessary information and explianation from the Promoter, during the course of our audit, which in my/our"
		  +
		  " opinion are necessary for the purpose of this certificate. Also I/We have attached herewith the copies of Financial Statements"
		  + " and Audit Report of the "
		  +this.project.
		  getPromoterName()+"(Promoter Name) for the financial year ending on"+ formFive
		  .getCertToDate();
		 

		 par = addPara(null, content, font4); par =
		 addPara(par,this.project.getPromoterName().toUpperCase(),fontUL);
		par = addPara(par, "(Promoter Name) for the financial year ending on ", font4);
		 par = addPara(par, formFive.getCertToDate(), fontUL);
		par = addPara(par, " .", font4);
		document.add(par);

		addLineBreak();
		addLineBreak();

		content = "(Project) for the period ended and this certificate is being issued based on the records"
				+ " and documents produced before me and explanations provided to me by the management of the Promoter based on the verfication of books of accounts till "; // +
																																												// formFive.getCertToDateStr();
		par = addPara(null,
				"I/We  hereby confirm that I/We have examined the prescribed registers, books and documents and the relevant records of ",
				font4);
		 par = addPara(par,
		 this.project.getProjectDetailsModel().getProjectName().toUpperCase(),
		 fontUL);
		par = addPara(par, content, font4);
		par = addPara(par, formFive.getCertToDate(), fontUL);
		par = addPara(par, " .", font4);
		document.add(par);

		addLineBreak();
		addLineBreak();

		par = addPara(null,
				"I/We  hereby declare that, I/We or any of us/our associate have not issued RERA Form-3 for any of the projects of ",
				font4);
		 par = addPara(par,this.project.getPromoterName(),
		 fontUL); par =
		addPara(par, " .", font4);
		document.add(par);

		addLineBreak();
		addLineBreak();

		 addPara("Place : " +
		 caDtl.getOficeDistictName() , font4);
		 //addPara("Date : " + in.gov.rera.form.five.common.DateUtil.getDateString(Calendar.getInstance()), font4);

		 addPara("Date : " + in.gov.rera.form.five.common.DateUtil.getDateString(Calendar.getInstance()), font4);
		 
		addParaRT("For,", font4);
		addLineBreak();

		addParaRT("Name Of CA Firm: " + caFirmName, font4);
		addParaRT("Firm Reg. No. : " + caFirmNo, font4);
		 addParaRT("Name of Signature :" +
		 formFive.getCaName().toUpperCase(), font4);
		addParaRT("Designation : " + formFive.getCaDesignation(), font4);
		addParaRT("(Signature and Stamps/Seal of the Signatory CA)", font4);
		 addParaRT("Membership Number: " + formFive.getCaNumber(), font4);
		 addParaRT("UDI Number: " + formFive.getCaUdinNumber(), font4);
		
		  if(caDtl.getOfficeTalukaName() !=null){
		  addParaRT("Full Address: " + caDtl.getOfficeAddress() +
		  ",\n" + caDtl.getOfficeTalukaName() + "," +
		  caDtl.getOficeDistictName() + "," +
		  caDtl.getOfficePinCode(), font4); } else {
		  addParaRT("Full Address: " + caDtl.getOfficeAddress() + "\n"
		  + "," + caDtl.getOfficeStateName()+ "," +
		  caDtl.getOfficePinCode(), font4); }
		  
		  addLineBreak(); addLineBreak(); addPara("Attachments:", font4); addPara(" Balance Sheet : Uploaded", font4); addLineBreak();
		  addPara("  Cash Flows Statement : Uploaded" 
		  , font4); addLineBreak();
		  addPara("  Profit & Loss account : Uploaded", font4); addLineBreak(); 
		  if(this.formFive.getFormFiveOtherDocList().size() > 0) {
		  addPara("Other Attachments:", font4); for (int i = 0; i
		  <this.formFive.getFormFiveOtherDocList().size(); i++) { addPara("  Other Documents : " +
		  formFive.getFormFiveOtherDocList().get(i).getDocName(), font4);
		  }
		  
		  }
		 
		document.close();

		LOGGER.debug("generatePdf() IS ENDED");
	}

	
	   public Image getWatermarkedImage(PdfContentByte cb, Image img, String watermark) throws DocumentException  {
	       
		    float width = img.getScaledWidth();
	        float height = img.getScaledHeight();
	        PdfTemplate template = cb.createTemplate(width, height);
	      
	        template.addImage(img, width, 0, 0, height, 0, 0);
	        ColumnText.showTextAligned(template, Element.ALIGN_CENTER,
	        		new Phrase(watermark, FONT), width / 2, height / 2, 30);
	        return Image.getInstance(template);
	    }
	
	
	private Paragraph addPara(Paragraph pr, String cnt, Font font) throws Exception {
		if (pr == null) {
			pr = new Paragraph();
			pr.setAlignment(Paragraph.ALIGN_LEFT);
		}
		pr.add(new Chunk(cnt, font));
		return pr;

	}

	private void addPara(String cnt, Font font3) throws Exception {

		Paragraph pr = new Paragraph(cnt, font3);
		pr.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(pr);

	}

	private void addParaRT(String cnt, Font font3) throws Exception {
		Paragraph pr = new Paragraph(cnt, font3);
		pr.setAlignment(Paragraph.ALIGN_RIGHT);
		document.add(pr);

	}

	private void addParaCenter(String cnt, Font font3) throws Exception {
		Paragraph pr = new Paragraph(cnt, font3);
		pr.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(pr);

	}

	private PdfPCell createCell(String cnt, Font font3) {
		Paragraph paragraph = new Paragraph();
		paragraph.setAlignment(Paragraph.ALIGN_LEFT);
		paragraph.add(new Chunk(cnt, font3));
		paragraph.setIndentationLeft(25);
		PdfPCell cell = new PdfPCell(paragraph);
		cell.setBorder(Rectangle.BOX);
		return cell;
	}

	private void addLineBreak() throws Exception {
		document.add(Chunk.NEWLINE);

	}
}

  class RedBorder extends PdfPageEventHelper {
  
  @Override public void onStartPage(PdfWriter writer, Document document) { try
  { PdfContentByte canvas1 = writer.getDirectContentUnder(); 
  Image image = Image.getInstance(GenerateFormFivePDF.caImage);
  image.setAbsolutePosition(50f, 180f); 
  image.scaleAbsolute(520, 480);
  canvas1.saveState(); PdfGState state = new PdfGState();
  state.setFillOpacity(0.1f); canvas1.setGState(state);
  canvas1.addImage(image); canvas1.restoreState();
  
  canvas1 = writer.getDirectContent();
  Rectangle rect = new Rectangle(20, 20,
  580, 830); rect.setBorder(Rectangle.BOX); // 
  rect.setBorderColor(new
  BaseColor(192, 0, 0)); rect.setBorderColor(BaseColor.GRAY);
  rect.setBorderWidth(4); canvas1.rectangle(rect);
  
  } catch (Exception ex) { ex.printStackTrace(); } }
  
  }
 
 
