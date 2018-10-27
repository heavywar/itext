
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.Paragraph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import main.Words;


public class Hyphenator {
    public static final String FONTSpecEnd= "D:\\allFonts\\fontSpecEndLetter.ttf";


    private String x = "йьъ";
    private String g = "аеёиоуыэюяaeiouy";
    private String s = "бвгджзклмнпрстфхцчшщbcdfghjklmnpqrstvwxz";
    private Vector rules = new Vector();
    public float minusResult;
    public   PdfFont  fontSpecEndLetter;
    public float minusResult2;
    public float resultMargin;

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

    public static void main(String[] args) {
        Hyphenator h = new Hyphenator();
        System.out.println(h.hyphenateWord("авторемонтник"));
        System.out.println(h.hyphenateWord("переоральный"));
        System.out.println(h.hyphenateWord("интернационализация"));
        System.out.println(h.hyphenateWord("Windows"));
    }


    public String hyphenateWord(String text) {
        test test = new test();
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


        System.out.println(text);


        return text;
    }

//    public String max (float max ,float one,String text)
//    {
//       String string = "Автомеханник";
//    }

    public ArrayList <String> widtString(float result,float maxSize,PdfFont font,String str) throws IOException {
          fontSpecEndLetter =  PdfFontFactory.createFont(FONTSpecEnd, PdfEncodings.IDENTITY_H, true);
        resultMargin = 0;
        //System.out.println(" m = " +maxSize);
        minusResult = 0;
        ArrayList <String> StringRes = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        float space = font.getWidth(" ",test.sizefont);
        float hyphen =  font.getWidth("-",test.sizefont);
        String s = hyphenateWord(str);
       ArrayList<String> ar = ArrayList(s);
         int n = 0;
        int n1 = 0;
         boolean Break = true;
        boolean exs = true;

        boolean Break22 = true;
        if(result +font.getWidth(str,test.sizefont)-space<maxSize )
        {
            minusResult = 0;
            resultMargin = result+font.getWidth(str,test.sizefont)-space;
            StringRes.add(str);
            StringRes.add("");
            System.out.println("break222");
            System.out.println("!!!resultMargin = " + resultMargin);
            return StringRes;

           // return StringRes.add(str);
        }

        result+=hyphen;
        if(result + font.getWidth(ar.get(0),test.sizefont)>maxSize)
        {
            minusResult = font.getWidth(str,test.sizefont);
            resultMargin = result-hyphen-space;
            System.out.println("break");
            System.out.println("!!!resultMargin = " + resultMargin);

            StringRes.add("");
            StringRes.add(str);
            return StringRes;
        }
int count = 0;
String lastSlog ="";
float resTest = result;
        for(int i = 0; i<ar.size();i++) {
            float res = font.getWidth(ar.get(i), test.sizefont);
          //  System.out.println("часть - " + ar.get(i) + " Width части - " + res + " width Result - " + result + res);


            resTest += res;



            if (resTest < maxSize ) {
                lastSlog = ar.get(i);

            }
        }
       for(int i = 0; i<ar.size();i++)
       {
           float res = font.getWidth(ar.get(i),test.sizefont);
          // float res12 = font.getWidth(ar.get(i+1),test.sizefont);

          System.out.println("часть - " + ar.get(i) + " Width части - "+ res + " width Result - " + result+res);
           Words words =new Words();

           float res1 = 0;
           float res2 = 0;
           float res3 = 0;
           float res4 = 0;
           result+=res;
           if(result<=maxSize) {
               resultMargin = result;
               n1 += ar.get(i).length();
               count++;//3

           }
            if (result<maxSize && Break &&ar.get(i).equals(lastSlog)) {

               res1 = fontSpecEndLetter.getWidth(str.substring(n1 - 1, n1), test.sizefont);
               res2 = font.getWidth(str.substring(n1 - 2, n1-1), test.sizefont);
                res3 = font.getWidth(str.substring(n1 - 1, n1), test.sizefont);
                res4 =font.getWidth(str.substring(n1 - 2, n1-1), test.sizefont);
                System.out.println("%%" + str.substring(n1 - 2, n1-1) +" " + res2);
                System.out.println("%%" + str.substring(n1 - 1, n1)+" " + res1);
                System.out.println(ar.get(i).charAt(ar.get(i).length()-2)+" " + res4);
                System.out.println(ar.get(i).charAt(ar.get(i).length()-1)+" " + res3);

               if(words.isSpecifiedLetterLowerLast(str.substring(n1 - 1, n1).charAt(0))){
                   System.out.println("ar.get" +ar.get(i));
                   System.out.println("resultR1 " + result);
                   System.out.println("res " +res);
                   System.out.println("res3+res4 " + res3+res4);
                   System.out.println("res1+res2 " + res1+res2);
                   System.out.println(res1+res2);
                  // result -=((res3+res4)-(res1+res2));
                   System.out.println("!!!" + ((res3+res4)-(res1+res2)));
                   System.out.println("resultR " + result);

               }

               //Break = false;

           }


           if(result<=maxSize) {

               resultMargin = result;
               n += ar.get(i).length();
               stringBuffer.append(ar.get(i)+ "-");
           }
           else
           {
               stringBuffer.append(ar.get(i));
           }






       }
        System.out.println("!!!resultMargin5 = " + resultMargin);
        //System.out.println(" n = " +n + "str = " + str.length());
        System.out.println("stringBuffer " +stringBuffer);
        String hyphennext = "";
        String resultAp ="";
        if(n>str.length() || n==0 ) {
            resultAp = str;

        }
        else {
            hyphennext =   str.substring(n);
            StringRes.add(str.substring(0, n) + "-");
            StringRes.add(str.substring(n));
            //resultAp = str.substring(0, n) + "-" + str.substring(n);
        }

        minusResult = font.getWidth(hyphennext,test.sizefont);

        return StringRes;
    }

    public float widtCount(float result,float maxSize,PdfFont font,String str) throws IOException {
        fontSpecEndLetter =  PdfFontFactory.createFont(FONTSpecEnd, PdfEncodings.IDENTITY_H, true);
        resultMargin = 0;
        //System.out.println(" m = " +maxSize);
        minusResult = 0;
        ArrayList <String> StringRes = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        float space = font.getWidth(" ",test.sizefont);
        float hyphen =  font.getWidth("-",test.sizefont);
        String s = hyphenateWord(str);
        ArrayList<String> ar = ArrayList(s);
        int n = 0;
        boolean Break22 = true;
        int n1 = 0;
        boolean Break = true;
        boolean exs = true;
        if(result +font.getWidth(str,test.sizefont)-space<maxSize )
        {
            minusResult = 0;
            resultMargin = result+font.getWidth(str,test.sizefont)-space;
            StringRes.add(str);
            StringRes.add("");
            System.out.println("break222");
            System.out.println("+++resultMargin = " + resultMargin);
            return resultMargin;

            // return StringRes.add(str);
        }


        result+=hyphen;
        if(result + font.getWidth(ar.get(0),test.sizefont)>maxSize)
        {
            minusResult = font.getWidth(str,test.sizefont);
            resultMargin = result-hyphen-space;
            System.out.println("break");
            System.out.println("+++resultMargin = " + resultMargin);

            StringRes.add("");
            StringRes.add(str);
            return resultMargin;
        }

        String lastSlog ="";
        float resTest = result;
        for(int i = 0; i<ar.size();i++) {
            float res = font.getWidth(ar.get(i), test.sizefont);
            //  System.out.println("часть - " + ar.get(i) + " Width части - " + res + " width Result - " + result + res);


            resTest += res;



            if (resTest < maxSize ) {
                lastSlog = ar.get(i);

            }
        }
        for(int i = 0; i<ar.size();i++)
        {
            float res = font.getWidth(ar.get(i),test.sizefont);
            System.out.println("часть - " + ar.get(i) + " Width части - "+ res + " width Result - " + result+res);


            System.out.println("stringBuffer " +stringBuffer);
            Words words =new Words();

            float res1 = 0;
            float res2 = 0;
            float res3 = 0;
            float res4 = 0;
            result+=res;
            if(result<=maxSize) {
                resultMargin = result;
                n1 += ar.get(i).length();


            }
            if (result<maxSize && Break &&ar.get(i).equals(lastSlog)) {

                res1 = fontSpecEndLetter.getWidth(str.substring(n1 - 1, n1), test.sizefont);
                res2 = font.getWidth(str.substring(n1 - 2, n1-1), test.sizefont);
                res3 = font.getWidth(str.substring(n1 - 1, n1), test.sizefont);
                res4 =font.getWidth(str.substring(n1 - 2, n1-1), test.sizefont);
                System.out.println("%%" + str.substring(n1 - 2, n1-1) +" " + res2);
                System.out.println("%%" + str.substring(n1 - 1, n1)+" " + res1);
                System.out.println(ar.get(i).charAt(ar.get(i).length()-2)+" " + res4);
                System.out.println(ar.get(i).charAt(ar.get(i).length()-1)+" " + res3);

                if(words.isSpecifiedLetterLowerLast(str.substring(n1 - 1, n1).charAt(0))){
                    System.out.println("ar.get" +ar.get(i));
                    System.out.println("resultR1 " + result);
                    System.out.println("res " +res);
                    System.out.println("res3+res4 " + res3+res4);
                    System.out.println("res1+res2 " + res1+res2);
                    System.out.println(res1+res2);
                  //  result -=((res3+res4)-(res1+res2));
                    System.out.println("!!!" + ((res3+res4)-(res1+res2)));
                    System.out.println("resultR " + result);

                }

                //Break = false;

            }
            if(result<=maxSize) {
                resultMargin = result;
                n += ar.get(i).length();
                stringBuffer.append(ar.get(i)+ "-");
            }
            else
            {
                stringBuffer.append(ar.get(i));
            }






        }
        System.out.println("+++resultMargin= " + resultMargin);
        //System.out.println(" n = " +n + "str = " + str.length());
        System.out.println("stringBuffer " +stringBuffer);
        String hyphennext = "";
        String resultAp ="";
        if(n>str.length() || n==0 ) {
            resultAp = str;

        }
        else {
            hyphennext =   str.substring(n);
            StringRes.add(str.substring(0, n) + "-");
            StringRes.add(str.substring(n));
            //resultAp = str.substring(0, n) + "-" + str.substring(n);
        }

        minusResult = font.getWidth(hyphennext,test.sizefont);

        return resultMargin;

    }

    class HyphenPair {
        public String pattern;
        public int position;

        public HyphenPair(String pattern, int position) {
            this.pattern = pattern;
            this.position = position;
        }

    }


    public static ArrayList<String> ArrayList(String string){
        ArrayList<String> arrayList = new ArrayList<>();
        for (String retval : string.split("%-%", 0)) {
    String delespace;
    delespace = retval.replace(" " ,"");
                arrayList.add(delespace);





        }
        return arrayList;
}
    }

