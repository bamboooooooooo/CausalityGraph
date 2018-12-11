import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class drawtest {

//	public drawtest() {
//		// TODO Auto-generated constructor stub
//		
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f=new JFrame();
		f.setTitle("画板");
		f.setSize(1400,900);
		
		JPanel jp = new JPanel();
		jp.setBackground(Color.WHITE);
		jp.addMouseListener(this);
		
		f.add(jp);
		f.setVisible(true);
	}

}
