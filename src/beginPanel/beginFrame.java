package beginPanel;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import swingGUI.MainJFrame;

public class beginFrame {
	static	Icon gif = new ImageIcon(beginFrame.class.getResource("LinearGreen.png"));
	public static void main(String[] args) {
//		 TODO Auto-generated method stub
//		EventQueue.invokeLater(new Runnable()
//		{
//		public void run()
//		{
//			JFrame frame = new JFrame();
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			GlassBox label = new GlassBox();
//			JPanel panel = new JPanel();
//			label.setIcon(gif);
//			label.setBounds(0, 0, label.getIcon().getIconWidth(), label.getIcon().getIconHeight());
////			JLabel label = new JLabel("gifigifgifigifgifigifgifigifgifigifgifigifgifigifgifigifgifigifgifigifgifigifgifigif");
//			frame.add(panel);
//			panel.add(label);
//			frame.setVisible(true);
//			frame.setLayout(null);
//			frame.setBounds(100, 100, 600, 600);
//			panel.setLayout(null);
//			panel.setBounds(0,0,600,600);
//			panel.setBackground(Color.BLUE);
//
//			frame.setVisible(true);
//			new Thread(new Runnable() {
//				
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					
//					label.renew();
//					label.paint(label.getGraphics());
//					
//					
//					
//					
//				}
//			}).start();;
//			
//			
//		}
//		});
		
		EventQueue.invokeLater(new Runnable()
		{
		public void run()
		{
			JFrame frame = new JFrame();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Fade_in label = new Fade_in();
			JPanel panel = new JPanel();
			label.setIcon(gif);
			label.setBounds(0, 0, label.getIcon().getIconWidth(), label.getIcon().getIconHeight());

			frame.add(panel);
			panel.add(label);
			frame.setVisible(true);
			frame.setLayout(null);
			frame.setBounds(100, 100, 600, 600);
			panel.setLayout(null);
			panel.setBounds(0,0,600,600);
			panel.setBackground(Color.BLUE);

			frame.setVisible(true);
			
//			panel.setOpaque(false);
			label.setOpaque(false);
			label.setLocation(50,50);
			label.init();
			label.start();
			
//			new Thread(new Runnable() {
//				
//				@Override
//				public void run() {
//					// TODO Auto-generated method stub
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					
//					
//					label.renew();
//					label.paint(label.getGraphics());
//					
//					
//					
//					
//				}
//			}).start();;
			
			
		}
		});
		

		
	}

}
