package jj;

public class Candy extends Product implements Food{

	int gms = 25;
	public Candy(int n,int c,int p)// parameterized constructor that takes number,code,price
	{
		super(n,c,p);
	}
	@Override
	public int getGms() {
		return gms;
		
	}
}
