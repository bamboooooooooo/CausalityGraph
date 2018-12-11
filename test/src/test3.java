import javax.swing.JFrame;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.Canvas;

import javax.swing.JMenu;
import java.awt.Color;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import java.awt.Component;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JMenuBar;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class test3{

//Canvas c; // 声明一个画布对象 

	//数组放100个星星x坐标	
	static int[] list_x=new int[100];	//数组放100个星星y坐标	
	static int[] list_y=new int[100];	//放那个需要移动星星在数组中的下标	
	static int[] a=new int[]{1};	
	public static void main(String[] args) {		
		for (int i = 0; i < 100; i++) {			
			list_x[i]=(int)(Math.random()*1400);			
			list_y[i]=(int)(Math.random()*900);		
			}		
		//实例化画板		
		JFrame f=new JFrame();		
		//设置画板大小		
		f.setSize(1400,900);		
		//先获得画布对象，设置画布背景颜色为黑色		
		f.getContentPane().setBackground(Color.BLACK);		
		//实例化画布		
		Mypanl m=new Mypanl();		
		//添加鼠标点击事件监听		
		m.addMouseListener(m);		
		//将画布放到画板上		
		f.add(m);		
		//展示画板		
		f.show();	
		}	
	static class Mypanl extends Panel implements MouseListener{		
		/*		 * 重写画布的绘画方法，里面有一个画笔参数*/		
		@Override		
		public void paint(Graphics g) {			
			//设置画笔颜色			
			g.setColor(Color.WHITE);			
			//设置画笔大小			
			g.setFont(new Font(null, 0,20));			
			//循环花数组里存放的星星			
			for (int i = 0; i < list_x.length; i++) {				
				g.drawString("*",list_x[i],list_y[i]);			
				}		
			}		
		@Override		
		/**		 * @note 鼠标按键在组件上单击（按下并释放）时调用。		 * */		
		public void mouseClicked(MouseEvent e) {					} 		
		@Override		
		/**		 * @note 鼠标按键在组件上按下时调用。		 * */		
		public void mousePressed(MouseEvent e) {			
			System.out.println(1);			
			//开始移动之前的x坐标			
			int mouseX=e.getX();			
			//开始移动之前的y坐标			
			int mouseY=e.getY();			
			//遍历坐标数组			
			for (int i = 0; i < list_x.length; i++) {				
				//比较看有没有坐标重复的，有就记下，没有就不该				
				if ((list_x[i]<=mouseX+2&&mouseX<=list_x[i]+9)&&(mouseY>=list_y[i]-14&&mouseY<=list_y[i]-8)) {					
					a[0]=i;					
					System.out.println("i="+a[0]);				
					}			
				}			
			} 		
		@Override		
		/**		 * @note 鼠标按钮在组件上释放时调用。		 * */		
		public void mouseReleased(MouseEvent e) {			
			System.out.println(2);			
			int mouseX=e.getX();			
			int mouseY=e.getY();			
			if (a[0]>=0) {				
				System.out.println("i="+a[0]);				
				list_x[a[0]]=mouseX-5;				
				list_y[a[0]]=mouseY+10;				
				repaint();			
				}			
			a[0]=-1;		
			} 		
		@Override		
		/**		 * @note 鼠标进入到组件上时调用。		 * */		
		public void mouseEntered(MouseEvent e) {					} 		
		@Override		
		/**		 * @note 鼠标离开组件时调用		 * */		
		public void mouseExited(MouseEvent e) {			
			// TODO Auto-generated method stub					
			}	
		}
	}
	
