package jj;

public class Edrink extends Product implements Drinks {
	
	int ml = 200;
	public Edrink(int n,int c,int p)// parameterized constructor that takes number,code,price
	{
		super(n,c,p);
	}
	@Override
	public int getMl() {
		return ml;
		
	}
}
