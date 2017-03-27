package jj;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyException extends Exception {
	public MyException(String t,JFrame f)
	{
		JOptionPane.showMessageDialog(f,t, "OYE!!", JOptionPane.PLAIN_MESSAGE);
	}
}
