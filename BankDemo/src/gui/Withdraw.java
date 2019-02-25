package gui;

import bean.Account;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import custExp.WithdrawLimitException;
import resource.DBConnection;

public class Withdraw extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JLabel j1,j2;
	JTextField t1;
	JButton b1,b2;
	static Account a;
	Withdraw(Account a){
		Withdraw.a=a;
		this.setLayout(null);
		
		j1=new JLabel("Amount");
		j1.setBounds(80,80,90,30);
		this.add(j1);
		
		j2=new JLabel("Withdraw");
		j2.setBounds(150,30,150,50);
		j2.setFont(new Font("Arial",Font.BOLD,18));
		j2.setForeground(Color.blue);
		this.add(j2);
		
		t1=new JTextField();
		t1.setBounds(160,80,90,30);
		this.add(t1);
		
		b1=new JButton("Withdraw");
		b1.setBounds(80,160,90,30);
		this.add(b1);
		//Register the event on b1
		b1.addActionListener(this);
		
		b2=new JButton("Reset");
		b2.setBounds(180,160,90,30);
		this.add(b2);
		b2.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent ae){
		String msg=ae.getActionCommand();
		if(msg.equals("Withdraw")){
			Float amt = Float.parseFloat(t1.getText());
			try{
				if (amt>4500.0)
					throw new WithdrawLimitException("Withdraw Limit is Rs. 4500");	
				Connection con=DBConnection.getDBConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from account where accno = "+a.getAccno());
				rs.next();     
				float amt_exist = rs.getFloat(3);
				if ((amt_exist-amt)<500)
					throw new WithdrawLimitException("Insufficient Balance");
				stmt.executeUpdate("update account set balance = "+(amt_exist-amt)+" where accno ="+a.getAccno());
				JOptionPane.showMessageDialog(this,"Withdraw Successfull");
				con.close();
				stmt.close();
				Home hh=new Home(a);
				hh.setVisible(true);
				hh.setSize(600,600);
				this.setVisible(false);
			}catch(Exception e){
				JOptionPane.showMessageDialog(this,e.getMessage());
			}
		}else{
			t1.setText("");
		}		
	}
	public static void main(String args[]){
		Withdraw obj=new Withdraw(a);
		obj.setVisible(true);
		obj.setSize(600,600);
		obj.setTitle("Withdraw Page");
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}