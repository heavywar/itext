package test;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class iyext2 {

    public static final String DEST = "results/objects/change_margin.pdf";
    public static  int anInt = 50;

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new iyext2().createPdf(DEST);
    }



    public void createPdf(String dest) throws IOException, DocumentException {
        StringBuilder builder = new StringBuilder("test");
       // DocListener docListener= new Document();
       // docListener.open();

      //  docListener.setMarginMirroring(true);

        for (int i = 0; i < 1000; i++)
            builder.append("test");
        String test = builder.toString();



        Document document = new Document(PageSize.A4);




        // docListener.setMargins(330, 30, 0, 0);
       // document.addDocListener(docListener);
        PdfWriter.getInstance(document, new FileOutputStream(dest));

        document.open();

document.add(new Paragraph(test));



        document.setMarginMirroring(true);
             document.add(new Paragraph("Starting on the next page, the margins will be mirrored."));        //document.setMarginMirroring(true);

        document.close();
    }
}

