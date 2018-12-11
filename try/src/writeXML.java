import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class writeXML {
	private String path;
	private static String conent;
	public static void writeCircle(String path,int x,int y,int r,String text) {
		// TODO Auto-generated constructor stub
		conent = "<circle cx=\"" + x + "\" cy=\"" + y + "\" r=\"" + r + "\" name=\"" + text + "\" />";
		System.out.println(conent);
		writhFile(path,conent);  
	}
	public void writeIdentical(){
		writhFile(path,conent);  
	}
	public void writeAnd(){
		writhFile(path,conent);  
	}
	public void writeOr(){
		writhFile(path,conent);  
	}
	public void writeNot(){
		writhFile(path,conent);  
	}
	public void writeInor(){
		writhFile(path,conent);  
	}
	public void writeEnor(){
		writhFile(path,conent);  
	}
	public void writeOnly(){
		writhFile(path,conent);  
	}
	public void writeRequire(){
		writhFile(path,conent);  
	}
	private static void writhFile(String path,String conent){
		 BufferedWriter out = null;   
		 try {   
			 out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true)));    
			 out.write(conent + "\r\n");   
		 } catch (Exception e) {   
			 e.printStackTrace();   
		 } finally {   
			 try {   
				 out.close();   
			 } catch (IOException e) {   
				 e.printStackTrace();   
			 }   
		 } 
	}
	public static void main(String arge[]) {
		String path = "C:\\Users\\lxs\\Desktop\\xmltry.xml";
		writeCircle(path,11,66,59,"vsgvfb");
	}
}
