package test194;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrameSize extends JFrame{
	private static final long serialVersionUID = -208558891244185548L;
	private JPanel contentPane;//����
	
	public static void main(String args[])
	{
		EventQueue.invokeLater(new Runnable(){//ʹ�¼��ɷ��߳��ϵĿ����ж����Ŷ�
			public void run(){//�������ж��������¼��ɷ����еĶ���ʱ���͵�����run����
				try{
					JFrameSize frame = new JFrameSize();
					frame.setVisible(true);//���ô��ڿɼ�
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	public JFrameSize(){
		setTitle("���ô����С");//���ô������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Ĭ�Ϲرշ�ʽ
		setSize(250,250);//���ô����С
		contentPane = new JPanel();//��������ģ��
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);//�����������
		JLabel label = new JLabel("��ȣ�250���߶ȣ�250");
		contentPane.add(label, BorderLayout.CENTER);//��ӱ�ǩ�ռ䵽����
		
//		String a = getTitle();//��ȡ�������
//		System.out.println(a);
		
//		setResizable(true);//���ô��ڴ�С�Ƿ�ɵ�(Ĭ�Ͽɵ���
	}
	
}
