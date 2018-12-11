package test193;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class JFrameDemo {
	JFrame mainJFrame;
	JLabel myJLabel;
	JLabel myJLabel1;
	
	public JFrameDemo()
	{
		mainJFrame = new JFrame("JFrame��ʾ����");//JFrameΪ��������
		myJLabel = new JLabel("Hello World!");
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.Windows.WindowsLookAndFeel");
		}catch(Exception e){
			System.err.println(e.toString());
		}
		mainJFrame.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT,30,20));//������ʽ����
		mainJFrame.getContentPane().add(myJLabel);//���swing���������������
		mainJFrame.setSize(400,400);//���ô����С
		mainJFrame.setVisible(true);//���ô����Ƿ�ɼ�
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ùرմ���ʱ�˳�JVM
	}
	public static void main(String args[])
	{
		new JFrameDemo();
	}
}
