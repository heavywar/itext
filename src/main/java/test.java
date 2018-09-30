import com.eaio.stringsearch.BNDM;
import com.eaio.stringsearch.StringSearch;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.Property;
import com.itextpdf.licensekey.LicenseKey;
import com.itextpdf.typography.config.LatinScriptConfig;
import com.itextpdf.typography.config.TypographyConfigurator;
import org.apache.pdfbox.io.IOUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class test {
    public static final String DEST = "./fonts/tutorial/TXTtest22.pdf";
    public static final String DEST2 = "D:\\new.txt";
    public static final String FONT = "D:\\V2Полный шрифтТЕст.ttf";

    public static void main(String[] args) throws Exception {
        LicenseKey.loadLicenseFile("./fonts/tutorial/itextkey1538302072407_0.xml");
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new test().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        PageSize ps = PageSize.A5;
        PdfFont font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H,true);
        Document doc = new Document(pdfDoc, ps);
        doc.setProperty(Property.FONT, font);


        String t = " aa ff (off)";
       // t.setUnderline(1,3);
        Paragraph p = new Paragraph(t);
        p.isKeepTogether();
        Paragraph p1 = new Paragraph("ff");
        doc.add(p);
        //doc.add(p.setFont(font));
//
        String text2 = " aa ff аг ав (on)";
        Paragraph pLiga = new Paragraph(text2);
        pLiga.setProperty(Property.TYPOGRAPHY_CONFIG, new TypographyConfigurator()
                .addFeatureConfig(
                        new LatinScriptConfig()
                                .setLigaturesApplying(true)
                                .setKerningFeature(true)
                ));
        doc.add(pLiga);

        doc.close();
    }
}
