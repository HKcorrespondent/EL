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
	//���
	private	static  int DEFAULT_WIDTH=1000;
	//�߶�
	private	static  int DEFAULT_HEIGHT=800;
	public BaseFrame() {
		//�趨��������Ŀ�Ⱥ͸߶�
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		//�趨�����Icon
		Image imageb = new ImageIcon ("C:\\Users\\asus\\Desktop\\JAVA\\fromCSDN\\src\\fromCSDN\\b.jpg").getImage();
		setIconImage(imageb);
//		
		
		//�趨��Ϸ�����С���ɸı�
		setResizable(false);
		//�趨��Ϸ����ĳ�ʼλ��
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