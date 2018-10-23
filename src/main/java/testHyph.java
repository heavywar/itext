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
import com.itextpdf.licensekey.LicenseKey;
import com.itextpdf.typography.config.StandardScriptConfig;
import com.itextpdf.typography.config.TypographyConfigurator;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class testHyph {
    public static final String DEST = "./fonts/tutorial/TXTtest122.pdf";
    public static final String DEST1 = "./fonts/tutorial/TXTtest22.pdf";
    public static final String DEST2 = "D:\\1.txt";
    public static final String FONT = "D:\\V7СоединенияПолный шрифтТЕст.ttf";

    // public static final String FONT1 = "D:\\fontGZ....ttf";
    // public static final String FONT3 = "D:\\newFont2т.ttf";
    public static final String FONT2 = "D:\\allFonts\\Font2.ttf";
    public static final String FONT3 = "D:\\allFonts\\Font3.ttf";
    public static float maxSize ;
    public static PdfFont font;
    int sizefont =16;

    public static void main(String[] args) throws Exception {
        LicenseKey.loadLicenseFile("./fonts/tutorial/itextkey1538302072407_0.xml");
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

        doc
                .setFontSize(sizefont)
                //  .setTextAlignment(TextAlignment.JUSTIFIED)
                .setProperty(Property.FONT, font);





        doc.setProperty(Property.TYPOGRAPHY_CONFIG, new TypographyConfigurator()
                .addFeatureConfig(
                        new StandardScriptConfig(new HashSet<Character.UnicodeScript>(Arrays.asList(Character.UnicodeScript.LATIN, Character.UnicodeScript.CYRILLIC)))
                                .setLigaturesApplying(true)
                        // .setKerningFeature(true)

                ));
        System.out.println(font.getWidth("ав",16));
         Paragraph p = new Paragraph("ав");
        Text t = new Text("аг");
        ArrayList<Integer[]> arrayList = new ArrayList<>();
        Integer[] integers =new Integer[10];

ArrayList<Float> arrayList1 = new ArrayList<>();
        arrayList1.add(1.2f);
    }

    }
