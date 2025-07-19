/* 1. Class Definition: Create class BasicTextEditor extends JFrame to create a GUI
window for the text editor.
2. Add Components:
 JTextArea (textArea): Provides a multi-line text area for text input.
 JScrollPane (scrollPane): Allows scrolling when the text exceeds the visible
area.
3. Implement Key Event Handling:
 KeyAdapter: Added to textArea to handle key events.
 handleKeyPressed(KeyEvent e): Method that processes key presses.
o Enter (VK_ENTER): Placeholder for handling Enter key press.
o Backspace (VK_BACK_SPACE): Deletes the character before the
caret position.
o Delete (VK_DELETE): Deletes the character at the caret position.
o Left arrow (VK_LEFT): Moves the caret position left.
o Right arrow (VK_RIGHT): Moves the caret position right.
o Typing characters: Inserts typed characters at the caret position. */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class BasicTextEditor extends JFrame implements KeyListener
{
	JTextArea ta;
	JScrollPane jp;
	BasicTextEditor()
	{
		setTitle("keyEvents");
		setSize(400,400);
		setLayout(new FlowLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ta=new JTextArea(30,30);
		ta.addKeyListener(this);
		jp=new JScrollPane(ta);
		setVisible(true);  
		add(jp);
	}
	 public void keyPressed(KeyEvent ke)
	{
		int cp=ta.getCaretPosition(); //to get current caret pos in textArea
		switch(ke.getKeyCode())
		{
			case KeyEvent.VK_ENTER:
			{
				ta.insert("\n",cp);
				ta.setCaretPosition(cp+1);
				ke.consume(); // Consume the event to prevent further processing
				break;
			}
			case KeyEvent.VK_BACK_SPACE:
			{
				
				if (cp > 0) // Check if the caret is at the beginning
				  ta.replaceRange("",cp-1,cp);
				ke.consume();
				  //replaceRange(String str, int start, int end)
				break;
			}
			case KeyEvent.VK_DELETE:
			{
				if (cp < ta.getText().length()) 
				   ta.replaceRange("",cp,cp+1);
			    ke.consume();
				break;
			}
			/*  at java.desktop/java.awt.EventQueue.dispatchEvent(EventQueue.java:744)
                at java.desktop/java.awt.EventDispatchThread.pumpOneEventForFilters(EventDispatchThread.java:203)
                at java.desktop/java.awt.EventDispatchThread.pumpEventsForFilter(EventDispatchThread.java:124)
                at java.desktop/java.awt.EventDispatchThread.pumpEventsForHierarchy(EventDispatchThread.java:113)
                at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:109)
                at java.desktop/java.awt.EventDispatchThread.pumpEvents(EventDispatchThread.java:101)
                at java.desktop/java.awt.EventDispatchThread.run(EventDispatchThread.java:90) 
		         if this error occurs: give boundry condition(especially for backspace,delete)
		    */
			case KeyEvent.VK_LEFT:
			{
				if(cp>0)
					ta.setCaretPosition(cp-1);
				ke.consume();
				break;
			}
			case KeyEvent.VK_RIGHT:
			{
				if(cp<ta.getText().length())
					ta.setCaretPosition(cp+1);
				ke.consume();
				break;
			}
		}
	}
	public void keyTyped(KeyEvent ke)
	{
		int cp=ta.getCaretPosition();
		char ch=ke.getKeyChar();
		if(Character.isDefined(ch)&&!Character.isISOControl(ch)) //check if char is defined and doesnt come under control events
		{                                                                //i.e its a simple char key
			ta.insert(String.valueOf(ch),cp); 
			ta.setCaretPosition(cp+1);
		}                                                       
		 ke.consume();  // Ensure the JTextArea doesn't handle the event again
	}
	public void keyReleased(KeyEvent ke)
	{}
	public static void main(String ar[])
	{
		new BasicTextEditor();
	}
	}