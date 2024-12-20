package SayaliAssignment;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

//File --> Workbook --> Sheet --> Rows --> Cells

public class ExcelReader{
    public static String[] readCredentials(String filelocation) throws IOException {

        String fileLocation = filelocation;
        String[] credentials = new String[2];

        FileInputStream file = new FileInputStream(fileLocation);

        XSSFWorkbook workbook = new XSSFWorkbook(file);      // create a workbook object
        XSSFSheet sheet = workbook.getSheet("Sheet1"); // create a sheet from Sheet1 at workbook

        int rows = sheet.getLastRowNum();
        int cells = sheet.getRow(1).getLastCellNum();

        for(int r=0; r<=rows; r++) { // iterating over each row top to bottom
            XSSFRow currentRow = sheet.getRow(r);

            for(int c=0; c<cells; c++) { // iterating over each cell left to right
                XSSFCell currentCell=currentRow.getCell(c);

                if(r==1) {
                    if(c==1) {
                        credentials[1] = currentCell.toString();
                    } else {
                        credentials[0] = currentCell.toString();
                    }
                } else {
                    break;
                }
            }
        }
        return credentials;
    }
}