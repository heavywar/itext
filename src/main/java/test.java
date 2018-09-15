

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.layer.PdfLayer;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.ColumnDocumentRenderer;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class test {
    public static final String DEST = "./stamp_page_x_of_y.pdf";
    public static final String SRC = "./fonts/tutorial/test.pdf";
    public static final String FONT = "D:\\birch111.ttf";

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new test().manipulatePdf(DEST);
    }


    protected void manipulatePdf(String dest) throws Exception {
        PdfFont font = PdfFontFactory.createFont(FONT, "Cp1251", true);
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(DEST));
        Document doc = new Document(pdfDoc);
        Paragraph p = new Paragraph();
        //String sa = "Приветит2f";
         String sa = "При жизни Серова картина экспонировалась на Таврической выставке (1905), организованной Сергеем Дягилевым, на Русской художественной выставке в Париже (1906). Кроме того, портрет демонстрировался на коллективных выставках Союза русских художников. В 1920 году картина перешла в собственность Малого театра. С 1935 года находится в Государственной Третьяковской галерее (инв. номер 28079). Там же хранится единственный известный искусствоведам эскиз к портрету, выполненный Серовым и показывающий, что ещё до начала непосредственной работы художник определил композицию, выбрал ракурс, придающий образу монументальность, и решил сделать акцент на силуэте актрисы.";

        String sub = "";

        int j = 1;
        int m = 0;
        float b = (float) 0.3;
        int afValue = sa.indexOf('в');
        for (int i = 0; i < sa.length(); i++) {
            Text t = new Text("");


            sub = sa.substring(afValue + m, afValue + j);
            if (sa.charAt(i) == 'в') {
                t.setText(String.valueOf(sa.charAt(i)));

                //t2.setTextRise((float) 1.2);

                //t2.setSkew(0,10);
                t.setRelativePosition(0, 0, 0, 1f);
//                  subcount = +1;
                j++;
                m++;


            } else if (sa.charAt(i) == sub.charAt(0)) {
                t.setText(String.valueOf(sa.charAt(i)));
                //t2.setTextRise((float) 1.2);
                //t2.setSkew(0,10);

                t.setRelativePosition(0, 0, 0, (float) (1 + b));

                j++;
                m++;
                b += 0.6;
                System.out.println("BBB" + b);

            }

            t.setText(String.valueOf(sa.charAt(i)));

            p.add(t);
        }



        doc.add(p.setFont(font));
        doc .close();
    }
}
