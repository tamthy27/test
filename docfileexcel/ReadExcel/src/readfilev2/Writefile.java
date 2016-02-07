package readfilev2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writefile {
	private Workbook workbook;

	public Writefile(Map<String, String> test1) {
		Input((HashMap<String, String>) test1);
	}

	public void Writefilexe(String filename, String sheetname,
			String pos, String value) {
		// TODO Auto-generated constructor stub
		if (filename != null && !filename.isEmpty()) {
			File file = new File(filename);
			try {
				if (file.canRead()) {
					try {
						FileInputStream fileInput = new FileInputStream(file);
						String[] a = filename.split("\\.");
						String string = a[a.length - 1];
						if (string.equals("xls")) {
							this.workbook = new HSSFWorkbook(fileInput);

						} else
							this.workbook = new XSSFWorkbook(fileInput);
						//Sheet sheet = this.workbook.createSheet(sheetname);
						Sheet sheet = this.workbook.getSheet("Sheet1");
						setCellValue(sheet, pos, value);
					FileOutputStream fileout = new FileOutputStream(file);
						this.workbook.write(fileout);
						this.workbook.close();

					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			} catch (EncryptedDocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private  void setCellValue(Sheet sheet, String location, String value) {
		CellReference celRef = new CellReference(location);
		// Cell cell = sheet.getRow(celRef.getRow()).getCell(celRef.getCol());
		// System.out.println(sheet.createRow(celRef.getRow()));
		Cell cell = sheet.createRow(celRef.getRow())
				.createCell(celRef.getCol());
		// if(sheet.getRow(celRef.getRow()).getCell(celRef.getCol())==null)
		// {
		// // System.out.println(sheet.createRow(celRef.getRow()));
		// cell = sheet.createRow(celRef.getRow()).createCell(celRef.getCol());
		// }
		// else
		// cell = sheet.getRow(celRef.getRow()).getCell(celRef.getCol());
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC:
			cell.setCellValue(new Double(value));
		default:
			cell.setCellValue(value);
		}
	}

	private void Input(HashMap<String, String> inputfiles) {
		int row = 1;
		int cell = 65;

		for (String s : inputfiles.values()) {
			String pos = (char) cell + String.valueOf(row);
			Writefilexe("C:/Users/VA/Desktop/test.xls", "Sheet1", pos, s);
			row++;

		}
	}
}