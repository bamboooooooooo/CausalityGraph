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
	
	BasicStroke size = new BasicStroke(1, BasicStroke.CAP_BUTT,BasicStroke.JOIN_BEVEL);// ���ʴ�ϸ
	JFrame f;
	//�һ�Ŀ¼
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
		f.setTitle("����");
		f.setSize(1400,900);
		
		con = f.getContentPane();
		jp = new Mypanl();
		jp.setBackground(Color.WHITE);
		jp.addMouseListener(this);
		jp.addMouseMotionListener(this);
		popupMenuList();
		con.add(jp);
		f.setLocationRelativeTo(null); //����λ����Ļ����
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
		f.setVisible(true);
	}
	
	//�����˵�
	public void popupMenuList(){
		//Project Menu����Ҽ�
		popupMenu = new JPopupMenu();//����һ������ʽ�˵�
		jp.addMouseListener(this);
		jp.add(popupMenu);
		newConnect = new JMenu("��ӹ���");
		causality = new JMenu("����-�����ϵ");
		inputrelation = new JMenu("Լ����ϵ");
		identical = new JMenuItem("�����");
		and = new JMenuItem("����");
		or = new JMenuItem("�Ż�");
		not = new JMenuItem("�׷�");
		inor = new JMenuItem("|����");
		eor = new JMenuItem("E����");
		only = new JMenuItem("OΨһ");
		require = new JMenuItem("RҪ��");
		newState = new JMenuItem("���״̬");
		
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
		     //���û���
			 g.setColor(Color.BLACK);
			 int r = 40;
			 int l = 20;
			 g.setFont(new Font(null, 0,l));
			 String str = "״̬";
			 int strWidth = g.getFontMetrics().stringWidth(str);
			 if(type == 0){
				g.drawOval(x, y, 2*r, 2*r);
				g.drawString(str,x + r - strWidth/2,y + r + l/2);
				
			}
		}	
	}
	
}

