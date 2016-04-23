package formatfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FormatFile {

    public static void readXLSXFile(File filepath, String xlsFile) throws IOException {
    

        //Creates instance  for reading xls, workbook,sheet, FileInputStream
        InputStream ExcelFileToRead = new FileInputStream(filepath);
        XSSFWorkbook wb = new XSSFWorkbook(ExcelFileToRead);
        XSSFSheet sheet = wb.getSheetAt(0);
         
        //Creates instances for writing output to xls format.
        String sheetName = "Import";//name of sheet
        HSSFWorkbook outWorkbook = new HSSFWorkbook();
        HSSFSheet outSheet = outWorkbook.createSheet(sheetName);

        //Variables to hold the data without ' and r for the row counter
        String cellReplace;
        int r = 0;
        
        //Outer and Inner loop for iterating through the workbook
        for (Row row : sheet) {

            HSSFRow outRow = outSheet.createRow(r);

            for (int cn = 0; cn < row.getLastCellNum(); cn++) {
                // If the cell is missing from the file, generate a blank one
                // (Works by specifying a MissingCellPolicy)
                Cell cell = row.getCell(cn, Row.CREATE_NULL_AS_BLANK);
                
                //NumberToTextConverter nc = new NumberToTextConverter.toText();
                //or
                DataFormatter df = new DataFormatter();
                String dataCell = df.formatCellValue(cell);
   
                //Replaces the single dash located in the data
                
                cellReplace = dataCell.replace("'", "");                         
                
                HSSFCell outCell = outRow.createCell(cn);
                outCell.setCellValue(cellReplace);
                //System.out.println("CELL: " + cn + " --> " + cellReplace);
                
                

            }//ends inner loop
            r++;
        }//ends outer loop

        FileOutputStream fileOut = new FileOutputStream(xlsFile.replace("xlsx", "xls"));
        outWorkbook.write(fileOut);
        fileOut.flush();
        System.out.print("File Exported Correclty");

    }


    public static void main(String[] args) throws IOException {
        //readXLSXFile();
        //writeXLSFile();

    }

}
