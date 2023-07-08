package hello;
//Printing reverse of a no.

import java.util.Scanner;

public class Prac4
{
    public static void main(String[] args)
    {
        int a=543;
        int reverse=0;
        while (a!=0)
        {
            int digit = a%10;
            reverse = digit + reverse*10;
            a = a/10;
        }
        System.out.println(reverse);
    }
}
