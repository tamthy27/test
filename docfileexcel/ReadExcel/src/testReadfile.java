import java.util.ArrayList;
import java.util.List;


public class testReadfile {

	public static void main(String[] args) {
		
		List<String> data = new ArrayList<String>();
		data=ReadfileUtil.readExcel("E:/test.xls");
		for (int i = 0; i < data.size(); i++) {
			System.out.println(data.get(i));
		}
		
	}
}
