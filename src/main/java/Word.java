import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.Random;

public class Word {
    ArrayList<String> arrayList = new ArrayList<>();
  //  String word ="Привет гребаный мир гребаныйгребаный";

    public static void main(String[] args) {
        Word w = new Word();

       w.test();
    }

    public void test()
    {
        String word ="Привет гребаный миррр ";
        arrayList = RandomLetter_WithoutSpace(word);
   String a[] = new String[2];
        for(int i = 0;i<arrayList.size();i++)
        {
           arrayList.get(i);

            char c = RandomLetter(arrayList.get(i));
           // System.out.println(c);
           // System.out.println(arrayList.get(i));
            for(int j = 0; j<arrayList.get(i).length();j++)
            {
                if(arrayList.get(i).charAt(j)== c)
                {
                  // System.out.println("+");
                  break;

                }
            }
        }

    }


    public ArrayList<String> RandomLetter_WithoutSpace(String word){
ArrayList<String> arrayList = new ArrayList<>();
            for (String retval : word.split(" ", 0)) {
                arrayList.add(retval);
            }
            return arrayList;

    }
    public char RandomLetter(String word) {
        Random rnd = new Random();
        int randomLenghtIndex = rnd.nextInt(word.length());//ПОзиция любой  буквы
        int minus = word.length() - randomLenghtIndex;// Разница между всеми буква и найденой
     char c = word.charAt(randomLenghtIndex);
        String s = "";

       int random_number1 = 1 + (int) (Math.random() * 3);//Числа от 2 до 5
        if(randomLenghtIndex+random_number1<word.length()) {
             s = word.substring(randomLenghtIndex, randomLenghtIndex + random_number1);
        }


       // System.out.println("Слово " + word +" Буква " + c +" Позиция " + randomLenghtIndex);
//        System.out.println("Новый рандом " + s);
//        System.out.println(minus);


        return c;
    }


}
