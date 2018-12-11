package test195;

//��̬�Ĵ����С����

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DynamicAdjustSize extends JFrame{
	public DynamicAdjustSize(){
	//@Override
		addWindowListener(new WindowAdapter(){//���Ӽ���������
			public void windowOpened(WindowEvent e){
				do_this_windowOpened(e);
			}
		});
		
		setTitle("���������С��������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);//���ô���λ��
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));//�������ı߽�
		contentPane.setLayout(new BorderLayout(0,0));//���ֹ�����
		setContentPane(contentPane);//�����������
	}
	private void do_this_windowOpened(WindowEvent e) {
	// TODO Auto-generated method stub
		Toolkit toolkit = getToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int width = (int)(screenSize.width * 0.8);
		int height = (int)(screenSize.height * 0.8);
		setSize(width,height);
	}
	public static void main(String args[])
	{
		EventQueue.invokeLater(new Runnable(){//ʹ�¼��ɷ��߳��ϵĿ����ж����Ŷ�
			public void run(){//�������ж��������¼��ɷ����еĶ���ʱ���͵�����run����
				try{
					DynamicAdjustSize frame = new DynamicAdjustSize();
					frame.setVisible(true);//���ô��ڿɼ�
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
}
