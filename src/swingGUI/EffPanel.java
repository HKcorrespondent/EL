package swingGUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import elimGame2.BlockArgsData;

public class EffPanel extends JPanel{
	
	
	private static  Image imageScore ;
	private static  Image image10000 ;
	private static  Image image1000 ;
	private static  Image image100 ;
	private static  Image image10 ;
	private static  Image image1 ;
	
	
	public static void changeScore(){
		Image[] images=BlockArgsData.getScoreImage();
	System.out.println("aaaaaaaaa");
		imageScore =images[0];

		image10000 =images[1];

		image1000 =images[2];
	
		image100 =images[3];
		System.out.print("2323");
		System.out.println(image100==null);
		image10 =images[4];
		image1 =images[5];
		
		
	}
	
	
	



























	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
//		super.paintComponent(g);
		g.drawImage(imageScore, 30, 30, this);
		g.drawImage(image10000, 130, 30, null);
		g.drawImage(image1000, 150, 30, null);
		
		
		

	
		g.drawImage(image100, 170, 30, null);
		
		g.drawImage(image10, 190, 30, null);
		g.drawImage(image1, 210, 30, null);

		
		this.repaint();
		
	}























	EffPanel(int height,int width){

		setOpaque(false);
		setLayout(null);
		setBounds(0, 0, width, height);
		changeScore();

		
		

	}
	
	
}
