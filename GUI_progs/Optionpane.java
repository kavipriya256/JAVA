//dialog box...

import javax.swing.*;

class Optionpane
{
	String s; int n;
	void func()
	{
		JOptionPane.showMessageDialog(null,"welcome");
		s=JOptionPane.showInputDialog(null,"name kya hai?");
		JOptionPane.showMessageDialog(null,"hii"+s);
		n=JOptionPane.showConfirmDialog(null,"do u like swing?");
		if(n==JOptionPane.YES_OPTION)
			JOptionPane.showMessageDialog(null,"i apperciate it");
		if(n==JOptionPane.NO_OPTION)
			JOptionPane.showMessageDialog(null,"poga poga pazhagidum");
		if(n==JOptionPane.CANCEL_OPTION)
			JOptionPane.showMessageDialog(null,"you cancelled it");
	}
	public static void main(String arg[])
	{
		Optionpane op=new Optionpane();
		op.func();
	}
}