package jj;

public class cola extends Product implements Drinks{
	
	int ml = 100;
	public cola(int n,int c,int p)// parameterized constructor that takes number,code,price
	{
		super(n,c,p);
	}
	@Override
	public int getMl() {
		return ml;
	
		
	}
	
}
