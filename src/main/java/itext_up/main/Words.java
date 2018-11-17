package itext_up.main;

import java.util.ArrayList;
import java.util.Random;

public class Words {
    private static ArrayList<String> arrayList = new ArrayList<>();

    public static ArrayList<String> getArrayList() {
        return arrayList;
    }

    public static void setArrayList(ArrayList<String> arrayList) {
        Words.arrayList = arrayList;
    }

//    public static void main(String[] args) {
//        String word ="Привет   гребаный мир гребаныйгребаный";
//
//        Words w = new Words();
//        arrayList =  w.Word_WithoutSpace(word);
//        for(String s :arrayList) {
//            System.out.println(s);
//            char c = w.RandomLetter(s);
//            System.out.println(c);
//        }
//    }


    public boolean isNumber(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

    public boolean isLeterSpec_Half(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = str.length()/2; i < str.length(); i++) {
            if (str.charAt(i) == 'д' || str.charAt(i) == 'у' || str.charAt(i) == 'з' || str.charAt(i) == 'щ' || str.charAt(i) == 'р' ||str.charAt(i) == 'ф'||str.charAt(i) == 'ц'||str.charAt(i) == 'щ' || str.charAt(i) == 'х'|| str.charAt(i) == 'ж'|| str.charAt(i) == 'г')
                return false;
        }
        return true;
    }
    public boolean isLeterSpec_Full(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'д' || str.charAt(i) == 'у' || str.charAt(i) == 'з' || str.charAt(i) == 'щ' || str.charAt(i) == 'р' ||str.charAt(i) == 'ф'||str.charAt(i) == 'ц'||str.charAt(i) == 'щ' )
                return false;
        }
        return true;
    }
    
    



    public ArrayList<String> Word_WithoutSpace(String string) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String retval : string.split(" ", 0)) {

            if (retval.length() != 0 && !retval.equals(" ")) {
                arrayList.add(retval);
                //  arrayList.add(" ");
            }
//

        }
        return arrayList;
    }
    public ArrayList<String> Word_WithoutSpaceforMainPdf(String string) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String retval : string.split(" ", 0)) {

            if (retval.length() != 0 && !retval.equals(" ")) {
                arrayList.add(retval+ " ");
                //arrayList.add(" ");
                //  arrayList.add(" ");
            }
//

        }
        return arrayList;
    }

    public char RandomLetter(String word) {

        Random rnd = new Random();
        int randomLenghtIndex = rnd.nextInt(word.length());//ПОзиция любой  буквы
        char c = word.charAt(randomLenghtIndex);
        String s = "";

        int random_number1 = 1 + (int) (Math.random() * 3);//Числа от 2 до 5
        if (randomLenghtIndex + random_number1 < word.length()) {
            s = word.substring(randomLenghtIndex, randomLenghtIndex + random_number1);
        }


        // System.out.println("Слово " + word +" Буква " + c +" Позиция " + randomLenghtIndex);
//        System.out.println("Новый рандом " + s);
//        System.out.println(minus);


        return c;
    }

    public int countSpace(String s) {
        int countSpace = 0;

        for (int i = 0; i < s.length(); i++) {


            if (s.charAt(i) == ' ') {
                countSpace++;
            } else {

                break;

            }

        }


        return countSpace;
    }


    public static boolean isLegature(String string)
    {
        String []Legature = {"аг","ав","ал","ах","ач","ая","аз","бв","бг","бя","бе","бя","бч","бж","вл","вя","ве","иг","ие","из","иг","их","ия","лег","рег","ег","еж","ез","еч","ог","оз","ож","ом","ол","оч","оэ","оя","о ","э ","ю ","ъ ","ь ","б ","в ","ст","пр","ее","ей"," в","иеч","иез","азг","вз","вг","ая","уз"," з"," ч"," х"," г","ич","ое","ий","о-","б-","в-","ю-","ъ-","ь-","э-","ав-","бв-","нг"};
        for(int i = 0; i<Legature.length;i++)
        {
            if(string.equals(Legature[i]))
                return true;


        }
        return false;


    }
    public  boolean isLegatureSpec(String string) {
        String[] Legature = {"Вг", "Вж", "Вэ", "Вч", "Вх",
                "Бг", "Бж", "Бэ", "Бч", "Бх",
                "Гг", "Гж", "Гэ", "Гч", "Гх",
                "Дг", "Дж", "Дэ", "Дч", "Дх",
                "Зг", "Зж", "Зэ", "Зч", "Зх",
                "Ог", "Ож", "Оэ", "Оч", "Ох",
                "Рг", "Рж", "Рэ", "Рч", "Рх",
                "Уг", "Уж", "Уэ", "Уч", "Ух",
                "Фг", "Фж", "Фэ", "Фч", "Фх",
                "Рг", "Рж", "Рэ", "Рч", "Рх",
                "Юг", "Юж", "Юэ", "Юч", "Юх"};
        for (int i = 0; i < Legature.length; i++) {
            if (string.equals(Legature[i]))
                return true;


        }
        return false;


    }
    public  boolean isSpecifiedLetterLowerfirst(char Char) {
        char[] Legature = {'г', 'ж', 'з', 'ч', 'х'};
        for (int i = 0; i < Legature.length; i++) {
            if (Char == Legature[i])
                return true;


        }
        return false;

    }
    public  boolean isSpecifiedLetterLowerLast(char Char) {
        char[] Legature = {'б', 'в', 'о', 'ю', 'ь','ф'};
        for (int i = 0; i < Legature.length; i++) {
            if (Char == Legature[i])
                return true;


        }
        return false;

    }

    public  boolean isSimbolForSpec(String str,int Int) {
        char[] SpecSimbol = {' ', ']',',', '.', ')', '?','!','1','2','3','4','5','6','7','8','9','0','*','#','"','-','+','=','%','<','>','/','&','|','-','_',';',':'};
        for(int i = 0 ; i<SpecSimbol.length;i++)
            if( str.length() >3 && str.charAt(Int) == SpecSimbol[i])
                return true;

        return false;

    }

}
