package in.gov.rera.form.five.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.DateUtil;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.GrayColor;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

import in.gov.rera.form.five.constants.ReraConstants;
import in.gov.rera.form.five.model.ProjectRegistrationModel;

public class ProjectCertificateUtil {

	// private static final Logger LOGGER =
	// Logger.getLogger(ProjectCertificateUtil.class);

	// public static final String IMAGE1 =
	// "../../../../../resources/images/reralogo.jpg";
	public static final Font FONT = new Font(FontFamily.HELVETICA, 12, Font.NORMAL, GrayColor.GRAYWHITE);
	private static String contextPath = null;
	private static String contextPath1 = null;
	private ProjectRegistrationModel project;
	private PdfWriter writer;
	private Document document;
	// String img =
	// "D:/AJ/CommonWorkspace/reraApp/WebContent/resources/images/RERA_Certificate_Logo.jpg";
	private static String img, fontPath, fontPath1;

	static {
		try {
			ResourceBundle rb = ResourceBundle.getBundle("in.gov.rera.common.config.RERAProperties");
			img = rb.getString("RERA_CERTIFICATE_LOGO_PATH");
			fontPath = rb.getString("FONT_PATH");
			fontPath1 = rb.getString("FONT_PATH_PDF");
			System.out.println("Font path::" + fontPath);
			System.out.println("Certificate path::" + img);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getContext() {
		return contextPath;
	}

	public static void setContext(ServletContext ctx) {
		if (contextPath == null)
			contextPath = ctx.getRealPath(fontPath);

		fontPath = contextPath;
	}

//--------------
	public static String getContext1() {
		return contextPath1;
	}

	public static void setContext1(ServletContext ctx) {
		if (contextPath1 == null)
			contextPath1 = ctx.getRealPath(fontPath1);

		fontPath1 = contextPath1;
	}

//--------------
	public ProjectCertificateUtil(ProjectRegistrationModel project) {
		this.project = project;
	}

	public void generateProjectCertificate(HttpServletResponse response) throws Exception {
		OutputStream out = response.getOutputStream();
		generateCret(out);
		out.close();

	}

	public File generateProjectCertificate() throws Exception {
		File pdf = File.createTempFile("certFile", ".pdf");
		OutputStream out = new FileOutputStream(pdf);
		generateCret(out);
		return pdf;
	}

	Font superNotesFonts;
	Font superNoteFontsSml;
	Font clickhereFont;

	private void generateCret(OutputStream out) throws Exception {

		BaseFont base = BaseFont.createFont(fontPath, BaseFont.WINANSI, true);

		Font font = new Font(base, 13f, Font.BOLD);
		// , BaseColor.(0,32,96)
		font.setColor(192, 0, 0);

		Font font1 = new Font(base, 12f, Font.NORMAL);
		Font font2 = new Font(base, 11f, Font.NORMAL);
		Font font3 = new Font(base, 10f, Font.BOLD);
		font3.setColor(192, 0, 0);
		Font font4 = new Font(base, 11f, Font.BOLD);
		font4.setColor(192, 0, 0);
		Font font5 = new Font(base, 09f, Font.NORMAL);
		font5.setColor(192, 0, 0);
		Font font6 = new Font(base, 10f, Font.NORMAL);
		Font font7 = new Font(base, 09f, Font.BOLD);
		// font7.setColor(192,0,0);
		Font romanListFonts = new Font(base, 08f, Font.NORMAL);
		Font promoterProjectFonts = new Font(base, 10f, Font.NORMAL);
		// Font projectFonts = new Font(base, 10f, Font.NORMAL);
		Font projectProjectFontsBold = new Font(base, 08f, Font.BOLD);
		// Font promoterFontsBold = new Font(base, 09f, Font.BOLD);
		Font superRemarksFonts = new Font(base, 08f, Font.NORMAL);
		Font superRemarksFontsSml = new Font(base, 06f, Font.NORMAL);
		Font romanListBoldFonts = new Font(base, 09f, Font.BOLD);// for (iv)
		Font newfont6 = new Font(base, 11f, Font.NORMAL);// for Date: and Place:
		Font newfontbold = new Font(base, 11f, Font.BOLD);// for Date: and Place:
		superNoteFontsSml = new Font(base, 06f, Font.UNDERLINE);
		superNotesFonts = new Font(base, 08f, Font.UNDERLINE);
		clickhereFont = new Font(base, 08f, Font.UNDERLINE);
		clickhereFont.setColor(BaseColor.BLUE);
		clickhereFont.setStyle(Font.BOLD);

		this.document = new Document();
		this.writer = PdfWriter.getInstance(this.document, out);
		this.document.setPageSize(PageSize.A4);
		this.document.setMargins(40, 40, 40, 40);
		this.document.open();
		/*
		 * PdfContentByte cb = writer.getDirectContentUnder();
		 * document.add(getWatermarkedImage(cb, Image.getInstance(IMAGE1), "Bruno"));
		 */

		Image image1 = Image.getInstance(img);
		image1.setAbsolutePosition(70f, 745f);
		image1.scaleAbsolute(70, 70);

		document.add(image1);

		PdfContentByte canvas1 = writer.getDirectContentUnder();
		Image image = Image.getInstance(img);
		image.setAbsolutePosition(50f, 180f);
		image.scaleAbsolute(510, 490);
		canvas1.saveState();
		PdfGState state = new PdfGState();
		state.setFillOpacity(0.1f);
		canvas1.setGState(state);
		canvas1.addImage(image);
		canvas1.restoreState();

		PdfContentByte canvas = writer.getDirectContent();
		Rectangle rect = new Rectangle(20, 20, 580, 830);
		rect.setBorder(Rectangle.BOX);
		rect.setBorderColor(new BaseColor(192, 0, 0));
		rect.setBorderWidth(5);
		canvas.rectangle(rect);

		String header = "     Gujarat Real Estate Regulatory Authority (RERA)";
		String header1 = "  Government of Gujarat";
		String header2 = "     Website: gujrera.gujarat.gov.in, Email: inforera@gujarat.gov.in";
		String header3 = "FORM - C";
		String header4 = "REGISTRATION CERTIFICATE OF PROJECT";
//		String header5 = "[See Rule 6(1)]";
		String header5 = "[The Gujarat Real Estate (Regulation and Development) (General) Rules, 2017 See Rule 6(1) \"said rules\"]";

		Paragraph pr = new Paragraph(header, font);
		pr.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(pr);
		Paragraph pr1 = new Paragraph(header1, font1);
		pr1.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(pr1);

		Paragraph pr2 = new Paragraph(header2, font2);
		pr2.setAlignment(Paragraph.ALIGN_CENTER);

		// -----
		LineSeparator line = new LineSeparator();
		line.setOffset(-2);
		pr2.add(line);
		document.add(pr2);

		document.add(Chunk.NEWLINE);
		// -----
		Paragraph pr3 = new Paragraph(header3, font3);
		pr3.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(pr3);
		Paragraph pr4 = new Paragraph(header4, font4);
		pr4.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(pr4);
		Paragraph pr5 = new Paragraph(header5, font5);
		pr5.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(pr5);

		document.add(Chunk.NEWLINE);

		PdfContentByte canvas11 = writer.getDirectContent();
		Rectangle rect1 = new Rectangle(60, 620, 550, 635);
		rect1.setBorder(Rectangle.BOX);
		// rect1.setBorderColor(BaseColor.BLUE);
		rect1.setBorderWidth(1);
		canvas11.rectangle(rect1);

		pr = new Paragraph();

//		pr.add(new Chunk("1. This registration is granted under section 5 to the following project under project registration number :-",font6));
		pr.add(new Chunk(
				"1. This registration is granted under section 5 of the Real Estate (Regulation & Development) Act, 2016 \"said act\" to the following Project under project registration number :-",
				font6));
		pr.setAlignment(Paragraph.ALIGN_LEFT);

		document.add(pr);

		Paragraph pr6 = new Paragraph();
		pr6.setAlignment(Paragraph.ALIGN_LEFT);
		// pr6.add(new Chunk(project.getProjectRegistrationNo() + " ", font7));
		pr6.setIndentationLeft(25);
		document.add(pr6);

		document.add(new Chunk(""));

		PdfContentByte canvas2 = writer.getDirectContent();
		Rectangle rect2 = new Rectangle(60, 458, 550, 618);
		rect2.setBorder(Rectangle.BOX);
		// rect1.setBorderColor(BaseColor.BLUE);
		rect2.setBorderWidth(1);
		canvas2.rectangle(rect2);

		PdfPTable table_sig = createProjectAndPromoterDetails(project, document, promoterProjectFonts,
				projectProjectFontsBold, superRemarksFonts, superRemarksFontsSml);
		document.add(table_sig);

		// document.add(Chunk.NEWLINE);
		// document.add(Chunk.NEWLINE);

		pr = new Paragraph();
		pr.add(new Chunk("2.This registration is granted subject to the following conditions, namely:-", font6));
		pr.setAlignment(Paragraph.ALIGN_LEFT);
		document.add(pr);

		pr = new Paragraph();
		pr.add(new Chunk("(i)     ", romanListFonts));
//		pr.add(new Chunk("The promoter shall enter into an agreement for sale with the allottees as prescribed by the appropriate Government. ",romanListFonts));
		pr.add(new Chunk(
				"The promoter shall enter into an agreement for sale with the allottees as prescribed in said rules as per \"Annexure A\" by the Government of Gujarat.",
				romanListFonts));
		pr.setIndentationLeft(20);
		pr.setAlignment(Paragraph.ALIGN_JUSTIFIED);

		document.add(pr);

		pr = new Paragraph();
		pr.add(new Chunk("(ii)    ", romanListFonts));
		pr.add(new Chunk(
				"The promoter shall execute and register a conveyance deed in favour of the allottee or the association of the"
						+ " allottees, as the case may be, of the apartment, plot or building, as the case may be, or the common areas as "
						+ "per section 17 of the said act.",
				romanListFonts));
		pr.setIndentationLeft(20);

		pr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(pr);

		pr = new Paragraph();
		pr.add(new Chunk("(iii)    ", romanListFonts));
		pr.add(new Chunk(
				"The promoter shall deposit seventy percent of the amounts realised by the promoter in a separate account "
						+ "to be maintained in a schedule bank to cover the cost of construction and the land cost to be used only for "
						+ "that purpose as per sub-clause (D) of clause (l) of sub-section (2) of section 4 of the said act. ",
				romanListFonts));
		pr.setIndentationLeft(20);

		pr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(pr);

		// String period=DateUtil.getDateString(project.getApprovedOn());
		// String startDate = DateUtil.getDateString(project
		// .getProjectDetailsModel().getStartDate());
		// String endDate = DateUtil.getDateString(project
		// .getProjectDetailsModel().getCompletionDate());
		// String expiryDate = DateUtil.getDateString(project.getExpireDate());

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		/*
		 * Date sd = dateFormat.parse(dateFormat.format(project.getApprovedOn().getTime
		 * ())); Date ed = dateFormat.parse(dateFormat.format(project.getExpireDate
		 * ().getTime()));
		 */
		Date sd = dateFormat.parse(dateFormat.format(project.getProjectDetailsModel().getStartDate().getTime()));
		Date ed = dateFormat.parse(dateFormat.format(project.getProjectDetailsModel().getCompletionDate().getTime()));
//		String endDt = DateUtil.getDateFromString(endDate);
		/*
		 * pr=new Paragraph(); pr.add(new
		 * Chunk("(iv) The registration shall be valid  for a period of "
		 * +getProjectDuration(sd, ed)+" commencing from Dt."+period+" and ending "+
		 * "with "+expiryDate+
		 * " unless renewed by the Real Estate Regulatory Authority in accordance with section 6 read with rule 7 of the Act:"
		 * + " rules made thereunder.",romanListFonts)); pr.setIndentationLeft(20);
		 * 
		 * pr.setAlignment(Paragraph.ALIGN_JUSTIFIED); document.add(pr);
		 */

		pr = new Paragraph();
		pr.add(new Chunk("(iv)    ", romanListFonts));
		Chunk c1 = new Chunk("The registration shall be valid till Dt. ", romanListBoldFonts);
		/*
		 * Chunk c2 = new Chunk("" + getDateDifferenceInDDMMYYYY(sd, ed),
		 * romanListFonts); c2.setUnderline(0.1f, -2f); Chunk c3 = new
		 * Chunk(" commencing from Dt.", romanListFonts);
		 * 
		 * Chunk c4 = new Chunk(startDate, romanListFonts); c4.setUnderline(0.1f, -2f);
		 * Chunk c5 = new Chunk(" and ending with Dt.", romanListFonts);
		 */
		// Chunk c6 = new Chunk(endDate, romanListBoldFonts);
		// c6.setUnderline(0.1f, -2f);
		Chunk c7 = new Chunk(
				" unless renewed by the Real Estate Regulatory Authority in accordance with section 6 of the said act read with rule 7 of the said rules made thereunder.",
				romanListFonts);

		pr.add(c1);
		/*
		 * pr.add(c2); pr.add(c3); pr.add(c4); pr.add(c5);
		 */
		// pr.add(c6);
		pr.add(c7);

		pr.setIndentationLeft(20);

		pr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(pr);

		pr = new Paragraph();
		pr.add(new Chunk("(v)    ", romanListFonts));
		pr.add(new Chunk(
				"The promoter shall comply with the provisions of the said act and the said rules and regulations made thereunder.",
				romanListFonts));
		pr.setIndentationLeft(20);

		pr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(pr);

		pr = new Paragraph();
		pr.add(new Chunk("(vi)    ", romanListFonts));
		pr.add(new Chunk(
				"The promoter shall not contravene the provisions of any other law for the time being in force as applicable to the project.",
				romanListFonts));
		pr.setIndentationLeft(20);

		pr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(pr);

		pr = new Paragraph();
		pr.add(new Chunk(
				"3. If the above mentioned conditions are not fulfilled by the promoter, the Authority may take necessary action against "
						+ "the promoter including revoking the registration granted herein, as per the said act and the said rules and regulations made "
						+ "thereunder.",
				font6));
		pr.setAlignment(Paragraph.ALIGN_JUSTIFIED);
		document.add(pr);
		document.add(Chunk.NEWLINE);
		/*
		 * pr=new Paragraph( ); document.add(pr); pr=new
		 * Paragraph(" Place:  Gandhinagar"); document.add(pr);
		 */

		/* Added by AJ */
		PdfPTable table = createTable1(project, document, font6, newfont6, newfontbold);
		document.add(table);

		/*
		 * Added by AJ
		 * 
		 * Project Reg Number Project Name Type of Project Project Address1, 2 District
		 * - Pincode Promoter Name Promoter address1, 2 District - Pincode Mobile number
		 * email
		 */

		/*
		 * pr=new Paragraph(); pr.add(new Chunk(" Date:  "+
		 * DateUtil.getDateString(project.getApprovedOn()),font6)); document.add(pr);
		 * pr=new Paragraph(); pr.add(new Chunk(" Place:  Gandhinagar",font6));
		 * document.add(pr);
		 */

		/*
		 * String qrCodeText = "Project Reg.No.: "+project.getProjectRegistrationNo
		 * ()+", Project Name: " +project.getProjectDetailsModel().getProjectName()+","
		 * + " Project Type: " +project.getProjectDetailsModel().getProjectType()+"," +
		 * " Address: "+ project.getProjectDetailsModel().getAddressLine1()+""+project
		 * .getProjectDetailsModel().getAddressLine2()+"," + " District: "+project
		 * .getProjectDetailsModel().getDistrictModel().getDistrictName()+", " +
		 * "Promoter Name: " +project.getPromoterDetailsModel().getPromoterName()+
		 * ", Address: "+project.getPromoterDetailsModel().getAddressLine1()+"" +
		 * ""+project.getPromoterDetailsModel().getAddressLine2()+", " +
		 * " Mobile No.: "+project.getPromoterDetailsModel().getMobileNo()+", " +
		 * " Email Id: "+project.getPromoterDetailsModel().getEmailId();
		 * 
		 * BarcodeQRCode barcodeQRCode = new BarcodeQRCode(qrCodeText, 1000, 1000,
		 * null); Image codeQrImage = barcodeQRCode.getImage();
		 * codeQrImage.scaleAbsolute(100, 100); document.add(codeQrImage);
		 */

		/*
		 * pr=new Paragraph(); pr.add(new
		 * Chunk("Signature and Seal of the Secretary",font6));
		 * pr.setAlignment(Paragraph.ALIGN_RIGHT); document.add(pr);
		 * 
		 * pr=new Paragraph(); pr.add(new
		 * Chunk("Gujarat Real Estate Regulatory Authority",font6));
		 * pr.setAlignment(Paragraph.ALIGN_RIGHT); document.add(pr);
		 */

		/*
		 * pr=new Paragraph(); pr.add(new Chunk("(Digitally Signed)"));
		 * pr.setAlignment(Paragraph.ALIGN_RIGHT); document.add(pr);
		 */

		document.close();

	}

	private PdfPTable createProjectAndPromoterDetails(ProjectRegistrationModel project, Document document,
			Font projectProjectFonts, Font projectProjectFontsBold, Font superRemarksFonts, Font superRemarksFontsSml) {

		PdfPTable table = new PdfPTable(1);
		float minAddressHight = 30f;
		float minRemarkHight = 30f;

		try {
			table.setHeaderRows(0);
			// table.getDefaultCell().setFixedHeight(15);
			table.setWidthPercentage(91);
//			table.spacingBefore();
			// table.getDefaultCell().setFixedHeight(12);
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
			// try {
			// table.setWidths(new int[] { 700 });
			// table.setSpacingAfter(1.0f);
			// } catch (DocumentException ex) {
			// System.out.println(ex.getMessage());
			// }

			Paragraph paragraph = new Paragraph();
			paragraph.setAlignment(Paragraph.ALIGN_LEFT);
			paragraph.add(new Chunk("Project Name & Address :-", projectProjectFonts));
			paragraph.setIndentationLeft(25);

			PdfPCell cell = new PdfPCell(paragraph);
			cell.setBorder(Rectangle.NO_BORDER);
			table.addCell(cell);

			Paragraph pr = new Paragraph();
			pr.setAlignment(Paragraph.ALIGN_LEFT);

			pr.add(new Chunk(project.getProjectDetailsModel().getProjectName().toString(), projectProjectFontsBold));
			pr.setIndentationLeft(25);
			cell = new PdfPCell(pr);
			cell.setBorder(Rectangle.NO_BORDER);
			table.addCell(cell);

			pr = new Paragraph();
			pr.setAlignment(Paragraph.ALIGN_LEFT);
			/*
			 * pr.add(new Chunk(project.getProjectDetailsModel().getAddressLine1() + ", " +
			 * project.getProjectDetailsModel().getAddressLine2() + ", " +
			 * project.getProjectDetailsModel().getSubDistrictModel() .getSubDistrictName()
			 * + ", " + project.getProjectDetailsModel().getDistrictModel()
			 * .getDistrictName() + ", " +
			 * project.getProjectDetailsModel().getDistrictModel()
			 * .getStateUtModel().getStateUtName(), projectProjectFontsBold));
			 */
			pr.setIndentationLeft(25);
			cell = new PdfPCell(pr);
			cell.setRowspan(3);
			cell.setMinimumHeight(minAddressHight);
			cell.setBorder(Rectangle.NO_BORDER);
			table.addCell(cell);

			String sremark = "Remarks:";
			/*
			 * if (project.getSuperRemarks() != null) { // sremark = sremark + getUnicode(
			 * project.getSuperRemarks()) + " "; sremark = sremark +
			 * project.getSuperRemarks() + " "; }
			 * 
			 * LOGGER.debug("Remarkssss:::::"+sremark);
			 */

			int lenthOfRem = sremark.length();
			pr = new Paragraph();
			if (sremark.contains("Note:")) {
				String note = sremark.substring(sremark.indexOf("Note:"));
				sremark = sremark.substring(0, sremark.indexOf("Note:"));
				Chunk chnk = null;
				if (lenthOfRem > 500) {
					pr.add(new Chunk(sremark, superRemarksFontsSml));
					chnk = new Chunk(note, superNoteFontsSml);
					chnk.setLineHeight(12);
				} else {
					pr.add(new Chunk(sremark, superRemarksFonts));
					chnk = new Chunk(note, superNotesFonts);
					chnk.setLineHeight(14);
				}
				/*
				 * Anchor anchor = new Anchor(chnk); anchor.setReference(
				 * "https://gujrera.gujarat.gov.in/viewProjectAffidavitDoc?projectId="+project.
				 * getProjectRegId()); chnk=new Chunk(" [Click Here]", clickhereFont);
				 * 
				 * anchor.add(chnk); chnk.setLineHeight(14); pr.add(anchor);
				 */
				pr.setIndentationLeft(25);
				cell = new PdfPCell(pr);
				cell.setMinimumHeight(minRemarkHight);
				cell.setRowspan(3);
				cell.setBorder(Rectangle.NO_BORDER);
				table.addCell(cell);

			} else {
				if (lenthOfRem > 500) {
					pr.add(new Chunk(sremark, superRemarksFontsSml));
				} else {
					pr.add(new Chunk(sremark, superRemarksFonts));
					minRemarkHight += 4;
				}

				pr.setIndentationLeft(25);
				cell = new PdfPCell(pr);
				cell.setMinimumHeight(minRemarkHight);
				cell.setRowspan(3);
				cell.setBorder(Rectangle.NO_BORDER);
				table.addCell(cell);
			}

			pr = new Paragraph();
			cell = new PdfPCell(pr);
			cell.setRowspan(3);
			cell.setBorder(Rectangle.NO_BORDER);
			table.addCell(cell);

			// Add Promoter Name & Address
			/*
			 * if (project.getRegistrationType().equals( ReraConstants.INDVISUAL_REG)) {
			 * 
			 * pr = new Paragraph(); pr.setAlignment(Paragraph.ALIGN_LEFT); pr.add(new
			 * Chunk("Promoter Name & Address :-", projectProjectFonts));
			 * pr.setIndentationLeft(25); cell = new PdfPCell(pr);
			 * cell.setBorder(Rectangle.NO_BORDER); table.addCell(cell);
			 * 
			 * pr = new Paragraph(); pr.setAlignment(Paragraph.ALIGN_LEFT);
			 * 
			 * pr.add(new Chunk("Mr./Ms. " +
			 * project.getPromoterDetailsModel().getPromoterName() + " son of Mr./Ms. " +
			 * project.getPromoterDetailsModel() .getPromoterIndividualFatherName(),
			 * projectProjectFontsBold));
			 * 
			 * pr.setIndentationLeft(25); cell = new PdfPCell(pr);
			 * cell.setBorder(Rectangle.NO_BORDER); table.addCell(cell);
			 * 
			 * Paragraph pr8 = new Paragraph(); pr8.setAlignment(Paragraph.ALIGN_LEFT);
			 * 
			 * String address = project.getPromoterDetailsModel() .getAddressLine1() + ", "
			 * + project.getPromoterDetailsModel().getAddressLine2() + ", " +
			 * project.getPromoterDetailsModel().getDistrictModel() .getDistrictName() +
			 * ", " + project.getPromoterDetailsModel().getDistrictModel()
			 * .getStateUtModel().getStateUtName();
			 * 
			 * 
			 * 
			 * if (null != project.getPromoterDetailsModel().getPinCode()) { address =
			 * address + "-" + project.getPromoterDetailsModel().getPinCode(); } pr8.add(new
			 * Chunk(address, projectProjectFontsBold));
			 * 
			 * pr8.setIndentationLeft(25); cell = new PdfPCell(pr8);
			 * cell.setMinimumHeight(minAddressHight); cell.setRowspan(3);
			 * cell.setBorder(Rectangle.NO_BORDER); table.addCell(cell); } else { pr = new
			 * Paragraph(); pr.setAlignment(Paragraph.ALIGN_LEFT); pr.add(new
			 * Chunk("Promoter Name & Address :-", projectProjectFonts));
			 * 
			 * pr.setIndentationLeft(25); cell = new PdfPCell(pr);
			 * cell.setBorder(Rectangle.NO_BORDER); table.addCell(cell);
			 * 
			 * pr = new Paragraph(); pr.setAlignment(Paragraph.ALIGN_LEFT); pr.add(new
			 * Chunk( project.getPromoterDetailsModel().getPromoterName() + " " +
			 * project.getPromoterDetailsModel() .getTypeOfPromoter(),
			 * projectProjectFontsBold));
			 * 
			 * pr.setIndentationLeft(25); cell = new PdfPCell(pr);
			 * cell.setBorder(Rectangle.NO_BORDER); table.addCell(cell);
			 * 
			 * Paragraph pr8 = new Paragraph(); pr8.setAlignment(Paragraph.ALIGN_LEFT);
			 * String address = project.getPromoterDetailsModel() .getAddressLine1() + ", "
			 * + project.getPromoterDetailsModel().getAddressLine2() + ", " +
			 * project.getPromoterDetailsModel().getDistrictModel() .getDistrictName() +
			 * ", " + project.getPromoterDetailsModel().getDistrictModel()
			 * .getStateUtModel().getStateUtName();
			 * 
			 * if (null != project.getPromoterDetailsModel().getPinCode()) { address =
			 * address + "-" + project.getPromoterDetailsModel().getPinCode(); } pr8.add(new
			 * Chunk(address, projectProjectFontsBold)); pr8.setIndentationLeft(25);
			 * cell.setRowspan(3);
			 * 
			 * cell = new PdfPCell(pr8); cell.setBorder(Rectangle.NO_BORDER);
			 * cell.setMinimumHeight(minAddressHight); table.addCell(cell); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
		return table;
	}

	private PdfPTable createTable1(ProjectRegistrationModel project, Document document, Font font6, Font newfont6,
			Font newfont_6) {

		PdfPTable table = new PdfPTable(2);
		try {

			table.setWidthPercentage(100);
			table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

			// table.getDefaultCell().setRowspan(2);
			/*
			 * String qrCodeText = project.getProjectRegistrationNo() + ",\n" +
			 * project.getProjectDetailsModel().getProjectName() + ",\n" +
			 * project.getProjectDetailsModel().getProjectType() + ",\n" +
			 * project.getProjectDetailsModel().getAddressLine1() + " " +
			 * project.getProjectDetailsModel().getAddressLine2() + " " +
			 * project.getProjectDetailsModel().getDistrictModel().getDistrictName() + ",\n"
			 * + project.getPromoterDetailsModel().getPromoterName() + ",\n" +
			 * project.getPromoterDetailsModel().getAddressLine1() + " " +
			 * project.getPromoterDetailsModel().getAddressLine2() + " " +
			 * project.getPromoterDetailsModel().getDistrictModel().getDistrictName() + "-"
			 * + project.getPromoterDetailsModel().getPinCode() + ",\n" +
			 * project.getPromoterDetailsModel().getMobileNo() + ",\n" +
			 * project.getPromoterDetailsModel().getEmailId();
			 */

			// BarcodeQRCode barcodeQRCode = new BarcodeQRCode(qrCodeText, 1000, 1000, null);
			//  Image codeQrImage = barcodeQRCode.getImage();
			// codeQrImage.scaleAbsolute(90, 90);
			// document.add(codeQrImage);

			PdfPTable table1 = new PdfPTable(1);
			table1.setWidthPercentage(100);
			table1.getDefaultCell().setBorder(PdfPCell.NO_BORDER);
			Phrase phrase = new Phrase();
			phrase.add(new Chunk(" Date:  ", newfont6));
			// phrase.add(new Chunk(DateUtil.getDateString(project.getApprovedOn()), newfont_6));
			table1.addCell(phrase);
			phrase = new Phrase();
			phrase.add(new Chunk(" Place:  ", newfont6));
			phrase.add(new Chunk("Gandhinagar", newfont_6));
			table1.addCell(phrase);
			document.add(table1);

			// PdfPCell cell = new PdfPCell(codeQrImage);
			/*
			 * cell.setRowspan(2); cell.setBorder(PdfPCell.NO_BORDER); table.addCell(cell);
			 */

			Paragraph paragraph = new Paragraph();
			Chunk c1 = new Chunk(
					"          											                                                     "
							+ "                                                 Signature and Seal of the Secretary",
					font6);
			Chunk c2 = new Chunk("                            Gujarat Real Estate Regulatory Authority", font6);
			paragraph.add(c1);
			paragraph.add(c2);
			paragraph.setIndentationLeft(100);
			PdfPCell cell1 = new PdfPCell(paragraph);
			cell1.setBorder(PdfPCell.NO_BORDER);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);

			/*
			 * phrase = new Phrase(); phrase.add(new
			 * Chunk("Gujarat Real Estate Regulatory Authority",font6)); PdfPCell cell4 =
			 * new PdfPCell(phrase); table.addCell(cell4);
			 */

			// table.addCell("");

			// document.add(codeQrImage);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return table;
	}

	/* Added by AJ */
	public String getProjectDuration(Date oldDate, Date newDate) {

		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		if (newDate.compareTo(oldDate) > 0) {
			System.out.println("newDate.compareTo(oldDate)=========" + oldDate);
			c1.setTime(oldDate);
			c2.setTime(newDate);
		} else {
			System.out.println("invalid");
			return "Invalid selection";
		}
		int year = 0;
		int month = 0;
		int days = 0;
		boolean doneMonth = false;
		boolean doneYears = false;
		while (c1.before(c2)) {
			if (!doneYears) {
				System.out.println("Yearrrr::::" + Calendar.YEAR);
				c1.add(Calendar.YEAR, 1);
				year++;
			}
			if (c1.after(c2) || doneYears) {
				if (!doneYears) {
					doneYears = true;
					year--;
					c1.add(Calendar.YEAR, -1);
				}
				if (!doneMonth) {
					c1.add(Calendar.MONTH, 1);
					month++;
				}
				if (c1.after(c2) || doneMonth) {
					if (!doneMonth) {
						doneMonth = true;
						month--;
						c1.add(Calendar.MONTH, -1);
					}

					c1.add(Calendar.DATE, 3);
					days++;
					if (c1.after(c2)) {
						days--;
					}
					if (days == 31 || month == 12) {
						break;
					}
				}
			}
		}
		System.out.println(year + " years, " + month + " months, " + days + " days");
		return year + " years, " + month + " months, " + days + " days";

	}

	public String dateDiff(Date from, Date to) {
		Calendar birthDay = new GregorianCalendar();
		birthDay.setTime(from);
		Calendar today = new GregorianCalendar();
		today.setTime(to);

		int yearsInBetween = today.get(Calendar.YEAR) - birthDay.get(Calendar.YEAR);
		int monthsDiff = today.get(Calendar.MONTH) - birthDay.get(Calendar.MONTH);
		int dayDiff = today.get(Calendar.DAY_OF_WEEK) - birthDay.get(Calendar.DAY_OF_WEEK);

		System.out.println("ljzxchvklzjxlckjvhlzkjdxfvzkc:::::::::" + monthsDiff + ",," + dayDiff);
		long ageInMonths = yearsInBetween * 12 + monthsDiff;
		long age = yearsInBetween;

		return yearsInBetween + " \tYears\t\t " + monthsDiff + " \tMonths\t\t " + dayDiff + " \tDays";
	}

	public static String getDateDifferenceInDDMMYYYY(Date from, Date to) {
		Calendar fromDate = Calendar.getInstance();
		Calendar toDate = Calendar.getInstance();
		fromDate.setTime(from);
		toDate.setTime(to);
		int increment = 0;
		int year, month, day;
		System.out.println("fromDate:" + fromDate.getActualMaximum(Calendar.DAY_OF_MONTH));
		System.out.println("toDate:" + toDate.getActualMaximum(Calendar.DAY_OF_MONTH));
		if (fromDate.get(Calendar.DAY_OF_MONTH) > toDate.get(Calendar.DAY_OF_MONTH)) {
			increment = fromDate.getActualMaximum(Calendar.DAY_OF_MONTH);
		}
		System.out.println("increment" + increment);
		// DAY CALCULATION
		System.out.println("toDate.get(Calendar.DAY_OF_MONTH):" + toDate.get(Calendar.DAY_OF_MONTH));
		System.out.println("fromDate.get(Calendar.DAY_OF_MONTH):" + fromDate.get(Calendar.DAY_OF_MONTH));
		if (increment != 0) {
			day = (toDate.get(Calendar.DAY_OF_MONTH) + increment) - fromDate.get(Calendar.DAY_OF_MONTH);
			increment = 1;
		} else {
			day = toDate.get(Calendar.DAY_OF_MONTH) - (fromDate.get(Calendar.DAY_OF_MONTH) - 1);
			// increment = 1;
		}
		System.out.println("increment::" + increment);

		// MONTH CALCULATION
		System.out.println("toDate.get(Calendar.MONTH:" + toDate.get(Calendar.MONTH));
		System.out.println("fromDate.get(Calendar.MONTH):" + fromDate.get(Calendar.MONTH));
		if ((fromDate.get(Calendar.MONTH) + increment) > toDate.get(Calendar.MONTH)) {
			month = (toDate.get(Calendar.MONTH) + 12) - (fromDate.get(Calendar.MONTH) + increment);
			increment = 1;
		} else {
			month = (toDate.get(Calendar.MONTH)) - (fromDate.get(Calendar.MONTH) + increment);
			increment = 0;
		}

		// YEAR CALCULATION
		year = toDate.get(Calendar.YEAR) - (fromDate.get(Calendar.YEAR) + increment);
		if (toDate.getActualMaximum(Calendar.DAY_OF_MONTH) == day) {
			day = 0;
			month += 1;
		}
		if (month == 12) {
			month = 0;
			year += 1;
		}
		return year + " \tYears,\t\t " + month + " \tMonths,\t\t " + day + " \tDays";
	}

	/* Added by AJ */

	/*
	 * public static void main(String args[]){
	 * 
	 * getDateDifferenceInDDMMYYYY(new Date(01-07-2017), new Date(30-06-2021)); }
	 * 
	 * private String getUnicode(String commnt){ StringBuffer sb=new
	 * StringBuffer(""); if(commnt!=null){ for(int x=0; x<commnt.length();x++){ char
	 * ch=commnt.charAt(x); if(ch=='+' || ch=='+' || ch=='-'|| ch=='%'|| ch=='/'||
	 * ch=='\\'|| ch=='*'|| ch=='$'|| ch=='@' ){ sb.append(String.format("\\u%04x",
	 * ch)).append(" "); }else{ sb.append(ch); } }
	 * 
	 * }
	 * 
	 * return sb.toString();
	 * 
	 * }
	 */
}
