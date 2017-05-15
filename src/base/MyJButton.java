package base;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Icon;
import javax.swing.JButton;

public class MyJButton extends JButton {
	int xCoordinate= 0;
	int yCoordinate= 0 ;
	
	public MyJButton() {
		// TODO Auto-generated constructor stub
		//
		
		setContentAreaFilled(false);
		setBorderPainted(false);
		setOpaque(false);
		
		addMouseListener(new MyJButton.MouseHandler()); 
		addMouseMotionListener(new MyJButton.MouseMotionHandler()); 
	}
	public void setIconaddress(Icon image){
		setIcon(image);
	}
	private class MouseHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Enter");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

			
			System.out.println("Pressed");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		} 
		
	}
	
	private class MouseMotionHandler implements MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		} 
		
	}
	
}
