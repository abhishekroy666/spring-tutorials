package rmi;

import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;

import resource.DBConnection;
import bean.Account;

public class BalanceImp extends UnicastRemoteObject implements Balance{
	
	private static final long serialVersionUID = 1L;
	BalanceImp() throws RemoteException
	{
	}
	
	@Override
	public float getBalance(Account a) throws RemoteException
	{
		float bal = 0;
		try{
			Connection con = DBConnection.getDBConnection();
			PreparedStatement p = con.prepareStatement("Select balance from account where accno = ?");
			p.setInt(1,a.getAccno());
			ResultSet rs = p.executeQuery();
			rs.next();
			bal = rs.getFloat(1);
			con.close();
			p.close();
			
		}
		catch(Exception e)
		{}
		return bal;
	}
}
