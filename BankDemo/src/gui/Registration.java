package gui;

import java.awt.*;
import javax.swing.*;
import resource.DBConnection;
import bean.Account;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class Registration extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JButton	b1,b2;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4;
	JPasswordField p1;
	
	static Account a;
	
	
	Registration(Account a){
		
		this.setLayout(null);
		Registration.a = a;
		
		b1 = new JButton("Create");
		b1.setBounds(100,400,90,30);
		b1.addActionListener(this);
		this.add(b1);

		b2 = new JButton("Reset");
		b2.setBounds(200,400,90,30);
		b2.addActionListener(this);
		this.add(b2);

		l1 =new JLabel("User Name");
		l1.setBounds(100,100,90,30);
		//l1.setForeground(Color.RED);
		this.add(l1);

		l2 =new JLabel("Password");
		l2.setBounds(100,150,90,30);
		//l2.setForeground(Color.RED);
		this.add(l2);
	
		l3 =new JLabel("Account No:");
		l3.setBounds(100,200,90,30);
		//l3.setForeground(Color.RED);
		this.add(l3);
		
		l4 =new JLabel("Name");
		l4.setBounds(100,250,90,30);
		//l4.setForeground(Color.RED);
		this.add(l4);
		
		l5 =new JLabel("Amount");
		l5.setBounds(100,300,90,30);
		//l5.setForeground(Color.RED);
		this.add(l5);
		
		l6 =new JLabel("Registration");
		l6.setFont(new Font("Times New Roman",Font.BOLD,14));
		l6.setForeground(Color.BLUE);
		l6.setBounds(170,40,100,40);
		this.add(l6);
	
		t1 = new JTextField();
		t1.setBounds(200,100,90,30);
		this.add(t1);

		p1 = new JPasswordField();
		p1.setBounds(200,150,90,30);
		this.add(p1);

		t2 = new JTextField();
		t2.setBounds(200,200,90,30);
		this.add(t2);
		
		t3 = new JTextField();
		t3.setBounds(200,250,90,30);
		this.add(t3);
	
		t4 = new JTextField();
		t4.setBounds(200,300,90,30);
		this.add(t4);
		
  }


	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		String msg = ae.getActionCommand();
		if(msg.equals("Create"))
		{
			String user = t1.getText();
			String pass = new String(p1.getPassword());
			int accno = Integer.parseInt(t2.getText()); 
			String name = t3.getText();
			float bal = Float.parseFloat(t4.getText());
			try{
				Connection con = DBConnection.getDBConnection();
				PreparedStatement ins = con.prepareStatement("insert into account values(?,?,?,?,?)");
				ins.setInt(1,accno);
				ins.setString(2,name);
				ins.setFloat(3,bal);
				ins.setString(4,user);
				ins.setString(5,pass);
				int res = ins.executeUpdate();
				if(res>0)
				{
					a = new Account(accno,name,bal,user,pass);
					JOptionPane.showMessageDialog(this,"Account Successfully Created..");
					AccountLogin aa = new AccountLogin();
					aa.setVisible(true);
					aa.setSize(600,600);
					this.setVisible(false);					
				}
				ins.close();
				con.close();
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(this,"Username/Account Number must be unique");
			}
		}
		if(msg.equals("Reset"))
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			p1.setText(null);
		}	
	}
	
	public static void main(String[] args)
	{
		Registration obj = new Registration(a);
		obj.setVisible(true);
		obj.setSize(500,500);
		obj.setTitle("Login Page");
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
