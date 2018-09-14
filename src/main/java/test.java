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



String s  = "aa2abb23";
for(int i = 0; i<s.length();i++)
{
    if (Character.isAlphabetic(s.charAt(i)))
        System.out.println( s.charAt(i)+" +");
    else
        System.out.println(s.charAt(i)+" -");
}

    }

    }

