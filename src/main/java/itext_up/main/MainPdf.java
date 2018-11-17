package itext_up.main;//1)Печать четныый(дырки<-) 2)печать четных
//Если листов не четное количетсво то последний , для нечетных пустой,самый первый для печати(например листов 91)


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
import com.itextpdf.layout.property.Leading;
import com.itextpdf.layout.property.Property;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPdf {

    private  float upper_Margin = 4.251969f;
    private float botom_Margin = 61.6929f;
    private float left_Margin = 61.6929f;
    private float right_Margin = 0;
    private float line_Spacing = 28.4365f;
    private float line_Spacing_Grid_y = 28.4365f;
    private float line_Spacing_Grid_x = 28.4365f;
    private float FirstLineIndent = 28.3465f;
    private boolean Upward_of_letters = true;
    private int Upward_frequency_of_letters =5;
    private boolean  Up_Down_of_letters = true;
    private int Up_Down_frequency_of_letters =7;
    private float Paragraph_spacing = 28.4365f;;


    public static final String DEST = "./fonts/tutorial/TXTtest122.pdf";
    public static final String DEST1 = "./fonts/tutorial/TXTtest22.pdf";
    public static final String DEST2 = "D:\\1.txt";
    public static final String DEST3 = "./fonts/tutorial/Margin++.pdf";
    // public static final String FONT1 = "D:\\fontGZ....ttf";
    // public static final String FONT3 = "D:\\newFont2т.ttf";
    List<Byte>  fontLis = new ArrayList<>();
    private static final String FONT = "D:\\allFonts\\font.ttf";
    private static final String FONTSpec = "D:\\allFonts\\fontSpecificLetter.ttf";
    private static final String FONT2 = "D:\\allFonts\\Font2.ttf";
    private static final String FONT3 = "D:\\allFonts\\Font3.ttf";
    private static final String FONT4 = "D:\\allFonts\\Font4.ttf";
    private static final String FONTSpecEnd= "D:\\allFonts\\fontSpecEndLetter.ttf";
    private  static float  maxSize ;
    static ArrayList<PdfFont> FontList = new ArrayList();
    private ArrayList<PdfFont> FileFontList = new ArrayList();
    private static PdfFont font;
    private static PdfFont font2;
    private static PdfFont font3;
    private static PdfFont font4;
    private static PdfFont fontSpec;
    private  static PdfFont fontSpecEndLetter;
    public static  final int sizefont = 16;
    public static  boolean grid =false;
    //Добавлеине в лист width параграфов
    private static  ArrayList<Float> ListWidth = new ArrayList<>();
    //Добавление рандома
    private static ArrayList<Integer> ListRandFont = new ArrayList<>();
    private static  boolean title = true;



    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new MainPdf().manipulatePdf(DEST);
        new mirrorMargin().createPdf(DEST3);

    }

    protected void manipulatePdf(String dest) throws Exception {

        Color redColor = new DeviceCmyk(0, 0.76f, 0.86f, 0.01f);
        Color greenColor = new DeviceCmyk(0.78f, 0, 0.81f, 0.21f);
        Color yellowColor = new DeviceCmyk(0, 0, 0.76f, 0.01f);
        Color pein = new DeviceCmyk(86, 64, 0, 45);
        Color pein1 = new DeviceCmyk(72, 54, 0, 42);
        font = PdfFontFactory.createFont(FONT, PdfEncodings.IDENTITY_H, true);
        fontSpec = PdfFontFactory.createFont(FONTSpec, PdfEncodings.IDENTITY_H, true);
        font2 = PdfFontFactory.createFont(FONT2, PdfEncodings.IDENTITY_H, true);
        font3 = PdfFontFactory.createFont(FONT3, PdfEncodings.IDENTITY_H, true);
        font4 = PdfFontFactory.createFont(FONT4, PdfEncodings.IDENTITY_H, true);
        fontSpecEndLetter =  PdfFontFactory.createFont(FONTSpecEnd, PdfEncodings.IDENTITY_H, true);

        FontList.add(font);
        FontList.add(font2);
        FontList.add(font3);
        FontList.add(font4);

        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        PageSize ps = PageSize.A5;
        Document doc = new Document(pdfDoc, ps);
        doc.setProperty(Property.LEADING, new Leading(Leading.FIXED, line_Spacing));// не ровно 1 см (1.003176 )т.к если будет 1 см то не ровно при печати

        doc
                .setFontSize(sizefont);
                //  .setTextAlignment(TextAlignment.JUSTIFIED)


        maxSize = doc.getPdfDocument().getDefaultPageSize().getWidth() - (doc.getLeftMargin() + doc.getRightMargin());
        //6.5mm auto
        //4.251969f 7.086615f
        doc.setMargins(upper_Margin, right_Margin, botom_Margin, left_Margin);
        String line ;
        if(grid) {
            PdfCanvas canvas = new PdfCanvas(pdfDoc.addNewPage());

            Color magentaColor = new DeviceCmyk(0.f, 0.f, 0.f, 100.f);
            canvas.setStrokeColor(magentaColor);

            for (double y = upper_Margin; y <= 595; y += line_Spacing_Grid_y) {
                canvas.moveTo(0, y);
                canvas.lineTo(420, y);
            }
            for (double x = 0; x <= 420; x += line_Spacing_Grid_x) {
                canvas.moveTo(x, 0);
                canvas.lineTo(x, 595);
            }
            canvas.closePathStroke();

        }
        Words words = new Words();
        Hyphenator hyphenator = new Hyphenator();
        Words words1 = new Words();

        BufferedReader br = new BufferedReader(new FileReader(DEST2));
        //   String line;
        boolean IsEmpty = false;
        while ((line = br.readLine()) != null) {
            ListWidth = new ArrayList<>();
            ListRandFont = new ArrayList<>();
            float Fspace = font.getWidth(" ",sizefont);
            Boolean parag = true;
            ArrayList<String> StringRes = new ArrayList<>();
            //Добавляю чтобы не было ошибки null
            StringRes.add("");
            StringRes.add("");
            boolean paragCount = true;

            int n = 0;
            float result =0;
            float firstLine = 0;
            if(line.length()>70 || title ) {
                result = 28.3465f;
                firstLine = FirstLineIndent;
            }
            title =false;
            int count = 0;
            int listWidthCount = 0;
            if(line.isEmpty()) {

                IsEmpty =true;
            }
            Text t2 = new Text("");

            Paragraph p = new Paragraph();
            p.setFirstLineIndent(firstLine);
            List<String> ListSyllables = words.Word_WithoutSpaceforMainPdf(line);

            getWidthStroke_function((ArrayList<String>) ListSyllables,result);
            for (int i = 0; i < ListSyllables.size(); i++) {
                Text t;
//false становиться после дефиса
                if (!parag) {
                    result = 0;
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

                    for (int j = 0; j < StringRes.get(1).length(); j++) {
                        t2 = new Text(String.valueOf(StringRes.get(1).charAt(j)));
                        if (j ==StringRes.get(1).length() - 3&&StringRes.get(1).length()>3&&StringRes.get(1).charAt(j) == StringRes.get(1).charAt(StringRes.get(1).length() - 3) && words.isSimbolForSpec(StringRes.get(1),StringRes.get(1).length()-2) && words.isSpecifiedLetterLowerLast(StringRes.get(1).charAt(j))) {
                            t2.setFont(fontSpecEndLetter);
                            result += fontSpecEndLetter.getWidth(ListSyllables.get(i).charAt(j), sizefont);

                        }
//                        //Порсле пробела если буква о в б и тд. то доп шрифт
////Если вначале есть буква г з и тд то новый шрифт
                        else if (j == 0 && words.isSpecifiedLetterLowerfirst(StringRes.get(1).charAt(j))) {
                            t2.setFont(fontSpec);
                            result += fontSpec.getWidth(ListSyllables.get(i).charAt(j), sizefont);

                        }
                        else if (j ==StringRes.get(1).length() - 2 &&StringRes.get(1).length()>1&&StringRes.get(1).charAt(j) == StringRes.get(1).charAt(StringRes.get(1).length() - 2 ) && StringRes.get(1).charAt(StringRes.get(1).length() - 1) == ' ' && words.isSpecifiedLetterLowerLast(StringRes.get(1).charAt(j))) {
                            t2.setFont(fontSpecEndLetter);
                            result += fontSpecEndLetter.getWidth(ListSyllables.get(i).charAt(j), sizefont);
                        } else {
                            t2.setFont(font);
                            result += font.getWidth(StringRes.get(1).charAt(j), sizefont);
                        }
                        p.add(t2);

                    }
                }


                if (parag) {
                    int countChange = 0;
                    float textRise = 0;
                    float nplus = 0f;
                    float nminus = 0;
                    for (int j = 0; j < ListSyllables.get(i).length(); j++) {


                        t = new Text(String.valueOf(ListSyllables.get(i).charAt(j)));
                        //Буквы вверх
                        if (Upward_of_letters &&  i % Upward_frequency_of_letters == 0 && count!=0 && !words1.isNumber((ListSyllables.get(i))) && ListSyllables.get(i).length() > 5 && ListSyllables.get(i).length() < 11 ) {
                            countChange++;

                            //Первая половина букв вверпх
                          //  && words.isLeterSpec_Half(Alist.get(i))
                            if (i % 2 == 0) {
                                if (countChange < ListSyllables.get(i).length() / 2)
                                    textRise += 1.25;
                                //t.setTextRise(textRise);
                              //  t.setBackgroundColor(yellowColor);

                            }
                            //Вторая половигна букв вверх
                            else if(i%2 != 0 ){
                                if (countChange >= ListSyllables.get(i).length() / 2)
                                    textRise += 0.85;
                                  t.setTextRise(textRise);
                               // t.setBackgroundColor(yellowColor);



                            }


                        }


                        //Буквы вверх вниз
                        else if (Up_Down_of_letters && i % Up_Down_frequency_of_letters == 0 && count!=0 &&  !words1.isNumber((ListSyllables.get(i))) && ListSyllables.get(i).length() > 5) {
                            if (ListSyllables.get(i).length() <= 8) {
                                if (ListSyllables.get(i).length() / 2 >= countChange) {
                                    nplus += 1.0;
                                } else {

                                    nminus += 1.0;

                                }
                                t.setTextRise(nplus - nminus);
                              //   t.setBackgroundColor(redColor);
                            } else {
                                int NumberofLetters = 0;

                                switch (ListSyllables.get(i).length()) {

                                    case 12:
                                        NumberofLetters = 1;
                                        break;
                                    case 13:
                                        NumberofLetters = 1;
                                        break;
                                    case 14:
                                        NumberofLetters = 2;
                                        break;
                                    case 15:
                                        NumberofLetters = 2;
                                        break;
                                    case 16:
                                        NumberofLetters = 3;
                                        break;
                                    case 17:
                                        NumberofLetters = 3;
                                        break;

                                    default:
                                        NumberofLetters = 0;
                                        break;
                                }
                                if (countChange > 2 && countChange <= 4 + NumberofLetters) {//Со второй буквы по 4(+case) буквы вверх
                                    nplus += 1.0;
                                    t.setTextRise(nplus - nminus);
                                }
                                // с 5(+case) по 7(2х case, потому что в начале ничего не прибавляется (i>2)) ,буквы винз
                                else if (countChange >= 5 + NumberofLetters && countChange < 7 + NumberofLetters + NumberofLetters) {
                                    nminus += 1.0;
                                    // t.setBackgroundColor(redColor);
                                    t.setTextRise(nplus - nminus);
                                }
                              //   t.setBackgroundColor(greenColor);
                            }
                            countChange++;
                        }

                        //Если слово больше 3(нужено чтобы не было ошибки IndexOutOfBoundsException)И если слово с конца(+пробел) содержит -,.! и тд, то применяется специльный шрифт
                        if (j ==ListSyllables.get(i).length() - 3&& ListSyllables.get(i).length() > 3 && ListSyllables.get(i).charAt(j) == ListSyllables.get(i).charAt(ListSyllables.get(i).length() - 3) && words.isSimbolForSpec(ListSyllables.get(i),ListSyllables.get(i).length() - 2) && words.isSpecifiedLetterLowerLast(ListSyllables.get(i).charAt(j))) {
                            t.setFont(fontSpecEndLetter);
                            result += fontSpecEndLetter.getWidth(ListSyllables.get(i).charAt(j), sizefont);
                        }
                        //Порсле пробела если буква о в б и тд. то доп шрифт
                        else  if (j ==ListSyllables.get(i).length() - 2&& ListSyllables.get(i).length() > 1 && ListSyllables.get(i).charAt(j) == ListSyllables.get(i).charAt(ListSyllables.get(i).length() - 2) &&  ListSyllables.get(i).charAt(ListSyllables.get(i).length() - 1) == ' ' && words.isSpecifiedLetterLowerLast(ListSyllables.get(i).charAt(j))) {
                            t.setFont(fontSpecEndLetter);
                            result += fontSpecEndLetter.getWidth(ListSyllables.get(i).charAt(j), sizefont);
                        }
//Если вначале есть буква г з и тд то новый шрифт
                        else if (j == 0 && words.isSpecifiedLetterLowerfirst(ListSyllables.get(i).charAt(j))) {
                            t.setFont(fontSpec);
                            result += fontSpec.getWidth(ListSyllables.get(i).charAt(j), sizefont);

                        }
                        else {
                            //Добавление шрифта под номером ListRandFont(n)
                                    t.setFont(FontList.get(ListRandFont.get(n)));
                                    result += FontList.get(ListRandFont.get(n)).getWidth(ListSyllables.get(i).charAt(j), sizefont);
                        }

                        n++;
//add space
//
                        try {
                            //Расстановка пробелов
                            float F = ListWidth.get(listWidthCount) + Fspace;
                            if (F < maxSize) {
                                if (ListSyllables.get(i).charAt(j) == ' ') {
                                    t = new Text("  ");
                                    Fspace += Fspace;

                                }
                            }
                        } catch (IndexOutOfBoundsException ex) {
                        }
                        p.add(t);
                        //Нужен для ListRandFont

                    }
                }
                parag = true;
                try {

                    if (result + font.getWidth(ListSyllables.get(i + 1), sizefont) > maxSize) {
                        parag = false;
                        StringRes = hyphenator.widtString(result, maxSize, font, ListSyllables.get(i + 1));
                        float letter_after_hyph = hyphenator.minusResult;
                        //Из Hyphenotor часть слова после дифиса
                        // t2 = new Text(StringRes.get(1));
                        Fspace = font.getWidth(" ", sizefont);
                        //  result= 0+letter_after_hyph;
                        //
                        listWidthCount++;


                    }

                } catch (IndexOutOfBoundsException ex) {

                }

                if (ListSyllables.size() - 1 == i) { //Нужен чтобы доавить последнюю стоку.

                    paragCount = false;
                    StringRes.add(0,"");//НУжен!! чтобы не добавлялись лишкние символы в конце
                }

                if (!parag || !paragCount) {

                    for (int j = 0; j < StringRes.get(0).length(); j++) {
                        t = new Text(String.valueOf(StringRes.get(0).charAt(j)));
                        if (StringRes.get(0).length()>1 && StringRes.get(0).charAt(j) == StringRes.get(0).charAt(StringRes.get(0).length() - 2 )
                                && words.isSpecifiedLetterLowerLast(StringRes.get(0).charAt(j)) && j ==StringRes.get(0).length() - 2) {
                            t.setFont(fontSpecEndLetter);
                        }else if (j == 0 && words.isSpecifiedLetterLowerfirst(StringRes.get(0).charAt(j))) {
                            t.setFont(fontSpec);

                        }

                        else
                            t.setFont(font);


                        p.add(t);
                    }


                    if(IsEmpty ) {

                        p.setMarginTop(Paragraph_spacing);

                        p.setMarginBottom(0);
                        IsEmpty =false;
                    }
                    else {
                        p.setMarginBottom(0);
                        p.setMarginTop(0);
                    }
                    doc.add(p);
                }

            }

        }

        doc.close();

    }
    //Метож нжен для добавления прробелов
    public static void getWidthStroke_function(ArrayList<String> Alist, float result) throws IOException {
        Boolean parag = true;
        ArrayList <String> StringRes = new ArrayList<>();
        StringRes.add("");
        StringRes.add("");
        int count = 0;
        Hyphenator hyphenator = new Hyphenator();
        Words words = new Words();
        for (int i = 0; i < Alist.size(); i++) {
            if(!parag){
                //result = 0;
                result =0;
                count++;
                //Нужен для маржинслева
                if (count % 2 == 0) {
                    result += 3;
                }
                if (count % 3 == 0) {

                    result += 5;
                }
                for (int j = 0; j < StringRes.get(1).length(); j++) {
                    if (j ==StringRes.get(1).length() - 3&&StringRes.get(1).length()>3&&StringRes.get(1).charAt(j) == StringRes.get(1).charAt(StringRes.get(1).length() - 3) && words.isSimbolForSpec(StringRes.get(1),StringRes.get(1).length()-2) && words.isSpecifiedLetterLowerLast(StringRes.get(1).charAt(j))) {
                        result += fontSpecEndLetter.getWidth(Alist.get(i).charAt(j), sizefont);
                    }
//                        //Порсле пробела если буква о в б и тд. то доп шрифт
////Если вначале есть буква г з и тд то новый шрифт
                    else if (j == 0 && words.isSpecifiedLetterLowerfirst(StringRes.get(1).charAt(j))) {
                        result += fontSpec.getWidth(Alist.get(i).charAt(j), sizefont);

                    }
                    else if (j ==StringRes.get(1).length() - 2 &&StringRes.get(1).length()>1&&StringRes.get(1).charAt(j) == StringRes.get(1).charAt(StringRes.get(1).length() - 2 ) && StringRes.get(1).charAt(StringRes.get(1).length() - 1) == ' ' && words.isSpecifiedLetterLowerLast(StringRes.get(1).charAt(j))) {
                        result += fontSpecEndLetter.getWidth(Alist.get(i).charAt(j), sizefont);
                    } else {
                        result += font.getWidth(StringRes.get(1).charAt(j), sizefont);

                    }
                    ;
                    //StringRes.get(1);
                }
            }

            if (parag) {

                for (int j = 0; j < Alist.get(i).length(); j++) {
                    int rand = 0 + (int) (Math.random() * FontList.size());
                    //Если слово больше 3(нужено чтобы не было ошибки IndexOutOfBoundsException)И если слово с конца(+пробел) содержит -,.! и тд, то применяется специльный шрифт
                    if (j ==Alist.get(i).length() - 3&& Alist.get(i).length() > 3 && Alist.get(i).charAt(j) == Alist.get(i).charAt(Alist.get(i).length() - 3) && words.isSimbolForSpec(Alist.get(i),Alist.get(i).length() - 2) && words.isSpecifiedLetterLowerLast(Alist.get(i).charAt(j))) {

                        result += fontSpecEndLetter.getWidth(Alist.get(i).charAt(j), sizefont);

                    }
                    //Порсле пробела если буква о в б и тд. то доп шрифт

                    else  if (j ==Alist.get(i).length() - 2&& Alist.get(i).length() > 1 && Alist.get(i).charAt(j) == Alist.get(i).charAt(Alist.get(i).length() - 2) &&  Alist.get(i).charAt(Alist.get(i).length() - 1) == ' ' && words.isSpecifiedLetterLowerLast(Alist.get(i).charAt(j))) {
                        result += fontSpecEndLetter.getWidth(Alist.get(i).charAt(j), sizefont);
                    }
//Если вначале есть буква г з и тд то новый шрифт
                    else if (j == 0 && words.isSpecifiedLetterLowerfirst(Alist.get(i).charAt(j))) {
                        result += fontSpec.getWidth(Alist.get(i).charAt(j), sizefont);

                    }
                    else {
                            result += FontList.get(rand).getWidth(Alist.get(i).charAt(j), sizefont);
                    }
                    //Нужен чтобы правильно поставить буквы
                    ListRandFont.add(rand);




                }
            }
            parag = true;
            try {

                if (result + font.getWidth(Alist.get(i + 1), sizefont) > maxSize) {
                    float f= hyphenator.widtCount(result, maxSize, font, Alist.get(i + 1));
                    float letter_after_hyph = hyphenator.minusResult;
                    // result = 0 + letter_after_hyph;
                    ListWidth.add(f);
                    parag = false;
                    StringRes = hyphenator.StringRes2;
                    // System.out.println(hyphenator.StringRes2);

                }

            } catch (IndexOutOfBoundsException ex) { } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}





