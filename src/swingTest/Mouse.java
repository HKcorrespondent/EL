package swingTest;

import java.awt.event.MouseEvent;
import elimGame2.BlockArgsData;
import elimGame2.BlockEnum;
import elimGame2.CommonGem;

public class Mouse implements java.awt.event.MouseListener{
	
	
	
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		// TODO Auto-generated method stub
		if(GameJPanel.lock){
			((GameJPanel)e.getComponent().getParent()).mouseExchage(e.getComponent().getY()/50,e.getComponent().getX()/50);
			}
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
		
		
		
	}

