package gui;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import resource.DBConnection;
import bean.Account;

public class Home extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JLabel j1;
	JButton b1,b2,b3,b4;
	static Account a;
	private static float bal;
	Home(Account a){
		Home.a=a;
		this.setLayout(null);
		
		// name of acc holder needs to be added
		
		String name= a.getName();
		j1 = new JLabel("Home Page "+name);
		j1.setBounds(160,30,150,50);
		j1.setFont(new Font("Arial",Font.BOLD,16));
		this.add(j1);
		
		b1 = new JButton("Deposit");
		b1.setBounds(160,80,90,30);
		this.add(b1);
		//Register the event on b1
		b1.addActionListener(this);
		
		b2 = new JButton("Withdraw");
		b2.setBounds(160,130,90,30);
		this.add(b2);
		b2.addActionListener(this);
		
		b3=new JButton("Balance");
		b3.setBounds(160,180,90,30);
		this.add(b3);
		b3.addActionListener(this);
		
		b4 = new JButton("Logout");
		b4.setBounds(160,250,90,30);
		this.add(b4);
		b4.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
			
			String msg=ae.getActionCommand();
			if(msg.equals("Deposit")){
				Deposit dd=new Deposit(a);
				dd.setVisible(true);
				dd.setSize(400,400);
				this.setVisible(false);
			}
			else if(msg.equals("Withdraw")){
				Withdraw ww = new Withdraw(a);
				ww.setVisible(true);
				ww.setSize(400,400);
				this.setVisible(false);
			}else if(msg.equals("Balance")){
				try{	
					Connection con = DBConnection.getDBConnection();
					PreparedStatement pstmt = con.prepareStatement("select balance from account where accno = ?");
					pstmt.setInt(1,a.getAccno());
					ResultSet rs = pstmt.executeQuery();
					rs.next();
					bal = rs.getFloat(1);
					con.close();
					pstmt.close();
				}
				catch(Exception e)
				{}
					JOptionPane.showMessageDialog(this,"Balance is : "+ bal);
			}
			else
			{
				AccountLogin aa = new AccountLogin();
				aa.setVisible(true);
				aa.setSize(600,600);
				this.setVisible(false);
			}
	}

	public static void main(String args[]){
		Home obj=new Home(a);
		obj.setVisible(true);
		obj.setSize(400,400);
		obj.setTitle("Home Page");
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
}