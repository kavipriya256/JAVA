//menu bar and popup menu

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Menu extends JFrame implements ActionListener
{
	JMenuBar mb; 
	JMenu file,option,color,priority,help;
	JMenuItem open,close,save,exit,r,g,b,h,l,about,cut,copy,paste;
	ImageIcon i;
	JLabel lab;
	JPopupMenu jp;
	Menu()
	{
		setVisible(true); setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,700);
		mb=new JMenuBar(); lab=new JLabel();
		i=new ImageIcon("ibutton.png");
		file=new JMenu("File"); option=new JMenu("Option"); help=new JMenu("Help");
		color=new JMenu("Color"); priority=new JMenu("Priority");
		open=new JMenuItem("open");  close=new JMenuItem("close");
		save=new JMenuItem("save");  exit=new JMenuItem("exit");
		r=new JMenuItem("red");  g=new JMenuItem("green");
		b=new JMenuItem("blue");  h=new JMenuItem("high");
		l=new JMenuItem("low");  about=new JMenuItem("about",i);
		about.setToolTipText("about the system");
		jp=new JPopupMenu();
		cut=new JMenuItem("cut");  
		copy=new JMenuItem("copy");
		paste=new JMenuItem("paste");
		file.add(open); file.add(save); file.add(close); 
		file.addSeparator(); file.add(exit);
		option.add(color);  option.add(priority);
		color.add(r);  color.add(g);  color.add(b);
		priority.add(h);  priority.add(l);
		help.add(about);
		jp.add(cut);  jp.add(copy); jp.add(paste);
		// add(jp)- dont add jp, jp has to be displayed only when right mouse is clicked.
		// so add mouseListener..
		mb.add(file); mb.add(option); mb.add(help); 
		setJMenuBar(mb); add(lab);
		open.addActionListener(this);  close.addActionListener(this);
		save.addActionListener(this);  exit.addActionListener(this);
		r.addActionListener(this);  g.addActionListener(this);
		b.addActionListener(this);  h.addActionListener(this);
		l.addActionListener(this);  about.addActionListener(this);
		file.setMnemonic(KeyEvent.VK_F);
		//file.setDisplayedMnemonicIndex(1); 1st index letter is taken as mnemonic
		open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_DOWN_MASK));
		//ctrl+shift+s 
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK|InputEvent.SHIFT_DOWN_MASK));
		//instead of input event: action event can be used; ActionEvent.CTRL_MASK , dont need to use down 
		addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent me)
			{
				if(me.isPopupTrigger())
					jp.show(me.getComponent(),me.getX(),me.getY());
			}
			public void mouseReleased(MouseEvent me)
			{
				if(me.isPopupTrigger())
					jp.show(me.getComponent(),me.getX(),me.getY());
			}
		});
	}
	public void actionPerformed(ActionEvent ae)
	{
		String s=ae.getActionCommand();
		if(s.equals("exit"))
			System.exit(0);
		else
			lab.setText(s);
	}
	public static void main(String ar[])
	{
		new Menu();
	}
}