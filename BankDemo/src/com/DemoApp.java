package com;

import java.util.Scanner;
import bean.Account;
import service.AccountService;

public class DemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int accno; String name, username, password; float amount;
		int ch = 0;
		AccountService as = new AccountService();
		Account ac;
		
		do
		{
			System.out.print("\n\n\t----Welcome to Demo Bank----");
			System.out.print("\n\tPress 1 to CREATE an account");
			System.out.print("\n\tPress 2 to WITHDRAW from an account");
			System.out.print("\n\tPress 3 to DEPOSIT into an account");
			System.out.print("\n\tPress 4 to check account BALANCE");
			System.out.print("\n\tPress 5 to TRANSFER amount");
			System.out.print("\n\tPress 6 to EXIT");
			System.out.print("\n\tEnter your choice : ");
			ch = sc.nextInt();
			
			switch(ch){
			case 1:
				System.out.print("\n\n\tEnter account number : "); accno = sc.nextInt();
				System.out.print("\tEnter name : "); name = sc.next();
				System.out.print("\tEnter username : "); username = sc.next();
				System.out.print("\tEnter password : "); password = sc.next();
				System.out.print("\tEnter amount : "); amount = sc.nextFloat();
				ac = new Account(accno,name,amount,username,password);
				try{as.createAccount(ac);}
				catch(Exception e){System.out.println(e);}
				break;
				
			case 2:
				System.out.print("\n\n\tEnter account number : "); accno = sc.nextInt();
				System.out.print("\tEnter amount : "); amount = sc.nextFloat();
				ac = new Account();
				ac.setAccno(accno);
				try{
					as.withdraw(ac,amount);
				}
				catch(Exception e){System.out.println(e);}
				break;
				
			case 3:
				System.out.print("\n\n\tEnter account number : "); accno = sc.nextInt();
				System.out.print("\tEnter amount : "); amount = sc.nextFloat();
				ac = new Account();
				ac.setAccno(accno);
				try{as.deposit(ac,amount);}
				catch(Exception e){System.out.println(e);}
				break;
				
			case 4:
				System.out.print("\n\n\tEnter account number : "); accno = sc.nextInt();
				ac = new Account();
				ac.setAccno(accno);
				try{as.checkBalance(ac);}
				catch(Exception e){System.out.println(e);}
				break;
				
			case 5:
				System.out.print("\n\n\tEnter your account number : "); int accno1 = sc.nextInt();
				Account ac1 = new Account(); ac1.setAccno(accno1);
				System.out.print("\tEnter payee account number : "); int accno2 = sc.nextInt();
				Account ac2 = new Account(); ac2.setAccno(accno2);
				System.out.print("\tEnter amount to be transferred : "); float amt = sc.nextFloat();
				try{
					as.transfer(ac1,ac2,amt);
				}catch(Exception e)
				{
					System.out.println(e);
				}
				break;				
			case 6:
				System.out.println("\n\tThank You!!");
				break;
				
			default:
				System.out.println("\tWrong Choice!!");
			}	
		}while(ch != 6);
		sc.close();

	}

}
