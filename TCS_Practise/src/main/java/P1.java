import java.sql.SQLOutput;

//Armstrong no.'s

public class P1
{
    public static void main(String[] args)
    {
        //int[] a={1,2,3,4,5,6,7};
        //int vol,con=0;
        int n=370;
        int temp=n;
        int r,sum=0;
        while (n>0)
        {
            r=n%10;
            sum=sum+r*r*r;
            n=n/10;
        }
        if (temp==sum)
        {
            System.out.println(temp+" "+"is an armstrong no.");
        }
        else
        {
            System.out.println(temp+" "+"is not an armstrong no.");
        }

    }
}

