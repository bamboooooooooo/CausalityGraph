import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
import po.Cable;
import po.Not;
import po.Only;
import po.Or;
import po.Require;
import po.Status;
import po.StatusPanel;

public class readtry{
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
	private static int qx,qy,zx,zy;
	private static Cable cable;
	private static List<SignPoint> pointList;
	private static SignPoint p1,p2,p3,p4;
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
//			status.setType(Integer.parseInt(ele.attributeValue("type")));
			statusList.add(status);
		 }
		 
		 for(Element ele:identicalElement){
			 identical = new Identical();
			 identical.setX1(Integer.parseInt(ele.attributeValue("x1")));
			 identical.setY1(Integer.parseInt(ele.attributeValue("y1")));
			 identical.setX2(Integer.parseInt(ele.attributeValue("x2")));
			 identical.setY2(Integer.parseInt(ele.attributeValue("y2")));
			 identical.setStart(ele.attributeValue("start"));
			 identical.setEnd(ele.attributeValue("end"));
			 identicalList.add(identical);
		 }
		 for(Element ele:andElement){
			 and = new And();
			 List<Element> cableElement = new ArrayList<Element>();
			 cableElement = ele.elements("cable");
			 List<Cable> cableList = new ArrayList<Cable>();
			 for(Element cabele : cableElement){
				 cable = new Cable();
				 cable.setX1(Integer.parseInt(cabele.attributeValue("x1")));
				 cable.setY1(Integer.parseInt(cabele.attributeValue("y1")));
				 cable.setX2(Integer.parseInt(cabele.attributeValue("x2")));
				 cable.setY2(Integer.parseInt(cabele.attributeValue("y2")));
				 cable.setStart(cabele.attributeValue("start"));
				 cable.setEnd(cabele.attributeValue("end"));
				 cableList.add(cable);
			 }
			 and.setCabelList(cableList);
			 and.setEnd(cableList.get(0).getEnd());
			 andList.add(and);
		 }
		 for(Element ele:orElement){
			 
		 }
		 for(Element ele:notElement){
			 not = new Not();
			 not.setX1(Integer.parseInt(ele.attributeValue("x1")));
			 not.setY1(Integer.parseInt(ele.attributeValue("y1")));
			 not.setX2(Integer.parseInt(ele.attributeValue("x2")));
			 not.setY2(Integer.parseInt(ele.attributeValue("y2")));
			 not.setStart(ele.attributeValue("start"));
			 not.setEnd(ele.attributeValue("end"));
			 notList.add(not);
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
				int x = spList.get(i).getX() + zx - qx;
				int y = spList.get(i).getY() + zy - qy;
				spList.get(i).setBounds(x,y,2 * r + 2,2 * r + 2);
				spList.get(i).repaint();
				updateIdentical(statusList.get(i),x,y);
				updateNot(statusList.get(i),x,y);
				updateAnd(statusList.get(i),x,y);
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
	
	public static void updateIdentical(Status sta,int x,int y){
		for(Identical identical:identicalList){
			if(identical.getStart().equals(sta.getName())){
				identical.setX1(x + 2 * sta.getR());
				identical.setY1(y + sta.getR());
			}
			else if(identical.getEnd().equals(sta.getName())){
				identical.setX2(x);
				identical.setY2(y + sta.getR());
			}
			else
				continue;
			jPanel.repaint();
		}
	}
	public static void updateNot(Status sta,int x,int y){
		for(Not not : notList){
			if(not.getStart().equals(sta.getName())){
				not.setX1(x + 2 * sta.getR());
				not.setY1(y + sta.getR());
			}
			else if(not.getEnd().equals(sta.getName())){
				not.setX2(x);
				not.setY2(y + sta.getR());
			}
			else
				continue;
			jPanel.repaint();
		}
	}
	public static void updateAnd(Status sta,int x,int y){
		for(And and : andList){
			List<Cable> cableList = and.getCableList();
			if(and.getEnd().equals(sta.getName())){
				for(Cable cable : cableList){
					cable.setX2(x);
					cable.setY2(y + sta.getR());
				}
			}
			for(Cable cable : cableList){
				if(cable.getStart().equals(sta.getName())){
					cable.setX1(x + 2 * sta.getR());
					cable.setY1(y + sta.getR());
				 }
			 }
			jPanel.repaint();
		}
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
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(Color.BLACK);
			int l = 30;
			g2d.setFont(new Font(null, 0,l));
			 //恒等
			 for(Identical identical:identicalList){
				 
				 int x1 = identical.getX1();
				 int y1 = identical.getY1();
				 int x2 = identical.getX2();
				 int y2 = identical.getY2();
				 Line2D line = new Line2D.Double(x1, y1, x2, y2);
				 g2d.draw(line);
				 p1 = new SignPoint(x1,y1 - 10,"identical",identicalList.indexOf(identical));
				 p2 = new SignPoint(x1 - 10,y1,"identical",identicalList.indexOf(identical));
				 p3 = new SignPoint(x2,y2 + 10,"identical",identicalList.indexOf(identical));
				 p4 = new SignPoint(x2 + 10,y2,"identical",identicalList.indexOf(identical));
//				 System.out.println("identical");
//				 System.out.println("left " + p2.getX() + " " + p2.getY() );
//				 System.out.println("right " + p4.getX() + " " + p4.getY() );
//				 System.out.println("up " + p1.getX() + " " + p1.getY() );
//				 System.out.println("down " + p3.getX() + " " + p3.getY() );
				 pointList.add(p1);
				 pointList.add(p2);
				 pointList.add(p3);
				 pointList.add(p4);
				 pointList.add(null);
			 }
			 //非
			 for(Not not:notList){
				 int x1 = not.getX1();
				 int y1 = not.getY1();
				 int x2 = not.getX2();
				 int y2 = not.getY2();
//				 int midx = x1 + (x2-x1)/2;
				 int midy = y1 + (y2-y1)/2;
//				 int d = (int)Math.sqrt((x2-x1) * (x2 - x1) + (y2 - y1) * (y2 - y1))/10;
				 g.drawLine(x1+1, y1+1, x2+1, y2+1);
				 g.drawLine(x1 + (x2 - x1) / 5, midy + 10, x1 + (x2 - x1) * 2 / 5, midy - 10);
				 g.drawLine(x1 + (x2 - x1) * 2 / 5, midy - 10, x1 + (x2 - x1) * 3 / 5, midy + 10);
				 g.drawLine(x1 + (x2 - x1) * 3 / 5, midy + 10, x1 + (x2 - x1) * 4 / 5, midy - 10);
//				 g.drawLine(midx - 2 * d,midy + d,midx - d,midy - d);
//				 g.drawLine(midx - d,midy - d,midx + d,midy + d);
//				 g.drawLine(midx + d,midy + d,midx + 2 * d,midy - d);
			 }
			//与
			 for(And and : andList){
				 List<Cable> cableList = and.getCableList();
				 int mt = cableList.get(0).getY1(),md = cableList.get(0).getY1(),j = 0,k = 0;
				 for(int i = 0;i < cableList.size();i ++ ){
					 cable = cableList.get(i);
					 int x1 = cable.getX1();
					 int y1 = cable.getY1();
					 int x2 = cable.getX2();
					 int y2 = cable.getY2();
					 g.drawLine(x1+1, y1+1, x2+1, y2+1);
					 if(y1 < mt){
						 mt = y1;
						 j = i;
					 }
					 if(y1 > md){
						 md = y1;
						 k = i;
					 }
				 }
				 Cable tcable = cableList.get(j);
				 Cable dcable = cableList.get(k);
				 int dt = (int)Math.sqrt((tcable.getX2()-tcable.getX1()) * (tcable.getX2() - tcable.getX1()) + (tcable.getY2() - tcable.getY1()) * (tcable.getY2() - tcable.getY1()));
				 int dd = (int)Math.sqrt((dcable.getX2()-dcable.getX1()) * (dcable.getX2() - dcable.getX1()) + (dcable.getY2() - dcable.getY1()) * (dcable.getY2() - dcable.getY1()));
				 int td = (int)Math.sqrt((dcable.getX1()-tcable.getX1()) * (dcable.getX1() - tcable.getX1()) + (dcable.getY1() - tcable.getY1()) * (dcable.getY1() - tcable.getY1()));
				 int x = tcable.getX1() + (tcable.getX2() - tcable.getX1()) * 7 / 8;
				 int y = tcable.getY1() + (tcable.getY2() - tcable.getY1()) * 7 / 8;
				 double d = Math.sqrt(((tcable.getX2() - tcable.getX1()) * 1 / 8) * ((tcable.getX2() - tcable.getX1()) * 1 / 8) + ((tcable.getY2() - tcable.getY1()) * 1 / 8) * ((tcable.getY2() - tcable.getY1()) * 1 / 8));
				 
				 double tjd = Math.atan((double)(tcable.getY2() - tcable.getY1())/(tcable.getX2() - tcable.getX1())) / Math.PI * 180;
				 double djd = Math.acos((double)(dt * dt + dd * dd - td * td) / (2 * dt * dd)) / Math.PI * 180;
//				 g.drawArc(x, y - (int)d, 2 * (int)d, 2 * (int)d, 180,(int)djd);
				 g.drawString("V",tcable.getX2() - (tcable.getX2() - tcable.getX1()) / 4 ,tcable.getY2() + 15 );
				 g.drawArc(tcable.getX2() - (int)d, tcable.getY2() - (int)d, 2 * (int)d, 2 * (int)d, 180 - (int)tjd,(int)djd);
				 p1 = new SignPoint(cableList.get(0).getX2(),cableList.get(0).getY2(),"and",0);
				 p2 = new SignPoint(tcable.getX1(),tcable.getY1(),"and",0);
				 p3 = new SignPoint(dcable.getX1(),dcable.getY1(),"and",0);
//				 System.out.println("and");
//				 System.out.println("right " + p1.getX() + " " + p1.getY() );
//				 System.out.println("up " + p2.getX() + " " + p2.getY() );
//				 System.out.println("down " + p3.getX() + " " + p3.getY() );
				 pointList.add(p1);
				 pointList.add(p2);
				 pointList.add(p3);
				 pointList.add(null);
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
		jPanel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();
				int y = e.getY();
				isContain(x,y,pointList);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		pointList = new ArrayList<SignPoint> ();
		pointList.add(null);
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

	private static void isContain(int x, int y, List<SignPoint> pointList) {
		// TODO Auto-generated method stub
		SignPoint point ;
		List<SignPoint> testPoint = new ArrayList<SignPoint>();
		for(int i = 1;i < pointList.size();i ++) {
			point = pointList.get(i);
			if(point != null) {
				testPoint.add(point);
			}
			else {
				boolean bool = istest(x,y,testPoint);
				if(bool == true) {
					System.out.println(testPoint.get(0).getType() + " " + testPoint.get(0).getI());
					break;
				}
				testPoint = new ArrayList<SignPoint>();
			}
		}
	}
	public static boolean istest(int x,int y,List<SignPoint> pointList) {
		boolean bool = false;
		List<Integer>  xlist = new ArrayList<Integer>();
		List<Integer>  ylist = new ArrayList<Integer>();
		int up = pointList.get(0).getY(),down = pointList.get(0).getY(),left = pointList.get(0).getX(),right = pointList.get(0).getX();
		for(SignPoint point : pointList) {
			xlist.add(point.getX());
			ylist.add(point.getY());
			if(point.getY() < up)
				up = point.getY();
			else if(point.getY() > down)
				down = point.getY();
			if(point.getX() < left)
				left = point.getX();
			else if(point.getX() > right)
				right = point.getX();
		}
		if (x < left || x > right || y < up || y > down) {
			return bool;
		}
		Integer[] verty = ylist.toArray(new Integer[xlist.size()]);
		Integer[] vertx = xlist.toArray(new Integer[xlist.size()]);
		bool = pnpoly(pointList.size(),vertx,verty,x,y);
		return bool;
	}
	public static boolean pnpoly(int nvert, Integer[] vertx, Integer[] verty, int testx, int testy)
	{
		int i, j;
		Boolean c = false;
		for (i = 0, j = nvert-1; i < nvert; j = i++) {
			if ( ((verty[i]>testy) != (verty[j]>testy)) && 
					(testx < (vertx[j]-vertx[i]) * (testy-verty[i]) / (verty[j]-verty[i]) + vertx[i]) )
				c = !c;
		}
		return c;
	}

	
}
