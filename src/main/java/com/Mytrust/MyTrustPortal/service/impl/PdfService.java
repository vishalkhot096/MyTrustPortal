package com.Mytrust.MyTrustPortal.service.impl;


import com.Mytrust.MyTrustPortal.entity.CompleteOrganazationDetails;
import com.Mytrust.MyTrustPortal.repo.CompleteOrganazationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;

@Service
public class PdfService {
    @Autowired
    CompleteOrganazationRepo completeOrganazationRepo;

    public void generatePdf(String appID) throws InterruptedException
    {
        try{
            byte[] preview;
            PdfWithNewLayout pdfWithNewLayout = new PdfWithNewLayout();
            preview = pdfWithNewLayout.generatePdf(appID,completeOrganazationRepo);
//            String encoded = Base64Utils.encodeToString(preview);
//            System.out.println("preview==> "+encoded);
            createPdfFromBytes(preview);

        }catch (Exception e){
//            LOGGER.d("generatePdf() : EXP  " + e.getLocalizedMessage());
            e.printStackTrace();
        }


    }
    public void createPdfFromBytes(byte[] pdf)
    {
        try {
            // Create file
            OutputStream out = new FileOutputStream("D:\\vishal_khot\\Java\\MyTrust\\MyTrustPortal\\src\\main\\resources\\static\\Data\\out.pdf");
            out.write(pdf);
            out.close();
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
