import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Info 
{
	int num,guess,round,attempt,maxAttempt;
	int score[]=new int[20];
	boolean won;
	int max=100,min=1;
	Info()
	{
		for(int i=0;i<20;i++)
			score[i]=0;
		round=0;
		maxAttempt=10;
	}
	void start()
	{
		round++;
		num=(int)(Math.random()*(max-min))+min;
		attempt=0;
		won=false;
	}
	int remAttempts()
	{
		return (maxAttempt-attempt);
	}
	String check(String gnum)
	{
		guess=Integer.parseInt(gnum);
		if(guess==num)
		{
			won=true;
			return("Yess Correct!!");
		}
		else if((guess-num)<0)
	    {
		    if((guess-num)<-20)
			    return("your guess is too low");
		    else
			    return("your guess is low");
	    }
	    else if((guess-num)>0)
	    {
		    if((guess-num)>20)
			    return("your guess is too high");
		    else
			    return("your guess is high");
	    }
		else 
			return "";
	}	
	int gameScore()
	{
		if(won==false)
			score[round]=0;
		else
			score[round]=(int)((float)(maxAttempt-attempt+1)/10*100);
		return score[round];
	}
	int totScore()
	{
		float totScore=0;
		for(int k=1;k<=round;k++)
			totScore+=score[k];
		return (int)(totScore/round);
	}
}
class GuessGame extends JFrame implements ActionListener
{
	Info i;
	JButton b1;
	JLabel l1,l2,l3,l4;
	JTextField t1;
	JPanel p1;
	GuessGame()
	{
		i=new Info();
		i.start();
		setTitle("Guess Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
		setLayout(new GridLayout(3,1));
		b1=new JButton("Submit");
		l1=new JLabel("Enter your guess(1-100)");
		l2=new JLabel("Attempts remaining "+ i.remAttempts());
		l3=new JLabel("WELCOME TO THE GUESS GAME",JLabel.CENTER);
		l4=new JLabel("");
		t1=new JTextField();
		p1=new JPanel();
		p1.setLayout(new GridLayout(2,2));
		p1.add(l1); p1.add(t1);
		p1.add(l2); p1.add(l4);
		add(l3);
		add(p1);
		add(b1);
		b1.addActionListener(this);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			i.attempt++;	
			l2.setText("Attempts remaining "+ i.remAttempts());
			String result=i.check(t1.getText());
			if((i.attempt==i.maxAttempt)||(i.won==true))
			{
				b1.setEnabled(false); //unabled the button b1 so that user cant try to press it
				if(i.won==false)
					l4.setText(result+"The number is "+i.num);
				else 
					l4.setText(result);
				JOptionPane.showMessageDialog(null,"Round"+i.round+" Score: "+i.gameScore()+"/100");
				int op=JOptionPane.showConfirmDialog(null,"Wanna play again?");
				if(op==JOptionPane.YES_OPTION)
				{

					b1.setEnabled(true);
					t1.setText("");
					l4.setText("");
					l2.setText("Attempts remaining 10");
					i.start();
				}
				else
				{
					if(i.round>1)
						JOptionPane.showMessageDialog(null,"Total Score for "+i.round+" rounds:"+i.totScore()+"/100");
					System.exit(0);
				}
			}
			else 
				l4.setText(result);
		}
	}
	public static void main(String ar[])
	{
		new GuessGame();
	}
}