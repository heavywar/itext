

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
    public static PdfFont font1;
    public static PdfFont font2;
    public static PdfFont font;
   static int sizefont = 16;
   static  ArrayList<Float> ListWidth = new ArrayList<>();
   static ArrayList<Integer> ListRandFont = new ArrayList<>();
    static int countLAst =0;


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
       font1 = PdfFontFactory.createFont(FONT2, PdfEncodings.IDENTITY_H, true);
         font2 = PdfFontFactory.createFont(FONT3, PdfEncodings.IDENTITY_H, true);


        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        PageSize ps = PageSize.A5;
        Document doc = new Document(pdfDoc, ps);
        doc.setProperty(Property.LEADING, new Leading(Leading.FIXED, 28.4965f));

        doc
                .setFontSize(sizefont)
                //  .setTextAlignment(TextAlignment.JUSTIFIED)
                .setProperty(Property.FONT, font);

        maxSize = doc.getPdfDocument().getDefaultPageSize().getWidth() - (doc.getLeftMargin() + doc.getRightMargin());

      //String s = "ремонтник4  авторемонтник5 авторемонтник6";
        // ps1.add(s);
        // doc.add(ps1);
      // String line = "ник1 авторемонтник2 авторемffffffонтник3 авторемонтник4 авторемонтник5 авторемонтник6 авторемонтник7  авторемонтник8";
        //автореrrrrмонтник5  авторемонтник6 авторемонтник7 авторемонтник8 автореrrrrмонтник9 автореrrrrмонтник10"  ;
        String line  = "Midnight Club II (с англ.-  «Полночный клуб 2») — видеоигра в жанре аркадных авто и мотогонок, разработанная студией Rockstar San Diego и изданная компанией Rockstar Games для игровых приставок PlayStation 2 и Xbox и для персональных компьютеров под управлением Windows в 2003 году. За локализацию гоночной аркады в России была ответственна компания «1С-СофтКлаб». 4 января 2008 года Midnight Club II была переиздана в сервисе Steam. В марте 2013 года игра стала доступна в разделе «PS2 Classics» сервиса PlayStation Network для консоли PlayStation 3. Midnight Club II является продолжением Midnight Club: Street Racing и второй игрой серии Midnight Club[⇨]." +

        "Как и в предшественнике, в Midnight Club II присутствуют два режима — «Аркада», в котором игрок может свободно участвовать в гонках в одиночном или многопользовательском вариантах, предварительно настроив условия соревнований, и «Карьера», в котором представлена сюжетная линия, где главный герой участвует в нелегальных заездах, стремясь получить статус лучшего уличного гонщика. Действие игры происходит в трёх реальных городах мира — Лос-Анджелесе, Париже и Токио, по которым предоставлена свобода передвижения. По мере прохождения игры становятся доступными новые автомобили и мотоциклы, достающиеся игроку от поверженных соперников. Для каждого транспортного средства характерны его особые способности, помогающие игроку в прохождении гонок[⇨]." +

        "Midnight Club II была анонсирована в 2002 году. Благодаря успеху Midnight Club: Street Racing на PlayStation 2, команда разработчиков Angel Studios[пр. 1] решила создать сиквел, включив в него различные нововведения, например онлайн-игру. Midnight Club II получила положительные отзывы от игровой прессы. Большинство журналистов хвалили проработанные города, разнообразие режимов и многопользовательскую онлайн-игру, но подвергали критике уровень сложности и графику[⇨]. В 2005 году было издано продолжение — Midnight Club 3: клуб едищион. ан";

//String line = "Midnight Club II (с англ.-  «Полночный клуб 2») — видеоигра в жанре аркадных авто и мотогонок, разработанная студией Rockstar San Diego и изданная компанией Rockstar Games";
//  p.add(line);
//        p.add("\n");
        System.out.println("max " + maxSize);
        // System.out.println("Строка" + font.getWidth(line,sizefont));
        System.out.println("one " + font.getWidth("для персональных компьютеров под управлением", sizefont));
        Words words = new Words();
        Hyphenator hyphenator = new Hyphenator();
        ArrayList<String> StringRes = new ArrayList<>();
        StringRes.add("");
        StringRes.add("");
        Paragraph p = new Paragraph();
        Boolean parag = true;
        Text t2 = new Text("");
 int n = 0;
        List<String> Alist = words.Word_WithoutSpaceforMainPdf(line);
        float result = 0;
       WidthStroke((ArrayList<String>) Alist);
        int count = 0;
        int listWidthCount = 0;
        float Fspace = font.getWidth(" ",sizefont);
        System.out.println("ListWidth = " + ListWidth);
        System.out.println(ListRandFont);
        boolean paragCount =true;
        for (int i = 0; i < Alist.size(); i++) {
            Text t = new Text("");

            if (!parag) {
                count++;
                p = new Paragraph();
                if (count % 2 == 0) {

                     p.setMarginLeft(3);
                    result += 3;
                }
                 if (count % 3 == 0) {
                     p.setMarginLeft(5);
                    result += 5;
                }
                p.add(t2);
                System.out.println("listWidthCount"+ listWidthCount);
                System.out.println("countLAst" + countLAst);

            }


            if (parag) {
                for (int j = 0; j < Alist.get(i).length(); j++) {
                    t = new Text(String.valueOf(Alist.get(i).charAt(j)));
                        if(ListRandFont.get(n)==1) {
                            t.setFont(font1);
                            result += font1.getWidth(Alist.get(i).charAt(j), sizefont);
                        }

                        if(ListRandFont.get(n)==2) {
                            t.setFont(font2);
                            result += font2.getWidth(Alist.get(i).charAt(j), sizefont);
                        }
                        if(ListRandFont.get(n)==3) {
                            t.setFont(font);
                            result += font.getWidth(Alist.get(i).charAt(j), sizefont);
                       }
                       n++;
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
                    p.add(t);

                }
            }
            parag = true;
            System.out.println("слово " + Alist.get(i) + "width  =" + result);
            try {


                if (result + font.getWidth(Alist.get(i + 1), sizefont) > maxSize) {

                    parag = false;
                    System.out.println(" resultMain" + result);

                    StringRes = hyphenator.widtString(result, maxSize, font, Alist.get(i + 1));
                    System.out.println("buffer " + StringRes);
                    float letter_after_hyph = hyphenator.minusResult;
                    System.out.println("БУквы после дифиса" + hyphenator.minusResult);
                    t = new Text(StringRes.get(0));
                    result = 0 + letter_after_hyph;



                    t2 = new Text(StringRes.get(1));
                    Fspace = font.getWidth(" ",sizefont);
                    listWidthCount++;


                }

            } catch (IndexOutOfBoundsException ex) {

            }

               if(Alist.size()-1 == i) { //Нужен чтобы доавить последнюю стоку.
                   System.out.println("!!!FALSE+");
                   paragCount = false;
               }

            if (!parag ||!paragCount) {
                p.add(t);
                doc.add(p);
            }

        }

        System.out.println("count+++" + count);
        doc.close();

    }
    public static void WidthStroke(ArrayList<String> Alist) {
        Boolean parag = true;
        float result = 0;
         int count = 0;
        Hyphenator hyphenator = new Hyphenator();
        for (int i = 0; i < Alist.size(); i++) {
 if(!parag){
     count++;
                 if (count % 2 == 0) {
                     result += 3;
                 }
                if (count % 3 == 0) {

                    result += 5;
                }
 }

            if (parag) {
                //last += p.getChildren().size();

                for (int j = 0; j < Alist.get(i).length(); j++) {

                    int rand = 1 + (int) (Math.random() *3);
                    if(rand==1) {

                        result += font1.getWidth(Alist.get(i).charAt(j), sizefont);
                    }

                    if(rand==2) {

                        result += font2.getWidth(Alist.get(i).charAt(j), sizefont);
                    }
                    if(rand==3) {

                        result += font.getWidth(Alist.get(i).charAt(j), sizefont);
                    }
                    ListRandFont.add(rand);




                }
            }
            parag = true;
            System.out.println("++слово1 " + Alist.get(i) + "++width1  =" + result);
            try {

                if (result + font.getWidth(Alist.get(i + 1), sizefont) > maxSize) {
                    System.out.println(" resultMain" + result);
                    float f= hyphenator.widtCount(result, maxSize, font, Alist.get(i + 1));
                    float letter_after_hyph = hyphenator.minusResult;
                    System.out.println("БУквы после дифиса" + hyphenator.minusResult);
                    result = 0 + letter_after_hyph;
                    ListWidth.add(f);
                     countLAst++;
                    parag = false;


                }

            } catch (IndexOutOfBoundsException ex) { }
        }
        System.out.println("count+++" + count);

    }
}





