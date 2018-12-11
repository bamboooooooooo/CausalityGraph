package test194;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JFrameSize extends JFrame{
	private static final long serialVersionUID = -208558891244185548L;
	private JPanel contentPane;//容器
	
	public static void main(String args[])
	{
		EventQueue.invokeLater(new Runnable(){//使事件派发线程上的可运行对象排队
			public void run(){//当可运行对象排在事件派发队列的队首时，就调用其run方法
				try{
					JFrameSize frame = new JFrameSize();
					frame.setVisible(true);//设置窗口可见
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	public JFrameSize(){
		setTitle("设置窗体大小");//设置窗体标题
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//默认关闭方式
		setSize(250,250);//设置窗体大小
		contentPane = new JPanel();//创建内容模板
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);//设置内容面板
		JLabel label = new JLabel("宽度：250，高度：250");
		contentPane.add(label, BorderLayout.CENTER);//添加标签空间到窗体
		
//		String a = getTitle();//获取窗体标题
//		System.out.println(a);
		
//		setResizable(true);//设置窗口大小是否可调(默认可调）
	}
	
}
