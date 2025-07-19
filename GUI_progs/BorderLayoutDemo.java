//for layouts refer: sem3 java materialhub

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutDemo {
  public static void main(String[] args) {
    JFrame frame = new JFrame("BorderLayoutDemo");
   
	frame.add(new JButton("PAGE_START"), BorderLayout.PAGE_START);
	frame.add(new JButton("PAGE_END"), BorderLayout.PAGE_END);
    	frame.add(new JButton("LINE_START"), BorderLayout.LINE_START);
    	frame.add(new JButton("LINE_END"), BorderLayout.LINE_END);
    	frame.add(new JButton("CENTER"), BorderLayout.CENTER);

    //pack() method calculates and assign appropriate size for frame
    frame.pack();
 
    //Making the frame visible
    frame.setVisible(true);
  }
}
