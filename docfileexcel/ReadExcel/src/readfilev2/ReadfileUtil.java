package readfilev2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadfileUtil {

	private Workbook workbook;
	private Sheet sheet;

	public Workbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}

	public ReadfileUtil(String filename) {
		if (filename != null && !filename.isEmpty()) {
			File file = new File(filename);
			if (file.canRead()) {
				try {
					FileInputStream fileInput = new FileInputStream(file);
					String[] a = filename.split("\\.");
					String string = a[a.length - 1];
					if (string.equals("xls")) {
						this.workbook = new HSSFWorkbook(fileInput);

					} else
						this.workbook = new XSSFWorkbook(fileInput);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}

	public ReadfileUtil() {
		// TODO Auto-generated constructor stub
	}

	public String Readfile(String pos) {
		// TODO Auto-generated method stub
		String[] a = pos.split("!");
		if (workbook != null)

		{
			Integer possheet = 0;
			for (int i = 4; i < a.length; i++) {
				possheet = possheet * 10;
				possheet += Integer.parseInt(String.valueOf(a[1].charAt(i)));

			}
			this.sheet = workbook.getSheetAt(possheet);
			if (sheet != null && sheet.getLastRowNum() > 0) {
				int posrow = 0;
				Integer poscell = 0;
				if ((int) (a[1].charAt(0)) < 97)
					poscell = (int) a[1].charAt(0) - 65;
				else
					poscell = (int) a[1].charAt(0) - 97;
				for (int i = 1; i < a[1].length(); i++) {
					posrow = posrow * 10;
					posrow += Integer.parseInt(String.valueOf(a[1].charAt(i)));

				}
				Row row = sheet.getRow(posrow-1);
				if(row!=null&&row.getLastCellNum()>0)
				{Cell cell = row.getCell(poscell);
//				return cell.getStringCellValue();
//				}
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					return cell.getStringCellValue();
				case Cell.CELL_TYPE_FORMULA:
					return cell.getCellFormula();
				case Cell.CELL_TYPE_NUMERIC:
					return String.valueOf(cell.getNumericCellValue());
				default:
					break;

				}}

			}

		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "nothing";
	}

}


