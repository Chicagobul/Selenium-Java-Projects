import java.io.IOException;
import java.util.ArrayList;

public class TestData
{
    public static void main(String[] args) throws IOException
    {
        Datadriven d = new Datadriven();
        ArrayList data = d.getData("Add Profile");
        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        System.out.println(data.get(3));
    }

}
