package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelWithDataProvider {
	@DataProvider(name="ExcelData")
	
	public Object[][] getExcelData() {
		Object[][] data=null;
		File src = new File("./TestData/Testdata.xlsx");

		try {
			FileInputStream fis = new FileInputStream(src);
			Workbook wb = new XSSFWorkbook(fis);
			// String w=wb.getSheetAt(1).getRow(0).getCell(0).getStringCellValue();
			// System.out.println(w);

			int rowNum = wb.getSheetAt(0).getPhysicalNumberOfRows();
			// System.out.println(rowNum);

			int cellNum = wb.getSheetAt(0).getRow(0).getPhysicalNumberOfCells();
			// System.out.println(cellNum);
			
			DataFormatter df = new DataFormatter();
			data=new Object[rowNum-1][cellNum];
			

			for (int i = 1; i < rowNum; i++) {
				for (int j = 0; j < cellNum; j++) {
					data[i-1][j] = df.formatCellValue(
							wb.getSheetAt(0).getRow(i).getCell(j));
					System.out.println(data);
				}
				wb.close();
				fis.close();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return data;
		

	}

}
