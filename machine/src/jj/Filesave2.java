package jj;
import java.io.*;
// this class is used to save the number of each product at the end executing the program.
//also retrieves the saved data from the file for the next execution.
//saves an object to a file
public class Filesave2 {
	
	public void filewrite(int a,int b)
	{
		
		Myobject2 m;
		m = new Myobject2();
		m.set(b);
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("D:\\javaproject\\Myproject"+a+".txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(m);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int fileread(int a)
	{	
		Myobject2 m;
		ObjectInputStream ois = null;
		Myobject2 mo = new Myobject2();
		FileInputStream fis = null;
		m = new Myobject2();
		try {
			fis =new FileInputStream("D:\\javaproject\\Myproject"+a+".txt");
			
		} catch (FileNotFoundException e) {// if file not found it will create the file
			File file = new File("D:\\javaproject\\Myproject"+a+".txt");
			if(!file.exists())
			{
				//System.out.println("hahahah");
				try {
					file.createNewFile();
					fis =new FileInputStream("D:\\javaproject\\Myproject"+a+".txt");
					m.initialize();
					FileOutputStream fos = new FileOutputStream(file);
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(m);
					oos.flush();
					oos.close();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ois = new ObjectInputStream(fis);
			mo = (Myobject2)ois.readObject();
			ois.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 
			mo.get();
		
		
	}
}
