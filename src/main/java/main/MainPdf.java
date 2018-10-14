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
import com.itextpdf.typography.config.StandardScriptConfig;
import com.itextpdf.typography.config.TypographyConfigurator;


import java.io.*;
import java.util.*;

public class MainPdf {
    public static final String DEST1 = "./fonts/tutorial/TXTtest2222.pdf";
    public static final String DEST = "./fonts/tutorial/TXTtest33322.pdf";
    public static final String DEST3 = "./fonts/tutorial/Margin++.pdf";
    public static final String DEST2 = "D:\\text.txt";
    public static final String FONT = "D:\\V7СоединенияПолный шрифтТЕст.ttf";
    public static final String FONT1 = "D:\\ArtScript.ttf";

    private  int sizefont = 15;

    public static void main(String[] args) throws Exception {
        LicenseKey.loadLicenseFile("./fonts/tutorial/itextkey1538302072407_0.xml");
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new PdfToTxt().manipulatePdf(DEST1);
        new MainPdf().manipulatePdf(DEST);
        new mirrorMargin().createPdf(DEST3);

    }

    protected void manipulatePdf(String dest) throws Exception {
        Color redColor = new DeviceCmyk(0, 0.76f, 0.86f, 0.01f);
        Color greenColor = new DeviceCmyk(0.78f, 0, 0.81f, 0.21f);
        Color yellowColor = new DeviceCmyk(0, 0, 0.76f, 0.01f);
        Color pein = new DeviceCmyk(86, 64, 0, 45);
        Color pein1 = new DeviceCmyk(72, 54, 0, 42);

        String MainWord = "При жизни Серова картина экспонировалась на Таврической выставке (1905), организованной Сергеем Дягилевым, на Русской художественной выставке в Париже (1906). Кроме того, портрет демонстрировался на коллективных выставках Союза русских художников. В 1920 году картина перешла в собственность Малого театра. С 1935 года находится в Государственной Третьяковской галерее (инв. номер 28079). Там же хранится единственный известный искусствоведам эскиз к портрету, выполненный Серовым и показывающий, что ещё до начала непосредственной работы художник определил композицию, выбрал ракурс, придающий образу монументальность, и решил сделать акцент на силуэте актрисы.";

        PdfFont font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H, true);
        PdfFont font1 = PdfFontFactory.createFont(FONT1, PdfEncodings.IDENTITY_H, true);

        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        PageSize ps = PageSize.A5;
        Document doc = new Document(pdfDoc, ps);
        System.out.println("!!!" + doc.getPdfDocument().getDefaultPageSize().getWidth());
        //1
       doc.setMargins(8.0394f, 0, 36, 56.6929f);
//2
       //doc.setMargins(8.0394f, 35.6929f, 36.69291338583f, 17.69291338583f);




        doc.setHyphenation(new HyphenationConfig("ru", "none", 2, 2))
                .setFontSize(sizefont)
                //  .setTextAlignment(TextAlignment.JUSTIFIED)
                .setProperty(Property.FONT, font);

        doc.setProperty(Property.TYPOGRAPHY_CONFIG, new TypographyConfigurator()
                .addFeatureConfig(
                        new StandardScriptConfig(new HashSet<Character.UnicodeScript>(Arrays.asList(Character.UnicodeScript.LATIN, Character.UnicodeScript.CYRILLIC)))
                                .setLigaturesApplying(true)
                               // .setKerningFeature(true)

                ));


//
        PdfCanvas canvas = new PdfCanvas(pdfDoc.addNewPage());


        Color magentaColor = new DeviceCmyk(0.f, 0.f, 0.f, 100.f);
        //canvas.setStrokeColor(magentaColor);




        for (double y = 0; y <= 595; y += 14.1732) {
            canvas.moveTo(0, y);
            canvas.lineTo(420, y);
        }
        for (double x = 0; x <= 420; x += 14.1732) {
            canvas.moveTo(x, 0);
            canvas.lineTo(x, 595);
        }


        canvas.closePathStroke();

//        FileInputStream fis =  new FileInputStream(DEST2);
//        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
//        String linetest;
        Words word = new Words();

        List<String> stringListRandom = new ArrayList<>();


        int n = 0;
        int nstring = 0;
        char c = ' ';

        Random r = new Random();
        String space = " ";

        boolean title = true;
        boolean peremos = false;
        boolean peremos1 = false;
        String checkLegature = "";
        String checkLegature1 = "";
        Boolean IscheckLegature = true;


        float firstcountspacewidth =  font.getWidth(" ",sizefont);
       // System.out.println(firstcountspacewidth);
        ReturnLineToLine ReturnLineToLine = new ReturnLineToLine();

        List<String> stringList = ReturnLineToLine.splitLine(DEST1);


        for(int icont =0; icont<stringList.size();icont++)
        {
            int countspaceresult = 0;
            for(int countspace = 0; countspace<stringList.get(icont).length();countspace++)
            {
               // System.out.println((stringList.get(icont).charAt(countspace)));
               if(stringList.get(icont).charAt(countspace) == ' ')
                   countspaceresult++;

            }
           //System.out.println("countspaceresult" +countspaceresult);

            float resultwidth  =  doc.getLeftMargin()+doc.getRightMargin();
            resultwidth=font.getWidth(stringList.get(icont),sizefont)+doc.getLeftMargin()+doc.getRightMargin();
           //
            // System.out.println(" resultwidth  line #" + icont + " = " + resultwidth);




            int firstcountspace  = word.countSpace(stringList.get(icont));
//            int random_number2 = 1 + (int) (Math.random() * 3);
//
//            if(random_number2 == 1)
//                space = " ";
//            if(random_number2 == 2)
//                space = "  ";
//            if(random_number2 == 3)
//                space = "  ";
            // System.out.println(linetest);
            Paragraph p = new Paragraph();
            if (!stringList.get(icont).isEmpty()) {
               // System.out.println( "пробелов- " +firstcountspace +" line # " + n + "-" + stringList.get(icont));
                int randomGet1 = 0;
                stringListRandom = word.Word_WithoutSpace(stringList.get(icont));


//                for(int i = 0; i<stringListRandom.size();i++) {
//                    int random_number1 = 1 + (int) (Math.random() * 3);
//
////                    if(random_number1 == 1)
////                        space = " ";
////                    if(random_number1 == 2)
////                        space = "  ";
////                    if(random_number1 == 3)
////                        space = "  ";
////                    if(stringListRandom.get(i).length()>5) {
////                        randomGet1 = r.nextInt(stringListRandom.size());
////
////
////                    }
               // }
                peremos = false;
                peremos1 = false;
                float spaceResult = resultwidth;
                float textRise = 0;
                float countLeguture = 0;
                for (Iterator<String> iter = stringListRandom.listIterator(); iter.hasNext(); ){
                    boolean hyphen = true;
                    String b1 = iter.next();


                        //resultwidth+=font.getWidth(b1,sizefont);

                    if(b1.equals("perenos!!%%"))
                    {

                        peremos = true;
                    //  iter.remove();
                       // j++;
                    }
                    if(b1.equals("perenos!!%%1"))
                    {
                        peremos1 = true;
                        //  iter.remove();
                        // j++;
                    }

                    String a1 = b1.replaceAll("perenos!!%%(\\w*)","");
                    space = " ";
                   if(spaceResult< 419 )
                        {

                        int random_number2 = 1 + (int) (Math.random() * 2);
                        if(random_number2 == 2) {
                            spaceResult += font.getWidth("  " ,sizefont);
                            if(spaceResult< 419){
                                space = "  ";

                            }

                        }

                    }
                    for(int Nhyphen = 0; Nhyphen<a1.length(); Nhyphen++)
                    {
                        if(a1.charAt(Nhyphen) == '-')
                            hyphen = false;


                    }



                    //String b1 = iter.next();
                    if(nstring%11 ==0&&a1.length()>=5 && a1.length()>=8 && !word.isNumber(a1))
                    {


                        int random_number1 = 2 + (int) (Math.random() *3);
                        int countRise = 0;

                        for(int i = 0; i< a1.length();i++)
                        {


                            Text t = new Text("");

                            try {
                                IscheckLegature = true;
                                checkLegature = a1.substring(i,i+2);
                                System.out.println("S1 " +checkLegature);

                                if(word.isLegature(checkLegature)){
                                    t = new Text(checkLegature);
                                    p.add(t);
                                    System.out.println("+");
                                    i+=2;
                                    countLeguture++;
                                    IscheckLegature= false;
                                    t.setTextRise(textRise);

                                }

                                if(!IscheckLegature) {
                                    textRise+=0.8;
                                    checkLegature1 = a1.substring(i, i + 2);
                                    System.out.println("S2 " +checkLegature1);
                                    if(word.isLegature(checkLegature1)) {
                                        t = new Text(checkLegature1);
                                        p.add(t);
                                        i+=2;
                                        t.setTextRise(textRise);
                                        textRise+=0.8;
                                    }
                                }

                            } catch (StringIndexOutOfBoundsException e) {

                            }
                            if (i + 1> a1.length()) {
                                System.out.println("++");
                                break;
                            }

                            //t.setText(String.valueOf(a1.charAt(i)));
                            t  = new Text(String.valueOf(a1.charAt(i)));

                            t.setTextRise(textRise);
                            p.add(t);

                            t.setBackgroundColor(yellowColor);
                             countRise++;
                            if(i+1<a1.length()/2)
                                textRise+=0.85;
                            else
                                textRise+=0;
                        }
                       // t.setSkew(random_number1,0);

p.add(" ");

                    }
//                    else if(stringListRandom.get(j) ==stringListRandom.get(randomGet1)) {
//
//                        Text t = new Text(stringListRandom.get(j)+space);
//                        t.setHorizontalScaling(1.4f);
//                        t.setFontSize(15);
//                          //  t.setBackgroundColor(redColor);
//                            p.add(t);
//
//                    }
                    else if(nstring%16 ==0 && !word.isNumber(a1)) {
                        int random_number1 = 2 + (int) (Math.random() *3);
                        Text t = new Text(a1+" ");
                        t.setSkew(random_number1*(-1),0);
                        // t.setBackgroundColor(greenColor);
                        p.add(t);


                    }

                    else if(nstring%19 ==0 && hyphen && !word.isNumber(a1) && a1.length()>5 && word.isLeterDZ(a1)) {
                       // System.out.println("+ " +resultwidth);
//                        String h = b1.substring(0,b1.length()/2);
//                        String h1 = b1.substring(b1.length()/2);
//                        Text t = new Text(h);
//                        t.setSkew(14,0);
//                        p.add(t);
//                        Text t2 = new Text(h1);
//                        t2.setSkew(-14,0);
//                        p.add(t2);
//                        System.out.println(h);
//                        System.out.println(h1);
                        int count = 0;
                        float nplus = 0f;
                        int ncount = 0;
                        float nminus =  1.3f;
                        int countspace = 0;
                        for(int i =0; i<a1.length();i++) {
                            countspace++;


                            Text t2 = new Text(String.valueOf((a1.charAt(i))));

                            if (a1.length() / 2 > ncount) {
                                t2.setTextRise(nplus);
                              //  t2.setFont(font1);
                                nplus += 1.0;
                            } else {

                                t2.setTextRise(nplus - nminus);

                                nminus += 1.0;

                            }
                            ncount++;
                         //t2.setBackgroundColor(redColor);
                           p.add(t2);
                            if (countspace == a1.length())
                                p.add(space);


                        }

                    }

                    else {
                        p.add(a1+space);
                        //p.setBackgroundColor(greenColor);
                    }
                    nstring++;



                }
               //
                // System.out.println(stringListRandom);
            } else {
                // int countspace  = word.countSpace(linetest);
                //  System.out.println( "пробелов вначаел - " +countspace + "line # " + n + "-" + linetest );
             //   p = new Paragraph(stringList.get(icont));

            }


          //  stringList.get(icont).replace("perenos!!%%", "HELLO WORLD");
            p.setMarginTop(0);
            p.setMarginBottom(0);
            if (title) {
                p.setFirstLineIndent(18.1732f);
               // System.out.println("+");
                title = false;
            } else {
                title = false;
                //  p.setMarginRight(13);
            }
            if (peremos1) {

                p.setMarginTop(0);

                title = true;

                }
            if (peremos) {
                p.setMarginBottom(28.3465f);

                title = true;
          }
           else {
                float countspacefirst = firstcountspacewidth *firstcountspace;

               // p.setMarginLeft(countspacefirst);


            }
            if(resultwidth<405&&n%2 == 0)
            {
                if(n%2 == 0 )
                    p.setMarginLeft(6);
                if(n%3 == 0 )
                    p.setMarginLeft(8);


            }
            else if (resultwidth<360&&n%3 == 0){
                if(n%3 == 0)
                    p.setMarginLeft(10);
               // p.setBackgroundColor(redColor);
            }
            String s = "в б";
            Text t = new Text("в б"+"   ");
//p.setFontColor(pein1);
            Paragraph g = new Paragraph(t);

//            p.setProperty(Property.TYPOGRAPHY_CONFIG, new TypographyConfigurator()
//                    .addFeatureConfig(
//                            new StandardScriptConfig(new HashSet<Character.UnicodeScript>(Arrays.asList(Character.UnicodeScript.LATIN, Character.UnicodeScript.CYRILLIC)))
//                                    .setLigaturesApplying(true)
//                                    //.setKerningFeature(true)
//
//                    ));


            doc.add(p.setFixedLeading(28.3465f));
            n++;
        }

        //
        // System.out.println(word.getArrayList());

        doc.close();
    }

}

