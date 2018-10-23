package test;

import java.util.ArrayList;

public class testRemove {
   static ArrayList<String > spaseList;
    public static void main(String[] args) {
        testRemove testRemove  = new testRemove();



    }

    public static void  spaseListF (int count)

    {
        for(int i = 0; i<count;i++)
        {
            int random_number1 = 1 + (int) (Math.random() * 3);

                    if(random_number1 == 1)
                        spaseList.add(" ");
                    if(random_number1 == 2)
                        spaseList.add("  ");;
                    if(random_number1 == 3)
                        spaseList.add("  ");
        }


    }
}
