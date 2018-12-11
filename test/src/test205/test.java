package test205;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
		JFrame frame = new JFrame();
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setBounds(0, 0, 800, 600);
		 JLabel label = new JLabel();
		 label.setSize(800, 600);
		 label.setIcon(new javax.swing.ImageIcon("C:\\Users\\lxs\\Documents\\test.jpg")); // NOI18N
		 frame.getContentPane().add(label);
		 frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test();
	}

}
