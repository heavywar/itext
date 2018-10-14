package main;

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

    public boolean isLeterDZ(String str) {
        if (str == null || str.isEmpty()) return false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'д' || str.charAt(i) == 'у' || str.charAt(i) == 'з' || str.charAt(i) == 'щ' || str.charAt(i) == 'ц')
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

    public boolean checkLigature(String s) {

int i ;
return false;
    }
    public static  boolean isLegature(String string)
    {
        String []Legature = {"аг","ав","ал","ах","ач","ая","аз","бв","бг","бя","бе","бя","бч","бж","вл","вя","ве","иг","ие","из","иг","их","ия","лег","рег","ег","еж","ез","еч","ог","оз","ож","ом","ол","оч","оэ","оя","о ","б ","в ","ст","пр","ее","ей"," в","иеч","иез","азг","вз","вг","ая","уз"," з"," ч"," х"," г","ич","ое","ий","о-","б-","в-","ю-","ъ-","ь-","э-","ав-","бв-","нг"};
        for(int i = 0; i<Legature.length;i++)
        {
            if(string.equals(Legature[i]))
                return true;


        }
        return false;


    }
}
