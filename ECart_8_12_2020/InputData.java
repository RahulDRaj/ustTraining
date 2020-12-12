package com.cart;

import java.util.Scanner;

public class InputData
{

    private static Scanner scanner = new Scanner(System.in);
    public static String getString(String string)  //Reading String
    {   String text;
        while(true)
        {
            System.out.println(string);
            text= scanner.next();
            if(!text.equals("")){
            break;}
            System.out.println("Entered String cannot be null");

        }
        return text;

    }

    public static float getNumber(String string,int min,int max) //Reading float between 2 values
    {
        float number = 0;

        while(true)
        {
            System.out.println(string);
            boolean repeat=true;
    while(repeat){
        try {
            number = scanner.nextFloat();
            repeat=false;
        }
        catch (Exception e){
            System.out.println("Please enter Data in prescribed format");
            scanner.nextLine();

            repeat=true;
        }
    }


            if(number>=min && number<=max){
                break;}
            System.out.println("Enter number between "+min+"and "+max);

        }
        return number;

    }

    public static float getNumber(String string) // Function overloading
    {

        return getNumber(string,0,Integer.MAX_VALUE);
    }
}
