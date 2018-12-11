import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

public class readXML{
	//缁勪欢
	private static List<Element> statusElement;//鐘舵��
	private static List<Element> identicalElement;//鎭掔瓑
	private static List<Element> andElement;//涓�
	private static List<Element> orElement;//鎴�
	private static List<Element> notElement;//闈�
	private static List<Element> inorElement;//鍖呭惈
	private static List<Element> eorElement;//浜掓枼
	private static List<Element> onlyElement;//鍞竴
	private static List<Element> requireElement;//瑕佹眰
	
	private static List<Status> statusList;//鐘舵��
	private static List<Identical> identicalList;//鎭掔瓑
	private static List<And> andList;//涓�
	private static List<Or> orList;//鎴�
	private static List<Not> notList;//闈�
	private static List<Inor> inorList;//鍖呭惈
	private static List<Eor> eorList;//浜掓枼
	private static List<Only> onlyList;//鍞竴
	private static List<Require> requireList;//瑕佹眰
	
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
	
	public static JPanel readxml(String path){
		JPanel jp = new Mypanl();
		try {   
			File f = new File(path);  //鏂囦欢鏌ユ壘 
			SAXReader reader = new SAXReader();   
			Document doc = reader.read(f);   //鏋勫缓XML婧愮殑DOM4J鏂囨。
			Element root = doc.getRootElement();   //寰楀埌鐨刋ML鐨勬牴鍏冪礌

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
		} catch (Exception e) {   
			e.printStackTrace();   
		}   
		jp.repaint();
		jp.setBackground(Color.WHITE);
		return jp;
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

	static class Mypanl extends JPanel{
//		 @SuppressWarnings("unused")
		public void paint(Graphics g) {
		     super.paint(g);
		     //璁剧疆鐢荤瑪
			 g.setColor(Color.BLACK);
			 int l = 30;
			 g.setFont(new Font(null, 0,l));
			 for(Status status:statusList){
				 int x = status.getX();
				 int y = status.getY();
				 int r = status.getR();
				 String str = "";
				 str = status.getName();
				 int strWidth = g.getFontMetrics().stringWidth(str);
				 g.drawOval(x, y, r*2, r*2);
				 g.drawString(str,x + r-strWidth/2,y + r+l/2);
			 }
			 
			 for(Identical identical:identicalList){
				 int x1 = identical.getX1();
				 int y1 = identical.getY1();
				 int x2 = identical.getX2();
				 int y2 = identical.getY2();
				 g.drawLine(x1, y1, x2, y2);
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
	}
	
	public static void main(String[] args) {   
		JFrame jf = new JFrame();
		con = jf.getContentPane();
		jf.setTitle("璇诲彇xml");
		jf.setSize(1000, 800);
		jf.setLocationRelativeTo(null); //绐楀彛浣嶄簬灞忓箷涓ぎ
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
		
		String path = "C:\\Users\\lxs\\Desktop\\xmltry.xml";
		JPanel jp = readxml(path);
		con.add(jp);
		con.validate();
		}   
}
