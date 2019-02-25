package gui;

import bean.Account;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import resource.DBConnection;


public class Deposit extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JLabel j1,j2;
	JTextField t1;
	JButton b1,b2;
	static Account a;
	Deposit(Account a){
		Deposit.a=a;
		this.setLayout(null);
		
		j1=new JLabel("Amount");
		j1.setBounds(80,80,90,30);
		this.add(j1);
		
		j2=new JLabel("Deposit");
		j2.setBounds(150,30,150,50);
		j2.setFont(new Font("Arial",Font.BOLD,18));
		j2.setForeground(Color.blue);
		this.add(j2);
		
		t1=new JTextField();
		t1.setBounds(160,80,90,30);
		this.add(t1);
		
		b1=new JButton("Deposit");
		b1.setBounds(80,160,90,30);
		this.add(b1);
		b1.addActionListener(this);
		
		b2=new JButton("Reset");
		b2.setBounds(180,160,90,30);
		this.add(b2);
		b2.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae){
			String msg=ae.getActionCommand();
			if(msg.equals("Deposit")){
				Float amt = Float.parseFloat(t1.getText());
				if(amt>50000.0){
					JOptionPane.showMessageDialog(this,"PAN details required");
				}
				try{
					Connection con=DBConnection.getDBConnection();
					Statement stmt =con.createStatement();
					ResultSet rs = stmt.executeQuery("select * from account where accno = "+a.getAccno());
					rs.next();       
					float amt_exist=rs.getFloat(3);
					stmt.executeUpdate("update account set balance = "+(amt_exist+amt)+" where accno = "+a.getAccno());
					JOptionPane.showMessageDialog(this,"Balance Deposited Successfully");
					con.close();
					stmt.close();
					Home hh=new Home(a);
					hh.setVisible(true);
					hh.setSize(600,600);
					this.setVisible(false);
				}catch(Exception e){
					System.out.println(e);
				}
			}
			else
			{
				t1.setText("");
			}
	}

	public static void main(String args[]){
		Deposit obj=new Deposit(a);
		obj.setVisible(true);
		obj.setSize(600,600);
		obj.setTitle("Deposit Page");
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
}
