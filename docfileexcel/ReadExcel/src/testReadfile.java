
import readfilev2.ReadfileUtil;
public class testReadfile {

	public static void main(String[] args) {
//		
//		List<String> data = new ArrayList<String>();
//		data=ReadfileUtil.readExcel("E:/test.xls");
//		for (int i = 0; i < data.size(); i++) {
//			System.out.println(data.get(i));
		
//		}
		ReadfileUtil readfile = new ReadfileUtil("C:/Users/VA/Desktop/test.xlsx");
		String data = readfile.Readfile("Sheet1!B4");
		System.out.println(data);
	}
}
