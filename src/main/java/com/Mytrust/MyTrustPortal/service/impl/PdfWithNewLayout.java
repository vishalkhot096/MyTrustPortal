package com.Mytrust.MyTrustPortal.service.impl;

import com.Mytrust.MyTrustPortal.entity.CompleteOrganazationDetails;
import com.Mytrust.MyTrustPortal.repo.CompleteOrganazationRepo;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.*;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class PdfWithNewLayout {
//    private static final String SESSION_USER_NAME = "Samuel";
    Document doc;
    ByteArrayOutputStream byteArrayOutputStream;
    PdfWriter pdfWriter;

    BaseFont bf_helv;
    BaseFont bf_times;
    BaseFont bf_courier;
    BaseFont bf_symbol;

    //    Font whiteFont = new Font(Font.TIMES_ROMAN, 12, Font.BOLD, new Color(255, 255, 255));
    Color GREY = new Color(230, 231, 232);
    Color GREEN = new Color(183, 210, 57);
    Color GREY_BG = new Color(245, 246, 247);
    final Font PARAGRAPH_FONT_HEADIN = new Font(Font.TIMES_ROMAN, 18, Font.BOLD, Color.BLACK);
    final Font PARAGRAPH_FONT_KEY = new Font(Font.HELVETICA, 12, Font.BOLD, Color.BLACK);
    final Font PARAGRAPH_FONT_KEY_GREEN = new Font(Font.HELVETICA, 12, Font.BOLD, GREEN);
    final Font PARAGRAPH_FONT_VALUE = new Font(Font.HELVETICA, 12, Font.NORMAL, Color.BLACK);
    final Font PARAGRAPH_FONT_VALUE_GREEN = new Font(Font.HELVETICA, 12, Font.NORMAL, GREEN);

    public PdfWithNewLayout() throws Exception {
//        prepareCardFieldsHM();
        Rectangle layout = new Rectangle(PageSize.A4);
        layout.setBackgroundColor(GREY_BG);
        doc = new Document(layout, 0, 0, 5, 5);
        byteArrayOutputStream = new ByteArrayOutputStream();
        pdfWriter = PdfWriter.getInstance(doc, byteArrayOutputStream);
        initializePdfFonts();

    }

    private void initializePdfFonts() {
        try {
            bf_helv = BaseFont.createFont(BaseFont.HELVETICA, "Cp1252", false);
            bf_times = BaseFont.createFont(BaseFont.TIMES_ROMAN, "Cp1252", false);
            bf_courier = BaseFont.createFont(BaseFont.COURIER, "Cp1252", false);
            bf_symbol = BaseFont.createFont(BaseFont.SYMBOL, "Cp1252", false);

        } catch (Exception e) {
            e.printStackTrace();
//            LOGGER.d("initializePdfFonts() ==> PDF GENERATION EXCEPTION : " + e.getMessage());
        }
    }

    public byte[] generatePdf(String appId, CompleteOrganazationRepo completeOrganazationRepo) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(doc, byteArrayOutputStream);
//        setCompanyLogo();
        doc.open();
        doc.newPage();

        doc.add(new Chunk());

        PdfPTable table=writeConsent(appId,completeOrganazationRepo);
        doc.add(table);

        doc.close();
        writer.close();
        return byteArrayOutputStream.toByteArray();

//        return null;
    }

    private PdfPTable writeConsent(String appId,CompleteOrganazationRepo completeOrganazationRepo) throws IOException {

        CompleteOrganazationDetails completeOrganazationDetails =   completeOrganazationRepo.getCompleteOrganazationDetailsByAppId(appId);
        Font font = new Font(Font.HELVETICA, 12, Font.BOLDITALIC);


        Image image = Image.getInstance("static/Group 97760 (1).png");
        image.scaleAbsolute(300, 200);
        image.setAbsolutePosition(0, 0);

        PdfPTable table=new PdfPTable(1);
        PdfPCell headingCell=setHeadingCell("Consent Form");
        table.addCell(headingCell);

        PdfPTable tableContent=new PdfPTable(2);
        PdfPCell cell=customCell("Application ID",GREY,0,PARAGRAPH_FONT_KEY);
        tableContent.addCell(cell);
        PdfPCell cell1=customCell(appId,GREY,0,PARAGRAPH_FONT_VALUE);
        tableContent.addCell(cell1);

        PdfPCell cell2=customCell("Name",GREY,0,PARAGRAPH_FONT_KEY);
        tableContent.addCell(cell2);
        PdfPCell cell3=customCell(completeOrganazationDetails.getName(),GREY,0,PARAGRAPH_FONT_VALUE);
        tableContent.addCell(cell3);

        PdfPCell cell4=customCell("Country",GREY,0,PARAGRAPH_FONT_KEY);
        tableContent.addCell(cell4);
        PdfPCell cell5=customCell(completeOrganazationDetails.getCountry(),GREY,0,PARAGRAPH_FONT_VALUE);
        tableContent.addCell(cell5);

        PdfPCell cell6=customCell("Email",GREY,0,PARAGRAPH_FONT_KEY);
        tableContent.addCell(cell6);
        PdfPCell cell7=customCell(completeOrganazationDetails.getEmail(),GREY,0,PARAGRAPH_FONT_VALUE);
        tableContent.addCell(cell7);


        PdfPCell cell8=customCell("Mobile Number",GREY,0,PARAGRAPH_FONT_KEY);
        tableContent.addCell(cell8);
        PdfPCell cell9=customCell(completeOrganazationDetails.getMobile_number(),GREY,0,PARAGRAPH_FONT_VALUE);
        tableContent.addCell(cell9);

        PdfPCell cell10=customCell("Pin Number",GREY,0,PARAGRAPH_FONT_KEY);
        tableContent.addCell(cell10);
        PdfPCell cell11=customCell(completeOrganazationDetails.getPinCode(),GREY,0,PARAGRAPH_FONT_VALUE);
        tableContent.addCell(cell11);

        PdfPCell cell12=customCell("Tax Number",GREY,0,PARAGRAPH_FONT_KEY);
        tableContent.addCell(cell12);
        PdfPCell cell13=customCell(completeOrganazationDetails.getTaxNo(),GREY,0,PARAGRAPH_FONT_VALUE);
        tableContent.addCell(cell13);

        //add Board Of Director table
        PdfPTable directorTable=new PdfPTable(1);
        PdfPCell directorHeadingCell=setHeadingCell("Board Of Director");
        directorTable.addCell(directorHeadingCell);

        PdfPTable directorTableFilesname=new PdfPTable(2);
        PdfPCell cell14=customCell("Tax Letter",GREY,0,PARAGRAPH_FONT_KEY);
        directorTableFilesname.addCell(cell14);
        PdfPCell cell115=customCell(completeOrganazationDetails.getTaxFileName(),GREY,0,PARAGRAPH_FONT_VALUE);
        directorTableFilesname.addCell(cell115);

        PdfPCell cell15=customCell("Incorporation Letter",GREY,0,PARAGRAPH_FONT_KEY);
        directorTableFilesname.addCell(cell15);
        PdfPCell cell116=customCell(completeOrganazationDetails.getIncorporationFileName(),GREY,0,PARAGRAPH_FONT_VALUE);
        directorTableFilesname.addCell(cell116);

        PdfPCell cell17=customCell("Additional Document",GREY,0,PARAGRAPH_FONT_KEY);
        directorTableFilesname.addCell(cell17);
        PdfPCell cell118=customCell(completeOrganazationDetails.getAdditionalDocFileName(),GREY,0,PARAGRAPH_FONT_VALUE);
        directorTableFilesname.addCell(cell118);

        PdfPCell cell18=customCell("Additional Document2",GREY,0,PARAGRAPH_FONT_KEY);
        directorTableFilesname.addCell(cell18);
        PdfPCell cell119=customCell(completeOrganazationDetails.getAdditionalDocFileName2(),GREY,0,PARAGRAPH_FONT_VALUE);
        directorTableFilesname.addCell(cell119);

        PdfPCell cell19=customCell("Additional Document3",GREY,0,PARAGRAPH_FONT_KEY);
        directorTableFilesname.addCell(cell19);
        PdfPCell cell120=customCell(completeOrganazationDetails.getAdditionalDocFileName3(),GREY,0,PARAGRAPH_FONT_VALUE);
        directorTableFilesname.addCell(cell120);


        PdfPTable DirectortableHeading = new PdfPTable(4);
        DirectortableHeading.setWidthPercentage(100);
        // setting column widths
        DirectortableHeading.setWidths(new float[] {6.0f, 6.0f, 6.0f, 6.0f});
        PdfPCell Directorcell = new PdfPCell();
        // table headers
        Directorcell.setPhrase(new Phrase(" Name", font));
        DirectortableHeading.addCell(Directorcell);
        Directorcell.setPhrase(new Phrase("Official Email", font));
        DirectortableHeading.addCell(Directorcell);
        Directorcell.setPhrase(new Phrase("Mytrust Email", font));
        DirectortableHeading.addCell(Directorcell);
        Directorcell.setPhrase(new Phrase("Mobile Number", font));
        DirectortableHeading.addCell(Directorcell);
        List<CompleteOrganazationDetails> completeOrganazationDetails1 =   completeOrganazationRepo.getBoardOfDirectoryList(appId);
        for(CompleteOrganazationDetails completeOrganazationDetails2:completeOrganazationDetails1){

            DirectortableHeading.addCell(completeOrganazationDetails2.getDirector_name());
            DirectortableHeading.addCell(completeOrganazationDetails2.getOffice_email());
            DirectortableHeading.addCell(completeOrganazationDetails2.getMytrust_email());
            DirectortableHeading.addCell(completeOrganazationDetails2.getMobile_number());
        }



        //ADD SPOC TABLE
        PdfPTable spocTable=new PdfPTable(1);
        PdfPCell spocHeadingCell=setHeadingCell("SPOC");
        spocTable.addCell(spocHeadingCell);

        PdfPTable SpoctableHeading = new PdfPTable(4);
        DirectortableHeading.setWidthPercentage(100);
        // setting column widths
        SpoctableHeading.setWidths(new float[] {6.0f, 6.0f, 6.0f, 6.0f});
        PdfPCell spocCell = new PdfPCell();
        // table headers
        spocCell.setPhrase(new Phrase(" Name", font));
        SpoctableHeading.addCell(spocCell);
        spocCell.setPhrase(new Phrase("Official Email", font));
        SpoctableHeading.addCell(spocCell);
        spocCell.setPhrase(new Phrase("Mytrust Email", font));
        SpoctableHeading.addCell(spocCell);
        spocCell.setPhrase(new Phrase("Mobile Number", font));
        SpoctableHeading.addCell(spocCell);

        List<CompleteOrganazationDetails> completeOrginationSpoc =   completeOrganazationRepo.getBoardOfDirectoryList(appId);
        for(CompleteOrganazationDetails completeOrganazationdetailsSpoc:completeOrginationSpoc){

            SpoctableHeading.addCell(completeOrganazationdetailsSpoc.getSpocName());
            SpoctableHeading.addCell(completeOrganazationdetailsSpoc.getSpocOfficeEmail());
            SpoctableHeading.addCell(completeOrganazationdetailsSpoc.getSpocMyTrustEmail());
            SpoctableHeading.addCell(completeOrganazationdetailsSpoc.getSpocMobileNumber());
        }

        PdfPTable signatureText=new PdfPTable(1);
        signatureText.setHorizontalAlignment(Element.ALIGN_LEFT);
        String sigText = "Sign here";
        signatureText.addCell(sigText);



        table.addCell(image);
        table.addCell(tableContent);
       table.addCell(directorTable);
        table.addCell(directorTableFilesname);
        table.addCell(DirectortableHeading);
        table.addCell(spocTable);
        table.addCell(SpoctableHeading);
        table.addCell(signatureText);
        return table;
    }
    private PdfPCell customCell(String phrase, Color color,int border,Font font)
    {
//        Font black = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);
        PdfPCell cell = new PdfPCell(new Phrase(phrase,font));
        cell.setBackgroundColor(color);
        cell.setPaddingBottom(5);
        cell.setPaddingLeft(5);
        cell.setBorder(border);
        return cell ;
    }
    private PdfPCell customCell(String phrase, Color color,int border,Font font,int leftPadding)
    {
//        Font black = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);
        PdfPCell cell = new PdfPCell(new Phrase(phrase,font));
        cell.setBackgroundColor(color);
        cell.setPaddingBottom(5);
        cell.setPaddingLeft(leftPadding);
        cell.setBorder(border);
        return cell ;
    }
    private PdfPCell customCell(PdfPTable table, int border)
    {
//        Font black = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);
        PdfPCell cell = new PdfPCell(table);
        cell.setPaddingBottom(5);
        cell.setPaddingLeft(5);
        cell.setBorder(border);
        return cell ;
    }
    private PdfPCell setHeadingCell(String heading){
        Chunk chunk = new Chunk(heading, PARAGRAPH_FONT_HEADIN);
        chunk.setUnderline(GREEN,0.1f,0.2f,-7f,0.1f,PdfContentByte.LINE_CAP_BUTT);
        Paragraph para= new Paragraph();
        para.add(chunk);
        para.setAlignment(Element.ALIGN_CENTER);
        PdfPCell cell=new PdfPCell();
        cell.addElement(para);
        cell.setBorder(0);
//        cell.setBackgroundColor(GREEN);
        cell.setPaddingLeft(5f);
        cell.setPaddingBottom(10f);
        return cell;
    }


}
