import javax.swing.*;
import java.awt.*;
class Banner extends JPanel {
int x = 0;
int y = 150;
int speed = 1;
public void paintComponent(Graphics g)
{
super.paintComponent(g);
String message = "AIDS";
g.drawString(message, x, y);
x += speed;
if (x > getWidth())
{
x = -100;
}
try {
Thread.sleep(10);
}
catch (InterruptedException e)
{
e.printStackTrace();
}
repaint();
}
public static void main(String[] args)
{
JFrame frame = new JFrame("Banner");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Banner banner = new Banner();
frame.add(banner);
frame.setSize(300, 200);
frame.setVisible(true);
}
}