import java.util.HashMap;
import java.util.Map;

public class P3
{
    public static void main(String[] args)
    {
        HashMap<Integer,String> map = new HashMap<>();
        map.put(1,"fasd");
        map.put(2,"sdfg");
        map.put(3,"wasd");
        map.put(4,"derf");
        map.put(5,"bAgjhy");
        for (Map.Entry m:map.entrySet())
        {
            String val = (String) m.getValue();
            for (int i=1; i<2;i++)
            {
                if (val.charAt(i) == 'a' || val.charAt(i) == 'A')
                {
                    System.out.println(m.getKey()+" "+val);
                }
            }
        }
    }
}
