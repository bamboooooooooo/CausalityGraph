package test209;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class JMenuDemo {
	
	JFrame mainJFrame;
	Container con;
	JScrollPane JSPane;
	JTextArea text;
	JMenuBar mainMenuBar;
	JMenu fileMenu,editMenu,formatMenu,helpMenu;
	JMenuItem newItem,openItem,saveItem,saveasItme,pageItem,printItem,exitItem;//"�ļ�"�˵��µ��Ӳ˵�
	JMenuItem undoItme,cutItem,copyItem,pasteItem,findItem,replaceItem,selectallItem;//"�༭"�˵��µ��Ӳ˵�
	JCheckBoxMenuItem wrapItem;//"����"�˵��µ��Ӳ˵�
	JMenuItem helpItem,aboutItem;//"����"�˵��µ��Ӳ˵�
	JMenuItem fontItem;
	public JMenuDemo() {
		// TODO Auto-generated constructor stub
		mainJFrame = new JFrame("�˵�ʹ��ʵ��");
		con = mainJFrame.getContentPane();
		text = new JTextArea();
		JSPane = new JScrollPane(text);
		createMenu();
		mainJFrame.setJMenuBar(mainMenuBar);
		con.add(JSPane,BorderLayout.CENTER);
		mainJFrame.setSize(300, 300);
		mainJFrame.setVisible(true);
		mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private void createMenu() {
		// TODO Auto-generated method stub
		mainMenuBar = new JMenuBar();
		fileMenu = new JMenu("文件");
		editMenu = new JMenu("编辑");
		formatMenu = new JMenu("执行");
		helpMenu = new JMenu("帮助");
		
		mainMenuBar.add(fileMenu);//����JMenuItem����ӵ���Ӧ��JMemu��
		newItem = new JMenuItem("�½�");
		openItem = new JMenuItem("��");
		saveItem = new JMenuItem("����");
		saveasItme = new JMenuItem("���Ϊ");
		pageItem = new JMenuItem("ҳ������");
		printItem = new JMenuItem("��ӡ");
		exitItem = new JMenuItem("�˳�");
		fileMenu.add(newItem);
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.add(saveasItme);
		fileMenu.add(pageItem);
		fileMenu.add(printItem);
		fileMenu.add(exitItem);
		
		mainMenuBar.add(editMenu);
		undoItme = new JMenuItem("����");
		cutItem = new JMenuItem("����");
		copyItem = new JMenuItem("����");
		pasteItem = new JMenuItem("ճ��");
		findItem = new JMenuItem("����");
		replaceItem = new JMenuItem("�滻");
		selectallItem = new JMenuItem("ȫѡ");
		editMenu.add(undoItme);
		editMenu.add(cutItem);
		editMenu.add(copyItem);
		editMenu.add(pasteItem);
		editMenu.add(findItem);
		editMenu.add(replaceItem);
		editMenu.add(selectallItem);
		
		mainMenuBar.add(formatMenu);
		wrapItem = new JCheckBoxMenuItem("�Զ�����");
		fontItem = new JMenuItem("��������");
		formatMenu.add(wrapItem);
		formatMenu.add(fontItem);
		
		mainMenuBar.add(helpMenu);
		helpItem = new JMenuItem("����");
		aboutItem = new JMenuItem("����");
		helpMenu.add(helpItem);
		helpMenu.add(aboutItem);
	}
	public static void main(String[] args)
	{
		new JMenuDemo();
	}
}
