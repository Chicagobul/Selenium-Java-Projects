import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Datadriven
{
    public ArrayList<String> getData(String testcaseName) throws IOException
    {
        ArrayList<String> a = new ArrayList<String>();
        FileInputStream fis = new FileInputStream("D:\\demodata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        //XSSF
        //It’s Stand for “XML Spreadsheet Format”.It is used for xlsx file format of MS-Excel.

        int sheets = workbook.getNumberOfSheets();
        for (int i = 0; i < sheets; i++)
        {
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata"))
            {
                XSSFSheet sheet = workbook.getSheetAt(i);
                Iterator<Row> rows = sheet.iterator();
                // Identify the Testcases column by scanning the entire first row
                Row firstrow = rows.next();
                // firstrow will have all the data of first row
                Iterator<Cell> c = firstrow.cellIterator();
                int j = 0, column = 0;
                while (c.hasNext())
                {
                    Cell value = c.next();
                    if (value.getStringCellValue().equalsIgnoreCase("Testcases"))
                    {
                        column = j;
                    }
                    j++;
                }
                System.out.println(column);

                // Now we will only check the Testcases row to find Purchase
                while (rows.hasNext())
                {
                    Row r = rows.next();
                    if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
                    // Here we use r.getCell(column) as we want the cell value for every row at 0th
                        // index as column has value 0
                    {
                        Iterator<Cell> cl = r.cellIterator();
                        while (cl.hasNext())
                        {
                            Cell b = cl.next();
                            if (b.getCellType() == CellType.STRING)
                            {
                                a.add(b.getStringCellValue());
                            } else
                            {
                                a.add(NumberToTextConverter.toText(b.getNumericCellValue()));
                                // we are using NumberToTextConverter method to convert int values into string
                            }
                        }
                    }
                }
            }
        }
        return a;
    }


    public static void main(String[] args)
    {

    }
}






