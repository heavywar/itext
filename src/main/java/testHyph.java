import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.Leading;
import com.itextpdf.layout.property.Property;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class testHyph {
    public static final String DEST = "./fonts/tutorial/TXTtest122.pdf";
    public static final String DEST1 = "./fonts/tutorial/TXTtest22.pdf";
    public static final String DEST2 = "D:\\1.txt";
    public static final String FONT = "D:\\allFonts\\1\\dirtfont.ttf";

    // public static final String FONT1 = "D:\\fontGZ....ttf";
    // public static final String FONT3 = "D:\\newFont2т.ttf";
    public static final String FONT2 = "D:\\allFonts\\Font2.ttf";
    public static final String FONT3 = "D:\\allFonts\\Font3.ttf";
    public static float maxSize ;
    public static PdfFont font;
    int sizefont =16;

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new testHyph ().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        Color redColor = new DeviceCmyk(0, 0.76f, 0.86f, 0.01f);
        Color greenColor = new DeviceCmyk(0.78f, 0, 0.81f, 0.21f);
        Color yellowColor = new DeviceCmyk(0, 0, 0.76f, 0.01f);
        Color pein = new DeviceCmyk(86, 64, 0, 45);
        Color pein1 = new DeviceCmyk(72, 54, 0, 42);
        font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H, true);

        PdfFont font1 = PdfFontFactory.createFont(FONT2, PdfEncodings.IDENTITY_H, true);
        PdfFont font2= PdfFontFactory.createFont(FONT3, PdfEncodings.IDENTITY_H, true);



        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        PageSize ps = PageSize.A5;
        Document doc = new Document(pdfDoc, ps);
        doc.setProperty(Property.LEADING, new Leading(Leading.FIXED, 28.4965f));



//
        Paragraph p = new Paragraph("fdfdf");
        p.setFont(font);



        p.setMarginTop(230);
//        String s = " Схема генетического кода\n" +
//                "Генети́ческий код (англ. Genetic code) — совокупность правил, согласно которым в живых клетках информация переводится с языка нуклеотидов (ген и мРНК) в язык аминокислот (белок). Собственно перевод (трансляцию) осуществляет рибосома, которая соединяет аминокислоты в цепочку согласно инструкции, записанной в кодонах мРНК. Соответствующие аминокислоты доставляются в рибосому молекулами тРНК. У всех живых организмов генетический код имеет только незначительные различия, что свидетельствует о наличии общего предка.";
//       for(int i = 0; i<s.length();i++)
//       {
//           Text text = new Text(String.valueOf(s.charAt(i)));
//           Text text2 = new Text("");
//           p.add(text);
//           p.add(text2);
//       }
        char[] c ;
        for(int i = 0; i<10000; i++) {
            c = font.getGlyph(i).getChars();
            System.out.print(c);
        }



         doc.add(p);
         doc.close();


    }

  }

