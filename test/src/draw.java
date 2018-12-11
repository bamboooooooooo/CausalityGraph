import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class draw {
	static int x;
    static int y;
    static int i=0;
	public draw() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//窗口设置
		JFrame f=new JFrame();
		f.setSize(1400,900);
		
		Mypanl m=new Mypanl();
		m.setBackground(Color.WHITE);
		
		m.addMouseListener(m);//添加鼠标监听
		m.addMouseMotionListener(m);//添加鼠标移动监听
		
		f.add(m);
		f.setVisible(true);
	}
	static class Mypanl extends JPanel implements MouseMotionListener, MouseListener{
		  /*
         * 重写画布的绘画方法，里面有一个画笔参数*/
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            //设置画笔颜色
            g.setColor(Color.BLACK);
            //设置画笔大小
            g.setFont(new Font(null, 0,50));
            //画*
            g.drawString("*",x,y);
            g.drawString("*",x+10,y+100);
        }
        
        //鼠标点击状态下拖动
        @Override
        public void mouseDragged(MouseEvent e) {
          //下面三行代码可形成图1效果
//        	Object o = new Object("*");
        
        		x=e.getX()-10;
        		y=e.getY()+28;
        		repaint();
        	
        	
           
        }
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println(i++);
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
	}
}
