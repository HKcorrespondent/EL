package base;
import elimGameEL.Data;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class AJPanel extends JPanel {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			private Image backGroundImage=null;
			
			private int imageX=0;
			private int imageY=0;
			private int WIDTH=0;
			private int HEIGHT=0;
			
			public void paintComponent(Graphics g){
				if(true){
				g.drawImage(backGroundImage, imageX, imageY,null);
				}		
			}
			
			public AJPanel(String address){
				//先简单搞一个背景
				backGroundImage = new ImageIcon (address).getImage();
				
				WIDTH=backGroundImage.getWidth(null);
				HEIGHT=backGroundImage.getHeight(null);
				
				setPreferredSize(new Dimension(WIDTH, HEIGHT));
				setLayout(null);
				
		
				
				JPanel game = new JPanel();
				
				Icon images = new ImageIcon("C:\\Users\\asus\\Desktop\\sucai\\p1.png");
				
				
				MyJButton[] myJButton = new MyJButton[9];
				for(int i=0; i<myJButton.length;i++){
					myJButton[i]=new MyJButton();
				}
				
				final int NUMBER=3;
				GridLayout glout=new GridLayout(NUMBER,NUMBER);
				game.setLayout(glout);
				
				for(int i=0; i<myJButton.length;i++){
				myJButton[i].setIconaddress(images);
				game.add(myJButton[i]);
				}
				
//				game.add(new JLabel(images));
				game.setBounds(WIDTH/5, HEIGHT/5, 480, 480);
//				game.setPreferredSize(new Dimension(480, 480));
				game.setOpaque(false);
		
//				this.add(game,BorderLayout.CENTER);
				this.add(game);
			
			
			
//				addMouseListener(new AJComponent.MouseHandler()); 
//				addMouseMotionListener(new AJComponent.MouseMotionHandler()); 
			}
			
//			private class MouseHandler implements MouseListener {
//
//				@Override
//				public void mouseClicked(MouseEvent e) {
//					// TODO Auto-generated method stub
//					
//				}
//
//				@Override
//				public void mouseEntered(MouseEvent e) {
//					// TODO Auto-generated method stub
//					System.out.println("Enter");
//				}
//
//				@Override
//				public void mouseExited(MouseEvent e) {
//					// TODO Auto-generated method stub
//					
//				}
//
//				@Override
//				public void mousePressed(MouseEvent e) {
//					// TODO Auto-generated method stub
//
//					
//					System.out.println("Pressed");
//				}
//
//				@Override
//				public void mouseReleased(MouseEvent e) {
//					// TODO Auto-generated method stub
//					
//				} 
//				
//			}
//			
//			private class MouseMotionHandler implements MouseMotionListener {
//
//				@Override
//				public void mouseDragged(MouseEvent e) {
//					// TODO Auto-generated method stub
//					
//				}
//
//				@Override
//				public void mouseMoved(MouseEvent e) {
//					// TODO Auto-generated method stub
//					
//				} 
//				
//			}
//			
	
			
			
	 }
