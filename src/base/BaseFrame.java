package base;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;





public class BaseFrame extends JFrame{
	//宽度
	private	static  int DEFAULT_WIDTH=1000;
	//高度
	private	static  int DEFAULT_HEIGHT=800;
	public BaseFrame() {
		//设定整个界面的宽度和高度
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		//设定界面的Icon
		Image imageb = new ImageIcon ("C:\\Users\\asus\\Desktop\\JAVA\\fromCSDN\\src\\fromCSDN\\b.jpg").getImage();
		setIconImage(imageb);
//		
		
		//设定游戏界面大小不可改变
		setResizable(false);
		//设定游戏界面的初始位置
		setLocation(200, 70);
		
		
		
		add(new AJPanel("C:\\Users\\asus\\Desktop\\sucai\\big.jpg"));

	
	    
} 
	
	 public static void main(String[] args){
	 EventQueue.invokeLater(new Runnable()
		{
		public void run()
		{
			BaseFrame frame = new BaseFrame();
			frame.setTitle("elimGame");
//			frame.setLocation(400, 100);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
		});
	 System.out.println("hello");
}
}