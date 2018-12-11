import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class cardtest2 {
	public static void main(String[] args) {
		UIManager ui = new UIManager();
		ui.initUI();
	}
}
class UIManager extends JFrame {
	public UIManager() {
		super("学生信息管理系统");
	}
	public void initUI() {
		this.setBounds(300, 300, 500, 400);
		this.addWindowListener(new WindowAdapter() {
		public void windowClosing(WindowEvent e) {
			super.windowClosing(e);
		       System.exit(0);
			}
		});
		layoutUI();
		this.setVisible(true);
	}
	private void layoutUI() {
		// 对象实例化
		JTabbedPane tab = new JTabbedPane(JTabbedPane.TOP);
		// 容器
		Container container = this.getLayeredPane();
		// 对象化面板
		JLabel l1 = new JLabel("111");
		JLabel l2 = new JLabel("222");
		JLabel l3 = new JLabel("333");
		JLabel l4 = new JLabel("444");
		
		JPanel combop = new JPanel();
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		p1.add(l1);
		p2.add(l2);
		p3.add(l3);
		p4.add(l4);
		
		tab.add(p1, "Select");
		tab.add(p2, "Updata");
		tab.add(p3, "Inserte");
		tab.add(p4, "Delete");
		 
		combop.add(new JLabel("学生信息管理系统"));
		 
		container.setLayout(new BorderLayout());
		container.add(combop, BorderLayout.NORTH);
		container.add(tab, BorderLayout.CENTER);
	
	   }

}
