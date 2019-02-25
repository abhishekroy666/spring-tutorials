package resource;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	
	public static int getDays(String date) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date departureDate = sdf.parse(date);
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(departureDate);
		
		Calendar cal2 = Calendar.getInstance();
		cal2.getTime();
		
		int days = cal1.get(Calendar.DAY_OF_YEAR)-cal2.get(Calendar.DAY_OF_YEAR);
		return days;
	}
}
