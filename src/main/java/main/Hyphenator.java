package main;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;


public class Hyphenator {
    public static final String FONTSpecEnd= "D:\\allFonts\\fontSpecEndLetter.ttf";



    private Vector rules = new Vector();
    public float minusResult;
    private   PdfFont  fontSpecEndLetter;
    private float resultMargin;
    public   ArrayList <String> StringRes2 = new ArrayList<>();


    public Hyphenator() {
        rules.addElement(new HyphenPair("xgg", 1));
        rules.addElement(new HyphenPair("xgs", 1));
        rules.addElement(new HyphenPair("xsg", 1));
        rules.addElement(new HyphenPair("xss", 1));
        rules.addElement(new HyphenPair("gssssg", 3));
        rules.addElement(new HyphenPair("gsssg", 3));
        rules.addElement(new HyphenPair("gsssg", 2));
        rules.addElement(new HyphenPair("sgsg", 2));
        rules.addElement(new HyphenPair("gssg", 2));
        rules.addElement(new HyphenPair("sggg", 2));
        rules.addElement(new HyphenPair("sggs", 2));
    }


    public String hyphenateWord(String text) {
         String x = "йьъ";
         String g = "аеёиоуыэюяaeiouy";
         String s = "бвгджзклмнпрстфхцчшщbcdfghjklmnpqrstvwxz";
        MainPdf test = new MainPdf();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (x.indexOf(c) != -1) {
                sb.append("x");
            } else if (g.indexOf(c) != -1) {
                sb.append("g");
            } else if (s.indexOf(c) != -1) {
                sb.append("s");
            } else {
                sb.append(c);
            }
        }
        String hyphenatedText = sb.toString();

        for(int i = 0; i < rules.size(); i++) {
            HyphenPair hp = (HyphenPair) rules.elementAt(i);
            int index = hyphenatedText.indexOf(hp.pattern);
            while(index != -1) {
                int actualIndex = index + hp.position;
                hyphenatedText = hyphenatedText.substring(0, actualIndex) + "%-%"  + hyphenatedText.substring(actualIndex);
                text = text.substring(0, actualIndex) +  "%-%" + text.substring(actualIndex);
                index = hyphenatedText.indexOf(hp.pattern);
            }
        }




        return text;
    }

//    public String max (float max ,float one,String text)
//    {
//       String string = "Автомеханник";
//    }

    public ArrayList <String> widtString(float result,float maxSize,PdfFont font,String str) throws IOException {
          fontSpecEndLetter =  PdfFontFactory.createFont(FONTSpecEnd, PdfEncodings.IDENTITY_H, true);
        resultMargin = 0;
        minusResult = 0;
        ArrayList <String> StringRes = new ArrayList<>();
        float space = font.getWidth(" ", MainPdf.sizefont);
        float hyphen =  font.getWidth("-", MainPdf.sizefont);
        String s = hyphenateWord(str);
       ArrayList<String> ar = ArrayList(s);
         int n = 0;
        int n1 = 0;

// Если слово влизает и не нуден дифис то остается всё как етсь
        if(result +font.getWidth(str, MainPdf.sizefont)-space<maxSize )
        {
            minusResult = 0;
            resultMargin = result+font.getWidth(str, MainPdf.sizefont)-space;
            StringRes.add(str);
            StringRes.add("");
            return StringRes;

           // return StringRes.add(str);
        }

        result+=hyphen;
        //Если слово сразу перебрасывается на новую строку
        if(result + font.getWidth(ar.get(0), MainPdf.sizefont)>maxSize)
        {
            minusResult = font.getWidth(str, MainPdf.sizefont);
            resultMargin = result-hyphen-space;
            StringRes.add("");
            StringRes.add(str);
            return StringRes;
        }
String lastSlog ="";
float resTest = result;
//Нужен чтобы узнать последние буквы перед дифисом
        for(int i = 0; i<ar.size();i++) {
            float res = font.getWidth(ar.get(i), MainPdf.sizefont);
            resTest += res;
            if (resTest < maxSize ) {
                lastSlog = ar.get(i);
            }
        }
       for(int i = 0; i<ar.size();i++)
       {
           float res = font.getWidth(ar.get(i), MainPdf.sizefont);
          // float res12 = font.getWidth(ar.get(i+1),test.sizefont);
           Words words =new Words();
           float res1 , res2, res3, res4;
           result+=res;
           //Нужен чтобы узнать посл буквы перед дифисом
           if(result<=maxSize) {
               resultMargin = result;
               n1 += ar.get(i).length();

           }
           //Добавлеие специльно символа перед дифисом. Считаю разницу между буквами Например П+О-П+О(спец О)
            if (result<maxSize &&ar.get(i).equals(lastSlog)) {

               res1 = fontSpecEndLetter.getWidth(str.substring(n1 - 1, n1), MainPdf.sizefont);
               res2 = font.getWidth(str.substring(n1 - 2, n1-1), MainPdf.sizefont);
                res3 = font.getWidth(str.substring(n1 - 1, n1), MainPdf.sizefont);
                res4 =font.getWidth(str.substring(n1 - 2, n1-1), MainPdf.sizefont);

               if(words.isSpecifiedLetterLowerLast(str.substring(n1 - 1, n1).charAt(0))){

                   result -=((res3+res4)-(res1+res2));


               }

               //Break = false;

           }


           if(result<=maxSize) {
               resultMargin = result;
               n += ar.get(i).length();
           }







       }
        String hyphennext ;
            hyphennext =   str.substring(n);
            StringRes.add(str.substring(0, n) + "-");
            StringRes.add(str.substring(n));
            //minusResult нужен чтобы от result отнять перенесенные символы которые на новой строке
        minusResult = font.getWidth(hyphennext, MainPdf.sizefont);
        return StringRes;
    }
//Дубликат нужен чтобы добавить пробелы
    public float widtCount(float result,float maxSize,PdfFont font,String str) throws IOException {
        StringRes2 = new ArrayList<>();

        fontSpecEndLetter =  PdfFontFactory.createFont(FONTSpecEnd, PdfEncodings.IDENTITY_H, true);
        resultMargin = 0;
        minusResult = 0;
        float space = font.getWidth(" ", MainPdf.sizefont);
        float hyphen =  font.getWidth("-", MainPdf.sizefont);
        String s = hyphenateWord(str);
        ArrayList<String> ar = ArrayList(s);
        int n = 0;
        int n1 = 0;
        boolean Break = true;
        if(result +font.getWidth(str, MainPdf.sizefont)-space<maxSize )
        {
            minusResult = 0;
            resultMargin = result+font.getWidth(str, MainPdf.sizefont)-space;
            StringRes2.add(str);
            StringRes2.add("");
            return resultMargin;

            // return StringRes.add(str);
        }


        result+=hyphen;
        if(result + font.getWidth(ar.get(0), MainPdf.sizefont)>maxSize)
        {
            minusResult = font.getWidth(str, MainPdf.sizefont);
            resultMargin = result-hyphen-space;

            StringRes2.add("");
            StringRes2.add(str);
            return resultMargin;
        }

        String lastSlog ="";
        float resTest = result;
        for(int i = 0; i<ar.size();i++) {
            float res = font.getWidth(ar.get(i), MainPdf.sizefont);
            resTest += res;
            if (resTest < maxSize ) {
                lastSlog = ar.get(i);

            }
        }
        for(int i = 0; i<ar.size();i++)
        {
            float res = font.getWidth(ar.get(i), MainPdf.sizefont);
            Words words =new Words();
            float res1 , res2, res3, res4;
            result+=res;
            if(result<=maxSize) {
                resultMargin = result;
                n1 += ar.get(i).length();

            }
            if (result<maxSize &&ar.get(i).equals(lastSlog)) {

                res1 = fontSpecEndLetter.getWidth(str.substring(n1 - 1, n1), MainPdf.sizefont);
                res2 = font.getWidth(str.substring(n1 - 2, n1-1), MainPdf.sizefont);
                res3 = font.getWidth(str.substring(n1 - 1, n1), MainPdf.sizefont);
                res4 =font.getWidth(str.substring(n1 - 2, n1-1), MainPdf.sizefont);

                if(words.isSpecifiedLetterLowerLast(str.substring(n1 - 1, n1).charAt(0))){
                   result -=((res3+res4)-(res1+res2));

                }

            }
            if(result<=maxSize) {
                resultMargin = result;
                n += ar.get(i).length();
            }







        }
        String hyphennext = "";


            hyphennext =   str.substring(n);
            StringRes2.add(str.substring(0, n) + "-");
            StringRes2.add(str.substring(n));
            //resultAp = str.substring(0, n) + "-" + str.substring(n);


        minusResult = font.getWidth(hyphennext, MainPdf.sizefont);

        return resultMargin;

    }

    class HyphenPair {
        private String pattern;
        private int position;

        private HyphenPair(String pattern, int position) {
            this.pattern = pattern;
            this.position = position;
        }

    }


    public static ArrayList<String> ArrayList(String string){
        //Разделаяю %-% Чтобы не было ошибок в словах типо: Что-нибудь и тд
        ArrayList<String> arrayList = new ArrayList<>();
        for (String retval : string.split("%-%", 0)) {
    String delespace;
    delespace = retval.replace(" " ,"");
                arrayList.add(delespace);


        }
        return arrayList;
}
    }

