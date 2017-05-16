package swingTest;



import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Locale;

import javax.imageio.ImageReader;
import javax.imageio.spi.ImageReaderSpi;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.sun.imageio.plugins.gif.GIFImageReader;
import com.sun.imageio.plugins.gif.GIFImageWriter;

import base.MyJButton;
import elimGame2.BlockEnum;
import elimGame2.myPoint;

public class JLabelTest extends JLabel implements Runnable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//得到图片
	
	static	java.net.URL imgURLyellow = JLabelTest.class.getResource("yellow.png");
	static	Icon yellow = new ImageIcon(imgURLyellow);
	
	static	java.net.URL imgURLpurple = JLabelTest.class.getResource("purple.png");
	static	Icon purple = new ImageIcon(imgURLpurple);
	
	static	java.net.URL imgURLblue = JLabelTest.class.getResource("blue.png");
	static	Icon blue = new ImageIcon(imgURLblue);
	
	static	java.net.URL imgURLor = JLabelTest.class.getResource("orange.png");
	static	Icon or = new ImageIcon(imgURLor);
	
	static	java.net.URL imgURLgreen = JLabelTest.class.getResource("green.png");
	static	Icon green = new ImageIcon(imgURLgreen);
	
	static	java.net.URL imgURLred = JLabelTest.class.getResource("red.png");
	static	Icon red = new ImageIcon(imgURLred);
	
	public myPoint nowLocation;
	myPoint moveTO ;
	
	
	static int x_zhou=-1;
	static int y_zhou=-1;
	
	public boolean newGet=false;
	
	public JLabelTest(int i ,int j,BlockEnum color){
		i=i*50;
		j=j*50;
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

		setBounds(i, j, 50, 50);

	}
	
	
	
	
	
	
	
	
	
	int specialGem=0;
	
	/*
	 * 用于产生特殊宝石的构造器
	 * 
	 * 
	 */
	
	
	
	public JLabelTest(int i ,int j,BlockEnum color,int _specialGem,Icon icon){
		i=i*50;
		j=j*50;
		nowLocation = new myPoint(j, i);
		moveTO = new myPoint(j, i);
		specialGem=_specialGem;
		setIcon(icon);
		setBounds(i, j, 50, 50);

	}
	
	
	
	
	
	
	
	
	
	
	public void goThere(int j, int i){
		moveTO.x=i*50;
		moveTO.y=j*50;
	}
	
	

	static	Icon common1 = new ImageIcon(JLabelTest.class.getResource("总消1.png"));

	static	Icon common2 = new ImageIcon(JLabelTest.class.getResource("总消2.png"));

	static	Icon common3 = new ImageIcon(JLabelTest.class.getResource("总消3.png"));

	static	Icon common4 = new ImageIcon(JLabelTest.class.getResource("总消4.png"));
	
	public void elimX( ){
	
		
		System.out.println("!!");
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			setIcon(null);
			
			
			
			
			
			setIcon(common1);
			try {
				Thread.sleep(180);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			setIcon(common2);
			try {
				Thread.sleep(180);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			setIcon(common3);
			try {
				Thread.sleep(180);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			setIcon(common4);
			try {
				Thread.sleep(180);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
				
			}
		}).start();;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//	由于现在只需要考虑横移和竖移(难道还能斜移?)
		long time =20;
		final int moveStrp=10;
		if(nowLocation.y!=moveTO.y){
			if(moveTO.y>nowLocation.y){
			
				int distance =moveTO.y-nowLocation.y;
				int move=0;
				while(move<=distance){
				this.setLocation(nowLocation.x, nowLocation.y+move);
				
				this.repaint();
				move+=moveStrp;
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
			}else{
				int distance =nowLocation.y-moveTO.y;
				int move=0;
				while(move<=distance){
				this.setLocation(nowLocation.x, nowLocation.y-move);
				this.repaint();
				move+=moveStrp;
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
			}
		
		}else if(nowLocation.x!=moveTO.x){
			
			if(moveTO.x>nowLocation.x){
				
				int distance =moveTO.x-nowLocation.x;
				int move=0;
				
				while(move<=distance){
				this.setLocation(nowLocation.x+move, nowLocation.y);
				this.repaint();
				move+=moveStrp;
				try {
					Thread.sleep(time);
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
				
			}else{
				int distance =nowLocation.x-moveTO.x;
				int move=0;
				while(move<=distance){
					
				this.setLocation(nowLocation.x-move, nowLocation.y);
				
				this.repaint();
				
				move+=moveStrp;
				try {
					Thread.sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
			}
			
			
			
			
			
		}
	
		nowLocation.x=moveTO.x;
		nowLocation.y=moveTO.y;
		setBounds(nowLocation.x, nowLocation.y, 50, 50);
	}


}
