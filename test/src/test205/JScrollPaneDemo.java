package test205;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;

public class JScrollPaneDemo {
	JScrollPane myJspane;
	JLabel myJlabel;
	JFrame myJframe;
	
	public JScrollPaneDemo() {
		// TODO Auto-generated constructor stub
		myJframe = new JFrame("JScrollPane");
		Icon picture = new ImageIcon("C:\\Users\\lxs\\Documents\\test.jpg");
		myJlabel = new JLabel(picture);
		myJlabel.setIcon(picture);
		myJspane = new JScrollPane();
		myJspane.setLayout(new ScrollPaneLayout());
		myJspane.getViewport().add(myJlabel);
		myJframe.add(myJspane);
		myJframe.setSize(300,300);
		myJframe.setVisible(true);
		myJframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args)
	{
		new JScrollPaneDemo();
	}
}
