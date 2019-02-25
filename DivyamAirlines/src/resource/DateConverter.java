package resource;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter{
	public static java.sql.Date getDate(String s)throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dd = sdf.parse(s);
		java.sql.Date dd1 = new java.sql.Date(dd.getTime());
		return dd1;
	}
	/*public static void main(String[] args)throws Exception{
		System.out.println(getDate("17/12/2016"));
	}*/
}
