package swingGUI;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import elimGame2.BlockArgsData;

public class StartPage extends JPanel {
	
	
	private static Image imageScore=BlockArgsData.getScoreImage()[0] ;
	private static Image image10000 ;
	private static Image image1000 ;
	private static Image image100 ;
	private static Image image10 ;
	private static Image image1 ;
	
	
	public void changeScore(){
		Image[] images=BlockArgsData.getScoreImage();
		
		imageScore =images[0];
		image10000 =images[1];
		image1000 =images[2];
		image100 =images[3];
		image10 =images[4];
		image1 =images[5];
	}
	
	
	




//	@Override
//	public void printComponents(Graphics g) {
//		// TODO Auto-generated method stub
//
//		g.drawImage(imageScore, 0, 0, this);
////		g.drawImage(image10000, 130, 30, null);
////		g.drawImage(image1000, 160, 30, null);
////		g.drawImage(image100, 190, 30, null);
////		g.drawImage(image10, 220, 30, null);
////		g.drawImage(image1, 250, 30, null);
//		super.printComponents(g);
//
//	}
	
	
	
	 static Music music = new Music();
	//¿í¶È
	public	static  int DEFAULT_WIDTH=600;
	//¸ß¶È
	public	static  int DEFAULT_HEIGHT=800;
	JButton startGame = new JButton();
	
	static	ImageIcon start = new ImageIcon(MainJFrame.class.getResource("start.png"));

	StartPage(int DEFAULT_WIDTH,int DEFAULT_HEIGHT){
//		setLayout(card);
		setLayout(null);
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		add(startGame);
		
		startGame.setContentAreaFilled(false);
		startGame.setBorderPainted(false);
		startGame.setOpaque(false);
		startGame.setIcon(start);
		startGame.setBounds(400, 300, start.getIconWidth(),start.getIconHeight());
		
	}
		
	
	
	
	
	
}
