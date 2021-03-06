package com.cit.employeeportal.rs;

import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/payslippdf")
public class PayslipPDFServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		try {
			doPost(req, resp);
			System.out.println("Getting in ... ");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException, DocumentException {
		String employeeid = req.getParameter("employee");
		String currentdate = req.getParameter("currentmonth");
		String strCurrentMonth = req.getParameter("strcurrentmonth");

		NumberFormat twodigitconversion = NumberFormat.getInstance();
		twodigitconversion.setMinimumFractionDigits(2);

		float emppfno = 0;

		int count = 0;
		Document document = new Document(PageSize.A4);
		BaseFont base = BaseFont.createFont("http://" + new URL(req.getRequestURL().toString()).getHost() + ":" + req.getLocalPort() + "" + req.getContextPath() + "/resources/font/Verdana.ttf", BaseFont.WINANSI, false);
		Font fontgry12 = new Font(base, 12, Font.BOLD, BaseColor.GRAY);
		Font fontgry10 = new Font(base, 10, Font.BOLD, BaseColor.GRAY);
		Font fontgry8 = new Font(base, 8, Font.BOLD, BaseColor.GRAY);
		Font fontgry6 = new Font(base, 6, Font.BOLD, BaseColor.GRAY);
		Font font12 = new Font(base, 12, Font.BOLD, BaseColor.BLACK);
		Font font10 = new Font(base, 10, Font.NORMAL, BaseColor.BLACK);
		Font font8 = new Font(base, 8, Font.NORMAL, BaseColor.BLACK);
		Font fontbold8 = new Font(base, 8, Font.BOLD, BaseColor.BLACK);
		Font font6 = new Font(base, 6, Font.NORMAL, BaseColor.BLACK);

		try {
			
			
			resp.setContentType("application/pdf");
			resp.setHeader("Content-Disposition", "attachment; filename=\"payslip.pdf\"");
			PdfWriter writer = PdfWriter.getInstance(document, resp.getOutputStream());
			String imageUrl = "http://" + new URL(req.getRequestURL().toString()).getHost() + ":" + req.getLocalPort() + "" + req.getContextPath() + "/resources/images/logo.png";

			PdfPTable logo = new PdfPTable(1);
			logo.setWidthPercentage(100);
			Image image = Image.getInstance(imageUrl);
			image.scaleAbsolute(150f, 35f);
			PdfPCell cell = new PdfPCell(image);
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setVerticalAlignment(Element.ALIGN_TOP);
			cell.setPaddingTop(0);
			cell.setBorder(0);
			logo.addCell(cell);

			PdfPTable header = new PdfPTable(1);
			header.setWidthPercentage(100);
			header.getDefaultCell().setBorder(10);

			PdfPCell headercontent = new PdfPCell(new Paragraph("Payslip for " + strCurrentMonth, font12));
			headercontent.setHorizontalAlignment(Element.ALIGN_CENTER);
			headercontent.setBorder(0);
			headercontent.setPaddingTop(20);
			headercontent.setPaddingBottom(20);
			header.addCell(headercontent);

			PdfPTable payslip = new PdfPTable(6);
			Rectangle rect = new Rectangle(523, 770);
			payslip.setWidthPercentage(new float[] { 131, 10, 120.5f, 131, 10, 120.5f }, rect);

			PdfPCell leftcontentcell_1 = new PdfPCell(new Paragraph("CODE", font8));
			leftcontentcell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			leftcontentcell_1.setPaddingTop(5);
			leftcontentcell_1.setPaddingBottom(5);
			leftcontentcell_1.setPaddingLeft(5);
			leftcontentcell_1.setBorderColor(BaseColor.GRAY);
			leftcontentcell_1.setBorder(Rectangle.LEFT | Rectangle.TOP);
			payslip.addCell(leftcontentcell_1);
			PdfPCell leftcoloncell_1 = new PdfPCell(new Paragraph(":", font8));
			leftcoloncell_1.setHorizontalAlignment(Element.ALIGN_CENTER);
			leftcoloncell_1.setPaddingTop(5);
			leftcoloncell_1.setPaddingBottom(5);
			leftcoloncell_1.setBorderColor(BaseColor.GRAY);
			leftcoloncell_1.setBorder(Rectangle.TOP);
			payslip.addCell(leftcoloncell_1);
			PdfPCell leftcontentcellvalue_1 = new PdfPCell(new Paragraph(String.valueOf("100101"),font8));
			leftcontentcellvalue_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			leftcontentcellvalue_1.setPaddingTop(5);
			leftcontentcellvalue_1.setPaddingBottom(5);
			leftcontentcellvalue_1.setBorderColor(BaseColor.GRAY);
			leftcontentcellvalue_1.setBorder(Rectangle.TOP);
			payslip.addCell(leftcontentcellvalue_1);
			PdfPCell rightcontentcell_1 = new PdfPCell(new Paragraph("BIRTH DATE", font8));
			rightcontentcell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			rightcontentcell_1.setPaddingTop(5);
			rightcontentcell_1.setPaddingBottom(5);
			rightcontentcell_1.setPaddingLeft(5);
			rightcontentcell_1.setBorderColor(BaseColor.GRAY);
			rightcontentcell_1.setBorder(Rectangle.LEFT | Rectangle.TOP);
			payslip.addCell(rightcontentcell_1);
			PdfPCell rightcoloncell_1 = new PdfPCell(new Paragraph(":", font8));
			rightcoloncell_1.setHorizontalAlignment((Element.ALIGN_CENTER));
			rightcoloncell_1.setPaddingTop(5);
			rightcoloncell_1.setPaddingBottom(5);
			rightcoloncell_1.setBorderColor(BaseColor.GRAY);
			rightcoloncell_1.setBorder(Rectangle.TOP);
			payslip.addCell(rightcoloncell_1);
			PdfPCell rightcontentcellvalue_1 = new PdfPCell(new Paragraph("06-06-1989", font8));
			rightcontentcellvalue_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			rightcontentcellvalue_1.setPaddingTop(5);
			rightcontentcellvalue_1.setPaddingBottom(5);
			rightcontentcellvalue_1.setBorderColor(BaseColor.GRAY);
			rightcontentcellvalue_1.setBorder(Rectangle.RIGHT | Rectangle.TOP);
			payslip.addCell(rightcontentcellvalue_1);

			PdfPCell leftcontentcell_2 = new PdfPCell(new Paragraph("NAME", font8));
			leftcontentcell_2.setHorizontalAlignment(Element.ALIGN_LEFT);
			leftcontentcell_2.setPaddingTop(5);
			leftcontentcell_2.setPaddingBottom(5);
			leftcontentcell_2.setPaddingLeft(5);
			leftcontentcell_2.setBorderColor(BaseColor.GRAY);
			leftcontentcell_2.setBorder(Rectangle.LEFT);
			payslip.addCell(leftcontentcell_2);
			PdfPCell leftcoloncell_2 = new PdfPCell(new Paragraph(":", font8));
			leftcoloncell_2.setHorizontalAlignment(Element.ALIGN_CENTER);
			leftcoloncell_2.setPaddingTop(5);
			leftcoloncell_2.setPaddingBottom(5);
			leftcoloncell_2.setBorder(0);
			payslip.addCell(leftcoloncell_2);
			PdfPCell leftcontentcellvalue_2;
			leftcontentcellvalue_2 = new PdfPCell(new Paragraph("Kalaiselvan Velmurugan" , font8));
			leftcontentcellvalue_2.setHorizontalAlignment(Element.ALIGN_LEFT);
			leftcontentcellvalue_2.setPaddingTop(5);
			leftcontentcellvalue_2.setPaddingBottom(5);
			leftcontentcellvalue_2.setBorder(0);
			payslip.addCell(leftcontentcellvalue_2);
			PdfPCell rightcontentcell_2 = new PdfPCell(new Paragraph("JOINING DATE", font8));
			rightcontentcell_2.setHorizontalAlignment(Element.ALIGN_LEFT);
			rightcontentcell_2.setPaddingTop(5);
			rightcontentcell_2.setPaddingBottom(5);
			rightcontentcell_2.setPaddingLeft(5);
			rightcontentcell_2.setBorderColor(BaseColor.GRAY);
			rightcontentcell_2.setBorder(Rectangle.LEFT);
			payslip.addCell(rightcontentcell_2);
			PdfPCell rightcoloncell_2 = new PdfPCell(new Paragraph(":", font8));
			rightcoloncell_2.setHorizontalAlignment(Element.ALIGN_CENTER);
			rightcoloncell_2.setPaddingTop(5);
			rightcoloncell_2.setPaddingBottom(5);
			rightcoloncell_2.setBorder(0);
			payslip.addCell(rightcoloncell_2);
			PdfPCell rightcontentcellvalue_2 = new PdfPCell(new Paragraph("06-06-1989", font8));
			rightcontentcellvalue_2.setHorizontalAlignment(Element.ALIGN_LEFT);
			rightcontentcellvalue_2.setPaddingTop(5);
			rightcontentcellvalue_2.setPaddingBottom(5);
			rightcontentcellvalue_2.setBorderColor(BaseColor.GRAY);
			rightcontentcellvalue_2.setBorder(Rectangle.RIGHT);
			payslip.addCell(rightcontentcellvalue_2);

			PdfPCell leftcontentcell_3 = new PdfPCell(new Paragraph("FATHER NAME", font8));
			leftcontentcell_3.setHorizontalAlignment(Element.ALIGN_LEFT);
			leftcontentcell_3.setPaddingTop(5);
			leftcontentcell_3.setPaddingBottom(5);
			leftcontentcell_3.setPaddingLeft(5);
			leftcontentcell_3.setBorderColor(BaseColor.GRAY);
			leftcontentcell_3.setBorder(Rectangle.LEFT);
			payslip.addCell(leftcontentcell_3);
			PdfPCell leftcoloncell_3 = new PdfPCell(new Paragraph(":", font8));
			leftcoloncell_3.setHorizontalAlignment(Element.ALIGN_CENTER);
			leftcoloncell_3.setPaddingTop(5);
			leftcoloncell_3.setPaddingBottom(5);
			leftcoloncell_3.setBorder(0);
			payslip.addCell(leftcoloncell_3);
			PdfPCell leftcontentcellvalue_3 = new PdfPCell(new Paragraph("Velmurugan Subramanian", font8));
			leftcontentcellvalue_3.setHorizontalAlignment(Element.ALIGN_LEFT);
			leftcontentcellvalue_3.setPaddingTop(5);
			leftcontentcellvalue_3.setPaddingBottom(5);
			leftcontentcellvalue_3.setBorder(0);
			payslip.addCell(leftcontentcellvalue_3);
			PdfPCell rightcontentcell_3 = new PdfPCell(new Paragraph("PAN NO", font8));
			rightcontentcell_3.setHorizontalAlignment(Element.ALIGN_LEFT);
			rightcontentcell_3.setPaddingTop(5);
			rightcontentcell_3.setPaddingBottom(5);
			rightcontentcell_3.setPaddingLeft(5);
			rightcontentcell_3.setBorderColor(BaseColor.GRAY);
			rightcontentcell_3.setBorder(Rectangle.LEFT);
			payslip.addCell(rightcontentcell_3);
			PdfPCell rightcoloncell_3 = new PdfPCell(new Paragraph(":", font8));
			rightcoloncell_3.setHorizontalAlignment((Element.ALIGN_CENTER));
			rightcoloncell_3.setBorder(0);
			rightcoloncell_3.setPaddingTop(5);
			rightcoloncell_3.setPaddingBottom(5);
			payslip.addCell(rightcoloncell_3);
			PdfPCell rightcontentcellvalue_3 = new PdfPCell(new Paragraph("BHFPK5335P", font8));
			rightcontentcellvalue_3.setHorizontalAlignment(Element.ALIGN_LEFT);
			rightcontentcellvalue_3.setBorderColor(BaseColor.GRAY);
			rightcontentcellvalue_3.setBorder(Rectangle.RIGHT);
			rightcontentcellvalue_3.setPaddingTop(5);
			rightcontentcellvalue_3.setPaddingBottom(5);
			payslip.addCell(rightcontentcellvalue_3);

			PdfPCell leftcontentcell_4 = new PdfPCell(new Paragraph("DEPARTMENT", font8));
			leftcontentcell_4.setHorizontalAlignment(Element.ALIGN_LEFT);
			leftcontentcell_4.setPaddingTop(5);
			leftcontentcell_4.setPaddingBottom(5);
			leftcontentcell_4.setPaddingLeft(5);
			leftcontentcell_4.setBorderColor(BaseColor.GRAY);
			leftcontentcell_4.setBorder(Rectangle.LEFT);
			payslip.addCell(leftcontentcell_4);
			PdfPCell leftcoloncell_4 = new PdfPCell(new Paragraph(":", font8));
			leftcoloncell_4.setHorizontalAlignment(Element.ALIGN_CENTER);
			leftcoloncell_4.setPaddingTop(5);
			leftcoloncell_4.setPaddingBottom(5);
			leftcoloncell_4.setBorder(0);
			payslip.addCell(leftcoloncell_4);
			PdfPCell leftcontentcellvalue_4 = new PdfPCell(new Paragraph("Java", font8));
			leftcontentcellvalue_4.setHorizontalAlignment(Element.ALIGN_LEFT);
			leftcontentcellvalue_4.setPaddingTop(5);
			leftcontentcellvalue_4.setPaddingBottom(5);
			leftcontentcellvalue_4.setBorder(0);
			payslip.addCell(leftcontentcellvalue_4);
			PdfPCell rightcontentcell_4 = new PdfPCell(new Paragraph("AADAR CARD NO", font8));
			rightcontentcell_4.setHorizontalAlignment(Element.ALIGN_LEFT);
			rightcontentcell_4.setPaddingTop(5);
			rightcontentcell_4.setPaddingBottom(5);
			rightcontentcell_4.setPaddingLeft(5);
			rightcontentcell_4.setBorderColor(BaseColor.GRAY);
			rightcontentcell_4.setBorder(Rectangle.LEFT);
			payslip.addCell(rightcontentcell_4);
			PdfPCell rightcoloncell_4 = new PdfPCell(new Paragraph(":", font8));
			rightcoloncell_4.setHorizontalAlignment((Element.ALIGN_CENTER));
			rightcoloncell_4.setPaddingTop(5);
			rightcoloncell_4.setPaddingBottom(5);
			rightcoloncell_4.setBorder(0);
			payslip.addCell(rightcoloncell_4);
			PdfPCell rightcontentcellvalue_4 = new PdfPCell(new Paragraph("225544668899", font8));
			rightcontentcellvalue_4.setHorizontalAlignment(Element.ALIGN_LEFT);
			rightcontentcellvalue_4.setPaddingTop(5);
			rightcontentcellvalue_4.setPaddingBottom(5);
			rightcontentcellvalue_4.setBorderColor(BaseColor.GRAY);
			rightcontentcellvalue_4.setBorder(Rectangle.RIGHT);
			payslip.addCell(rightcontentcellvalue_4);

			PdfPCell leftcontentcell_5 = new PdfPCell(new Paragraph("DESIGNATION", font8));
			leftcontentcell_5.setHorizontalAlignment(Element.ALIGN_LEFT);
			leftcontentcell_5.setPaddingTop(5);
			leftcontentcell_5.setPaddingBottom(5);
			leftcontentcell_5.setPaddingLeft(5);
			leftcontentcell_5.setBorderColor(BaseColor.GRAY);
			leftcontentcell_5.setBorder(Rectangle.LEFT);
			payslip.addCell(leftcontentcell_5);
			PdfPCell leftcoloncell_5 = new PdfPCell(new Paragraph(":", font8));
			leftcoloncell_5.setHorizontalAlignment(Element.ALIGN_CENTER);
			leftcoloncell_5.setPaddingTop(5);
			leftcoloncell_5.setPaddingBottom(5);
			leftcoloncell_5.setBorder(0);
			payslip.addCell(leftcoloncell_5);
			PdfPCell leftcontentcellvalue_5 = new PdfPCell(new Paragraph("Senior Software Engineer", font8));
			leftcontentcellvalue_5.setHorizontalAlignment(Element.ALIGN_LEFT);
			leftcontentcellvalue_5.setPaddingTop(5);
			leftcontentcellvalue_5.setPaddingBottom(5);
			leftcontentcellvalue_5.setBorder(0);
			payslip.addCell(leftcontentcellvalue_5);
			PdfPCell rightcontentcell_5 = new PdfPCell(new Paragraph("UAN NO", font8));
			rightcontentcell_5.setHorizontalAlignment(Element.ALIGN_LEFT);
			rightcontentcell_5.setPaddingTop(5);
			rightcontentcell_5.setPaddingBottom(5);
			rightcontentcell_5.setPaddingLeft(5);
			rightcontentcell_5.setBorderColor(BaseColor.GRAY);
			rightcontentcell_5.setBorder(Rectangle.LEFT);
			payslip.addCell(rightcontentcell_5);
			PdfPCell rightcoloncell_5 = new PdfPCell(new Paragraph(":", font8));
			rightcoloncell_5.setHorizontalAlignment((Element.ALIGN_CENTER));
			rightcoloncell_5.setPaddingTop(5);
			rightcoloncell_5.setPaddingBottom(5);
			rightcoloncell_5.setBorder(0);
			payslip.addCell(rightcoloncell_5);
			PdfPCell rightcontentcellvalue_5 = new PdfPCell(new Paragraph("101066663826", font8));
			rightcontentcellvalue_5.setHorizontalAlignment(Element.ALIGN_LEFT);
			rightcontentcellvalue_5.setPaddingTop(5);
			rightcontentcellvalue_5.setPaddingBottom(5);
			rightcontentcellvalue_5.setBorderColor(BaseColor.GRAY);
			rightcontentcellvalue_5.setBorder(Rectangle.RIGHT);
			payslip.addCell(rightcontentcellvalue_5);

			PdfPCell leftcontentcell_6 = new PdfPCell(new Paragraph("BANK NAME", font8));
			leftcontentcell_6.setHorizontalAlignment(Element.ALIGN_LEFT);
			leftcontentcell_6.setPaddingTop(5);
			leftcontentcell_6.setPaddingBottom(5);
			leftcontentcell_6.setPaddingLeft(5);
			leftcontentcell_6.setBorderColor(BaseColor.GRAY);
			leftcontentcell_6.setBorder(Rectangle.LEFT);
			payslip.addCell(leftcontentcell_6);
			PdfPCell leftcoloncell_6 = new PdfPCell(new Paragraph(":", font8));
			leftcoloncell_6.setHorizontalAlignment(Element.ALIGN_CENTER);
			leftcoloncell_6.setPaddingTop(5);
			leftcoloncell_6.setPaddingBottom(5);
			leftcoloncell_6.setBorder(0);
			payslip.addCell(leftcoloncell_6);
			PdfPCell leftcontentcellvalue_6 = new PdfPCell(new Paragraph("ICICI Bank", font8));
			leftcontentcellvalue_6.setHorizontalAlignment(Element.ALIGN_LEFT);
			leftcontentcellvalue_6.setPaddingTop(5);
			leftcontentcellvalue_6.setPaddingBottom(5);
			leftcontentcellvalue_6.setBorder(0);
			payslip.addCell(leftcontentcellvalue_6);
			PdfPCell rightcontentcell_6 = new PdfPCell(new Paragraph("DAYS PAYABLE", font8));
			rightcontentcell_6.setHorizontalAlignment(Element.ALIGN_LEFT);
			rightcontentcell_6.setPaddingTop(5);
			rightcontentcell_6.setPaddingBottom(5);
			rightcontentcell_6.setPaddingLeft(5);
			rightcontentcell_6.setBorderColor(BaseColor.GRAY);
			rightcontentcell_6.setBorder(Rectangle.LEFT);
			payslip.addCell(rightcontentcell_6);
			PdfPCell rightcoloncell_6 = new PdfPCell(new Paragraph(":", font8));
			rightcoloncell_6.setHorizontalAlignment((Element.ALIGN_CENTER));
			rightcoloncell_6.setPaddingTop(5);
			rightcoloncell_6.setPaddingBottom(5);
			rightcoloncell_6.setBorder(0);
			payslip.addCell(rightcoloncell_6);
			PdfPCell rightcontentcellvalue_6 = new PdfPCell(new Paragraph("30", font8));
			rightcontentcellvalue_6.setHorizontalAlignment(Element.ALIGN_LEFT);
			rightcontentcellvalue_6.setPaddingTop(5);
			rightcontentcellvalue_6.setPaddingBottom(5);
			rightcontentcellvalue_6.setBorderColor(BaseColor.GRAY);
			rightcontentcellvalue_6.setBorder(Rectangle.RIGHT);
			payslip.addCell(rightcontentcellvalue_6);

			PdfPCell leftcontentcell_7 = new PdfPCell(new Paragraph("ACCOUNT NO", font8));
			leftcontentcell_7.setHorizontalAlignment(Element.ALIGN_LEFT);
			leftcontentcell_7.setPaddingTop(5);
			leftcontentcell_7.setPaddingBottom(5);
			leftcontentcell_7.setPaddingLeft(5);
			leftcontentcell_7.setBorderColor(BaseColor.GRAY);
			leftcontentcell_7.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
			payslip.addCell(leftcontentcell_7);
			PdfPCell leftcoloncell_7 = new PdfPCell(new Paragraph(":", font8));
			leftcoloncell_7.setHorizontalAlignment(Element.ALIGN_CENTER);
			leftcoloncell_7.setPaddingTop(5);
			leftcoloncell_7.setPaddingBottom(5);
			leftcoloncell_7.setBorderColor(BaseColor.GRAY);
			leftcoloncell_7.setBorder(Rectangle.BOTTOM);
			payslip.addCell(leftcoloncell_7);
			PdfPCell leftcontentcellvalue_7 = new PdfPCell(new Paragraph("", font8));
			leftcontentcellvalue_7.setHorizontalAlignment(Element.ALIGN_LEFT);
			leftcontentcellvalue_7.setPaddingTop(5);
			leftcontentcellvalue_7.setPaddingBottom(5);
			leftcontentcellvalue_7.setBorderColor(BaseColor.GRAY);
			leftcontentcellvalue_7.setBorder(Rectangle.BOTTOM);
			payslip.addCell(leftcontentcellvalue_7);

			PdfPCell rightcontentcell_7 = new PdfPCell(new Paragraph("JOINING LOCATION", font8));
			rightcontentcell_7.setHorizontalAlignment(Element.ALIGN_LEFT);
			rightcontentcell_7.setPaddingTop(5);
			rightcontentcell_7.setPaddingBottom(5);
			rightcontentcell_7.setPaddingLeft(5);
			rightcontentcell_7.setBorderColor(BaseColor.GRAY);
			rightcontentcell_7.setBorder(Rectangle.LEFT | Rectangle.BOTTOM);
			payslip.addCell(rightcontentcell_7);
			PdfPCell rightcoloncell_7 = new PdfPCell(new Paragraph(":", font8));
			rightcoloncell_7.setHorizontalAlignment((Element.ALIGN_CENTER));
			rightcoloncell_7.setPaddingTop(5);
			rightcoloncell_7.setPaddingBottom(5);
			rightcoloncell_7.setBorderColor(BaseColor.GRAY);
			rightcoloncell_7.setBorder(Rectangle.BOTTOM);
			payslip.addCell(rightcoloncell_7);
			PdfPCell rightcontentcellvalue_7 = new PdfPCell(new Paragraph("Chennai", font8));
			rightcontentcellvalue_7.setHorizontalAlignment(Element.ALIGN_LEFT);
			rightcontentcellvalue_7.setPaddingTop(5);
			rightcontentcellvalue_7.setPaddingBottom(5);
			rightcontentcellvalue_7.setBorderColor(BaseColor.GRAY);
			rightcontentcellvalue_7.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT);
			payslip.addCell(rightcontentcellvalue_7);

			PdfPTable headingtbl = new PdfPTable(2);
			headingtbl.setWidthPercentage(100);
			PdfPCell leftheading = new PdfPCell(new Paragraph("EARNINGS (Rs.)", font8));
			leftheading.setHorizontalAlignment(Element.ALIGN_CENTER);
			leftheading.setPaddingTop(5);
			leftheading.setPaddingBottom(5);
			leftheading.setBorderColor(BaseColor.GRAY);
			leftheading.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			headingtbl.addCell(leftheading);

			PdfPCell headingright = new PdfPCell(new Paragraph("DEDUCTION (Rs.)", font8));
			headingright.setHorizontalAlignment(Element.ALIGN_CENTER);
			headingright.setPaddingTop(5);
			headingright.setPaddingBottom(5);
			headingright.setBorderColor(BaseColor.GRAY);
			headingright.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT);
			headingtbl.addCell(headingright);

			PdfPTable payroll = new PdfPTable(4);
			Rectangle rectangle = new Rectangle(523, 770);
			payroll.setWidthPercentage(new float[] { 175, 86.5f, 175, 86.5f }, rectangle);

			PdfPCell description = new PdfPCell(new Paragraph("Description", font8));
			description.setHorizontalAlignment(Element.ALIGN_CENTER);
			description.setPaddingTop(5);
			description.setPaddingBottom(5);
			description.setPaddingLeft(5);
			description.setBorderColor(BaseColor.GRAY);
			description.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			payroll.addCell(description);

			PdfPCell amount = new PdfPCell(new Paragraph("Amount (Rs.)", font8));
			amount.setHorizontalAlignment(Element.ALIGN_CENTER);
			amount.setPaddingTop(5);
			amount.setPaddingBottom(5);
			amount.setBorderColor(BaseColor.GRAY);
			amount.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			payroll.addCell(amount);

			PdfPCell deduction = new PdfPCell(new Paragraph("Description", font8));
			deduction.setHorizontalAlignment(Element.ALIGN_CENTER);
			deduction.setPaddingTop(5);
			deduction.setPaddingBottom(5);
			deduction.setPaddingLeft(5);
			deduction.setBorderColor(BaseColor.GRAY);
			deduction.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			payroll.addCell(deduction);

			PdfPCell deductionamt = new PdfPCell(new Paragraph("Amount (Rs.)", font8));
			deductionamt.setHorizontalAlignment(Element.ALIGN_CENTER);
			deductionamt.setPaddingTop(5);
			deductionamt.setPaddingBottom(5);
			deductionamt.setBorderColor(BaseColor.GRAY);
			deductionamt.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			payroll.addCell(deductionamt);

			PdfPCell payrollbasccell_1 = new PdfPCell(new Paragraph("Basic", font8));
			payrollbasccell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			payrollbasccell_1.setPaddingTop(5);
			payrollbasccell_1.setPaddingBottom(5);
			payrollbasccell_1.setPaddingLeft(5);
			payrollbasccell_1.setBorderColor(BaseColor.GRAY);
			payrollbasccell_1.setBorder(Rectangle.LEFT);
			payroll.addCell(payrollbasccell_1);

			PdfPCell payrollamountcell_1 = new PdfPCell(new Paragraph("", font8));
			payrollamountcell_1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			payrollamountcell_1.setPaddingTop(5);
			payrollamountcell_1.setPaddingBottom(5);
			payrollamountcell_1.setBorderColor(BaseColor.GRAY);
			payrollamountcell_1.setBorder(Rectangle.RIGHT | Rectangle.LEFT);
			payroll.addCell(payrollamountcell_1);

			PdfPCell payrolldesccell_1 = new PdfPCell(new Paragraph("PF", font8));
			payrolldesccell_1.setHorizontalAlignment(Element.ALIGN_LEFT);
			payrolldesccell_1.setPaddingTop(5);
			payrolldesccell_1.setPaddingBottom(5);
			payrolldesccell_1.setPaddingLeft(5);
			payrolldesccell_1.setBorderColor(BaseColor.GRAY);
			payrolldesccell_1.setBorder(Rectangle.LEFT);
			payroll.addCell(payrolldesccell_1);
			PdfPCell payrolldescamtcell_1 = new PdfPCell(new Paragraph(String.valueOf(""), font8));
			payrolldescamtcell_1.setHorizontalAlignment(Element.ALIGN_RIGHT);
			payrolldescamtcell_1.setPaddingTop(5);
			payrolldescamtcell_1.setPaddingBottom(5);
			payrolldescamtcell_1.setBorderColor(BaseColor.GRAY);
			payrolldescamtcell_1.setBorder(Rectangle.RIGHT | Rectangle.LEFT);
			payroll.addCell(payrolldescamtcell_1);

			PdfPCell payrollcell_4 = new PdfPCell(new Paragraph("HRA", font8));
			payrollcell_4.setHorizontalAlignment(Element.ALIGN_LEFT);
			payrollcell_4.setPaddingTop(5);
			payrollcell_4.setPaddingBottom(5);
			payrollcell_4.setPaddingLeft(5);
			payrollcell_4.setBorderColor(BaseColor.GRAY);
			payrollcell_4.setBorder(Rectangle.LEFT);
			payroll.addCell(payrollcell_4);

			PdfPCell payrollamountcell_4 = new PdfPCell(new Paragraph(twodigitconversion.format(""), font8));
			payrollamountcell_4.setHorizontalAlignment(Element.ALIGN_RIGHT);
			payrollamountcell_4.setPaddingTop(5);
			payrollamountcell_4.setPaddingBottom(5);
			payrollamountcell_4.setBorderColor(BaseColor.GRAY);
			payrollamountcell_4.setBorder(Rectangle.RIGHT | Rectangle.LEFT);
			payroll.addCell(payrollamountcell_4);

			PdfPCell payrolldPTcell_2 = new PdfPCell(new Paragraph("PT", font8));
			payrolldPTcell_2.setHorizontalAlignment(Element.ALIGN_LEFT);
			payrolldPTcell_2.setPaddingTop(5);
			payrolldPTcell_2.setPaddingBottom(5);
			payrolldPTcell_2.setPaddingLeft(5);
			payrolldPTcell_2.setBorderColor(BaseColor.GRAY);
			payrolldPTcell_2.setBorder(Rectangle.LEFT);
			payroll.addCell(payrolldPTcell_2);

			PdfPCell payrolldescamtcell_2 = new PdfPCell(new Paragraph("", font8));
			payrolldescamtcell_2.setHorizontalAlignment(Element.ALIGN_RIGHT);
			payrolldescamtcell_2.setPaddingTop(5);
			payrolldescamtcell_2.setPaddingBottom(5);
			payrolldescamtcell_2.setBorderColor(BaseColor.GRAY);
			payrolldescamtcell_2.setBorder(Rectangle.RIGHT | Rectangle.LEFT);
			payroll.addCell(payrolldescamtcell_2);
			
			PdfPCell payrollcell_3 = new PdfPCell(new Paragraph("Con Allowances", font8));
			payrollcell_3.setHorizontalAlignment(Element.ALIGN_LEFT);
			payrollcell_3.setPaddingTop(5);
			payrollcell_3.setPaddingBottom(5);
			payrollcell_3.setPaddingLeft(5);
			payrollcell_3.setBorderColor(BaseColor.GRAY);
			payrollcell_3.setBorder(Rectangle.LEFT);
			payroll.addCell(payrollcell_3);

			PdfPCell payrollamountcell_3 = new PdfPCell(new Paragraph(String.valueOf(twodigitconversion.format("")), font8));
			payrollamountcell_3.setHorizontalAlignment(Element.ALIGN_RIGHT);
			payrollamountcell_3.setPaddingTop(5);
			payrollamountcell_3.setPaddingBottom(5);
			payrollamountcell_3.setBorderColor(BaseColor.GRAY);
			payrollamountcell_3.setBorder(Rectangle.RIGHT | Rectangle.LEFT);
			payroll.addCell(payrollamountcell_3);

			PdfPCell payrolldtdscell_3 = new PdfPCell(new Paragraph("TDS", font8));
			payrolldtdscell_3.setHorizontalAlignment(Element.ALIGN_LEFT);
			payrolldtdscell_3.setPaddingTop(5);
			payrolldtdscell_3.setPaddingBottom(5);
			payrolldtdscell_3.setPaddingLeft(5);
			payrolldtdscell_3.setBorderColor(BaseColor.GRAY);
			payrolldtdscell_3.setBorder(Rectangle.LEFT);
			payroll.addCell(payrolldtdscell_3);
			
			PdfPCell payrolldescamtcell_3 = new PdfPCell(new Paragraph("", font8));
			payrolldescamtcell_3.setHorizontalAlignment(Element.ALIGN_RIGHT);
			payrolldescamtcell_3.setPaddingTop(5);
			payrolldescamtcell_3.setPaddingBottom(5);
			payrolldescamtcell_3.setBorderColor(BaseColor.GRAY);
			payrolldescamtcell_3.setBorder(Rectangle.RIGHT | Rectangle.LEFT);
			payroll.addCell(payrolldescamtcell_3);

			PdfPCell payrollcell_2 = new PdfPCell(new Paragraph("Per Allowances", font8));
			payrollcell_2.setHorizontalAlignment(Element.ALIGN_LEFT);
			payrollcell_2.setPaddingTop(5);
			payrollcell_2.setPaddingBottom(5);
			payrollcell_2.setPaddingLeft(5);
			payrollcell_2.setBorderColor(BaseColor.GRAY);
			payrollcell_2.setBorder(Rectangle.LEFT);
			payroll.addCell(payrollcell_2);

			PdfPCell payrollamountcell_2 = new PdfPCell(new Paragraph(String.valueOf(twodigitconversion.format("")), font8));
			payrollamountcell_2.setHorizontalAlignment(Element.ALIGN_RIGHT);
			payrollamountcell_2.setPaddingTop(5);
			payrollamountcell_2.setPaddingBottom(5);
			payrollamountcell_2.setBorderColor(BaseColor.GRAY);
			payrollamountcell_2.setBorder(Rectangle.RIGHT | Rectangle.LEFT);
			payroll.addCell(payrollamountcell_2);

			PdfPCell payrolldtdscell_4 = new PdfPCell(new Paragraph("Lose of pay", font8));
			payrolldtdscell_4.setHorizontalAlignment(Element.ALIGN_LEFT);
			payrolldtdscell_4.setPaddingTop(5);
			payrolldtdscell_4.setPaddingBottom(5);
			payrolldtdscell_4.setBorderColor(BaseColor.GRAY);
			payrolldtdscell_4.setBorder(Rectangle.LEFT);
			payroll.addCell(payrolldtdscell_4);

			PdfPCell payrolldescamtcell_4 = new PdfPCell(new Paragraph("", font8));
			payrolldescamtcell_4.setHorizontalAlignment(Element.ALIGN_RIGHT);
			payrolldescamtcell_4.setPaddingTop(5);
			payrolldescamtcell_4.setPaddingBottom(5);
			payrolldescamtcell_4.setBorderColor(BaseColor.GRAY);
			payrolldescamtcell_4.setBorder(Rectangle.RIGHT | Rectangle.LEFT);
			payroll.addCell(payrolldescamtcell_4);

			PdfPCell payrollcell_5 = new PdfPCell(new Paragraph("Total Earnings", fontbold8));
			payrollcell_5.setHorizontalAlignment(Element.ALIGN_LEFT);
			payrollcell_5.setPaddingTop(5);
			payrollcell_5.setPaddingBottom(5);
			payrollcell_5.setPaddingLeft(5);
			payrollcell_5.setBorderColor(BaseColor.GRAY);
			payrollcell_5.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			payroll.addCell(payrollcell_5);

			PdfPCell payrollamountcell_5 = new PdfPCell(new Paragraph(twodigitconversion.format(""), fontbold8));
			payrollamountcell_5.setHorizontalAlignment(Element.ALIGN_RIGHT);
			payrollamountcell_5.setPaddingTop(5);
			payrollamountcell_5.setPaddingBottom(5);
			payrollamountcell_5.setBorderColor(BaseColor.GRAY);
			payrollamountcell_5.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			payroll.addCell(payrollamountcell_5);

			PdfPCell payrolldeductioncell_5 = new PdfPCell(new Paragraph("Total Deduction", fontbold8));
			payrolldeductioncell_5.setHorizontalAlignment(Element.ALIGN_LEFT);
			payrolldeductioncell_5.setPaddingTop(5);
			payrolldeductioncell_5.setPaddingBottom(5);
			payrolldeductioncell_5.setPaddingLeft(5);
			payrolldeductioncell_5.setBorderColor(BaseColor.GRAY);
			payrolldeductioncell_5.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			payroll.addCell(payrolldeductioncell_5);

			PdfPCell payrolldeductionamtcell_5 = new PdfPCell(new Paragraph(twodigitconversion.format(""), fontbold8));
			payrolldeductionamtcell_5.setHorizontalAlignment(Element.ALIGN_RIGHT);
			payrolldeductionamtcell_5.setPaddingTop(5);
			payrolldeductionamtcell_5.setPaddingBottom(5);
			payrolldeductionamtcell_5.setBorderColor(BaseColor.GRAY);
			payrolldeductionamtcell_5.setBorder(Rectangle.TOP | Rectangle.BOTTOM | Rectangle.RIGHT | Rectangle.LEFT);
			payroll.addCell(payrolldeductionamtcell_5);

			PdfPCell payrollcell_6 = new PdfPCell(new Paragraph("Net Payable Amount :", fontbold8));
			payrollcell_6.setHorizontalAlignment(Element.ALIGN_LEFT);
			payrollcell_6.setPaddingTop(5);
			payrollcell_6.setPaddingBottom(5);
			payrollcell_6.setPaddingLeft(5);
			payrollcell_6.setBorderColor(BaseColor.GRAY);
			payrollcell_6.setBorder(Rectangle.BOTTOM | Rectangle.LEFT);
			payroll.addCell(payrollcell_6);

			PdfPCell payrollcoloncell_6 = new PdfPCell(new Paragraph(twodigitconversion.format(""), fontbold8));
			payrollcoloncell_6.setHorizontalAlignment(Element.ALIGN_RIGHT);
			payrollcoloncell_6.setPaddingTop(5);
			payrollcoloncell_6.setPaddingBottom(5);
			payrollcoloncell_6.setBorderColor(BaseColor.GRAY);
			payrollcoloncell_6.setBorder(Rectangle.BOTTOM);
			payroll.addCell(payrollcoloncell_6);

			PdfPCell payrollamtcell_6 = new PdfPCell(new Paragraph("", font8));
			payrollamtcell_6.setHorizontalAlignment(Element.ALIGN_CENTER);
			payrollamtcell_6.setPaddingTop(5);
			payrollamtcell_6.setPaddingBottom(5);
			payrollamtcell_6.setBorderColor(BaseColor.GRAY);
			payrollamtcell_6.setBorder(Rectangle.BOTTOM);
			payroll.addCell(payrollamtcell_6);

			PdfPCell payrollempcell_6 = new PdfPCell(new Paragraph("", font8));
			payrollempcell_6.setHorizontalAlignment(Element.ALIGN_LEFT);
			payrollempcell_6.setPaddingTop(5);
			payrollempcell_6.setPaddingBottom(5);
			payrollempcell_6.setBorderColor(BaseColor.GRAY);
			payrollempcell_6.setBorder(Rectangle.BOTTOM | Rectangle.RIGHT);
			payroll.addCell(payrollempcell_6);
			PdfPTable footer = new PdfPTable(1);
			footer.setWidthPercentage(100);
			footer.getDefaultCell().setBorder(10);

			PdfPCell footercontent = new PdfPCell(new Paragraph("This is a computer generated salary slip, so signature is not required", font6));
			footercontent.setHorizontalAlignment(Element.ALIGN_CENTER);
			footercontent.setBorder(0);
			footercontent.setPaddingTop(20);
			footercontent.setPaddingBottom(20);
			footer.addCell(footercontent);

			PdfPTable table = new PdfPTable(1);
			table.setTotalWidth(595);
			PdfPCell cell1 = new PdfPCell(new Phrase("Congruent Info Tect" + " | " + "www.congruentindia.com", fontgry12));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBorder(0);
			cell1.setBorderWidthTop(0.5f);
			cell1.setPaddingTop(3);
			cell1.setBorderColorTop(BaseColor.GRAY);
			table.addCell(cell1);
			cell1 = new PdfPCell(new Phrase("Thiruvanmaiyur"+", "+ "Chennai" + "-" + "600062" +", " + "India", fontgry8));
			cell1.setBorder(0);
			cell1.setPaddingTop(10);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell1);
			cell1 = new PdfPCell(new Phrase("Off: +91 44 " + "585458555" + " | " + "Mob: +91 " + "9942784325" + " | " + "info@congruentindia.com", fontgry8));
			cell1.setPaddingBottom(20);
			cell1.setBorder(0);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell1);

			//PayslipPDFUtil event = new PayslipPDFUtil(table);
			//writer.setPageEvent(event);
			document.open();
			document.add(logo);
			document.add(header);
			document.add(payslip);
			document.add(headingtbl);
			document.add(payroll);
			document.add(footer);
			document.close();
			//}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
