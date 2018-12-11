package test195;

//动态的窗体大小调整

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
		addWindowListener(new WindowAdapter(){//增加监听器设置
			public void windowOpened(WindowEvent e){
				do_this_windowOpened(e);
			}
		});
		
		setTitle("根据桌面大小调整窗体");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);//设置窗体位置
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));//设置面板的边界
		contentPane.setLayout(new BorderLayout(0,0));//布局管理器
		setContentPane(contentPane);//设置内容面板
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
		EventQueue.invokeLater(new Runnable(){//使事件派发线程上的可运行对象排队
			public void run(){//当可运行对象排在事件派发队列的队首时，就调用其run方法
				try{
					DynamicAdjustSize frame = new DynamicAdjustSize();
					frame.setVisible(true);//设置窗口可见
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
}
