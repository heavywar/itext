package main;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;

import java.io.File;
import java.io.IOException;

public class mirrorMargin {



    public static final String DEST1 = "./fonts/tutorial/TXTtest33322.pdf";

    public static final String DEST = "results/chapter02/canvas_repeat.pdf";
    int x =0;

    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new mirrorMargin().createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {
        PdfDocument srcDoc = new PdfDocument(new PdfReader(DEST1));
        Rectangle rect = srcDoc.getFirstPage().getPageSize();
        System.out.println(rect);
        Rectangle pageSize = new Rectangle(rect.getWidth(), rect.getHeight());

        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        pdfDoc.setDefaultPageSize(new PageSize(pageSize));
        System.out.println(srcDoc.getNumberOfPages());
        PdfCanvas content = new PdfCanvas(pdfDoc.addNewPage());

        // adding the same page 16 times with a different offset
int n = 0;
        for (int i = 1; i < srcDoc.getNumberOfPages(); i++) {
            PdfFormXObject page = srcDoc.getPage(i).copyAsFormXObject(pdfDoc);
            content.clip();
            content.newPath();
            x++;
            if(n%2==0)
                content.addXObject(page,0,0);
                else if(!(n%2==0))
            content.addXObject(page,-36.6929f,0);
                content = new PdfCanvas(pdfDoc.addNewPage());
                n++;

        }
        srcDoc.close();
        pdfDoc.close();
    }

}