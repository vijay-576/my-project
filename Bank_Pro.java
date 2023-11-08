package jdbc_prg;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Bank_Pro implements ActionListener,KeyListener
{
	JFrame frm,frm1;
	JMenuBar mb;
	JMenu m1,m2,m3,m4;
	JMenuItem mi1,mi2,mi3,m2i,m3i,m3i1;
	JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8;
	Font f,f1;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
	JTextField t2,t3,t5,t6,t7,t8,t9,t0,t11,t12,t13,t14,t15;
	JComboBox<String> c1,c2,c3;
	
	Connection con;
	Statement st;
	ResultSet rs;
	PreparedStatement pst;
	
	String a1,a2,a3,a4,a5,a6,a7;
	String a,b,c,d,v,z,x;
	int m,n,p;
	
	JTable tab;
	JScrollPane sp;
	DefaultTableModel tm=new DefaultTableModel(0,0);
	public Bank_Pro()
	{
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bankacc","root","");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void bankCre()
	{
		f=new Font("Arial", Font.BOLD, 30);
		l1=new JLabel("BANK OF UNIVERSE");
		l1.setBounds(500, 50, 300, 100);
		l1.setFont(f);
		mb=new JMenuBar();
		
		m1=new JMenu("File");
		mi1=new JMenuItem("Create");
		mi2=new JMenuItem("Delete");
		mi3=new JMenuItem("Update");
		
		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		
		m2=new JMenu("Transaction");
		m2i=new JMenuItem("Deposit/Withdraw");
		
		m2.add(m2i);
		m3=new JMenu("Report");
		m3i=new JMenuItem("Transaction Report");
		m3i1=new JMenuItem("Customer Report");
		m3.add(m3i);
		m3.add(m3i1);
		
		m4=new JMenu("Exit");
		
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		mb.add(m4);
		
		GraphicsEnvironment gs = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle r = gs.getMaximumWindowBounds();
		int w=r.width;
		int h=r.height;
	
		JFrame.setDefaultLookAndFeelDecorated(true);
		frm=new JFrame("Bank");
		frm.setSize(w, h);
		frm.setLocationRelativeTo(null);
		frm.setLayout(null);
		frm.setExtendedState(frm.getExtendedState());
		frm.setJMenuBar(mb);
		frm.setDefaultCloseOperation(3);
		
		frm.add(l1);
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		m2i.addActionListener(this);
		m3i.addActionListener(this);
		m3i1.addActionListener(this);

		frm.setVisible(true);
	}
	public static void main(String[] args) 
	{
		Bank_Pro bp=new Bank_Pro();
		bp.bankCre();
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==mi1 || e.getSource()==mi3)
		{

			if(e.getSource()==mi1)
			{
			b1=new JButton("Update");
			b1.setBounds(550, 500, 120, 35);
			b2=new JButton("Clear");
			b2.setBounds(700, 500, 100, 35);
			
			t0=new JTextField(30);
			t0.setBounds(900, 370, 250, 30);
			t0.setEditable(false);
			}
			if(e.getSource()==mi3)
			{
			
			b5=new JButton("Update");
			b5.setBounds(550, 500, 120, 35);
			b6=new JButton("Clear");
			b6.setBounds(700, 500, 100, 35);
			
			t0=new JTextField(30);
			t0.setBounds(900, 370, 250, 30);			
			}
			
			c1=new JComboBox<>();
			c1.addItem("Adharcard");
			c1.addItem("Pancard");
			c1.addItem("Voter ID");
			c1.addItem("Driving license");
			
			c2=new JComboBox<>();
			c2.addItem("Savings");
			c2.addItem("Current");
			
			f1=new Font("Arial", Font.BOLD, 20);
			l0=new JLabel("Account Number :");
			l0.setFont(f1);
			l0.setBounds(700, 360, 180, 30);

			f=new Font("Arial", Font.BOLD, 30);
			l1=new JLabel("BANK OF UNIVERSE");
			l1.setBounds(500, 50, 300, 100);
			l1.setFont(f);
			
			f1=new Font("Arial", Font.BOLD, 20);
			l2=new JLabel("Customer Name :");
			l2.setFont(f1);
			l3=new JLabel("Address :");
			l3.setFont(f1);
			l4=new JLabel("Proof :");
			l4.setFont(f1);
			l5=new JLabel("Account Type :");
			l5.setFont(f1);
			l6=new JLabel("Email ID :");
			l6.setFont(f1);
			l7=new JLabel("Date :");
			l7.setFont(f1);
			l8=new JLabel("phone Number :");
			l8.setFont(f1);
			
			t6=new JTextField(20);
			t2=new JTextField(20);
			t3=new JTextField(20);
			t7=new JTextField(20);
			t8=new JTextField(20);
			
			l2.setBounds(200, 150, 170, 50);
			t2.setBounds(400, 160, 250, 30);
			l4.setBounds(200, 220, 170, 50);
			c1.setBounds(400, 230, 250, 30);
			l6.setBounds(200, 290, 170, 50);
			t6.setBounds(400, 300, 250, 30);
			l8.setBounds(200, 360, 180, 50);
			t8.setBounds(400, 370, 250, 30);
			l3.setBounds(700, 150, 170, 50);
			t3.setBounds(900, 160, 250, 30);
			l5.setBounds(700, 220, 170, 50);
			c2.setBounds(900, 230, 250, 30);
			l7.setBounds(700, 290, 170, 50);
			t7.setBounds(900, 300, 250, 30);

			GraphicsEnvironment gs = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Rectangle r = gs.getMaximumWindowBounds();
			int w=r.width;
			int h=r.height;
		
			JFrame.setDefaultLookAndFeelDecorated(true);
			frm=new JFrame("Bank");
			frm.setSize(w, h);
			frm.setLocationRelativeTo(null);
			frm.setLayout(null);
			frm.setExtendedState(frm.getExtendedState());
			
		
			frm.add(l1);
			frm.add(l2);
			frm.add(t2);
			frm.add(l3);
			frm.add(t3);
			frm.add(l4);
			frm.add(c1);
			frm.add(l5);
			frm.add(c2);
			frm.add(l6);
			frm.add(t6);
			frm.add(l7);
			frm.add(t7);
			frm.add(l8);
			frm.add(t8);
			frm.add(l0);
			if(e.getSource()==mi1)
			{
			frm.add(b1);
			frm.add(b2);
			frm.add(t0);
			
			b1.addActionListener(this);
			b2.addActionListener(this);
			}
			if(e.getSource()==mi3)
			{
			frm.add(b5);
			frm.add(b6);
			frm.add(t0);
			b5.addActionListener(this);
			b6.addActionListener(this);
			t0.addKeyListener(this);
			}
			t2.addKeyListener(this);
			t3.addKeyListener(this);
			t6.addKeyListener(this);
			t7.addKeyListener(this);
			t8.addKeyListener(this);
			
			frm.setVisible(true);
		
		}
		if(e.getSource()==b1)
		{
		int i=120;
		try
		{
		st=con.createStatement();
		rs=st.executeQuery("select accno from accholder order by accno");
		while(rs.next())
		{
			i=rs.getInt(1);
		}
		pst=con.prepareStatement("insert into accholder values(?,?,?,?,?,?,?)");
		
		pst.setInt(1, i+1);
		pst.setString(2, t2.getText() );
		pst.setString(3, t3.getText() );
		pst.setString(4,  t8.getText() );
		pst.setString(5, t6.getText() );
		pst.setString(6, (String) c2.getSelectedItem() );
		pst.setString(7, t7.getText());
		
		pst.executeUpdate();
		}
		catch(Exception a)
		{
			a.printStackTrace();
			JOptionPane.showMessageDialog(frm, "Email Id already Exist");
			return;
		}
		t0.setText(Integer.toString(i+1));
		}
		if(e.getSource()==b2 || e.getSource()==b4 || e.getSource()==b6 )
		{
			t2.setText("");
			t3.setText("");
			if(e.getSource()==b2 || e.getSource()==b6)
			{
			t6.setText("");
			t7.setText("");
			t8.setText("");
			t2.requestFocus();
			}
		}
		if(e.getSource()==b5)
		{
			String sql="update accholder set cusname=?,address=?,phno=?,email=?,acctype=? where accno=?";
			try 
			{
				pst=con.prepareStatement(sql);
				pst.setString(1, t2.getText() );
				pst.setString(2, t3.getText() );
				pst.setString(3,  t8.getText() );
				pst.setString(4, t6.getText() );
				pst.setString(5, (String) c2.getSelectedItem() );
				pst.setString(6, t0.getText());
				
				pst.executeUpdate();
				
				JOptionPane.showMessageDialog(frm, "Your details are updated");
			} catch (SQLException e1) 
			{
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource()==mi2)
		{
			b3=new JButton("Delete");
			b3.setBounds(550, 500, 120, 35);
			b4=new JButton("Clear");
			b4.setBounds(700, 500, 100, 35);
			
			f=new Font("Arial", Font.BOLD, 30);
			l1=new JLabel("BANK OF UNIVERSE");
			l1.setBounds(500, 50, 300, 100);
			l1.setFont(f);
			
			f1=new Font("Arial", Font.BOLD, 20);
			l2=new JLabel("Account Number :");
			l2.setFont(f1);
			l3=new JLabel("Email ID :");
			l3.setFont(f1);
			
			t9=new JTextField(20);
			t3=new JTextField(20);
			
			l2.setBounds(450,180, 180,30);
			t9.setBounds(650, 180, 200, 30);
			l3.setBounds(450,250, 180,30);
			t3.setBounds(650, 250, 200, 30);
			
			GraphicsEnvironment gs = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Rectangle r = gs.getMaximumWindowBounds();
			int w=r.width;
			int h=r.height;
		
			JFrame.setDefaultLookAndFeelDecorated(true);
			frm=new JFrame("Bank");
			frm.setSize(w, h);
			frm.setLocationRelativeTo(null);
			frm.setLayout(null);
			frm.setExtendedState(frm.getExtendedState());
			
			frm.add(l1);
			frm.add(l2);
			frm.add(l3);
			frm.add(t9);
			frm.add(t3);
			frm.add(b3);
			frm.add(b4);
			
			b3.addActionListener(this);
			b4.addActionListener(this);
			t9.addKeyListener(this);
			t3.addKeyListener(this);

			frm.setVisible(true);
		

		}
		if(e.getSource()==b3)
		{
			String m = t9.getText();
			try
			{
				pst=con.prepareStatement("delete from accholder where accno=?");
				pst.setString(1, m);
				pst.execute();
			}
			catch(Exception a)
			{
				a.printStackTrace();
				return;
			}
			JOptionPane.showMessageDialog(frm, "Your Account is Removed");
		}
		if(e.getSource()==m2i)
		{
			b7=new JButton("Display");
			b8=new JButton("Update");
			b9=new JButton("Return");
			b0=new JButton("Clear");
			
			b7.setBounds(410, 470, 100, 35);
			b8.setBounds(540, 470, 100, 35);
			b9.setBounds(670, 470, 100, 35);
			b0.setBounds(800, 470, 100, 35);

			c3=new JComboBox<>();
			c3.addItem("Deposit");
			c3.addItem("Withdraw");
			
			f=new Font("Arial", Font.BOLD, 30);
			l1=new JLabel("BANK OF UNIVERSE");
			l1.setBounds(500, 50, 300, 100);
			l1.setFont(f);
			
			f1=new Font("Arial", Font.BOLD, 20);
			l2=new JLabel("Account Number :");
			l2.setFont(f1);
			l3=new JLabel("Customer Name :");
			l3.setFont(f1);
			l4=new JLabel("Transaction Amount :");
			l4.setFont(f1);
			l5=new JLabel("Operation Mode :");
			l5.setFont(f1);
			l6=new JLabel("Email ID :");
			l6.setFont(f1);
			l7=new JLabel("Date :");
			l7.setFont(f1);
			l8=new JLabel("Balance :");
			l8.setFont(f1);
			
			t11=new JTextField(20);
			t12=new JTextField(20);
			t13=new JTextField(20);
			t14=new JTextField(20);
			t15=new JTextField(20);
			t7=new JTextField(20);
			
			t7.setEditable(false);
			t7.setBackground(Color.white);
			
			l2.setBounds(180, 150, 180, 50);
			t11.setBounds(400, 160, 250, 30);
			l4.setBounds(180, 220, 220, 50);
			t12.setBounds(400, 230, 250, 30);
			l6.setBounds(180, 290, 170, 50);
			t13.setBounds(400, 300, 250, 30);
			l8.setBounds(180, 360, 180, 50);
			t7.setBounds(400, 370, 250, 30);
			l3.setBounds(700, 150, 170, 50);
			t15.setBounds(900, 160, 250, 30);
			l5.setBounds(700, 220, 170, 50);
			c3.setBounds(900, 230, 250, 30);
			l7.setBounds(700, 290, 170, 50);
			t14.setBounds(900, 300, 250, 30);


			GraphicsEnvironment gs = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Rectangle r = gs.getMaximumWindowBounds();
			int w=r.width;
			int h=r.height;
		
			JFrame.setDefaultLookAndFeelDecorated(true);
			frm=new JFrame("Bank");
			frm.setSize(w, h);
			frm.setLocationRelativeTo(null);
			frm.setLayout(null);
			frm.setExtendedState(frm.getExtendedState());
		
			frm.add(l1);
			frm.add(l2);
			frm.add(t11);
			frm.add(l3);
			frm.add(t12);
			frm.add(l4);
			frm.add(t13);
			frm.add(l5);
			frm.add(c3);
			frm.add(l6);
			frm.add(t14);
			frm.add(l7);
			frm.add(t15);
			frm.add(l8);
			frm.add(t7);
			frm.add(b7);
			frm.add(b8);
			frm.add(b9);
			frm.add(b0);
			
			b7.addActionListener(this);
			b8.addActionListener(this);
			b9.addActionListener(this);
			b0.addActionListener(this);
			
			t11.addKeyListener(this);
			t12.addKeyListener(this);
			t13.addKeyListener(this);
			t14.addKeyListener(this);
			t15.addKeyListener(this);
			
			frm.setVisible(true);
		}
		if(e.getSource()==b8)
		{
			String g=(String) c3.getSelectedItem();
			String h=t12.getText();
			int l=Integer.parseInt(t11.getText());
			int i=Integer.parseInt(h);
			long j=System.currentTimeMillis();
			Date k=new Date(j);
			try
			{
				st=con.createStatement();
				rs=st.executeQuery("select accno from trans where accno="+l);
				while(rs.next())
				{
					n = rs.getInt(1);
					System.out.println(n);
				}	
				
				if(l==n)
				{
					st=con.createStatement();
					rs=st.executeQuery("select bal from trans where accno="+l);
					while(rs.next())
					{
						m = rs.getInt(1);
					}	 
				}
				else
				{
					m=0;
				}
				
				pst=con.prepareStatement("insert into trans values(?,?,?,?,?,?)");
				
				pst.setString(1, t11.getText());
				pst.setString(2, t15.getText());
				pst.setString(3, g);
				pst.setInt(4, i);
				if(g=="Deposit")
				{
					pst.setInt(5, m+i);
				}
				else
				{
					pst.setInt(5, m-i);
				}
				pst.setDate(6, k);
				
				pst.executeUpdate();
			
			}
			catch(Exception a)
			{
				a.printStackTrace();
			}
		}
		if(e.getSource()==b7)
		{
			int l=Integer.parseInt(t11.getText());
			int r=Integer.parseInt(t12.getText());
			try
			{
				st=con.createStatement();
				rs=st.executeQuery("select bal from trans where accno="+l);
				while(rs.next())
				{
				 p = rs.getInt(1);
				}
				if(t12.getText()=="Deposit")
				{
				t7.setText(Integer.toString(p+r));
				}
				else
				{
					t7.setText(Integer.toString(p-r));
				}
			}
			catch(Exception a)
			{
				a.printStackTrace();
			}
		}
		if(e.getSource()==b9)
		{
			frm.dispose();
		}
		if(e.getSource()==b0)
		{
			t11.setText("");
			t12.setText("");
			t13.setText("");
			t14.setText("");
			t15.setText("");
			t7.setText("");
		}
		if(e.getSource()==m3i)
		{
			tab=new JTable();
			 String[] head= {"Account No","Customer Name","Transaction Type","Transaction Amount","Balance","Transaction date"}; 
			 tm.setColumnIdentifiers(head);
			 tab.setModel(tm);
		
			sp=new JScrollPane(tab);
			
			GraphicsEnvironment gs = GraphicsEnvironment.getLocalGraphicsEnvironment();
			Rectangle r = gs.getMaximumWindowBounds();
			int w=r.width;
			int h=r.height;
		
			JFrame.setDefaultLookAndFeelDecorated(true);
			frm=new JFrame("Bank");
			frm.setSize(w, h);
			
			frm.add(sp,BorderLayout.CENTER);
		//	frm.add(tab);
			
			frm.setVisible(true);
			try
			{
				st=con.createStatement();
				rs=st.executeQuery("select*from trans");
				while(rs.next())
				{
					b=rs.getString(1);
					c=rs.getString(2);
					d=rs.getString(3);
					v=rs.getString(4);
					z=rs.getString(5);
					x=rs.getString(6);
					
					tm.addRow(new Object[] {b,c,d,v,z,x});
				}
			}
			catch(Exception a)
			{
				a.printStackTrace();
			}
		}
			if(e.getSource()==m3i1)
			{
				tab=new JTable();
				 String[] he= {"Account No","Customer Name","Address","Phone Number","Email ID","Account type","Opening Date"}; 
				 tm.setColumnIdentifiers(he);
				 tab.setModel(tm);
			
				sp=new JScrollPane(tab);
				
				GraphicsEnvironment gs = GraphicsEnvironment.getLocalGraphicsEnvironment();
				Rectangle r = gs.getMaximumWindowBounds();
				int w=r.width;
				int h=r.height;
			
				JFrame.setDefaultLookAndFeelDecorated(true);
				frm=new JFrame("Bank");
				frm.setSize(w, h);
				frm.add(sp,BorderLayout.CENTER);
				
				//frm.add(tab);
				
				frm.setVisible(true);
				try
				{
					st=con.createStatement();
					rs=st.executeQuery("select*from accholder");
					while(rs.next())
					{
						b=rs.getString(1);
						c=rs.getString(2);
						d=rs.getString(3);
						v=rs.getString(4);
						z=rs.getString(5);
						x=rs.getString(6);
						a=rs.getString(7);
						tm.addRow(new Object[] {b,c,d,v,z,x,a});
					}
				}
				catch(Exception a)
				{
					a.printStackTrace();
				}
			}
			
	}
	@Override
	public void keyPressed(KeyEvent e) 
	{
		if(e.getSource()==t2 && e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			t6.requestFocus();
		}
		if(e.getSource()==t6 && e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			t8.requestFocus();
		}
		if(e.getSource()==t8 && e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			t3.requestFocus();
		}
		if(e.getSource()==t3 && e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			t7.requestFocus();
		}
		if(e.getSource()==t7 && e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			t0.requestFocus();
		}
		if(e.getSource()==t9 && e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			t3.requestFocus();
		}
		if(e.getSource()==t11 && e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			t12.requestFocus();
		}
		if(e.getSource()==t12 && e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			t13.requestFocus();
		}
		if(e.getSource()==t13 && e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			t15.requestFocus();
		}
		if(e.getSource()==t15 && e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			t14.requestFocus();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
