package jj;

public class Choco extends Product implements Food {
	
	int gms = 10;
	public Choco(int n,int c,int p)// parameterized constructor that takes number,code,price
	{
		super(n,c,p);
	}
	@Override
	public int getGms() {
		return gms;
		
	}
	
}
