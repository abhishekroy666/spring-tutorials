package gui;

import java.awt.*;
import javax.swing.*;
import bean.Account;
import resource.DBConnection;
import java.awt.event.*;
import java.sql.*;

public class AccountLogin extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JLabel j1,j2,j3;
	JTextField t1;
	JPasswordField p1;
	JButton b1,b2,b3;
	
	static Account a;
	
	AccountLogin()
	{
		this.setLayout(null);
		
		j1 = new JLabel("Login");
		j1.setFont(new Font("Arial",Font.BOLD,20));
		j1.setForeground(Color.red);
		j1.setBounds(170,40,90,30);
		
		j2 = new JLabel("Username");
		j2.setBounds(80,90,90,30);
		
		j3 = new JLabel("Password");
		j3.setBounds(80,150,90,20);
				
		t1 = new JTextField();
		t1.setBounds(180,90,120,30);
		
		p1 = new JPasswordField();
		p1.setBounds(180,150,120,30);
				
		b1 = new JButton("Submit");
		b1.setBounds(80,230,90,30);
		b1.addActionListener(this);	//Register the event
		
		b2 = new JButton("Reset");
		b2.setBounds(210,230,90,30);
		b2.addActionListener(this); //Register the event
		
		b3 = new JButton("New User");
		b3.setBounds(150,280,90,30);
		b3.setForeground(Color.BLUE);
		b3.addActionListener(this);
			
		this.add(j1);
		this.add(j2);
		this.add(j3);
		this.add(t1);
		this.add(p1);
		this.add(b1);
		this.add(b2);
		this.add(b3);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		String msg = ae.getActionCommand();
		if(msg.equals("Submit"))
		{
			try
			{
				Connection con = DBConnection.getDBConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from account");
				ResultSet rs = pstmt.executeQuery();
				int flag = 0;
				while(rs.next())
				{
					String user = t1.getText();
					String pass = new String(p1.getPassword());
					if(user.equals(rs.getString(4)) && pass.equals(rs.getString(5)))
					{
						int accno = rs.getInt(1);
						Account a = new Account();
						a.setAccno(accno);
						a.setName(rs.getString(2));
						a.setAmount(rs.getFloat(3));
						JOptionPane.showMessageDialog(this,"Login Successful");
						Home hh = new Home(a);
						hh.setVisible(true);
						hh.setSize(600,600);
						this.setVisible(false);
						flag = 1;
						con.close();
						pstmt.close();
						break;
					}
				}
				if(flag == 0)
				{
					JOptionPane.showMessageDialog(this,"Invalid Credentials");
					t1.setText("");
					p1.setText(null);
				}
				con.close();
				pstmt.close();
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,e.getMessage());
			}			
			t1.setText("");
			p1.setText(null);
		}
		else if(msg.equals("New User"))
		{
			Registration rg = new Registration(a);
			rg.setVisible(true);
			rg.setSize(600,600);
			this.setVisible(false);
		}
		else
		{
			t1.setText("");
			p1.setText(null);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountLogin obj = new AccountLogin();
		obj.setVisible(true);
		obj.setSize(400,400);
		obj.setTitle("Login Page");
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
