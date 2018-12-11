import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class test extends JFrame implements ActionListener{
	 String filename="C:\\Users\\lxs\\Desktop\\test.txt";//这里写你准备好的文本文件的全路径名 
	 JTextArea jta=new JTextArea(10,10);//文本区域 
	 JScrollPane jsp=new JScrollPane(jta); //滚动条
	 JButton jb=new JButton("读取文件"); 
	 JButton jb1=new JButton("保存文件"); 
	 JPanel jp=new JPanel();
	 test(){ 
	  setTitle("读取文本文件"); 
	  jb.addActionListener(this); 
	  jb1.addActionListener(this); 
	  jp.add(jb); 
	  jp.add(jb1); 
	  add(jsp,BorderLayout.CENTER); 
	  add(jp,BorderLayout.SOUTH); 
	  setSize(300, 300); 
	  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	  setLocationRelativeTo(null); 
	 } 
	 public static void main(String[] args) { 
	  new test().setVisible(true); 
	 } 
	 @Override 
	 public void actionPerformed(ActionEvent e) { 
		  if(e.getSource()==jb){ 
		   readFile(filename); 
		  } 
		  if(e.getSource()==jb1)
		  {
			  String text = jta.getText();
			  saveFile(filename,text);
		  }
	 } 
	 private void saveFile(String filename2,String text) {
		// TODO Auto-generated method stub
		 OutputStream os = null;
	        try {
	           os = new FileOutputStream(filename2);
	           OutputStreamWriter write = new OutputStreamWriter(os,"UTF-8");
	           BufferedWriter writer=new BufferedWriter(write);
	           writer.write(text);
	           write.close();
	           writer.close();

//	           DataOutputStream dos = new DataOutputStream(os);
//	           byte[]b = text.getBytes();
//	           dos.write(b);
//	           dos.flush();
	           System.out.println(text);
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // 完毕，关闭所有链接
	            try {
	                os.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }

	}
	public void readFile(String filename2){ 
		  try { 		  
			  FileInputStream is = new FileInputStream(filename2);
			  BufferedInputStream bis = new BufferedInputStream(is);
			  byte[] b = new byte[is.available()];
			  bis.read(b);
			  jta.append(new String(b)+"\n"); 
			  is.close();
			  bis.close();
		  } catch (FileNotFoundException e) {
				e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	 }
}
