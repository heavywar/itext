

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.hyphenation.HyphenationConfig;
import com.itextpdf.layout.property.Property;
import com.itextpdf.licensekey.LicenseKey;
import com.itextpdf.typography.config.StandardScriptConfig;
import com.itextpdf.typography.config.TypographyConfigurator;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;

public class test {
    public static final String DEST = "./fonts/tutorial/TXTtest122.pdf";
    public static final String DEST1 = "./fonts/tutorial/TXTtest22.pdf";
    public static final String DEST2 = "D:\\new.txt";
    public static final String FONT = "D:\\V7СоединенияПолный шрифтТЕст.ttf";
        public static final String FONT1 = "D:\\ArtScript.ttf";




    public static void main(String[] args) throws Exception {
        LicenseKey.loadLicenseFile("./fonts/tutorial/itextkey1538302072407_0.xml");
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new test().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfFont font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H, true);
        PdfFont font1 = PdfFontFactory.createFont(FONT1, PdfEncodings.IDENTITY_H, true);

        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        PageSize ps = PageSize.A5;
        Document doc = new Document(pdfDoc, ps);
        doc.setHyphenation(new HyphenationConfig("ru", "none", 2, 2))
                .setFontSize(17)
                //  .setTextAlignment(TextAlignment.JUSTIFIED)
                .setProperty(Property.FONT, font);

        doc.setProperty(Property.TYPOGRAPHY_CONFIG, new TypographyConfigurator()
                .addFeatureConfig(
                        new StandardScriptConfig(new HashSet<Character.UnicodeScript>(Arrays.asList(Character.UnicodeScript.LATIN, Character.UnicodeScript.CYRILLIC)))
                                .setLigaturesApplying(true)
                        // .setKerningFeature(true)

                ));

        String text = new String("взаг");
        Paragraph p1 =new Paragraph();
        String s1 = "";
        String s2 = "";
        Boolean b = true;
        int countLeguture = 0;
        int n = 0;
        for(int i = 0;i<text.length();i++)
        {
            Text text1 = new Text("");

            try {
                b = true;
                s1 = text.substring(i,i+2);
            System.out.println("S1 " +s1);

                if(test.isLegature(s1)){
                    text1 = new Text(s1);
                p1.add(text1);
                System.out.println("+");
                    i+=2;
                    countLeguture++;
                    b = false;

               }

            if(!b) {
                s2 = text.substring(i, i + 2);
                System.out.println("S2  " + s2);


                if(test.isLegature(s2)) {
                    text1 = new Text(s2);
                    p1.add(text1);
                    i+=2;
                }
            }

            } catch (StringIndexOutOfBoundsException e) {

            }
            if (i + 1> text.length()) {
                System.out.println("++");
                break;
            }
            text1 = new Text(String.valueOf(text.charAt(i))).setFont(font);


                    p1.add(text1);
            n++;
        }

        //System.out.println(ff);
        doc.add(p1);
        doc.close();



}
public static  boolean isLegature(String string)
{
    String []Legature = {"аг","ав","ал","ах","ач","ая","аз","бв","бг","бя","бе","бя","бч","бж","вл","вя","ве","иг","ие","из","иг","их","ия","лег","рег","ег","еж","ез","еч","ог","оз","ож","ом","ол","оч","оэ","оя","о ","б ","в ","ст","пр","ее","ей"," в","иеч","иез","азг","вз","вг","ая","уз"," з"," ч"," х"," г"};
    for(int i = 0; i<Legature.length;i++)
    {
        if(string.equals(Legature[i]))
        return true;


    }
    return false;


}
}
