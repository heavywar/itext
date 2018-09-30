
import java.util.ArrayList;
import java.util.Random;

public class Word {
  static   ArrayList<String> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        String word ="Привет   гребаный мир гребаныйгребаный";

        Word w = new Word();
        arrayList =  w.RandomLetter_WithoutSpace(word);
        for(String s :arrayList) {
            System.out.println(s);
            char c = w.RandomLetter(s);
            System.out.println(c);
        }
    }




    public void test()
    {
        String word ="Привет   гребаный миррр ";
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


    public ArrayList<String> RandomLetter_WithoutSpace(String string){

ArrayList<String> arrayList = new ArrayList<>();
            for (String retval : string.split(" ", 0)) {
                if(retval.length()!=0)
                arrayList.add(retval);
            }
            return arrayList;

    }
    public char RandomLetter(String word) {

        Random rnd = new Random();
        int randomLenghtIndex = rnd.nextInt(word.length());//ПОзиция любой  буквы
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
