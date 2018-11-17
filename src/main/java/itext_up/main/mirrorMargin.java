package itext_up.main;
//1)Печать четныый(дырки<-) 2)печать четных
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceCmyk;
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
    public static final String DEST1 = "./fonts/tutorial/TXTtest122.pdf";

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
        for (int i =1 ; i <= srcDoc.getNumberOfPages(); i++) {

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
            Color magentaColor = new DeviceCmyk(0.f, 0.f, 0.f, 100.f);
            content.setStrokeColor(magentaColor);
            if(MainPdf.grid) {
                for (double y = 4.251969f; y <= 595; y += 14.1732) {
                    content.moveTo(0, y);
                    content.lineTo(420, y);
                }
                for (double x = 0; x <= 420; x += 14.1732) {
                    content.moveTo(x, 0);
                    content.lineTo(x, 595);
                }
                content.closePathStroke();
            }

        }
        srcDoc.close();
        pdfDoc.close();
    }

}
