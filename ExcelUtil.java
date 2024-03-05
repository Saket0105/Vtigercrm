package CommonUtil;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
public String getDataFromExcel(String Sheetname,int Rownum,int Cellnum) throws EncryptedDocumentException, IOException {
	FileInputStream file=new FileInputStream("src\\test\\resources\\Data.xlsx");
	Workbook work = WorkbookFactory.create(file);
	Sheet sh = work.getSheet(Sheetname);
	Row rw = sh.getRow(Rownum) ;
	 Cell cl = rw.getCell(Cellnum);
    String value = cl.getStringCellValue();
 
	
	return value;
}
}
