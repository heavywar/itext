package test;

import com.itextpdf.io.IOException;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;

import java.io.File;

public class ffa1 {
    public static final String SRC = "fonts/tutorial/TXTtest33322.pdf";

    public static final String DEST = "results/chapter05/add_content.pdf";

    public static void main(String args[]) throws IOException, java.io.IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ffa1().manipulatePdf(SRC, DEST);
    }

    public void manipulatePdf(String src, String dest) throws IOException, java.io.IOException {

        //Initialize PDF document
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(src), new PdfWriter(dest));

        Document document = new Document(pdfDoc);
        Rectangle pageSize;
        PdfCanvas canvas;
        int n = pdfDoc.getNumberOfPages();
        for (int i = 1; i <= n; i++) {
            PdfPage page = pdfDoc.getPage(i);
            pageSize = page.getPageSize();
            canvas = new PdfCanvas(page);


            //Draw header text



            //Draw watermark
            canvas.saveState();



            canvas.restoreState();
        }

        pdfDoc.close();

    }
}
