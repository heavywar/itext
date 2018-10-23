

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
import main.Words;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static final String DEST = "./fonts/tutorial/TXTtest122.pdf";
    public static final String DEST1 = "./fonts/tutorial/TXTtest22.pdf";
    public static final String DEST2 = "D:\\1.txt";
    public static final String FONT = "D:\\V7СоединенияПолный шрифтТЕст.ttf";

    // public static final String FONT1 = "D:\\fontGZ....ttf";
    // public static final String FONT3 = "D:\\newFont2т.ttf";
    public static final String FONT2 = "D:\\allFonts\\Font2.ttf";
    public static final String FONT3 = "D:\\allFonts\\Font3.ttf";
    public static float maxSize;
    public static PdfFont font;
   static int sizefont = 16;
   static  ArrayList<Float> ListWidth = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        LicenseKey.loadLicenseFile("./fonts/tutorial/itextkey1538302072407_0.xml");
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new test().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        Color redColor = new DeviceCmyk(0, 0.76f, 0.86f, 0.01f);
        Color greenColor = new DeviceCmyk(0.78f, 0, 0.81f, 0.21f);
        Color yellowColor = new DeviceCmyk(0, 0, 0.76f, 0.01f);
        Color pein = new DeviceCmyk(86, 64, 0, 45);
        Color pein1 = new DeviceCmyk(72, 54, 0, 42);
        font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H, true);

       // PdfFont font1 = PdfFontFactory.createFont(FONT2, PdfEncodings.IDENTITY_H, true);
       // PdfFont font2 = PdfFontFactory.createFont(FONT3, PdfEncodings.IDENTITY_H, true);


        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        PageSize ps = PageSize.A5;
        Document doc = new Document(pdfDoc, ps);
        doc.setProperty(Property.LEADING, new Leading(Leading.FIXED, 28.4965f));

        doc
                .setFontSize(sizefont)
                //  .setTextAlignment(TextAlignment.JUSTIFIED)
                .setProperty(Property.FONT, font);

        maxSize = doc.getPdfDocument().getDefaultPageSize().getWidth() - (doc.getLeftMargin() + doc.getRightMargin());

        Paragraph ps1 = new Paragraph();
      //String s = "ремонтник4  авторемонтник5 авторемонтник6";
        // ps1.add(s);
        // doc.add(ps1);
        String line = "ник1 авторемонтник2 авторемffffffонтник3 авторемонтник4 авторемонтник5 авторемонтник6 авторемонтник7  ";
        //автореrrrrмонтник5  авторемонтник6 авторемонтник7 авторемонтник8 автореrrrrмонтник9 автореrrrrмонтник10"  ;
//        String line  = "Midnight Club II (с англ.-  «Полночный клуб 2») — видеоигра в жанре аркадных авто и мотогонок, разработанная студией Rockstar San Diego и изданная компанией Rockstar Games для игровых приставок PlayStation 2 и Xbox и для персональных компьютеров под управлением Windows в 2003 году. За локализацию гоночной аркады в России была ответственна компания «1С-СофтКлаб». 4 января 2008 года Midnight Club II была переиздана в сервисе Steam. В марте 2013 года игра стала доступна в разделе «PS2 Classics» сервиса PlayStation Network для консоли PlayStation 3. Midnight Club II является продолжением Midnight Club: Street Racing и второй игрой серии Midnight Club[⇨]." +
//
//        "Как и в предшественнике, в Midnight Club II присутствуют два режима — «Аркада», в котором игрок может свободно участвовать в гонках в одиночном или многопользовательском вариантах, предварительно настроив условия соревнований, и «Карьера», в котором представлена сюжетная линия, где главный герой участвует в нелегальных заездах, стремясь получить статус лучшего уличного гонщика. Действие игры происходит в трёх реальных городах мира — Лос-Анджелесе, Париже и Токио, по которым предоставлена свобода передвижения. По мере прохождения игры становятся доступными новые автомобили и мотоциклы, достающиеся игроку от поверженных соперников. Для каждого транспортного средства характерны его особые способности, помогающие игроку в прохождении гонок[⇨]." +
//
//        "Midnight Club II была анонсирована в 2002 году. Благодаря успеху Midnight Club: Street Racing на PlayStation 2, команда разработчиков Angel Studios[пр. 1] решила создать сиквел, включив в него различные нововведения, например онлайн-игру. Midnight Club II получила положительные отзывы от игровой прессы. Большинство журналистов хвалили проработанные города, разнообразие режимов и многопользовательскую онлайн-игру, но подвергали критике уровень сложности и графику[⇨]. В 2005 году было издано продолжение — Midnight Club 3: DUB Edition[⇨].";

//String line = "Midnight Club II (с англ.-  «Полночный клуб 2») — видеоигра в жанре аркадных авто и мотогонок, разработанная студией Rockstar San Diego и изданная компанией Rockstar Games";
//  p.add(line);
//        p.add("\n");
        System.out.println("max " + maxSize);
        // System.out.println("Строка" + font.getWidth(line,sizefont));
        System.out.println("one " + font.getWidth("мотогонок, разработанная студией Rockstar", sizefont));
        Words words = new Words();
        String space = " ";
        float resulttest = 0;
        ArrayList<String> arrayList;
        Hyphenator hyphenator = new Hyphenator();
        ArrayList<String> StringRes = new ArrayList<>();
        StringRes.add("");
        StringRes.add("");


        BufferedReader br = new BufferedReader(new FileReader(DEST2));
        //String line = ;
        //Paragraph p;
        boolean Bdoc = true;
        Paragraph p = new Paragraph();
        String a = "";
        float resultMargin = 0;
        Boolean parag = true;
        Boolean Bspace = true;
        int last = 0;
        int lastI = 0;
        String lastS = "";
        Text t2 = new Text("");
        Text t3 = new Text("");

        List<String> Alist = words.Word_WithoutSpaceforMainPdf(line);
        float result = 0;
       WidthStroke((ArrayList<String>) Alist);
        //System.out.println(maxSize);
        int count = 0;
        int listWidthCount = 0;
        float Fspace = font.getWidth(" ",sizefont);
        for (int i = 0; i < Alist.size(); i++) {
            Text t = new Text("");

            if (!parag) {
                System.out.println("ListWidth = " + ListWidth);
                count++;
                //last += p.getChildren().size();
                p = new Paragraph();
                if (count % 2 == 0) {
                    //System.out.println("++++++++++++=========");
                    // p.setMarginLeft(4);
                   // result += 5;
                }
                if (count % 3 == 0) {
                    // System.out.println("++++++++++++=========");
                    // p.setMarginLeft(7);
                  //  result += 8;
                }
                p.add(t2);
                // parag = true;

            }
            last++;
            // parag = true;

            if (parag) {
                for (int j = 0; j < Alist.get(i).length(); j++) {
//                        int rand = 1 + (int) (Math.random() *3);
//                        if(rand==1) {
//                            t = new Text(String.valueOf(Alist.get(i).charAt(j)));
//                            t.setFont(font1);
//                            result += font1.getWidth(Alist.get(i).charAt(j), sizefont);
//                        }


//                        if(rand==2) {
//                            t = new Text(String.valueOf(Alist.get(i).charAt(j)));
//                            t.setFont(font2);
//                            result += font2.getWidth(Alist.get(i).charAt(j), sizefont);
//                        }
//                        if(rand==3) {
                    t = new Text(String.valueOf(Alist.get(i).charAt(j)));
//add space
                    try {

                        float F = ListWidth.get(listWidthCount)+Fspace;
                        if (F < maxSize) {
                            if (Alist.get(i).charAt(j) == ' ') {
                               t = new Text("  ");
                                Fspace+=Fspace;



                            }
                        }
                    }catch (IndexOutOfBoundsException ex){}
                    t.setFont(font);
                    result+= font.getWidth(Alist.get(i).charAt(j), sizefont);
                    // }
                    p.add(t);

                }
            }
            parag = true;


            // t = new Text(Alist.get(i));

            System.out.println("слово " + Alist.get(i) + "width  =" + result);
            // System.out.println(result);
            try {


                if (result + font.getWidth(Alist.get(i + 1), sizefont) > maxSize) {

                    parag = false;
                    //   result = result-font.getWidth(Alist.get(i ;
                    System.out.println(" resultMain" + result);
                    // String string = hyphenator.hyphenateWord(Alist.get(i));

                    StringRes = hyphenator.widtString(result, maxSize, font, Alist.get(i + 1));
                    System.out.println("buffer " + StringRes);
                    float letter_after_hyph = hyphenator.minusResult;
                    System.out.println("БУквы после дифиса" + hyphenator.minusResult);
                    t = new Text(StringRes.get(0));
                    result = 0 + letter_after_hyph;
                    // p = new Paragraph();



                    t2 = new Text(StringRes.get(1));
                    last--;
                    resultMargin = hyphenator.resultMargin;
                    Fspace = font.getWidth(" ",sizefont);
                    listWidthCount++;


                }
                a = StringRes.get(1);
                // System.out.println("aaaa " + a );
            } catch (IndexOutOfBoundsException ex) {

            }

            // System.out.println("aaaaa" + a);


            //System.out.println("!!!!!"+resulttest);
            if (!parag) {
                p.add(t);
                doc.add(p);
                //  doc.add(new Paragraph("\n"));
                lastS = a;

            }
            lastI = i;
        }

        System.out.println("last " + last);
        System.out.println("lastI " + lastI);
        int resultLast = lastI - last;

        if (last < Alist.size()) {

            Paragraph p1 = new Paragraph();
            System.out.println("+++ " + lastS);
            p1.add(lastS);
            for (int i = 0; i < resultLast; i++) {
                try {
                    last++;
                    p1.add(Alist.get(last));

                } catch (IndexOutOfBoundsException ex) {

                }
            }
            //doc.add(p1);

        }
        doc.close();


    }

    public static ArrayList<String> ArrayList(String string) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String retval : string.split("-", 0)) {

            if (retval.length() != 0 && !retval.equals(" ")) {
                arrayList.add(retval + " ");
                //arrayList.add(" ");
                //  arrayList.add(" ");
            }
//

        }
        return arrayList;
    }

    public static void WidthStroke(ArrayList<String> Alist) {
        Text t = new Text("");
        Boolean parag = true;
        float result = 0;
        Hyphenator hyphenator = new Hyphenator();
        for (int i = 0; i < Alist.size(); i++) {
            //Text t = new Text("");




            if (parag) {
                for (int j = 0; j < Alist.get(i).length(); j++) {

                 result+= font.getWidth(Alist.get(i).charAt(j), sizefont);



                }
            }
            parag = true;




            System.out.println("++слово1 " + Alist.get(i) + "++width1  =" + result);
            try {


                if (result + font.getWidth(Alist.get(i + 1), sizefont) > maxSize) {
                    System.out.println(" resultMain" + result);
                    // String string = hyphenator.hyphenateWord(Alist.get(i));

                    float f= hyphenator.widtCount(result, maxSize, font, Alist.get(i + 1));
                   // System.out.println("buffer " + StringRes);
                    float letter_after_hyph = hyphenator.minusResult;
                    System.out.println("БУквы после дифиса" + hyphenator.minusResult);
                   // t = new Text(StringRes.get(0));
                    result = 0 + letter_after_hyph;
                    ListWidth.add(f);
                    // p = new Paragraph();

                    parag = false;



                }
                // System.out.println("aaaa " + a );
            } catch (IndexOutOfBoundsException ex) {

            }

            // System.out.println("aaaaa" + a);


            //System.out.println("!!!!!"+resulttest);

        }


        // System.out.println("aaaaa" + a);


    }
}





