
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.layout.element.Paragraph;

import java.util.ArrayList;
import java.util.Vector;


public class Hyphenator {


    private String x = "йьъ";
    private String g = "аеёиоуыэюяaeiouy";
    private String s = "бвгджзклмнпрстфхцчшщbcdfghjklmnpqrstvwxz";
    private Vector rules = new Vector();
    public float minusResult;
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
                hyphenatedText = hyphenatedText.substring(0, actualIndex) + "-"  + hyphenatedText.substring(actualIndex);
                text = text.substring(0, actualIndex) +  "-" + text.substring(actualIndex);
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

    public ArrayList <String> widtString(float result,float maxSize,PdfFont font,String str)
    {
        resultMargin = 0;
        //System.out.println(" m = " +maxSize);
        minusResult = 0;
        ArrayList <String> StringRes = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        float space = font.getWidth(" ",16);
        float hyphen =  font.getWidth("-",16);
        String s = hyphenateWord(str);
       ArrayList<String> ar = ArrayList(s);
         int n = 0;
         boolean Break = true;
        boolean Break22 = true;
        if(result +font.getWidth(str,16)-space<maxSize )
        {
            minusResult = 0;
            resultMargin = result+font.getWidth(str,16)-space;
            StringRes.add(str);
            StringRes.add("");
            System.out.println("break222");
            System.out.println("!!!resultMargin = " + resultMargin);
            return StringRes;

           // return StringRes.add(str);
        }
         boolean exs = true;

        result+=hyphen;
        if(result + font.getWidth(ar.get(0),16)>maxSize)
        {
            minusResult = font.getWidth(str,16);
            resultMargin = result-hyphen-space;
            System.out.println("break");
            System.out.println("!!!resultMargin = " + resultMargin);

            StringRes.add("");
            StringRes.add(str);
            return StringRes;
        }

       for(int i = 0; i<ar.size();i++)
       {
           float res = font.getWidth(ar.get(i),16);
           System.out.println("часть - " + ar.get(i) + " Width части - "+ res + " width Result - " + result+res);



           exs = false;

           //   System.out.println("res = " +res);
           result+=res;


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

        minusResult = font.getWidth(hyphennext,16);

        return StringRes;
    }

    public float widtCount(float result,float maxSize,PdfFont font,String str)
    {
        resultMargin = 0;
        //System.out.println(" m = " +maxSize);
        minusResult = 0;
        ArrayList <String> StringRes = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        float space = font.getWidth(" ",16);
        float hyphen =  font.getWidth("-",16);
        String s = hyphenateWord(str);
        ArrayList<String> ar = ArrayList(s);
        int n = 0;
        boolean Break = true;
        boolean Break22 = true;
        if(result +font.getWidth(str,16)-space<maxSize )
        {
            minusResult = 0;
            resultMargin = result+font.getWidth(str,16)-space;
            StringRes.add(str);
            StringRes.add("");
            System.out.println("break222");
            System.out.println("+++resultMargin = " + resultMargin);
            return resultMargin;

            // return StringRes.add(str);
        }
        boolean exs = true;

        result+=hyphen;
        if(result + font.getWidth(ar.get(0),16)>maxSize)
        {
            minusResult = font.getWidth(str,16);
            resultMargin = result-hyphen-space;
            System.out.println("break");
            System.out.println("+++resultMargin = " + resultMargin);

            StringRes.add("");
            StringRes.add(str);
            return resultMargin;
        }

        for(int i = 0; i<ar.size();i++)
        {
            float res = font.getWidth(ar.get(i),16);
            System.out.println("часть - " + ar.get(i) + " Width части - "+ res + " width Result - " + result+res);



            exs = false;

            //   System.out.println("res = " +res);
            result+=res;

            System.out.println("stringBuffer " +stringBuffer);

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

        minusResult = font.getWidth(hyphennext,16);

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
        for (String retval : string.split("-", 0)) {
    String delespace;
    delespace = retval.replace(" " ,"");
                arrayList.add(delespace);





        }
        return arrayList;
}
    }

