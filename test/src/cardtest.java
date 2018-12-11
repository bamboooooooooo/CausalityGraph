import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class cardtest extends JPanel{
	/**	 * 读取文件内容	 * @param args	 */	
	public static void main(String[] args) {
	    String subject[] = { "Math", " English", "SQL", "   java", "  c ", " c++ ",
	        " cobol ", "this is a test" };
	    JFrame f = new JFrame();
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JList<String> list = new JList<String>(subject);
	    JScrollPane s = new JScrollPane(list);
	    s.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    s.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	    f.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
	    f.add(s);
	    f.setSize(300, 300);
	    f.setVisible(true);
	  }
	}
