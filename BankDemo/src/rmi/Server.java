package rmi;

import java.rmi.*;

public class Server {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Balance b = new BalanceImp();
		Naming.rebind("rmi://192.168.1.85:1099/abc",b);
		System.out.println("\n\tObject added to RMI Registry");
	}

}
