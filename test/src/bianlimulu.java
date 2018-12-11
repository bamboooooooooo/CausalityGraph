import java.io.File;

public class bianlimulu {
	public static void main(String[] args)
	{
				
		String path = "E:\\Causality Case\\";//存储路径
		File file = new File(path);		//获取其file对象		
		File[] fs = file.listFiles();	//遍历path下的文件和目录，放在File数组中		
		for(int i = 0; i<file.length();i++){					//遍历File[]数组			
				//若非目录(即文件)，则打印				
				System.out.println(fs[i].getName());		
			
		}
	}
}
		
		
