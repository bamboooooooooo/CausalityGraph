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
	Container con;//��������
	ListenMouse listenmouse;
	
	//�����ڲ������ڼ�������¼�
	public class ListenMouse extends MouseAdapter{
		public void mouseEntered(MouseEvent e){	//������ƶ�����ǩ��ʱ
			linkLabel.setCursor(new Cursor(Cursor.HAND_CURSOR)); //�ı��ǩ��������״��������״
		}
	}
	
	public JLabelDemo() {
		// TODO Auto-generated constructor stub
		listenmouse = new ListenMouse();//��������¼�������
		mainJFrame = new JFrame("ͼ���ǩʹ��ʵ��");
		con=mainJFrame.getContentPane();//���JFrame���������
		linkLabel = new JLabel("������Ƶ��˴�����꽫��Ϊ��״");
		con.add(linkLabel,BorderLayout.NORTH);
		linkLabel.addMouseListener(listenmouse);//�����������
		mainJFrame.setSize(250,250);
		mainJFrame.setVisible(true);
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JLabelDemo();
	}

}
