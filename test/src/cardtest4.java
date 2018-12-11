import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class cardtest4 extends JFrame{
	public cardtest4(){          
		initComponents();      
		}      
	/** 初始化组件 */      
	private void initComponents(){          
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);          
		setTitle("Netbeans IDE 6.9.1");          
		initMenuBar();                   
		initMainPanel();          
		pack();          
		setExtendedState(JFrame.MAXIMIZED_BOTH);      
		}      
	private void initMenuBar(){     
		JMenuBar menuBar;      
		menuBar=new JMenuBar();      
		JMenu fileMenu=new JMenu("文件(F)");      
		menuBar.add(fileMenu);      
		JMenu editMenu=new JMenu("编辑(E)");      
		menuBar.add(editMenu);      
		JMenu viewMenu=new JMenu("视图(V)");      
		menuBar.add(viewMenu);      
		JMenu leadMenu=new JMenu("导航(V)");      
		menuBar.add(leadMenu);      
		JMenu sourceMenu=new JMenu("源(S)");      
		menuBar.add(sourceMenu);      
		JMenu refactorMenu=new JMenu("重构(A)");      
		menuBar.add(refactorMenu);      
		JMenu runMenu=new JMenu("运行(R)");      
		menuBar.add(runMenu);      
		JMenu debugMenu=new JMenu("调试(D)");      
		menuBar.add(debugMenu);      
		JMenu analyseMenu=new JMenu("分析(P)");      
		menuBar.add(analyseMenu);      
		JMenu termMenu=new JMenu("团队开发(M)");      
		menuBar.add(termMenu);      
		JMenu toolMenu=new JMenu("工具(T)");      
		menuBar.add(toolMenu);      
		JMenu windowMenu=new JMenu("窗口(W)");      
		menuBar.add(windowMenu);      
		JMenu helpMenu=new JMenu("帮助(H)");      
		menuBar.add(helpMenu);      
		setJMenuBar(menuBar);  }  
	  
		/** 初始化界面主框架 */      
		private void initMainPanel(){          
		JPanel centerPanel=new JPanel();          
		centerPanel.setLayout(new java.awt.GridLayout());          
		JSplitPane leftSplitPane =new JSplitPane();          
		leftSplitPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));          
		leftSplitPane.setResizeWeight(0.12);

		JPanel leftPanel=new JPanel();          
		leftPanel.setLayout(new java.awt.GridLayout());          
		JTabbedPane leftTabbedPane=new JTabbedPane();          
		leftPanel.add(leftTabbedPane);          
		leftSplitPane.setLeftComponent(leftPanel);          
		JPanel rightPanel=new JPanel();          
		rightPanel.setLayout(new java.awt.GridLayout());          
		JTabbedPane workTabbedPane=new JTabbedPane();          
		
		workTabbedPane.add("NetbeansUI.java", new JPanel());  
		workTabbedPane.setTabComponentAt(0,new TabbedPanel(workTabbedPane));  
		workTabbedPane.add("Netbeans.java", new JPanel());  
		workTabbedPane.setTabComponentAt(1,new TabbedPanel(workTabbedPane));  
		 
		JSplitPane downSplitPane =new JSplitPane();          
		downSplitPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));          
		downSplitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);          
		downSplitPane.setResizeWeight(0.8);          
		downSplitPane.setTopComponent(workTabbedPane);          
		JTabbedPane downTabbedPane=new JTabbedPane();          
		downTabbedPane.add("输出", new JPanel());          
		downSplitPane.setBottomComponent(downTabbedPane);          
		rightPanel.add(downSplitPane);          
		leftSplitPane.setRightComponent(rightPanel);          
		centerPanel.add(leftSplitPane);          
		getContentPane().add(centerPanel, java.awt.BorderLayout.CENTER);          
		//底部状态栏          
		JPanel bottomPanel=new JPanel();          
		bottomPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));          
		bottomPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));          
		bottomPanel.add(new JLabel("Netbeans IDE(run)"));          
		bottomPanel.add(new JProgressBar());          
		bottomPanel.add(new JLabel("INS"));          
		getContentPane().add(bottomPanel, java.awt.BorderLayout.PAGE_END);      
		}  
		public static void main(String[] args)
		{
			new cardtest4().setVisible(true);
		}
		
}
