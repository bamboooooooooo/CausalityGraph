package test197;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JLabelDemo {
	
	JLabel linkLabel;
	JFrame mainJFrame;
	Container con;//声明容器
	ListenMouse listenmouse;
	
	//创建内部类用于监听鼠标事件
	public class ListenMouse extends MouseAdapter{
		public void mouseEntered(MouseEvent e){	//当鼠标移动到标签上时
			linkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR)); //改变标签上鼠标的形状，如变成手状
		}
	}
	
	public JLabelDemo() {
		// TODO Auto-generated constructor stub
		listenmouse = new ListenMouse();//建立鼠标事件监听器
		mainJFrame = new JFrame("图像标签使用实例");
		con=mainJFrame.getContentPane();//获得JFrame的内容面板
		linkLabel = new JLabel("把鼠标移到此处，鼠标将变为手状");
		con.add(linkLabel,BorderLayout.NORTH);
		linkLabel.addMouseListener(listenmouse);//添加鼠标监听器
		mainJFrame.setSize(250,250);
		mainJFrame.setVisible(true);
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JLabelDemo();
	}

}
