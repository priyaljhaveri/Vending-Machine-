package jj;

import java.io.File;

public class Product {
	int no;
	int code;
	int price;
	int a=0;
	public Product(int n,int c,int p)
	{
		no=n;
		code=c;
		price=p;
	}
	
	public int getCode() {
		return code;
		
	}
	public int getPrice() {
		return price;
		
	}
	
	public int getNo() {
		return no;
		
	}
	public void add(int x)
	{
		no+=x;
		Filesave2 s = new Filesave2();
		s.filewrite(code,no);
		//Sqlconn con = new Sqlconn();
		//con.adddb(code, no);
	}
	public void use()
	{
		no--;
		System.out.println(no);
	}
	public void sub()
	{
		Filesave2 s = new Filesave2();
		System.out.println(no);
		s.filewrite(code, no);
	}
	

}
