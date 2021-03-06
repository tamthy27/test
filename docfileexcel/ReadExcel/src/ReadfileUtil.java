import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;


public class ReadfileUtil {

	public static List<String> readExcel (String filename)
	{
		if(filename!=null&&!filename.isEmpty())
		{
			File file = new File(filename);
			if(file.canRead())
			{
				try {
					FileInputStream input = new FileInputStream(file);
					HSSFWorkbook hssfWorkbook = new HSSFWorkbook(input);
					if(hssfWorkbook!=null)
					{
						HSSFSheet sheet =  hssfWorkbook.getSheetAt(0);
						if(sheet!=null&&sheet.getLastRowNum()>0)
						{
							List<String> lstdata = new ArrayList<String>();
							for (int i = 0; i <= sheet.getLastRowNum(); i++) {
								Row row = sheet.getRow(i);
								if(row!=null&&row.getLastCellNum()>0)
								{
									String data = row.getCell(0).getStringCellValue();
									lstdata.add(data);
								}
							}
							return lstdata;	
						}
						
					}
					
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
		return null;
	}
}
