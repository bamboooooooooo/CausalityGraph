import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class drawtest extends JFrame implements ActionListener, MouseListener, MouseMotionListener {
	private JPopupMenu popupMenu;
	private JPanel jp;
	private int type = -1;
	private int x = -1;
	private int y = -1;
	private static Container con;
	
	BasicStroke size = new BasicStroke(1, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);// 画笔粗细
	JFrame f;
	//右击目录
	private JMenu newConnect,causality,inputrelation;
	private JMenuItem identical,and,or,not;
	private JMenuItem inor,eor,only,require;
	private JMenuItem newState;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		drawtest dt = new drawtest();
	}
	public drawtest(){
		f=new JFrame();
		f.setTitle("画板");
		f.setSize(1400,900);
		
		con = f.getContentPane();
		jp = new Mypanl();
		jp.setBackground(Color.WHITE);
		jp.addMouseListener(this);
		jp.addMouseMotionListener(this);
		popupMenuList();
		con.add(jp);
		f.setLocationRelativeTo(null); //窗口位于屏幕中央
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		f.setVisible(true);
	}
	
	//弹出菜单
	public void popupMenuList(){
		//Project Menu点击右键
		popupMenu = new JPopupMenu();//创建一个弹出式菜单
		jp.addMouseListener(this);
		jp.add(popupMenu);
		newConnect = new JMenu("添加关联");
		causality = new JMenu("输入-输出关系");
		inputrelation = new JMenu("约束关系");
		identical = new JMenuItem("—恒等");
		and = new JMenuItem("∧与");
		or = new JMenuItem("∨或");
		not = new JMenuItem("∽非");
		inor = new JMenuItem("|包含");
		eor = new JMenuItem("E互斥");
		only = new JMenuItem("O唯一");
		require = new JMenuItem("R要求");
		newState = new JMenuItem("添加状态");
		
		newConnect.add(causality);
		newConnect.add(inputrelation);
		causality.add(identical);
		causality.add(and);
		causality.add(or);
		causality.add(not);
		inputrelation.add(inor);
		inputrelation.add(eor);
		inputrelation.add(only);
		inputrelation.add(require);
		
		identical.addActionListener(this);
		and.addActionListener(this);
		or.addActionListener(this);
		not.addActionListener(this);
		inor.addActionListener(this);
		eor.addActionListener(this);
		only.addActionListener(this);
		require.addActionListener(this);
		newState.addActionListener(this);
		
		popupMenu.add(newState);
		popupMenu.add(newConnect);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == newState){
			type = 0;
			jp.repaint();
		}
		if(e.getSource() == identical)
			type = 1;
		if(e.getSource() == and)
			type = 2;
		if(e.getSource() == or)
			type = 3;
		if(e.getSource() == not)
			type = 4;
		if(e.getSource() == inor)
			type = 5;
		if(e.getSource() == eor)
			type = 6;
		if(e.getSource() == only)
			type = 7;
		if(e.getSource() == require)
			type = 8;
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getButton() == MouseEvent.BUTTON3) {
			x = e.getX();
			y = e.getY();
			popupMenu.show(jp,e.getX(), e.getY());
			
			 }
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	class Mypanl extends JPanel{
		 public void paint(Graphics g) {
		     super.paint(g);
		     //设置画笔
			 g.setColor(Color.BLACK);
			 int r = 40;
			 int l = 20;
			 g.setFont(new Font(null, 0,l));
			 String str = "状态";
			 int strWidth = g.getFontMetrics().stringWidth(str);
			 if(type == 0){
				g.drawOval(x, y, 2*r, 2*r);
				g.drawString(str,x + r - strWidth/2,y + r + l/2);
				
			}
		}	
	}
	
}

