package main;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.hyphenation.HyphenationConfig;
import com.itextpdf.layout.property.Property;
import com.itextpdf.licensekey.LicenseKey;


import java.io.*;
import java.util.*;

public class PdfToTxt {
    public static final String DEST = "./fonts/tutorial/TXTtest221.pdf";
    public static final String DEST2 = "D:\\1.txt";

    public static final String FONT = "D:\\V7СоединенияПолный шрифтТЕст.ttf";
    private  int sizefont = 16;

    public static void main(String[] args) throws Exception {
        LicenseKey.loadLicenseFile("./fonts/tutorial/itextkey1538302072407_0.xml");
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new PdfToTxt().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        Color redColor = new DeviceCmyk(0, 0.76f, 0.86f, 0.01f);
        Color greenColor = new DeviceCmyk(0.78f, 0, 0.81f, 0.21f);
        Color yellowColor = new DeviceCmyk(0, 0, 0.76f, 0.01f);
        Color pein = new DeviceCmyk(86, 64, 0, 45);
        Color pein1 = new DeviceCmyk(72, 54, 0, 42);

        String MainWord = "При жизни Серова картина экспонировалась на Таврической выставке (1905), организованной Сергеем Дягилевым, на Русской художественной выставке в Париже (1906). Кроме того, портрет демонстрировался на коллективных выставках Союза русских художников. В 1920 году картина перешла в собственность Малого театра. С 1935 года находится в Государственной Третьяковской галерее (инв. номер 28079). Там же хранится единственный известный искусствоведам эскиз к портрету, выполненный Серовым и показывающий, что ещё до начала непосредственной работы художник определил композицию, выбрал ракурс, придающий образу монументальность, и решил сделать акцент на силуэте актрисы.";


        PdfFont font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H, true);
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        PageSize ps = PageSize.A5;
        Document doc = new Document(pdfDoc, ps);
       doc.setMargins(8.50394f ,0, 36.69291338583f, 66.6929f);

       //doc.setMargins(4.25197f, 36.69291338583f, 36.69291338583f, 16.69291338583f);






        doc.setHyphenation(new HyphenationConfig("ru", "none", 1, 1))
                .setFontSize(sizefont)
               //  .setTextAlignment(TextAlignment.JUSTIFIED)
                .setProperty(Property.FONT, font);



        PdfCanvas canvas = new PdfCanvas(pdfDoc.addNewPage());
        Color magentaColor = new DeviceCmyk(0.f, 0.f, 0.f, 100.f);
       // canvas.setStrokeColor(magentaColor);



//
//        for (double y = 0; y <= 595; y += 14.1732) {
//            canvas.moveTo(0, y);
//            canvas.lineTo(420, y);
//        }
//        for (double x = 0; x <= 420; x += 14.1732) {
//            canvas.moveTo(x, 0);
//            canvas.lineTo(x, 595);
//        }
//
//
//        canvas.closePathStroke();

        FileInputStream fis =  new FileInputStream(DEST2);
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        String linetest;
        Words word = new Words();

        List<String> stringListRandom = new ArrayList<>();



              int n = 0;
        int nstring = 0;
        char c = ' ';
        boolean title = true;
        Random r = new Random();
        String space = " ";
        float firstcountspacewidth =  0;
        float maxMargoin = 0;
        while ((linetest = br.readLine()) != null) {
            int firstcountspace  = word.countSpace(linetest);
            if(firstcountspace == 0)
                 firstcountspacewidth =  0;
            else
                firstcountspacewidth = font.getWidth(" ",sizefont);

//            int random_number2 = 1 + (int) (Math.random() * 3);
////
//            if(random_number2 == 1)
//                space = " ";
//            if(random_number2 == 2)
//                space = "  ";
//            if(random_number2 == 3)
//                space = "  ";
           //  System.out.println(linetest);
            Paragraph p = new Paragraph();
//            if (!linetest.isEmpty()) {
//
//                System.out.println( "пробелов- " +firstcountspace +" line # " + n + "-" + linetest);
//
//                int randomGet1 = 0;


              // stringListRandom = word.Word_WithoutSpace(linetest);
//                int resultwidth = 0;
               for(int i = 0; i<stringListRandom.size();i++) {
//                    int random_number1 = 1 + (int) (Math.random() * 3);
//
//                    if(random_number1 == 1)
//                     space = " ";
//                    if(random_number1 == 2)
//                        space = "  ";
//                    if(random_number1 == 3)
//                        space = "  ";
//                    if(stringListRandom.get(i).length()>5) {
//                        randomGet1 = r.nextInt(stringListRandom.size());
//
//
//                        for(int width = 0; width<stringListRandom.get(i).length();width++)
//                        {
//                            resultwidth+=font.getWidth(stringListRandom.get(i).charAt(width),sizefont);
//                        }
////                        System.out.println("resultwidth = " +resultwidth);
////                        System.out.println("getWidth = " +ps.getWidth());
////                        if(resultwidth>ps.getWidth())
////                        System.out.println("++++");
//
//
//                    }
//                }
//                for (int j = 0; j < stringListRandom.size(); j++) {
//                    if(nstring%11 ==0&&stringListRandom.get(j).length()<=10)
//                    {
//                        int random_number1 = 3 + (int) (Math.random() *4);
//
//                        Text t = new Text(stringListRandom.get(j)+space);
//                        t.setSkew(random_number1,0);
//                      // t.setBackgroundColor(yellowColor);
//                        p.add(t);
//
//                    }
////                    else if(stringListRandom.get(j) ==stringListRandom.get(randomGet1)) {
////
////                        Text t = new Text(stringListRandom.get(j)+space);
////                        t.setHorizontalScaling(1.4f);
////                        t.setFontSize(15);
////                          //  t.setBackgroundColor(redColor);
////                            p.add(t);
////
////                    }
//                    else if(nstring%16 ==0) {
//                        int random_number1 = 2 + (int) (Math.random() *3);
//                        Text t = new Text(stringListRandom.get(j)+space);
//                        t.setSkew(random_number1*(-1),0);
//                       // t.setBackgroundColor(greenColor);
//                        p.add(t);
//
//
//                    }
//
//                    else if(nstring%21 ==0 && resultwidth>ps.getWidth()) {
//
//                        int count = 0;
//                        float nplus = 1.1f;
//                        int ncount = 0;
//                        float nminus =  1.1f;
//                        int countspace = 0;
//                        for(int i =0; i<stringListRandom.get(j).length();i++) {
//                            countspace++;
//
//
//                            Text t2 = new Text(String.valueOf(stringListRandom.get(j).charAt(i)));
//                            if (stringListRandom.get(j).length() / 2 >= ncount) {
//                                t2.setTextRise(nplus);
//                                nplus += 1.0;
//                            } else {
//
//                                t2.setTextRise(nplus - nminus);
//
//                                nminus += 1.0;
//
//                            }
//                            ncount++;
//                           // t2.setBackgroundColor(redColor);
//                            p.add(t2);
//                            if (countspace == stringListRandom.get(j).length())
//                                p.add(" ");
//
//
//                        }
//                    }
//
//
//                    else {

                        //p.setBackgroundColor(greenColor);
                        }
            p.add(linetest);
                  //  nstring++;


//            } else {
//               // int countspace  = word.countSpace(linetest);
//              //  System.out.println( "пробелов вначаел - " +countspace + "line # " + n + "-" + linetest );
//                p = new Paragraph(linetest);
//
//            }



            if (title ) {
                p.setFirstLineIndent(18.1732f);
                title = false;
            } else {

              //  p.setMarginRight(13);
            }
            if (linetest.isEmpty()) {

                p.setMarginBottom(28.35f);
                p.setMarginTop(0);
                p.add(" ");
                p.add("perenos!!%%");
                title = true;
            } else if(!linetest.isEmpty() && linetest.length()>70) {
               // float countspacefirst = firstcountspacewidth *firstcountspace;
                p.setMarginBottom(0);
               // p.setMarginLeft(countspacefirst);
                p.setMarginTop(0);
                p.add(" ");
                p.add("perenos!!%%1");
                title = true;

            }
            String s = "в б";
            Text t = new Text("в б"+"   ");
//p.setFontColor(pein1);
            Paragraph g = new Paragraph(t);

//            p.setProperty(Property.TYPOGRAPHY_CONFIG, new TypographyConfigurator()
//                    .addFeatureConfig(
//                            new StandardScriptConfig(new HashSet<Character.UnicodeScript>(Arrays.asList(Character.UnicodeScript.LATIN, Character.UnicodeScript.CYRILLIC)))
//                                    .setLigaturesApplying(true)
//                                    .setKerningFeature(true)
//
//
//
//
//                    ));
           // doc.setHyphenation(new HyphenationConfig("ru", "none", 2, 2))
            p.setProperty(Property.HYPHENATION, new HyphenationConfig("ru", "none", 2, 2));






            doc.add(p.setFixedLeading(28.35f));
            n++;
        }



        doc.close();

    }

}

