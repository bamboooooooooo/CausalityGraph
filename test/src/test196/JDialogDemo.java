
//�����Ի���

package test196;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JDialogDemo extends JFrame{
	JFrame mainJFrame;
	JLabel myJLabel;
	JDialog subDialog;
	int width;
	int height;
	
	private void do_this_windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
			Toolkit toolkit = getToolkit();
			Dimension screenSize = toolkit.getScreenSize();
			width = (int)(screenSize.width * 0.8);
			height = (int)(screenSize.height * 0.8);
		}
	
	public JDialogDemo(){
		//@Override
		addWindowListener(new WindowAdapter(){//���Ӽ���������
			public void windowOpened(WindowEvent e){
				do_this_windowOpened(e);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);//���ô���λ��
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));//�������ı߽�
		contentPane.setLayout(new BorderLayout(0,0));//���ֹ�����
		setContentPane(contentPane);//�����������
		mainJFrame = new JFrame();
		myJLabel = new JLabel("Hello,World");
		subDialog = new JDialog(mainJFrame,"����һ���Ի���");//�����Ի���
		subDialog.getContentPane().setLayout(new FlowLayout());//���ֹ�����
		subDialog.getContentPane().add(myJLabel);
		mainJFrame.setSize(width, height);
		System.out.println(width + ' ' + height);
//		mainJFrame.setVisible(true);
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		subDialog.setSize(200,200);
		subDialog.setVisible(true);
	}
	
	public static void main(String args[])
	{
		EventQueue.invokeLater(new Runnable(){//ʹ�¼��ɷ��߳��ϵĿ����ж����Ŷ�
			public void run(){//�������ж��������¼��ɷ����еĶ���ʱ���͵�����run����
				try{
					JDialogDemo frame = new JDialogDemo();
					frame.setVisible(true);//���ô��ڿɼ�
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
}
