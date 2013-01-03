package com.fnz.pdf;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fnz.VO.CustomerVO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;

import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

public class BillGeneration 
{
	private static String FILE = "c:/temp/FirstPdf.pdf";
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
			Font.BOLD);
	private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.NORMAL, BaseColor.RED);
	private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
			Font.BOLD);
	private static Font bold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
			Font.BOLD);
	private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 8,
			Font.BOLD);
	private static Font smallItalic = new Font(Font.FontFamily.TIMES_ROMAN, 10,
			Font.ITALIC);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			
			DecimalFormat df = new DecimalFormat("#.##");
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");  
			OutputStream file = new FileOutputStream(new File(
					"C:\\FlyAsh\\Test.pdf"));
			Document document = new Document();
			Date date = new Date();
			String companyname = "Abhinay";
			String aL1 = "B/14 Sailishree Vihar";
			String aL2 = "Cuttack";
			String ph = "9999999999";
			String email = "xyz@abc.com";
			Double total = 0.0;
			Double taxAmount = 0.0;
			Double grandTotal = 0.0;
			Integer serial = 1;
			Boolean tax = true;
			LineSeparator objectName = new LineSeparator();
			PdfWriter writer = PdfWriter.getInstance(document, file);
			/*Rectangle art = new Rectangle(50, 50, 545, 792);
			writer.setBoxSize("art", art);
			
			HeaderFooter headerFooter = new HeaderFooter();
			writer.setPageEvent(new TableHeader()); */
			

			BaseFont bf = BaseFont.createFont("c:/windows/fonts/arial.ttf",
					BaseFont.CP1252, BaseFont.EMBEDDED);
			Font font = new Font(bf, 12);
			Font fontBold = new Font(bf, 12, Font.BOLD);
			Font fontItalic = new Font(bf, 12, Font.ITALIC);
			Font fontBoldItalic = new Font(bf, 12, Font.BOLDITALIC);

			document.open();
			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);
			

			// font = FontFactory.getFont(“Times-Roman”);
			// document.add(new Paragraph(“Disclaimer”, font));
			/*
			 * Font fontbold = FontFactory.getFont(“Times-Roman”, 12,
			 * Font.BOLD); document.add(new Paragraph(“Times-Roman, Bold”,
			 * fontbold));
			 */

			Chunk chunk = new Chunk("Disclaimer\n");
			chunk.setFont(fontBold);
			chunk.setUnderline(0.2f, -2f);
			Paragraph paragraph1 = new Paragraph("1.Any purchases of Apple products over the Internet from the ZA Store will be subject to terms and conditions as set by the operating body, ZA Online Store Pty (Ltd).",smallItalic);
			Paragraph paragraph2 = new Paragraph("2.Any purchases of Apple products over the Internet from the ZA Store will be subject to terms and conditions as set by the operating body, ZA Online Store Pty (Ltd).",smallItalic);
			Phrase phraseBottom = new Phrase();
			phraseBottom.add(Chunk.NEWLINE);
			phraseBottom.add(chunk);
			phraseBottom.add(Chunk.NEWLINE);
			phraseBottom.add(paragraph1);
			phraseBottom.add(Chunk.NEWLINE);
			phraseBottom.add(paragraph2);
			phraseBottom.add(Chunk.NEWLINE);
			
			
			String a[][] = new String[19][10];

			for (int i = 0; i < 19; i++)
				for (int j = 0; j < 10; j++)
					a[i][j] = " ";

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 10; j++) {
					if (j % 2 == 0) {
						a[i][j] = "Electromicsaad afasfhahf";
					} else {
						a[i][j] = "1000.12";
					}
				}
			}

			
			float[] colsWidth2 = { 1f, 3f, 1f, 1f, 1f }; // Code 1

			PdfPTable table = new PdfPTable(colsWidth2);
			PdfPCell cell;

			table.setWidthPercentage(90); // Code 2
			table.setHorizontalAlignment(Element.ALIGN_CENTER);// Code 3
			// table.setSpacingAfter(document.getPageSize().getHeight()-table.getTotalHeight()-350);

			if (tax)
			{
				table.setHeaderRows(14);
				table.setFooterRows(5);
			}
			else
			{
				table.setHeaderRows(14);
				table.setFooterRows(6);
			}

			//table.setSplitRows(false);

			

			cell = new PdfPCell(new Phrase(companyname,
					bold));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(PdfPCell.NO_BORDER);
			cell.setColspan(5);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(aL1
					, smallBold));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(PdfPCell.NO_BORDER);
			cell.setColspan(5);
			//cell.setPaddingBottom(20f);
			//cell.setBorderWidth(1f);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(aL2
					+ " – " + "753001", smallBold));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(PdfPCell.NO_BORDER);
			cell.setColspan(5);
			//cell.setPaddingBottom(20f);
			//cell.setBorderWidth(1f);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase("Phone - " + ph+ "     Email - " + email, smallBold));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(PdfPCell.NO_BORDER);
			cell.setColspan(5);
			table.addCell(cell);
			
			cell = new PdfPCell(new Phrase("TIN No : " + "TIN123456789", smallBold));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(PdfPCell.BOTTOM);
			cell.setColspan(5);
			cell.setPaddingBottom(20);
			cell.setBorderWidth(1f);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase("XYZ", smallItalic));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setPaddingTop(10f);
			cell.setBorder(PdfPCell.NO_BORDER);
			cell.setColspan(3);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase("Date - " + format.format(date).toString(), smallItalic));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setPaddingTop(10f);
			cell.setBorder(PdfPCell.NO_BORDER);
			cell.setColspan(2);
			table.addCell(cell);
			
			
			
			cell = new PdfPCell(new Phrase("Street 1,sas", smallItalic));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorder(PdfPCell.NO_BORDER);
			cell.setColspan(3);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase("Order No : " + format.format(date).toString(), smallItalic));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setBorder(PdfPCell.NO_BORDER);
			cell.setColspan(2);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Phrase("8979456454", smallItalic));
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorder(PdfPCell.BOTTOM);
			cell.setPaddingBottom(15f);
			cell.setBorderWidth(1f);
			cell.setColspan(5);
			table.addCell(cell);
			
			
			
			table.getDefaultCell().setColspan(0);
			table.getDefaultCell().setBorder(PdfPCell.NO_BORDER);

			cell = new PdfPCell(new Phrase("Serial", fontItalic));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(PdfPCell.BOTTOM);
			cell.setBorderWidth(1f);
			cell.setPaddingBottom(10f);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Item", fontItalic));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(PdfPCell.BOTTOM);
			cell.setBorderWidth(1f);
			cell.setPaddingBottom(10f);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Unit Price", fontItalic));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(PdfPCell.BOTTOM);
			cell.setBorderWidth(1f);
			cell.setPaddingBottom(10f);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Quantity", fontItalic));
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setBorder(PdfPCell.BOTTOM);
			cell.setBorderWidth(1f);
			cell.setPaddingBottom(10f);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase("Price", fontItalic));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setBorder(PdfPCell.BOTTOM);
			cell.setBorderWidth(1f);
			cell.setPaddingBottom(10f);
			table.addCell(cell);
			
			
			cell = new PdfPCell(new Paragraph("  "));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setBorder(PdfPCell.BOTTOM);
			cell.setBorderWidth(0.5f);
			cell.setPaddingBottom(10f);
			cell.setColspan(5);
			table.addCell(cell);
			
			
			for(int i=0;i<19;i++)
			{
				for(int j=0;j<9;j++)
				{
					if(a[i][++j]!=" ")
					{
						total = total + Double.parseDouble(a[i][j]);
					}
				}
			}
			
			taxAmount = ((Double)(total*0.125));
			grandTotal = Double.parseDouble(df.format(total)) + Double.parseDouble(df.format(taxAmount)); 
			
			cell = new PdfPCell(new Phrase("Total", fontItalic));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setBorder(PdfPCell.BOTTOM);
			//cell.setBorderWidth(1f);
			cell.setColspan(4);
			cell.setPaddingTop(5f);
			cell.setPaddingBottom(5f);
			cell.setPaddingRight(80f);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(df.format(total), fontItalic));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setBorder(PdfPCell.BOTTOM);
			//cell.setBorderWidth(1f);
			cell.setPaddingTop(5f);
			cell.setPaddingBottom(5f);
			cell.setColspan(1);
			table.addCell(cell);
			
			if (tax)
			{
				cell = new PdfPCell(new Phrase("Tax(12.5%)", fontItalic));
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setBorder(PdfPCell.BOTTOM);
				cell.setBorderWidth(1f);
				cell.setColspan(4);
				cell.setPaddingTop(5f);
				cell.setPaddingBottom(5f);
				cell.setPaddingRight(70f);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(df.format(taxAmount), fontItalic));
				cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
				cell.setBorder(PdfPCell.BOTTOM);
				cell.setBorderWidth(1f);
				cell.setPaddingTop(5f);
				cell.setPaddingBottom(5f);
				cell.setColspan(1);
				table.addCell(cell);
			}

			
			
			cell = new PdfPCell(new Phrase("Grand Total", fontBoldItalic));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
			cell.setBorderWidth(1f);
			cell.setPaddingTop(7.5f);
			cell.setPaddingBottom(7.5f);
			cell.setPaddingLeft(20f);
			cell.setPaddingRight(70f);
			cell.setColspan(4);
			table.addCell(cell);

			
			cell = new PdfPCell(new Phrase(df.format(grandTotal), fontBoldItalic));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cell.setBorder(PdfPCell.TOP | PdfPCell.BOTTOM);
			cell.setBorderWidth(1f);
			cell.setPaddingTop(7.5f);
			cell.setPaddingBottom(7.5f);
			cell.setColspan(1);
			table.addCell(cell);

			cell = new PdfPCell(phraseBottom);
			cell.setHorizontalAlignment(Element.ALIGN_LEFT);
			cell.setBorder(PdfPCell.TOP);
			cell.setPaddingTop(7.5f);
			cell.setColspan(5);
			table.addCell(cell);

			table.completeRow();
			table.getDefaultCell().setPaddingTop(5f);
			table.getDefaultCell().setPaddingBottom(5f);

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 9; j++) {
					table.getDefaultCell().setHorizontalAlignment(
							Element.ALIGN_CENTER);
					if(a[i][j] != " ")
					{
						table.addCell((serial++).toString());
					}
					else
					{
						table.addCell(" ");
					}
					table.getDefaultCell().setHorizontalAlignment(
							Element.ALIGN_CENTER);
					table.addCell(a[i][j]);
					if(a[i][j] != " ")
					{
						table.addCell("1000");
						table.addCell("1");
					}
					else
					{
						table.addCell(" ");
						table.addCell(" ");
					}
					table.getDefaultCell().setHorizontalAlignment(
							Element.ALIGN_RIGHT);
					table.addCell(a[i][++j]);
				}
			}

			document.add(table);

			
			
			document.close();
			file.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		if (Desktop.isDesktopSupported()) {
			try {
				File myFile = new File("C:\\FlyAsh\\Test.pdf");
				Desktop.getDesktop().open(myFile);
			} catch (IOException ex) {
				// no application registered for PDFs
			}
		}
	}

}
