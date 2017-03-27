package jj;
import java.util.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.*;

public class Main implements ActionListener,KeyListener{
	int x=200;
	int y=250;
	int rs;
	int p,q,r,w;
	Anim a;
	JFrame frame,frame1,frame2,frame3;
	Filesave2 sa = new Filesave2();
	Choco c= new Choco(sa.fileread(1),1,15);//objects created every time we run the program 
	Candy d= new Candy(sa.fileread(2),2,10);// constructor that takes number,code,price
	Edrink e= new Edrink(sa.fileread(3),3,25);
	cola f= new cola(sa.fileread(4),4,20);
	JLabel l6;
	JRadioButton r1;
	JRadioButton r2;
	JRadioButton r3;
	JRadioButton r4;
	JButton b1 = new JButton("SUBMIT");
	JButton b3;
	JButton b4;
	JButton b5;
	JButton b6;
	JButton b7;//money
	JButton b8;
	JButton b9;
	JButton b10;
	JButton b11;
	JButton b12;//submit
	JButton b13;//add to cart
	JButton b14;//buy
	JButton b15;//back
	JButton b16;
	JTextField t;
	JPanel pa,p1,p4,p8;
	JTextField t3,t4;
	String s;
	public static void main(String[] args) {
		
		
		Main m = new Main();
		m.start();
	}
	public void start()
	{
		p=0;
		q=0;
		r=0;
		w=0;
		String s,str;
		frame = new JFrame();//opening frame
		frame1 = new JFrame();//frame for suppliers
		frame2 = new JFrame();//for customers
		frame3 = new JFrame();//submit for customers
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//opening frame
		p1 = new JPanel();//panel for frame1
		pa = new JPanel();//all the labels in 1st frame
		JPanel p2 = new JPanel();//panel for radio button
		JPanel p3 = new JPanel(); //for text field and label
		p1.setBackground(Color.DARK_GRAY);
		p1.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));//layout for suppliers
		pa.setBackground(Color.GREEN);
		pa.setLayout(new BoxLayout(pa,BoxLayout.Y_AXIS));
		p2.setLayout(new FlowLayout());
		p3.setLayout(new FlowLayout());
		JLabel l1 = new JLabel("CANDY                   ");
		JLabel l2 = new JLabel("COLA                      ");
		JLabel l3 = new JLabel("ENERGY DRINK     ");
		JLabel l4 = new JLabel("CHOCOLATES      ");
		JLabel l10 = new JLabel("TOUCH THE BALL TO THE GREEN STRIP BY USING YOUR KEYBOARD");
		JLabel l5 = new JLabel("VENDING MACHINE!!",SwingConstants.CENTER);
		l5.setBackground(Color.MAGENTA);
		pa.add(l1);
		pa.add(l2);
		pa.add(l3);
		pa.add(l4);
		frame.getContentPane().add(BorderLayout.NORTH,l5);//adding the header 
		frame.getContentPane().add(BorderLayout.WEST,pa);//adding all the labels
		frame.getContentPane().add(BorderLayout.SOUTH, l10);
		//supplier frame 
		//radio buttons for supplier frame
		r1 = new JRadioButton("CANDY");
		r2 = new JRadioButton("CHOCOLATE");
		r3 = new JRadioButton("E-DRINK");
		r4 = new JRadioButton("COLA");
		ButtonGroup group = new ButtonGroup();
		group.add(r1);
		group.add(r2);
		group.add(r3);
		group.add(r4);
		r1.addActionListener(this);
		r2.addActionListener(this);
		r3.addActionListener(this);
		r4.addActionListener(this);
		p2.add(r1);
		p2.add(r2);
		p2.add(r3);
		p2.add(r4);
		p1.add(p2);
		b1.addActionListener(new ButtonListener());
		
		l6 = new JLabel();
		t= new JTextField();
		t.setPreferredSize(new Dimension(150,20));
		p3.add(l6);
		p3.add(t);
		p1.add(p3);
		
		frame1.getContentPane().add(p1);
		
		//opening frame labels
		Border b = BorderFactory.createLineBorder(Color.BLACK);
		l1.setBorder(b);
		l2.setBorder(b);
		l3.setBorder(b);
		l4.setBorder(b);
		l10.setBorder(b);
		l6.setBorder(b);
		l1.setPreferredSize(new Dimension(100,125));//method in container
		l2.setPreferredSize(new Dimension(100,125));
		l3.setPreferredSize(new Dimension(100,125));
		l4.setPreferredSize(new Dimension(100,125));
		l6.setPreferredSize(new Dimension(150,20));
		
		//animation object on opening frame
		a = new Anim();
		a.addKeyListener(this);
		a.setFocusable(true);//used for keyboard listener
		frame.getContentPane().add(a);
		frame.setSize(500, 500);
		frame.setVisible(true);
		
		//frame for payment
		p4 = new JPanel();
		p4.setLayout(new BoxLayout(p4,BoxLayout.Y_AXIS));
		frame2.getContentPane().add(p4);
		
		
		b7 = new JButton("1");
		b8 = new JButton("5");
		b9 = new JButton("10");
		b10 = new JButton("50");
		b11 = new JButton("100");
		b7.addActionListener(new ButtonListener3());
		b8.addActionListener(new ButtonListener3());
		b9.addActionListener(new ButtonListener3());
		b10.addActionListener(new ButtonListener3());
		b11.addActionListener(new ButtonListener3());
		JPanel p6 = new JPanel();
		p6.setLayout(new FlowLayout());
		p6.add(b7);
		p6.add(b8);
		p6.add(b9);
		p6.add(b10);
		p6.add(b11);
		p4.add(p6);
		
		t3 = new JTextField();
		t3.setPreferredSize(new Dimension(50,20));
		t3.setText("0");
		JLabel l7 = new JLabel("ENTER MONEY IN MACHINE");
		l7.setBorder(b);
		JPanel p7 = new JPanel();
		p7.setLayout(new FlowLayout());
		p7.add(l7);
		p7.add(t3);
		p4.add(p7);
		
		b12 =new JButton("SUBMIT");
		b12.addActionListener(new ButtonListener3());
		p4.add(b12);
		
		//frame 3 customer buy frame
		p8 = new JPanel();
		p8.setLayout(new BoxLayout(p8,BoxLayout.Y_AXIS));
		frame3.getContentPane().add(p8);
		JPanel p5 = new JPanel();
		p5.setLayout(new FlowLayout());
		b3 = new JButton("CANDY");
		b4 = new JButton("CHOCOLATE");
		b5 = new JButton("E-DRINK");
		b6 = new JButton("COLA");
		b3.addActionListener(new ButtonListener2());
		b4.addActionListener(new ButtonListener2());
		b5.addActionListener(new ButtonListener2());
		b6.addActionListener(new ButtonListener2());
		p5.add(b3);
		p5.add(b4);
		p5.add(b5);
		p5.add(b6);
		p8.add(p5);
		JLabel l9 = new JLabel("ENTER THE CODE OF PRODUCT NEEDED");
		t4 = new JTextField();
		t4.setPreferredSize(new Dimension(50,20));
		b13 = new JButton("ADD TO CART");
		b13.addActionListener(new ButtonListener5());
		JPanel p9 = new JPanel();
		p9.setLayout(new FlowLayout());
		p9.add(l9);
		p9.add(t4);
		p9.add(b13);
		p8.add(p9);
		b16 = new JButton("SHOW CURRENT CART");
		b16.addActionListener(new ButtonListener6());
		p8.add(b16);
		b14 = new JButton("BUY");
		b14.addActionListener(new ButtonListener6());
		b15 = new JButton("BACK");
		JPanel p10 = new JPanel();
		p10.setLayout(new FlowLayout());
		p10.add(b14);
		p10.add(b15);
		p8.add(p10);
		
		
		
		
		
	}
	class Anim extends JPanel 
	{
		public void paintComponent(Graphics g)
		{
			g.setColor(Color.WHITE);
			g.fillRect(0,0,this.getWidth(), this.getHeight());
			g.setColor(Color.BLUE);
			g.fillOval(x, 150, 100, 100);
		}
	}
	
	//radio button on supplier frame 
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(r1.isSelected()==true)
		{
			l6.setText("CANDY");
			if(d.getNo()>10)
			{
				if(b1.getParent()!=null)//remove the submit button
				{
					p1.remove(b1);
				}
				t.setText("IT IS NOT OUT OF STOCK");
			}
			else
			{
				
				if(b1.getParent()==null)
				{
					p1.add(b1);
				}
				l6.setText("AMOUNT OF CANDY:");
				t.setText("");
			}
		}
		else if(r2.isSelected()==true)
		{
			l6.setText("CHOCOLATE");
			if(c.getNo()>10)
			{
				if(b1.getParent()!=null)
				{
					p1.remove(b1);
				}
				t.setText("CANNOT SUPPLY AS IT IS NOT OUT OF STOCK");
			}
			else
			{	
				if(b1.getParent()==null)
				{
					p1.add(b1);
				}
				l6.setText("AMOUNT OF CHOCOLATE:");
				t.setText("");
			}
		}
		else if(r3.isSelected()==true)
		{
			l6.setText("E-DRINK");
			if(e.getNo()>10)
			{
				if(b1.getParent()!=null)
				{
					p1.remove(b1);
				}
				t.setText("CANNOT SUPPLY AS IT IS NOT OUT OF STOCK");
			}
			else
			{
				
				if(b1.getParent()==null)
				{
					p1.add(b1);
				}
				l6.setText("AMOUNT OF E-DRINK:");
				t.setText("");
			}
		}
		else if(r4.isSelected()==true)
		{
			l6.setText("COLA");
			if(f.getNo()>10)
			{
				if(b1.getParent()!=null)
				{
					p1.remove(b1);
				}
				t.setText("CANNOT SUPPLY AS IT IS NOT OUT OF STOCK");
			}
			else
			{
				if(b1.getParent()==null)
				{
					p1.add(b1);
				}
				l6.setText("AMOUNT OF COLA:");
				t.setText("");
			}
		}
		
		
	}
	
class ButtonListener implements ActionListener //supplier submit button
{

	@Override
	public void actionPerformed(ActionEvent z) {
		if(r1.isSelected()==true)
		{
			d.add(Integer.parseInt(t.getText()));
		}
		else if(r2.isSelected()==true)
		{
			c.add(Integer.parseInt(t.getText()));
		}
		else if(r3.isSelected()==true)
		{
			e.add(Integer.parseInt(t.getText()));
		}
		else if(r4.isSelected()==true)
		{
			f.add(Integer.parseInt(t.getText()));
		}
		JOptionPane.showMessageDialog(frame1, "You have successfully supplied the items","SUCCESS", JOptionPane.PLAIN_MESSAGE);
		frame1.setVisible(false);
	}
	
}
class ButtonListener2 implements ActionListener//frame 3 buttons of candy choco e-drink cola
{

	@Override
	public void actionPerformed(ActionEvent a) {
		JButton b = (JButton)a.getSource();
		if(b.getText().equals("CANDY"))
		{
			JOptionPane.showMessageDialog(frame3, "Number of items left: "+d.getNo()+"\n Code no.: "+d.getCode()+"\n Price: "+d.getPrice()+"\nGrams: "+d.getGms(),"ITEM DETAILS", JOptionPane.PLAIN_MESSAGE);
		}
		else if(b.getText().equals("CHOCOLATE"))
		{
			JOptionPane.showMessageDialog(frame3, "Number of items left: "+c.getNo()+"\n Code no.: "+c.getCode()+"\n Price: "+c.getPrice()+"\nGrams: "+c.getGms(),"ITEM DETAILS", JOptionPane.PLAIN_MESSAGE);
		}
		else if(b.getText().equals("E-DRINK"))
		{
			JOptionPane.showMessageDialog(frame3, "Number of items left: "+e.getNo()+"\n Code no.: "+e.getCode()+"\n Price: "+e.getPrice()+"\nQuantity in ml: "+e.getMl(),"ITEM DETAILS", JOptionPane.PLAIN_MESSAGE);
		}
		else if(b.getText().equals("COLA"))
		{
			JOptionPane.showMessageDialog(frame3, "Number of items left: "+f.getNo()+"\n Code no.: "+f.getCode()+"\n Price: "+f.getPrice()+"\nGrams: "+f.getMl(),"ITEM DETAILS", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	
}
class ButtonListener3 implements ActionListener // money buttons on frame 2 (1,5,10,50,100)
{

	@Override
	public void actionPerformed(ActionEvent z) {
		if((JButton)z.getSource()==b7)
		{
			t3.setText(Integer.parseInt(t3.getText())+Integer.parseInt(b7.getText())+"");
		}
		if((JButton)z.getSource()==b8)
		{
			t3.setText(Integer.parseInt(t3.getText())+Integer.parseInt(b8.getText())+"");
		}
		else if((JButton)z.getSource()==b9)
		{
			t3.setText(Integer.parseInt(t3.getText())+Integer.parseInt(b9.getText())+"");
		}
		else if((JButton)z.getSource()==b10)
		{
			t3.setText(Integer.parseInt(t3.getText())+Integer.parseInt(b10.getText())+"");
		}
		else if((JButton)z.getSource()==b11)
		{
			t3.setText(Integer.parseInt(t3.getText())+Integer.parseInt(b11.getText())+"");
		}
		else if((JButton)z.getSource()==b12)
		{
			s = t3.getText();
			rs = Integer.parseInt(s);
			frame3.setSize(500,500);
			frame3.setVisible(true);
		}
	}
	
}
class ButtonListener5 implements ActionListener // add to cart button on frame 3
{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(t4.getText().equals("2"))
		{
			if(d.getNo()!=0)
			{
				t4.setText("");
				
				if(rs-d.getPrice()>=0)
					{
						rs-=d.getPrice();
						d.use();
						q++;
					}
			
				else
					try {
						throw new MyException("CASH LIMIT EXCEEDED",frame3);
					} catch (MyException e) {
					}
			}
			else
			{
				JOptionPane.showMessageDialog(frame3,"Out Of Stock","SORRY!!", JOptionPane.PLAIN_MESSAGE);
			}
			
		}
		else if(t4.getText().equals("1"))
		{
			if(c.getNo()!=0)
			{
				t4.setText("");
				
				if(rs-c.getPrice()>=0)
					{
						rs-=c.getPrice();
						c.use();
						p++;
					}
				else
					try {
						throw new MyException("CASH LIMIT EXCEEDED",frame3);
					} catch (MyException e) {
					}
			}
			else
			{
				JOptionPane.showMessageDialog(frame3,"Out Of Stock","SORRY!!", JOptionPane.PLAIN_MESSAGE);
			}
			
		}
		else if(t4.getText().equals("3"))
		{
			if(e.getNo()!=0)
			{
				t4.setText("");
				
				if(rs-e.getPrice()>=0)
					{
						rs-=e.getPrice();
						e.use();
						r++;
					}
				else
					try {
						throw new MyException("CASH LIMIT EXCEEDED",frame3);
					} catch (MyException e) {
					}
			}
			else
			{
				JOptionPane.showMessageDialog(frame3,"Out Of Stock","SORRY!!", JOptionPane.PLAIN_MESSAGE);
			}
			
		}
		else if(t4.getText().equals("4"))
		{
			if(f.getNo()!=0)
			{
				t4.setText("");
				
				if(rs-f.getPrice()>=0)
					{
						rs-=f.getPrice();
						f.use();
						w++;
					}
				else
					try {
						throw new MyException("CASH LIMIT EXCEEDED",frame3);
					} catch (MyException e) {
					}
			}
			else
			{
				JOptionPane.showMessageDialog(frame3,"Out Of Stock","SORRY!!", JOptionPane.PLAIN_MESSAGE);
			}
			
		}
		
	}
	
}
class ButtonListener6 implements ActionListener // show current cart , buy , cancel button on frame3
{
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if((JButton)arg0.getSource()==b16)
		{
			JOptionPane.showMessageDialog(frame3,"CHOCOLATES: "+p+"\nCANDIES "+q+"\nE-DRINK: "+r+"\nCOLA: "+w, "CURRENT CART", JOptionPane.PLAIN_MESSAGE);
		}
		else{
			
		
		Object[] options = {"CONFIRM","CANCEL"};
		int n=	JOptionPane.showOptionDialog(frame3, "You bought :\n"+p+" CHOCOLATES\n"+q+" CANDIES\n"+r+" E-DRINKS\n"+w+" COLAS\n", "CONFORMATION", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if(n==JOptionPane.YES_OPTION)
		{
			JOptionPane.showMessageDialog(frame3, "Your change is "+rs, "CHANGE", JOptionPane.PLAIN_MESSAGE);
			c.sub();
			d.sub();
			e.sub();
			f.sub();
			frame3.setVisible(false);
			frame2.setVisible(false);
		}
		else
		{
			c.add(p);
			d.add(q);
			e.add(r);
			f.add(w);
			p=0;
			q=0;
			r=0;
			w=0;
			rs = Integer.parseInt(s);
		}
		
		}
	}
	
}

@Override
public void keyPressed(KeyEvent g) {
	if(g.getKeyCode()==KeyEvent.VK_LEFT)
	{
		
			x-=10;
			a.repaint();
		
		if(x==0){
			Object possibilities[] = {"Customer","Supplier"};
			s =(String) JOptionPane.showInputDialog(frame, "Select one user type", "ENTRY TO VENDING MACHINE", JOptionPane.PLAIN_MESSAGE, null, possibilities,"Customer");
			
			try{
			if(s.equals("Supplier"))
			{
				 String str = (String)JOptionPane.showInputDialog(frame, "Enter 4 digit security code", "SECURITY STEP", JOptionPane.PLAIN_MESSAGE);
				if(str.equals("0007"))
				{	
					frame1.setSize(500, 500);
					frame1.setVisible(true);
					
						
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Access Denied","UNAUTHORIZED ACCESS", JOptionPane.WARNING_MESSAGE);
				}
			}
			
			else if(s.equals("Customer"))
			{
				frame2.setSize(500, 500);
				frame2.setVisible(true);
				
			}
			else
			{
				frame.setVisible(false);
			}
		}
			catch(NullPointerException k)
			{
				
			}
		}
	}
}
@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

}
