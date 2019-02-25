package rmi;

import java.rmi.*;
import bean.Account;

public interface Balance extends Remote{
	public float getBalance(Account a) throws RemoteException;
}
