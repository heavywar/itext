package main;
//1)Печать четныый(дырки<-) 2)печать четных
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
import com.itextpdf.layout.property.Leading;
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
    public static final String FONT = "D:\\allFonts\\font.ttf";
    public static final String FONTSpec = "D:\\allFonts\\fontSpecificLetter.ttf";
    public static final String FONT2 = "D:\\allFonts\\Font2.ttf";
    public static final String FONT3 = "D:\\allFonts\\Font3.ttf";
    public static final String FONT4 = "D:\\allFonts\\Font4.ttf";


    private  int sizefont = 16;

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
        Color Greenpein = new DeviceCmyk(83, 0, 65, 24);


        String MainWord = "При жизни Серова картина экспонировалась на Таврической выставке (1905), организованной Сергеем Дягилевым, на Русской художественной выставке в Париже (1906). Кроме того, портрет демонстрировался на коллективных выставках Союза русских художников. В 1920 году картина перешла в собственность Малого театра. С 1935 года находится в Государственной Третьяковской галерее (инв. номер 28079). Там же хранится единственный известный искусствоведам эскиз к портрету, выполненный Серовым и показывающий, что ещё до начала непосредственной работы художник определил композицию, выбрал ракурс, придающий образу монументальность, и решил сделать акцент на силуэте актрисы.";

        PdfFont font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H, true);
        PdfFont fontSpec = PdfFontFactory.createFont(FONTSpec, PdfEncodings.IDENTITY_H, true);
        PdfFont font2 = PdfFontFactory.createFont(FONT2, PdfEncodings.IDENTITY_H, true);
        PdfFont font3 = PdfFontFactory.createFont(FONT3, PdfEncodings.IDENTITY_H, true);
        PdfFont font4 = PdfFontFactory.createFont(FONT4, PdfEncodings.IDENTITY_H, true);

        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        PageSize ps = PageSize.A5;
        Document doc = new Document(pdfDoc, ps);
        System.out.println("!!!" + doc.getPdfDocument().getDefaultPageSize().getWidth());
        //1

                //8.0394f
        //6.5mm auto
       doc.setMargins(  5.66929f ,0, 36, 61.6929f);
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
        doc.setProperty(Property.LEADING, new Leading(Leading.FIXED, 28.4965f));



        PdfCanvas canvas = new PdfCanvas(pdfDoc.addNewPage());


        Color magentaColor = new DeviceCmyk(0.f, 0.f, 0.f, 100.f);
        //canvas.setStrokeColor(magentaColor);




        for (double y = 3.40157f; y <= 595; y += 14.1732) {
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
 float forMagrin = font.getWidth(" " ,sizefont);
        Random r = new Random();
        String space = " ";
        boolean title = true;
        boolean peremos = false; // Для переноса на 1 строку
        boolean peremos1 = false;// Для красной строки
        String checkLegature = "";//Лигатуры которые содерадтсья в методе
        String checkLegature1 = "";//Нужен чтобы определить лиратуру сразу полсе checkLegature
        Boolean IscheckLegature = true;//Нужен для checkLegature1
        float max = 0;
        //Максимальный размер страницы
        float maxSize = doc.getPdfDocument().getDefaultPageSize().getWidth()-(doc.getLeftMargin()+doc.getRightMargin())-16;


        float firstcountspacewidth =  font.getWidth(" ",sizefont);
       // System.out.println(firstcountspacewidth);
        ReturnLineToLine ReturnLineToLine = new ReturnLineToLine();

        List<String> stringList = ReturnLineToLine.splitLine(DEST1);


        for(int icont =0; icont<stringList.size();icont++)
        {
            int countspaceresult = 0;
            for(int countspace = 0; countspace<stringList.get(icont).length();countspace++)
            {
               if(stringList.get(icont).charAt(countspace) == ' ')
                   countspaceresult++;

            }

            float resultwidth  =  doc.getLeftMargin()+doc.getRightMargin();
            // Длина всех символов в строке
            resultwidth=font.getWidth(stringList.get(icont),sizefont);
            // Проверка на красную строку(Для разных setMarginleft)
           if(title)
               resultwidth+=18.1732f;

           //определение маексимальной строки
            if(max<resultwidth)
                max = resultwidth;

            System.out.println(" resultwidth  line #" + icont + " = " + resultwidth );




            int firstcountspace  = word.countSpace(stringList.get(icont));

            // System.out.println(linetest);
            Paragraph p = new Paragraph();
            float spaceResult = resultwidth;
            if (!stringList.get(icont).isEmpty()) {
               System.out.println( stringList.get(icont));
               //Деление строки на слова, нужен для работы со словами (text rise up)
                stringListRandom = word.Word_WithoutSpaceforMainPdf(stringList.get(icont));


                peremos = false;
                peremos1 = false;


                float countLeguture = 0;
                int countRise = 0;
                //Проход по словам в строке использован итератор для замены perenos
                for (Iterator<String> iter = stringListRandom.listIterator(); iter.hasNext(); ){
                    boolean hyphen = true;
                    float textRise = 0;
                    String b1 = iter.next();


                  //Перенос который добавляет в pdfToTxt для переноса в main
                    if(b1.equals("perenos!!%% ")||b1.equals("perenos!!%%"))
                    {
                        System.out.println("perenos");
                        peremos = true;

                    }
                    if(b1.equals("perenos!!%%1 ") || b1.equals("perenos!!%%1") )
                    {
                        peremos1 = true;
                        System.out.println("perenos1");

                    }

                    String a1 = b1.replaceAll("perenos!!%%(\\w*)","");
                    space = "";
                    //Добавление пробелов, если в строку влезают пробелы то добавляем
                   if(spaceResult<maxSize)
                        {
                        int random_number2 = 1 + (int) (Math.random() *2);

//                        if(random_number2 == 2) {
                            //Проверка нужна чтобы не добавить лишний пробел
                            spaceResult += font.getWidth(" " ,sizefont);
                            if(spaceResult< maxSize){
                                space = " ";

                           // }

                        }

                    }
                    //Проверка для букв изменяют положение(вверх вниз)
                    for(int Nhyphen = 0; Nhyphen<a1.length(); Nhyphen++)
                    {
                        if(a1.charAt(Nhyphen) == '-')
                            hyphen = false;


                    }



                    //String b1 = iter.next();

                    //Буквы вверх
                    if(nstring%8 ==0&& a1.length()>5 && !word.isNumber(a1) && word.isLeterSpec_Half(a1))
                    {


                        int random_number1 = 2 + (int) (Math.random() *3);


                        for(int i = 0; i< a1.length();i++)
                        {


                            Text t = new Text("");

                            try {

                                IscheckLegature = true;
                                //1)Нужен чтобы определить лигатуру, спомощью этого попределяются пары букв (Привет - пр,ри,ив...)
                                checkLegature = a1.substring(i,i+2);

                                //2)С помощью функцции в которой указаны лигатуру ищутся совпадения
                                if(word.isLegature(checkLegature)){
                                    t = new Text(checkLegature);
                                    p.add(t);
                                    //Увеличение i нужно чтобы после добавления ligature счетчик продолжал после этой пары букв
                                    //Например : Привет - Лигатура Пр, следующая i должна быть на "и"->I+=2;
                                    i+=2;
                                    countLeguture++;
                                    IscheckLegature= false;
                                    t.setTextRise(textRise);

                                }

                                if(!IscheckLegature) {
                                    //3)Этот определяет следующую пару букв после метода выше, т.к. Есди цикд увеличит i++ то после одна буква пропустится
                                    //Например Пр, следующая i должна быть на "и"->I+=2 после цикла i увеличится еще на i++ ->Будет i+=3;
                                    textRise+=0.8;
                                    checkLegature1 = a1.substring(i, i + 2);
                                    if(word.isLegature(checkLegature1)) {
                                        t = new Text(checkLegature1);
                                        p.add(t);
                                        i+=2;
                                        t.setTextRise(textRise);
                                        textRise+=0.8;
                                    }
                                }
                               //обработка ощибки из за i+2;
                            } catch (StringIndexOutOfBoundsException e) {

                            }
                            //обработка ощибки из за i+2;
                            if (i + 1> a1.length()) {
                                break;
                            }

                            int random_number2 = 1 + (int) (Math.random() *4);

                            if (i == 0 && word.isSpecifiedLetterLower(a1.charAt(i))) {
                                t = new Text(String.valueOf(a1.charAt(i))).setFont(fontSpec);
                            }
                            else {
                                if (random_number2 == 1)
                                    t = new Text(String.valueOf(a1.charAt(i))).setFont(font);
                                else if (random_number2 == 2)
                                    t = new Text(String.valueOf(a1.charAt(i))).setFont(font2);
                                else if (random_number2 == 3)
                                    t = new Text(String.valueOf(a1.charAt(i))).setFont(font3);
                                else if (random_number2 == 4)
                                    t = new Text(String.valueOf(a1.charAt(i))).setFont(font4);
                            }

                            t.setTextRise(textRise);


                            t.setBackgroundColor(yellowColor);
                             countRise++;
                            if(i+1<a1.length()/2)
                                if(a1.length()<10)
                                textRise+=0.85;
                            else
                                    textRise+=0.65;
                            else
                                textRise+=0;
                            //p.add(t.setBackgroundColor(greenColor));
                        }



                    }
//
                    //Буквы вниз
                    else if(icont%19!=0 &&nstring%16 ==0 && a1.length()>=5 && a1.length()>=8 &&!word.isNumber(a1) &&word.isLeterSpec_Full(a1)) { //Вниз
                        for(int i = 0; i< a1.length();i++)
                        {


                            Text t = new Text("");

                            try {
                                IscheckLegature = true;
                                checkLegature = a1.substring(i,i+2);

                                if(word.isLegature(checkLegature)){
                                    t = new Text(checkLegature);
                                    p.add(t);
                                    i+=2;
                                    countLeguture++;
                                    IscheckLegature= false;
                                    t.setTextRise(-textRise);

                                }

                                if(!IscheckLegature) {
                                    textRise+=0.8;
                                    checkLegature1 = a1.substring(i, i + 2);
                                    if(word.isLegature(checkLegature1)) {
                                        t = new Text(checkLegature1);
                                        p.add(t);
                                        i+=2;
                                        t.setTextRise(-textRise);
                                        textRise+=0.2;
                                    }
                                }

                            } catch (StringIndexOutOfBoundsException e) {

                            }
                            if (i + 1> a1.length()) {
                                break;
                            }

                            t  = new Text(String.valueOf(a1.charAt(i)));

                            t.setTextRise(-textRise);
                            p.add(t);

                         //  t.setBackgroundColor(greenColor);
                            countRise++;
                            if(i-1>a1.length()/2)
                                textRise+=0.85;
                            else
                                textRise+=0;
                        }



                    }
//Буквы вверх\вниз
                    else if(nstring%2 ==0 && hyphen && !word.isNumber(a1) && a1.length()>5) {
                        float nplus = 0f;
                        float nminus =  1.3f;
                        if(a1.length()<8) {
                            for (int i = 0; i < a1.length(); i++) {
                                Text t2 = new Text(String.valueOf((a1.charAt(i))));

                                if (a1.length() / 2 > i) {
                                    t2.setTextRise(nplus);
                                    nplus += 1.0;
                                } else {

                                    t2.setTextRise(nplus - nminus);

                                    nminus += 1.0;

                                }


                                p.add(t2);


                               // t2.setBackgroundColor(redColor);

                            }
                        }
                        else{
                            int NumberofLetters = 0;

                            switch (a1.length())
                            {
                                case 12: NumberofLetters = 1;break;
                                case 13 : NumberofLetters = 1;break;
                                case 14: NumberofLetters = 2;break;
                                case 15: NumberofLetters = 2;break;
                                case 16: NumberofLetters = 3;break;
                                case 17: NumberofLetters = 3;break;

                                default:NumberofLetters = 0;break;
                            }
                             nplus =0 ;
                             nminus =  0;
                            for(int i =0; i<a1.length();i++) {
                                int random_number2 = 1 + (int) (Math.random() *4);
                                Text t = new Text("");
                                if (i == 0 && word.isSpecifiedLetterLower(a1.charAt(i))) {
                                    t = new Text(String.valueOf(a1.charAt(i))).setFont(fontSpec);
                                }
                                else {
                                    if (random_number2 == 1)
                                        t = new Text(String.valueOf(a1.charAt(i))).setFont(font);
                                    else if (random_number2 == 2)
                                        t = new Text(String.valueOf(a1.charAt(i))).setFont(font2);
                                    else if (random_number2 == 3)
                                        t = new Text(String.valueOf(a1.charAt(i))).setFont(font3);
                                    else if (random_number2 == 4)
                                        t = new Text(String.valueOf(a1.charAt(i))).setFont(font4);
                                }


                                    if(i>2 && i<=4+NumberofLetters) {//Со второй буквы по 4(+case) буквы вверх
                                    nplus += 1.0;
                                   // t2.setBackgroundColor(greenColor);
                                    t.setTextRise(nplus - nminus);

                                }


                               // с 5(+case) по 7(2х case, потому что в начале ничего не прибавляется (i>2)) ,буквы винз
                                if(i>=5+NumberofLetters && i<7+NumberofLetters+NumberofLetters ) {
                                    nminus += 1.0;
                                   // t2.setBackgroundColor(redColor);
                                    t.setTextRise(nplus - nminus);


                                }





                                    p.add(t);


                               // t2.setBackgroundColor(greenColor);

                            }


                        }


                    }

                    else { //Все
                        for(int i = 0; i< a1.length();i++)
                        {



                            Text t = new Text("");

                            try {
                                IscheckLegature = true;
                                //1)Нужен чтобы определить лигатуру, спомощью этого попределяются пары букв (Привет - пр,ри,ив...)

                                checkLegature = a1.substring(i,i+2);
                                //2)С помощью функцции в которой указаны лигатуру ищутся совпадения

                                if(word.isLegature(checkLegature)){
                                    t = new Text(checkLegature);
                                    p.add(t);
                                    i+=2;

                                    IscheckLegature= false;

                                }
                                //Определяем специальные буквы которые идут первые или псоле опредленных прописных букв
                                //Например г,Бг
                                if(word.isLegatureSpec(checkLegature))
                                {
                                    t = new Text(checkLegature);
                                    t.setFont(fontSpec);
                                    System.out.println("+");
                                    p.add(t);
                                    i += 2;
                                    IscheckLegature = false;
                                    //Увеличение i нужно чтобы после добавления ligature счетчик продолжал после этой пары букв
                                    //Например : Привет - Лигатура Пр, следующая i должна быть на "и"->I+=2;
                                }

                              //3)Этот определяет следующую пару букв после метода выше, т.к. Есди цикд увеличит i++ то после одна буква пропустится
                                //Например Пр, следующая i должна быть на "и"->I+=2 после цикла i увеличится еще на i++ ->Будет i+=3;
                                if(!IscheckLegature) {
                                    textRise+=0.8;
                                    checkLegature1 = a1.substring(i, i + 2);
                                   if(word.isLegature(checkLegature1)) {
                                        t = new Text(checkLegature1);
                                        p.add(t);
                                        i+=2;

                                    }
                                }
                          //Обработка ошибки.
                            } catch (StringIndexOutOfBoundsException e) {

                            }
                            //Обработка ошибки, чтобы не добавлялась лишняя буква
                            if (i + 1> a1.length()) {
                              //  System.out.println("++");
                                break;
                            }

                            //t.setText(String.valueOf(a1.charAt(i)));
                            int random_number2 = 1 + (int) (Math.random() *4);

                            if (i == 0 && word.isSpecifiedLetterLower( a1.charAt(i)))
                                t= new Text(String.valueOf(a1.charAt(i))).setFont(fontSpec);
                                else {
                                    if(random_number2==1)
                                        t = new Text(String.valueOf(a1.charAt(i))).setFont(font);
                                    else if (random_number2 == 2)
                                        t = new Text(String.valueOf(a1.charAt(i))).setFont(font2);
                               else if(random_number2==3)
                                    t = new Text(String.valueOf(a1.charAt(i))).setFont(font3);
                                else if (random_number2 == 4)
                                    t = new Text(String.valueOf(a1.charAt(i))).setFont(font4);


                                }
                            p.add(t);


                        }


                    }
                    p.add(space);
                   //nstring подсчет сколько раз пройден цикл со словам, нужен чтобы определить в каком слове доавбить  setTextRise
                    nstring++;



                }

            }


            p.setMarginTop(0);
            p.setMarginBottom(0);
            if (title) {
                p.setFirstLineIndent(28.3465f);
                title = false;
           }
             else {
                title = false;
            }
            if (peremos1 ) {

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
            //Установка разных margin,если хватает места в строке( !resultwidth+6>maxSize) то добавляем
            System.out.println(spaceResult);
            //formargin нужен, потому что spaceResult складывается лишний раз с size пробела.
//            if(spaceResult-forMagrin+6<maxSize)
//            {
//                System.out.println("+++++++=====================");
//                if(n%2 == 0 )
//                    p.setMarginLeft(4);
//                if(n%3 == 0 )
//                    p.setMarginLeft(6);
//
//
//            }
            if( n%2 == 0){
                    System.out.println("4444+++++++=====================");

                p.setMarginLeft(4);


            }

            if( n%3 == 0)
            {
                System.out.println("666+++++++=====================");

                p.setMarginLeft(6);


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


            doc.add(p);
            n++;
        }

        //
        // System.out.println(word.getArrayList());

        doc.close();
        System.out.println(max);
        System.out.println(maxSize);
    }

}

