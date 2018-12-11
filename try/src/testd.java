import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import po.And;
import po.Eor;
import po.Identical;
import po.Inor;
import po.Not;
import po.Only;
import po.Or;
import po.Require;
import po.Status;
import po.StatusPanel;

public class testd{
	//组件
	private static List<Element> statusElement;//状态
	private static List<Element> identicalElement;//恒等
	private static List<Element> andElement;//与
	private static List<Element> orElement;//或
	private static List<Element> notElement;//非
	private static List<Element> inorElement;//包含
	private static List<Element> eorElement;//互斥
	private static List<Element> onlyElement;//唯一
	private static List<Element> requireElement;//要求
	
	private static List<Status> statusList;//状态
	private static List<Identical> identicalList;//恒等
	private static List<And> andList;//与
	private static List<Or> orList;//或
	private static List<Not> notList;//非
	private static List<Inor> inorList;//包含
	private static List<Eor> eorList;//互斥
	private static List<Only> onlyList;//唯一
	private static List<Require> requireList;//要求
	
	private static Status status;
	private static Identical identical;
	private static And and;
	private static Or or;
	private static Not not;
	private static Inor inor;
	private static Eor eor;
	private static Only only;
	private static Require require;
	private static Container con;
	private static List<StatusPanel> spList;

	private static StatusPanel sp;
	private static JPanel jPanel;
	private static int type;
	static int qx,qy,zx,zy;
	
	static Vector paintInfo = null;// 点信息向量组
	public static void read(String path){
		try {   
			File f = new File(path);  //文件查找 
			SAXReader reader = new SAXReader();   
			Document doc = reader.read(f);   //构建XML源的DOM4J文档
			Element root = doc.getRootElement();   //得到的XML的根元素

			statusElement = root.elements("state");
			identicalElement = root.elements("identical");
			andElement = root.elements("and");
			orElement = root.elements("or");
			notElement = root.elements("not");
			inorElement = root.elements("inor");
			eorElement = root.elements("eor");
			onlyElement = root.elements("only");
			requireElement = root.elements("require");
			
			getElement();
			initsqList();
			paintInfo = new Vector();

		} catch (Exception e) {   
			e.printStackTrace();   
		}   
	}
	
	private static void getElement() {
		// TODO Auto-generated method stub
		statusList = new ArrayList<Status>();
		identicalList = new ArrayList<Identical>();
		andList = new ArrayList<And>();
		orList = new ArrayList<Or>();
		notList = new ArrayList<Not>();
		inorList = new ArrayList<Inor>();
		eorList = new ArrayList<Eor>();
		onlyList = new ArrayList<Only>();
		requireList = new ArrayList<Require>();
		
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
		 for(Element ele:andElement){
			 
		 }
		 for(Element ele:orElement){
			 
		 }
		 for(Element ele:notElement){
			 
		 }
		 for(Element ele:inorElement){

		 }
		 for(Element ele:eorElement){

		 }
		 for(Element ele:onlyElement){

		 }
		 for(Element ele:requireElement){

		 }
	}
	private static void initsqList(){
		spList = new ArrayList<StatusPanel>();
		 for(int i = 0;i < statusList.size();i ++){
			 sp = new StatusPanel();
			 sp.setOpaque(false);
			 spList.add(sp);
		 }
	}
	
	private static void drawPanel(int i){
		status = statusList.get(i);
		int x = status.getX();
	    int y = status.getY();
		int r = status.getR();
		type = 0;
		
		spList.get(i).addMouseListener(new MouseListener(){
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == spList.get(i)){
				if(spList.get(i).getBorder() == BorderFactory.createEtchedBorder())
					spList.get(i).setBorder(BorderFactory.createEmptyBorder());
				else
					spList.get(i).setBorder(BorderFactory.createEtchedBorder());
			}
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			 Point point = MouseInfo.getPointerInfo().getLocation(); 
			 qx = point.x; 
			 qy = point.y;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource() == spList.get(i)){
				Point point = MouseInfo.getPointerInfo().getLocation(); 
				zx = point.x; 
				zy = point.y;
				spList.get(i).setBounds(spList.get(i).getX() + zx - qx,spList.get(i).getY() + zy - qy,2 * r + 2,2 * r + 2);
				spList.get(i).repaint();
			}
					 
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
		spList.get(i).setBounds(x, y, 2*r+2, 2*r+2);
		String str = "";
		str = status.getName();
		spList.get(i).setVisible(true);
		spList.get(i).setPart(status, type);
		spList.get(i).repaint();
		type = -1;
	}
	
	static class Mypanel extends JPanel{
/**主画板，绘制链接
		 * 
		 */
		private static final long serialVersionUID = 8784049943863444767L;

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
				 g.drawLine(x1+1, y1+1, x2+1, y2+1);
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
		read(path);
		
		if(spList != null)
			for(int i = 0;i < spList.size();i ++ ){
				drawPanel(i);
				jPanel.add(spList.get(i));
			}
		jPanel.setLayout(null);
		jPanel.repaint();
		con.add(jPanel);
		con.validate();
		}

	
}
