import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class test extends JFrame{
// �ڴ˶������Ҫ�õ����
private JButton jButton, jButton2;
private JPanel jPanel, jPanel2, jPanel3;
private JLabel jLabel, jLabel2;
private JCheckBox jCheckBox1, jCheckBox2, jCheckBox3;
private ButtonGroup buttonGroup;
private JRadioButton jRadioButton, jRadioButton2,jRadioButton3, jRadioButton4;
public static void main(String[] args){
test mySelect = new test();
}
// ���췽��
public test(){
// ���
jPanel = new JPanel();
jPanel2 = new JPanel();
jPanel3 =new JPanel();
// ��ť
jButton = new JButton("ȷ��");
jButton2 = new JButton("ȡ��");
// ��ǩ
jLabel = new JLabel("��ѡ��");
jLabel2 = new JLabel("����");
// ��ѡ
jCheckBox1 = new JCheckBox("Python");
jCheckBox2 = new JCheckBox("Java");
jCheckBox3 = new JCheckBox("Python");
// ��ѡ
jRadioButton = new JRadioButton("Linux");
jRadioButton2 = new JRadioButton("Unix");
jRadioButton3 = new JRadioButton("Windows");
jRadioButton4 = new JRadioButton("Mac OS");
// ��ѡ��Group
buttonGroup = new ButtonGroup();
buttonGroup.add(jRadioButton);
buttonGroup.add(jRadioButton2);
buttonGroup.add(jRadioButton3);
buttonGroup.add(jRadioButton4);
 
jPanel.add(jLabel);
jLabel.add(jCheckBox1);
jPanel.add(jCheckBox2);
jPanel.add(jCheckBox3);
jPanel2.add(jLabel2);
jPanel2.add(jRadioButton);
jPanel2.add(jRadioButton2);
jPanel2.add(jRadioButton3);
jPanel2.add(jRadioButton4);
 
jPanel3.add(jButton);
jPanel3.add(jButton2);
 
this.setLayout(new GridLayout(3, 1));
this.add(jPanel);
this.add(jPanel2);
this.add(jPanel3);
//����JFrame����
this.setTitle("����");
this.setLocation(500, 250);
this.setSize(350, 200);
this.setResizable(false);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
}
}
