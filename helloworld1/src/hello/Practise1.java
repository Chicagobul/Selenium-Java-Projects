package hello;

public class Practise1
{
    public static void main(String[] args)
    {
        int k=3;
        int l=1;
        for(int i=1;i<5;i++)
        {
            for(int j=1;j<=i;j++)
            {
                System.out.print(l*k);
                System.out.print("\t");
                l++;
            }
            System.out.println("");

        }
    }

}

