
 import java.awt.*;
 import java.awt.event.*;
 import java.awt.image.BufferedImage;
 import java.awt.image.*;
 import java.io.*;
 import javax.imageio.*;
 public class Point
 {
       private Frame f = new Frame("图片缩放程序");
       private FileDialog d1 = new FileDialog(f, "选择一张图片", FileDialog.LOAD);
       private FileDialog d2 = new FileDialog(f, "选择保存图片的路径", FileDialog.SAVE);
       private Button b1 = new Button("打开图片");
       private Button b2 = new Button("保存图片");
       private Button b3 = new Button("缩放图片");
       private TextField height = new TextField(5);
       private TextField width = new TextField(5);
       private Panel pl = new Panel();
       //定义一个BufferedImage对象,保存图片
       private BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
       private imageCanvas canvas = new imageCanvas();
       private Image srcImage;
       private Graphics g = image.getGraphics();
       public void init()throws Exception
       {
            b1.addActionListener(new ActionListener()
            {
                  public void actionPerformed(ActionEvent e)
                  {
                       try
                       {
                             image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
                             image.flush();
                             g = image.getGraphics();
                             d1.setVisible(true);
                             srcImage = ImageIO.read(new File(d1.getDirectory() + d1.getFile()));
                            
                             g.drawImage(srcImage,0,0, null);
                             canvas.repaint();
                       }
                       catch (Exception ee)
                       {
                             ee.printStackTrace();
                       }
                  }
            });
            b2.addActionListener(new ActionListener()
            {
                  public void actionPerformed(ActionEvent e)
                  {
                       try
                       {
                             d2.setVisible(true);
                             ImageIO.write(image, "jpeg", new File(d2.getDirectory() + d2.getFile()));
                             height.setText("");
                             width.setText("");
                       }
                       catch (Exception ee)
                       {
                             ee.printStackTrace();
                       }
                  }
            });
            b3.addActionListener(new ActionListener()
            {
                  public void actionPerformed(ActionEvent e)
                  {
                       int WIDTH = Integer.parseInt(width.getText());
                       int HEIGHT = Integer.parseInt(height.getText());
                       image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
                        g = image.getGraphics();
                       g.drawImage(srcImage, 0, 0,WIDTH,HEIGHT, null);
                       canvas.repaint();
                  }
            });
            pl.add(b1);
            pl.add(b2);
            pl.add(b3);
            pl.add(width);
            pl.add(height);
            canvas.setPreferredSize(new Dimension(800, 600));
            f.add(canvas);
            f.add(pl, BorderLayout.SOUTH);
            f.addWindowListener(new WindowAdapter()
            {
                  public void windowClosing(WindowEvent e)
                  {
                       System.exit(0);
                  }
            });
            f.pack();
            f.setVisible(true);
       }
       public static void main(String[] args)throws Exception
       {
            new Point().init();
       }
       class imageCanvas extends Canvas
       {
            //重写Canvas的paint方法
            public void paint(Graphics g)
            {
                  //将image绘制到该组件上
                  g.drawImage(image, 0, 0, null);
            }
       }
 } 