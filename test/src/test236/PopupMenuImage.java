package test236;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

public class PopupMenuImage extends JFrame{
	private JPanel contentPane;
	public PopupMenuImage(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,300,200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		JPopupMenu popupMenu = new JPopupMenu();//创建一个弹出式菜单
		contentPane.setComponentPopupMenu(popupMenu);
		
		JMenuItem cut = new JMenuItem("剪切");
		JMenuItem copy = new JMenuItem("复制");
		JMenuItem paste = new JMenuItem("粘贴");
		JMenuItem delete = new JMenuItem("删除");
//		cut.setIcon(new ImageIcon(PopupMenuImage.class.getResource("cut.jpg")));
//		cut.addActionListener(listener);
//		copy.addActionListener(listener);
//		paste.addActionListener(listener);
//		delete.addActionListener(listener);
		
		popupMenu.add(cut);
		popupMenu.add(copy);
		popupMenu.add(paste);
		popupMenu.add(delete);
		
		contentPane.setLayout(new BorderLayout(0,0));
		setContentPane(contentPane);
		
	}
	private ActionListener listener = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			e.getActionCommand();
		}
	};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable(){//使事件派发线程上的可运行对象排队
			public void run(){//当可运行对象排在事件派发队列的队首时，就调用其run方法
				try{
					PopupMenuImage mi = new PopupMenuImage();//声明窗口
					mi.setVisible(true);//窗体可见性设置
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}

}
