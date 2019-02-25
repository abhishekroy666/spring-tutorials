package resource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	static Connection con;
	public static Connection getDBConnection()
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","system","tiger");
		}catch(Exception e)
		{
			System.out.println("\n\tDB Connection Error "+e);
		}
		return con;
	}	
}
