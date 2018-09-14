
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceCmyk;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.ElementPropertyContainer;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.hyphenation.HyphenationConfig;
import com.itextpdf.layout.splitting.ISplitCharacters;
import org.apache.commons.lang.RandomStringUtils;

import java.io.File;
import java.util.ArrayList;


class Test {
    ArrayList<String>  WordList = new ArrayList<>();
    String MainWord = "При жизни Серова картина экспонировалась на Таврической выставке (1905), организованной Сергеем Дягилевым, на Русской художественной выставке в Париже (1906). Кроме того, портрет демонстрировался на коллективных выставках Союза русских художников. В 1920 году картина перешла в собственность Малого театра. С 1935 года находится в Государственной Третьяковской галерее (инв. номер 28079). Там же хранится единственный известный искусствоведам эскиз к портрету, выполненный Серовым и показывающий, что ещё до начала непосредственной работы художник определил композицию, выбрал ракурс, придающий образу монументальность, и решил сделать акцент на силуэте актрисы.";
    public static final String DEST = "./fonts/tutorial/f05_russian_encoding.pdf";
    public static final String FONT = "D:\\birch111.ttf";
    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new Test().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfFont font = PdfFontFactory.createFont(FONT, "Cp1251", true);

        //ArrayList<String> arrayList = new ArrayList<>();
        //arrayList.add("xxxxx");

        String b1 = "Привет ебаный мир(тестовая версия)";//
        Text text1 = new Text(b1);//

        text1.setFont(font).setFontSize(15);//
        String s = "fdfd";
        Paragraph p1 = new Paragraph(text1);//
       // p1.add(text1);
       // p1.add(text1);
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc);


        Paragraph p = new Paragraph();
        String sa = "Приветит2f";
        String sub = "";
        //int a = sa.indexOf('f');
       // System.out.println(a);
        int j = 1;
        int m = 0;
        float b = (float) 0.3;
        int afValue = sa.indexOf('в');
        for (int i = 0; i < sa.length(); i++) {
            Text t = new Text("");



              sub = sa.substring(afValue+m,afValue+j);
              System.out.println(sub);
              if (sa.charAt(i) == 'в') {
                 // t.setText(String.valueOf(sa.charAt(i)));
                  System.out.println(String.valueOf(sa.charAt(i)));

                  //t2.setTextRise((float) 1.2);

                  //t2.setSkew(0,10);
                  t.setRelativePosition(0, 0, 0, 1f);
//                  subcount = +1;
                  j++;
                  m++;


              } else if (sa.charAt(i) == sub.charAt(0)) {
                 // System.out.println("SUB " + String.valueOf(sa.charAt(i)));
                  t.setText(String.valueOf(sa.charAt(i)));
                  //t2.setTextRise((float) 1.2);
                  //t2.setSkew(0,10);

                  t.setRelativePosition(0, 0, 0, (float) (1+b));

                  j++;
                  m++;
                  b+=0.6;
                  System.out.println("BBB" +b);

          }

          //  System.out.println("В конце " + a);
            t.setText(String.valueOf(sa.charAt(i)));

            p.add(t);


        }

//
//
//
//
//
//        Paragraph p2 = new Paragraph();
//
//        ArrayList<String> stringArrayList = new ArrayList<>();
//stringArrayList.add("Привет");
//stringArrayList.add("мир");
//
//        for (int i = 0; i <stringArrayList.size(); i++)
//        {
//
//            System.out.println(stringArrayList.get(i));
//            for(int j = 0; j<stringArrayList.get(i).length();j++) {
//                Text t2 = new Text("");
//                if(stringArrayList.get(i).charAt(j) == 'и') {
//                    t2.setText(String.valueOf(stringArrayList.get(i).charAt(j)));
//                    System.out.println(String.valueOf(stringArrayList.get(i).charAt(j)));
//                    t2.setTextRise(5);
//                }
//                t2.setText(String.valueOf(stringArrayList.get(i).charAt(j)));
//                p2.add(t2);
//            }
//        }

        PdfCanvas canvas = new PdfCanvas(pdfDoc.addNewPage());
        Color magentaColor = new DeviceCmyk(0.f, 1.f, 0.f, 0.f);
        canvas.setStrokeColor(magentaColor);


        for (double y = 10; y < 1400; y += 20) {
            canvas.moveTo(0, y);
            canvas.lineTo(780, y);
        }


        canvas.closePathStroke();


      doc.add(returnRise().setFont(font));//
        //doc.add(returnRise().setFont(font).setFixedLeading(20));
        doc.close();
    }

        private Paragraph returnRise() {
            Word w = new Word();
           // String sub = "";
            //int a = sa.indexOf('f');
            // System.out.println(a);
            String sub = "";
            //float b = (float) 0.3;
            ArrayList<String> stringArrayList = new ArrayList<>();
            stringArrayList = w.RandomLetter_WithoutSpace(MainWord);
            Paragraph p = new Paragraph();
            int randomif =0;

            for (int i = 0; i <stringArrayList.size(); i++)
            {

                float countSetRise = (float) 0.3;
                int secondsub = 1;
                int firssub = 0;

               // System.out.println(stringArrayList.get(i));
                char c = w.RandomLetter(stringArrayList.get(i));
                char s = w.RandomLetter(stringArrayList.get(i));
              //  System.out.println("!!!!!!!!" + c + " " +s );
                int afValue = stringArrayList.get(i).indexOf(c);for(int j = 0; j<stringArrayList.get(i).length();j++) {
                Text t2 = new Text("");
                sub = stringArrayList.get(i).substring(afValue + firssub, afValue + secondsub);

                if (stringArrayList.get(i).charAt(j) == c) {
                    t2.setText(String.valueOf(stringArrayList.get(i).charAt(j)));


                    t2.setRelativePosition(0, 0, 0, 1 + countSetRise);

                    secondsub++;
                    firssub++;
                    countSetRise += 0.3;
                } else if (stringArrayList.get(i).charAt(j) == sub.charAt(0)) {
                    t2.setText(String.valueOf(stringArrayList.get(i).charAt(j)));


                    //t2.setSkew(0,10);
                    t2.setRelativePosition(0, 0, 0, 1 + countSetRise);
                    secondsub++;
                    firssub++;
                    countSetRise += 0.3;
                }
                randomif++;
                t2.setText(String.valueOf(stringArrayList.get(i).charAt(j)));
                p.add(t2);

            }

                p.add(" ");



            }
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
