import org.apache.commons.lang.RandomStringUtils;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
//        Random r = new Random();
//        r.ints(20);
//        String alphabet = "абмвгдезжиклмнопрстуфхцчщ";
//        for (int i = 0; i < 50; i++) {
//
//            //System.out.println(alphabet.charAt(r.nextInt(10)));
//        } // prints 50 random characters from alphabet
//        String a = RandomStringUtils.random(alphabet.length()/5,alphabet);
//       for(int i = 0; i<a.length();i++)
//           System.out.println(a.charAt(i));
//    }
//        String chars = "Привет";
//        Random rnd = new Random();
//        char c = chars.charAt(rnd.nextInt(chars.length()));
//        System.out.println(c);
//        StringBuilder stringBuilder;
        String ar = "Привет";

        int afValue = ar.indexOf('в');
        int result = ar.length() - afValue;
        System.out.println(afValue);
        String sub = "";
        //System.out.println(sub);
//        char[] a = new  char[result];
        //System.out.println(a);

        for(int i = 0;i<=result;i++)
        {
             sub = ar.substring(afValue,afValue+i);
            System.out.println(sub);




        }

//         System.out.println(a[0]);
//        System.out.println(a[1]);
//        System.out.println(a[2]);



    }

    }

