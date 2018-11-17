package itext_up.main;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;


public class Hyphenator {
    public static final String FONTSpecEnd= "D:\\allFonts\\fontSpecEndLetter.ttf";
    public static final String fontSpecFirst= "D:\\allFonts\\fontSpecificLetter.ttf";




    private Vector rules = new Vector();
    public float minusResult;
    private   PdfFont  fontSpecEndLetter =  PdfFontFactory.createFont(FONTSpecEnd, PdfEncodings.IDENTITY_H, true);
    private   PdfFont   fontSpecFirstLetter =   PdfFontFactory.createFont(fontSpecFirst, PdfEncodings.IDENTITY_H, true);
    private float resultMargin;
    public   ArrayList <String> StringRes2 = new ArrayList<>();


    public Hyphenator() throws IOException {
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

        resultMargin = 0;
        minusResult = 0;
        ArrayList <String> getResultString = new ArrayList<>();
        float getwidthSpace = font.getWidth(" ", MainPdf.sizefont);
        float getwidthHyphen =  font.getWidth("-", MainPdf.sizefont);
        String lastWord = hyphenateWord(str);
        //System.out.println(str);
       ArrayList<String> syllables = Parts_by_syllables(lastWord);
         int n = 0;
        int n1 = 0;

// Если слово влизает и не нуден дифис то остается всё как етсь
        if(result +font.getWidth(str, MainPdf.sizefont)-getwidthSpace<maxSize )
        {
            minusResult = 0;
            resultMargin = result+font.getWidth(str, MainPdf.sizefont)-getwidthSpace;
            getResultString.add(str);
            getResultString.add("");

            return getResultString;


           // return StringRes.add(str);
        }

        result+=getwidthHyphen;
        //Если слово сразу перебрасывается на новую строку
        if(result + font.getWidth(syllables.get(0), MainPdf.sizefont)>maxSize)
        {
            minusResult = font.getWidth(str, MainPdf.sizefont);
            resultMargin = result-getwidthHyphen-getwidthSpace;
            getResultString.add("");
            getResultString.add(str);
            return getResultString;
        }

        Words words =new Words();

//Подсчет первой буквы если г. х и тд
        result = getResultFirsLetter(result, font, str, words);
        //Подсчет последней буквы
        result = getResultEndLetter(result, maxSize, font, str, syllables, words);

        for(int i = 0; i<syllables.size();i++)
       {
          float res = font.getWidth(syllables.get(i), MainPdf.sizefont);

          result+=res;
//           //Нужен чтобы узнать посл буквы перед дифисом


           if(result<=maxSize) {
               resultMargin = result;
               n += syllables.get(i).length();
           }


       }
        String hyphennext ;
            hyphennext =   str.substring(n);
            getResultString.add(str.substring(0, n) + "-");
            getResultString.add(str.substring(n));
            //minusResult нужен чтобы от result отнять перенесенные символы которые на новой строке
        minusResult = font.getWidth(hyphennext, MainPdf.sizefont);
        return getResultString;
    }



    //Дубликат нужен чтобы добавить пробелы
    public float widtCount(float result,float maxSize,PdfFont font,String str) throws IOException {
        StringRes2 = new ArrayList<>();
        resultMargin = 0;
        minusResult = 0;
        float space = font.getWidth(" ", MainPdf.sizefont);
        float hyphen =  font.getWidth("-", MainPdf.sizefont);
        String s = hyphenateWord(str);
        ArrayList<String> syllables = Parts_by_syllables(s);
        int n = 0;
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
        if(result + font.getWidth(syllables.get(0), MainPdf.sizefont)>maxSize)
        {
            minusResult = font.getWidth(str, MainPdf.sizefont);
            resultMargin = result-hyphen-space;

            StringRes2.add("");
            StringRes2.add(str);
            return resultMargin;
        }
        Words words =new Words();
       //Подсчет первой буквы если г. х и тд
        result = getResultFirsLetter(result, font, str, words);
        //Подсчет последней буквы
        result = getResultEndLetter(result, maxSize, font, str, syllables, words);
        for(int i = 0; i<syllables.size();i++)
        {
            float res = font.getWidth(syllables.get(i), MainPdf.sizefont);
//
            result+=res;
            if(result<=maxSize) {
                resultMargin = result;
                n += syllables.get(i).length();
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


    public static ArrayList<String> Parts_by_syllables(String string){
        //Разделаяю %-% Чтобы не было ошибок в словах типо: Что-нибудь и тд
        ArrayList<String> arrayList = new ArrayList<>();
        for (String retval : string.split("%-%", 0)) {
    String delespace;
    delespace = retval.replace(" " ,"");
                arrayList.add(delespace);


        }
        return arrayList;
}
    private float getResultEndLetter(float result, float maxSize, PdfFont font, String str, ArrayList<String> syllables, Words words) {
        float widthFirstLetterEdit;
        float widthFirstLetter;
        float widthresultFirstLetter;
        float resTest = result;

//        }
        int countlast = 0;
        for(int i = 0; i<syllables.size();i++) {
            float res = font.getWidth(syllables.get(i), MainPdf.sizefont);
            resTest += res;
            if(resTest<=maxSize) {
                countlast += syllables.get(i).length();
            }
        }
        char lastSym = str.substring(0, countlast).charAt(countlast-1);
        if(words.isSpecifiedLetterLowerLast(lastSym)) {
            widthFirstLetterEdit = fontSpecEndLetter.getWidth(lastSym, MainPdf.sizefont);
            widthFirstLetter = font.getWidth(lastSym, MainPdf.sizefont);
            widthresultFirstLetter = widthFirstLetter - widthFirstLetterEdit;
            result -= widthresultFirstLetter;
        }
        return result;
    }
    private float getResultFirsLetter(float result, PdfFont font, String str, Words words) {
        float widthFirstLetterEdit;
        float widthFirstLetter;
        float widthresultFirstLetter;
        if(words.isSpecifiedLetterLowerfirst(str.charAt(0))) {
            widthFirstLetterEdit = fontSpecFirstLetter.getWidth(str.charAt(0), MainPdf.sizefont);
            widthFirstLetter = font.getWidth(str.charAt(0), MainPdf.sizefont);
            widthresultFirstLetter = widthFirstLetter - widthFirstLetterEdit;
            result -= widthresultFirstLetter;
        }
        return result;
    }
    }

