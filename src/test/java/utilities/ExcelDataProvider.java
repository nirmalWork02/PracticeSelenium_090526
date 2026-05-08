package utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	Workbook wb;

	public ExcelDataProvider() {

		File src = new File("./TestData/Testdata.xlsx");
		try {
			
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException ("File Not Found " + e.getMessage());
		}
	}

	public String getStringData(int sIndex, int row, int cell) {
		return wb.getSheetAt(sIndex).getRow(row).getCell(cell).getStringCellValue();
	}

	public double getNumericData(String sName, int row, int cell) {
		return wb.getSheet(sName).getRow(row).getCell(cell).getNumericCellValue();
	}

}
