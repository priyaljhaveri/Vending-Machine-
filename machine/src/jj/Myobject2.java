package jj;

import java.io.Serializable;

public class Myobject2 implements Serializable{
	int no;
	public void set(int a)
	{
		no=a;
	}
	public int get()
	{
		return no;
	}
	public void initialize()
	{
		no=5;//initially 5 items in the machine
	}
}
