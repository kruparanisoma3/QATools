package Utils;

import java.util.Date;

public class DateFun {
	
	public static String datem() {
		Date date=new Date();
		return date.toString().replace(":", "-").replace(" ", "-");
		 
		
		
	}

}
