
import java.util.HashMap;
import java.util.Map;

import readfilev2.ReadfileUtil;
import readfilev2.Writefile;
public class testReadfile {

	public static void main(String[] args) {
//		
//		List<String> data = new ArrayList<String>();
//		data=ReadfileUtil.readExcel("E:/test.xls");
//		for (int i = 0; i < data.size(); i++) {
//			System.out.println(data.get(i));
		
//		}
		
		
//		
//		ReadfileUtil readfile = new ReadfileUtil("C:/Users/VA/Desktop/test.xlsx");
//		String data = readfile.Readfile("Sheet1!B4");
//		System.out.println(data);
		Map<String , String	> test1 = new HashMap<String, String>();
		test1.put("121", "abe");
		test1.put("122", "abk");
		test1.put("123", "abe");
		test1.put("121", "abc");
		Writefile wr = new Writefile(test1);
	}
}
