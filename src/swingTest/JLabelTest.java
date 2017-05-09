package swingTest;



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import base.MyJButton;
import elimGame2.BlockEnum;
import elimGame2.myPoint;

public class JLabelTest extends JLabel implements Runnable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//�õ�ͼƬ
	static	java.net.URL imgURLyellow = JLabelTest.class.getResource("yellow.jpg");
		Icon yellow = new ImageIcon(imgURLyellow);
	
	static	java.net.URL imgURLpurple = JLabelTest.class.getResource("purple.jpg");
		Icon purple = new ImageIcon(imgURLpurple);
	
	static	java.net.URL imgURLblue = JLabelTest.class.getResource("blue.jpg");
		Icon blue = new ImageIcon(imgURLblue);
	
	static	java.net.URL imgURLor = JLabelTest.class.getResource("or.jpg");
		Icon or = new ImageIcon(imgURLor);
	
	static	java.net.URL imgURLgreen = JLabelTest.class.getResource("green.jpg");
		Icon green = new ImageIcon(imgURLgreen);
	
	static	java.net.URL imgURLred = JLabelTest.class.getResource("red.jpg");
		Icon red = new ImageIcon(imgURLred);
		
	myPoint nowLocation;
	myPoint moveTO ;
	boolean exchage = false;
	
	public JLabelTest(int i ,int j,BlockEnum color){
		
		nowLocation = new myPoint(j, i);
		moveTO = new myPoint(j, i);
		switch(color){
		case GREEN :
			setIcon(green);
			break;
		case BLUE:
			setIcon(blue);
			break;
		case ELIM:
			
			break;
		case PURPLE:
			setIcon(purple);
			break;
		case RED:
			setIcon(red);
			break;
		case WHITE:
			setIcon(or);
			break;
		case YELLOW:
			setIcon(yellow);
			break;
		default:
			break;
		
		}
		
		////���Բ���������λ�úʹ�С
		setBounds(i, j, 50, 50);
		System.out.println(i + " "+j);
//		addMouseListener(new MouseListener() {
//			
//			@Override
//			public void mouseReleased(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mousePressed(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseExited(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseEntered(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void mouseClicked(MouseEvent arg0) {
//				// TODO Auto-generated method stub
//				System.out.println("asdasd");
//			}
//		});
	}
	
	
	
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//	��������ֻ��Ҫ���Ǻ��ƺ�����(�ѵ�����б��?)
		//Y��ֻ������
		if(nowLocation.y!=moveTO.y){
		int distance =moveTO.y-nowLocation.y;
		int move=0;
		while(move<=distance){
		this.setLocation(nowLocation.x, nowLocation.y+move);
		this.repaint();
		move+=5;
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
		
		}else if(nowLocation.x!=moveTO.x){
			if(moveTO.x>nowLocation.x){
				int distance =moveTO.x-nowLocation.x;
				int move=0;
				while(move<=distance){
				this.setLocation(nowLocation.x+move, nowLocation.y);
				this.repaint();
				move+=5;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
				
			}else{
				int distance =nowLocation.x-moveTO.x;
				int move=0;
				while(move<=distance){
				this.setLocation(nowLocation.x+move, nowLocation.y);
				this.repaint();
				move+=5;
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
			}
			
			
			
			
			
		}
	}


}