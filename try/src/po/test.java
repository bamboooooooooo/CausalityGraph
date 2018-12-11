package po;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class test {
	private static int type = -1;
	private static List<Element> statusElement;//状态
	private static List<Element> identicalElement;//恒等
		
	private static List<Status> statusList;//状态
	private static List<Identical> identicalList;//恒等
		
	private static Status status;
	private static Identical identical;
	private static Container con;
	private static List<StatusPanel> spList;
	private static JPanel jPanel;//主画板
	private static StatusPanel sp;
		
	public static void test(String path){
		try {   
			File f = new File(path);  //文件查找 
			SAXReader reader = new SAXReader();   
			Document doc = reader.read(f);   //构建XML源的DOM4J文档
			Element root = doc.getRootElement();   //得到的XML的根元素

			statusElement = root.elements("state");
			identicalElement = root.elements("identical");
			
			getElement();
			
		} catch (Exception e) {   
			e.printStackTrace();   
		}   
//		jp.repaint();
		
//		return jpList;
	}
	private static void getElement() {
		// TODO Auto-generated method stub
		statusList = new ArrayList<Status>();
		identicalList = new ArrayList<Identical>();
		
		for(Element ele:statusElement){
			status = new Status();
			status.setX(Integer.parseInt(ele.attributeValue("cx")));
			status.setY(Integer.parseInt(ele.attributeValue("cy")));
			status.setR(Integer.parseInt(ele.attributeValue("r")));
			status.setName(ele.attributeValue("name"));
			status.setType(Integer.parseInt(ele.attributeValue("type")));
			statusList.add(status);
		 }
		 
		 for(Element ele:identicalElement){
			 identical = new Identical();
			 identical.setX1(Integer.parseInt(ele.attributeValue("x1")));
			 identical.setY1(Integer.parseInt(ele.attributeValue("y1")));
			 identical.setX2(Integer.parseInt(ele.attributeValue("x2")));
			 identical.setY2(Integer.parseInt(ele.attributeValue("y2")));
			 identical.setStart(ele.attributeValue("star"));
			 identical.setEnd(ele.attributeValue("end"));
			 identicalList.add(identical);
		 }
	}
	
	private static void drawPanel(){
		spList = new ArrayList<StatusPanel>();
		 for(int i = 0;i < statusList.size();i ++){
			 status = statusList.get(i);
			 sp = new StatusPanel();
			 sp.setBackground(Color.GREEN);
			 sp.setOpaque(false);
			 sp.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
		});
			 type = 0;
			
			 int x = status.getX();
			 int y = status.getY();
			 int r = status.getR();
			 sp.setSize(2*r,2*r);
			 sp.setLocation(x, y);
			 sp.setBounds(x, y, 2*r+10, 2*r+10);
			 String str = "";
			 str = status.getName();
			 sp.setVisible(true);
			 sp.setLayout(null);
			 sp.setPart(status, type);
			 sp.repaint();
//			 sp.validate();
			 spList.add(sp);
			 type = -1;
		 }
	}
	
	static class Mypanel extends JPanel{
//		 @SuppressWarnings("unused")
		public void paint(Graphics g) {
		     super.paint(g);
		     //设置画笔
			 g.setColor(Color.BLACK);
			 int l = 30;
			 g.setFont(new Font(null, 0,l));
			 for(Identical identical:identicalList){
				 int x1 = identical.getX1();
				 int y1 = identical.getY1();
				 int x2 = identical.getX2();
				 int y2 = identical.getY2();
				 g.drawLine(x1+5, y1+5, x2+5, y2+5);
			 }
			
		}
	}
	public static void main(String[] args) {  
		JFrame jf = new JFrame();
		con = jf.getContentPane();
		jf.setTitle("读取xml");
		jf.setSize(1000, 800);
		jf.setLocationRelativeTo(null); //窗口位于屏幕中央
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
		jPanel = new Mypanel();
		jPanel.setBackground(Color.WHITE);
		String path = "C:\\Users\\lxs\\Desktop\\xmltry.xml";
//		List<Mypanel> mypList = read(path);
		test(path);
		drawPanel();
		
		jPanel.setBackground(Color.WHITE);
		if(spList != null)
		for(StatusPanel mp:spList){
			jPanel.add(mp);
		}
		jPanel.setLayout(null);
		jPanel.repaint();
		con.add(jPanel);
		con.validate();
		}
}
