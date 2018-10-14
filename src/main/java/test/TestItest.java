package test;

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

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class TestItest {

   private String MainWord = "При жизни Серова картина экспонировалась на Таврической выставке (1905), организованной Сергеем Дягилевым, на Русской художественной выставке в Париже (1906). Кроме того, портрет демонстрировался на коллективных выставках Союза русских художников. В 1920 году картина перешла в собственность Малого театра. С 1935 года находится в Государственной Третьяковской галерее (инв. номер 28079). Там же хранится единственный известный искусствоведам эскиз к портрету, выполненный Серовым и показывающий, что ещё до начала непосредственной работы художник определил композицию, выбрал ракурс, придающий образу монументальность, и решил сделать акцент на силуэте актрисы.";
    public static final String DEST = "./fonts/tutorial/test.pdf";
    public static final String FONT = "D:\\birch111.ttf";
    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new TestItest().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfFont font = PdfFontFactory.createFont(FONT, "Cp1251", true);

        //ArrayList<String> arrayList = new ArrayList<>();
        //arrayList.add("xxxxx");
       String b1 = "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii1iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii";//
        Text text1 = new Text(b1);//
        PageSize ps = PageSize.A4;
        text1.setFont(font).setFontSize(15);//
        Paragraph p1 = new Paragraph(text1);//

        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc,ps);
        main.ReturnLine ReturnLine = new main.ReturnLine();
       List<String> ar = ReturnLine.splitLine("D:\\test.pdf");
        doc.setLeftMargin(0);
        doc.setRightMargin(0);
    int a = 0;
    int margin =5;
        int max=10;
        int min=5;
        Random rn = new Random();
        int diff=max-min;



       for(String split :ar)
       {
           Paragraph p = new Paragraph();
           int irand = rn.nextInt(diff+1);

           irand+=min;
           System.out.println(irand);
           if(a%2 == 0) {
               p.setMarginLeft(10+margin);
             //  p.setMarginLeft(10+margin);
               p.add(split);
           }
           else if(a%2 != 0){
             p.setMarginLeft(6+margin);
         // p.setMarginRight(6-margin);
           p.add(split);

           }
           a++;
           doc.add(p.setFont(font));
       }

        float pdfWidth1 =  pdfDoc.getDefaultPageSize().getWidth();
        float pdfWidth = pdfDoc.getDefaultPageSize().getWidth()-(doc.getRightMargin()+doc.getLeftMargin());
        float getWithFont = font.getWidth(b1,15 );
        float width1 = getWithFont;
        width1 /= 1000;
        System.out.println("a4 "  + pdfWidth1);
        System.out.println("width font" +getWithFont);
      //doc.add(p1);//


        PdfCanvas canvas = new PdfCanvas(pdfDoc.addNewPage());
        Color magentaColor = new DeviceCmyk(0.f, 1.f, 0.f, 0.f);
        canvas.setStrokeColor(magentaColor);


        for (double y = 10; y < 1400; y += 20) {
            canvas.moveTo(0, y);
            canvas.lineTo(780, y);
        }


        canvas.closePathStroke();

       // doc.add(returnRise().setFont(font).setFixedLeading(20).setHyphenation(new HyphenationConfig("ru", "none", 2, 2)));
        doc.close();
    }

        private Paragraph returnRise() {
            main.Words w = new main.Words();
            Color greenColor = new DeviceCmyk(0.78f, 0, 0.81f, 0.21f);
            Color yellowColor = new DeviceCmyk(0, 0, 0.76f, 0.01f);
            Color redColor = new DeviceCmyk(0, 0.76f, 0.86f, 0.01f);
            Color blueColor = new DeviceCmyk(0.28f, 0.11f, 0, 0);
            String sub;//String Для substring
            ArrayList<String> stringArrayList = new ArrayList<>();
            stringArrayList = w.Word_WithoutSpace(MainWord);
            Paragraph p = new Paragraph();
            int randomif =0;// Увеличивается for для каждого слова ,чтобы выбрать слово которое при использованииr remainder  возвращает 0
            int remainder = 4;//остаток,делиться на ranmomif

            for (int i = 0; i <stringArrayList.size(); i++) {
                 if(randomif %remainder ==0){//Если слово под номером randomif делиться на  remainder то заходим внутрь ,if нужен для того чтобы определить на сколько слов будет применяться setRise
                float countSetRise = (float) 0.6; //Устанавливает setRise и увиеличивается каждый раз
                int firssub = 0;// substring(+ firssub, + secondsub
                int secondsub = 1; //

                char c = w.RandomLetter(stringArrayList.get(i));//Ранлом буква с которой будет начинаться setRise
                char s = w.RandomLetter(stringArrayList.get(i));
                int afValue = stringArrayList.get(i).indexOf(c);
                for (int j = 0; j < stringArrayList.get(i).length(); j++) {
                    Text t2 = new Text("");
                    sub = stringArrayList.get(i).substring(afValue + firssub, afValue + secondsub);//Буквы которые должны увеличиваться(serRise)

                    if (stringArrayList.get(i).charAt(j) == c && Character.isAlphabetic(stringArrayList.get(i).charAt(j))) {
                        t2.setText(String.valueOf(stringArrayList.get(i).charAt(j)));

                        t2.setRelativePosition(0, 0, 0, 0 + countSetRise);
                       t2.setBold();
                        secondsub++;
                        firssub++;
                        countSetRise += 0.3;
                    }// закрытие if(sub)
                     else if (stringArrayList.get(i).charAt(j) == sub.charAt(0)  && Character.isAlphabetic(stringArrayList.get(i).charAt(j))) {
                        t2.setText(String.valueOf(stringArrayList.get(i).charAt(j)));
                        t2.setBold();

                        //t2.setSkew(0,10);
                        t2.setRelativePosition(0, 0, 0, 0 + countSetRise);
                        secondsub++;
                        firssub++;
                        countSetRise += 0.3;
                    }//Закрытие else
                    t2.setText(String.valueOf(stringArrayList.get(i).charAt(j)));
                    p.add(t2);


                }//Закрытие фор по буквам.



            }//Закрытие рандом иф
                if(randomif %remainder !=0) {// Чтобы добавить все остальные слова
                    Text t2 = new Text("");
                    if (randomif % (remainder+2) == 0) {
                        t2.setText(stringArrayList.get(i));
                        t2.setBackgroundColor(greenColor);
                        t2.setTextRise(5);

                    }
                    if (randomif % (remainder+2) != 0) {
                        t2.setText(stringArrayList.get(i));
                        t2.setBackgroundColor(redColor);
                    }
                    p.add(t2);
                }
                p.add(" ");
                randomif++;

            }//Закрытие фор
             return p;
        }
}//text.setHyphenation(new HyphenationConfig("ru", "none", 2, 2));
//    private Text returnCorrectColor(char letter) {
//        Text text = new Text("");
//        if (letter == 'и') {
//            text.setText(String.valueOf(letter));
//            text.setTextRise(4);
//        }
//        text.setText(String.valueOf(letter));
//    }
