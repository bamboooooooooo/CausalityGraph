import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*监听
 * */

public class cardtest3 extends JFrame implements ChangeListener {
	private JPanel productPanel;  
	private JPanel userPanel;  
	private JTabbedPane tabbedPane;  
	      
	public cardtest3() {  
		super("JTabbedPane的事件监听");  
        init();  
    }  
	
	public void init() {  
		setSize(500,300);  
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		productPanel = new JPanel();  
		productPanel.setName("商品信息面板"); //为面板设置名称  
        userPanel = new JPanel();  
        userPanel.setName("用户信息面板");  
        tabbedPane = new JTabbedPane();  
	    tabbedPane.add("商品信息", productPanel); //将面板添加到选项卡中  
        tabbedPane.add("用户信息", userPanel);  
        tabbedPane.addChangeListener(this); //添加监听器  
	    this.getContentPane().add(tabbedPane); //将选项卡加入到窗口中  
	    this.setVisible(true);  
    }  
	      
	   /** 
	36.    * 实现ChangeListener接口中的stateChanged方法 
	37.    * 当侦听器的目标已更改其状态时调用 
	38.    */  
	public void stateChanged(ChangeEvent e) {  
		String name = tabbedPane.getSelectedComponent().getName();  
	    System.out.println("你选中的面板名称 === " + name);  
	}  
	public static void main(String[] args)
	{
		new cardtest3();
	}
}
