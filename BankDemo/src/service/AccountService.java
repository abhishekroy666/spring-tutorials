package service;

import bean.Account;

import java.sql.*;
import resource.DBConnection;
import custExp.InsufficientBalanceException;
import custExp.UniqueIdException;
import custExp.WithdrawLimitException;

public class AccountService {
		
	public void createAccount(Account ac) throws Exception
	{
		try{
			Connection con = DBConnection.getDBConnection();
			PreparedStatement ins = con.prepareStatement("insert into account values(?,?,?)");
			ins.setInt(1,ac.getAccno());
			ins.setString(2, ac.getName());
			ins.setFloat(3,ac.getAmount());
			int res = ins.executeUpdate();
			if(res>0)
			{
				System.out.println("\n\tAccount Successfully Created..");
			}
			else
			{
				throw new UniqueIdException("ID Already Exists");
			}
			ins.close();
			con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
			//acc number must be unique
			//amount>500 else exception
	}
	
	public void withdraw(Account ac,float amt) throws Exception
	{
		try{
			if(amt>4500.0)
				throw new WithdrawLimitException("Limit is Rs. 4500");
			Connection con = DBConnection.getDBConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from account");
			int flag = 0;
			while(rs.next())
			{
				int accno = rs.getInt(1);
				if(accno == ac.getAccno())
				{
					float deduct = rs.getFloat(3);
					deduct -= amt;
					if(deduct < 500.0)
						throw new InsufficientBalanceException("Insufficient Balance");
					PreparedStatement with = con.prepareStatement("update account set balance = ? where accno = ?");
					with.setFloat(1,deduct);
					with.setInt(2,ac.getAccno());
								
					int res = with.executeUpdate();
					if(res>0)
					{
						System.out.println("\n\tAmount Withdrawn..");
						with.close();
						flag = 1;
						break;
					}
					with.close();
					
				}				
			}	
			if(flag == 0)
				throw new UniqueIdException("ID Mismatch!!");
			stmt.close();
			con.close();
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
			// min balance in account 500
			//max withdraw 4500
	}
	
	public void deposit(Account ac,float amt) throws Exception
	{
		try{
			Connection con = DBConnection.getDBConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from account");
			int flag = 0;
			while(rs.next())
			{
				int accno = rs.getInt(1);
				if(accno == ac.getAccno())
				{
					float add = rs.getFloat(3);
					add += amt;
					if(add>50000)
						throw new Exception("PAN Card required");
					PreparedStatement dep = con.prepareStatement("update account set balance = ? where accno = ?");
					dep.setFloat(1,add);
					dep.setInt(2,ac.getAccno());
								
					int res = dep.executeUpdate();
					if(res>0)
					{
						System.out.println("\n\tAmount Added..");
						dep.close();
						flag = 1;
						break;
					}
					dep.close();
				}				
			}
			if(flag == 0)
				throw new UniqueIdException("ID Mismatch!!");
			stmt.close();
			con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}	//>50000 ask pan card
	}
	
	public void checkBalance(Account ac) throws Exception
	{
		try{
			Connection con = DBConnection.getDBConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from account");
			int flag = 0;
			while(rs.next())
			{
				int accno = rs.getInt(1);
				if(accno == ac.getAccno())
				{
					System.out.println("\n\tBalance is "+rs.getFloat(3));
					flag = 1;
					break;
				}
			}
			if(flag == 0)
				throw new UniqueIdException("Account does not exist");
			stmt.close();
			con.close();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	public void transfer(Account ac1, Account ac2, float amount) throws Exception
	{
		withdraw(ac1,amount);
		deposit(ac2,amount);
	}
}
