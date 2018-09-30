import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import java.io.File;

public class texta5 {
    public static final String DEST = "./fonts/tutorial/test6.pdf";
    public static final String DEST2 = "./fonts/tutorial/jekyll_hyde_tabs3.pdf";
    public static final String pdfMain = "D:\\pdfMain.pdf";
    public static final String FONT = "D:\\ofont.ru_VoronovFont.ttf";
    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new texta5().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        PageSize ps = PageSize.A5;
        PdfFont font = PdfFontFactory.createFont(FONT, "Cp1251", true);
        Document doc = new Document(pdfDoc, ps);

        Text t = new Text("Привет");
        t.setUnderline(1,3);
        Paragraph p = new Paragraph(t);
        p.isKeepTogether();
        Paragraph p1 = new Paragraph("Нормально");
        doc.add(p1.setFont(font));
        doc.add(p.setFont(font));

        doc.close();
    }

}
