package swingTest;



import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.sun.prism.Image;

import elimGame2.BlockArgsData;
import elimGame2.BlockEnum;
import elimGame2.CommonGem;

public class GameJPanel extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	
	public static int heightNum = 10;
	

	Thread t1 ;

	Thread t2 ;
	
	java.awt.Image	backGroundImage = new ImageIcon ("C:\\Users\\asus\\Desktop\\sucai\\big.jpg").getImage();
	
	
	public GameJPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		//绝对布局下设置位置和大小
		setBounds(20,20,400,600);
		
		int height=5 ;
		int width=4 ;
		BlockArgsData blockArgsData = new BlockArgsData(height, width);
		blockArgsData.initializeData();
		CommonGem[][] data = blockArgsData.getArgs();
		
		for(int i =0;i<width;i++){
			for(int j =0;j<height;j++){
				add(data[j][i].getLabel());
				final int jy = j;
				final int ix = i;
				data[j][i].getLabel().addMouseListener(new MouseListener() {
					
					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
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
						//试探周围的在前一次中是否被点击过
						if(blockArgsData.checkArge( jy+1, ix)!=null&&data[jy+1][ix].getLabel().exchage==true){
							if(blockArgsData.exchangeloc(jy, ix, jy+1, ix)){
								
							}else{
								
							}
								
						}
						if(blockArgsData.checkArge( jy-1, ix)!=null&&data[jy-1][ix].getLabel().exchage==true){
							if(blockArgsData.exchangeloc(jy, ix, jy-1, ix)){
								
							}else{
								
							}
								
						}
						if(blockArgsData.checkArge( jy, ix+1)!=null&&data[jy][ix+1].getLabel().exchage==true){
							if(blockArgsData.exchangeloc(jy, ix, jy, ix+1)){
								
							}else{
								
							}
								
						}
						if(blockArgsData.checkArge( jy, ix-1)!=null&&data[jy][ix-1].getLabel().exchage==true){
							if(blockArgsData.exchangeloc(jy, ix, jy, ix-1)){
								
							}else{
								
							}
								
						}
						
						
						
						
					}
				});
			}
		}
		
		
		
	

		
		
		
//		{
//			 Button b1 = new Button("启动"); 
//			 add(b1);
//			 b1.setBounds(300, 500, 100, 50);
//			 b1.addActionListener(this);
//			}
			
	}
	
	
	public void actionPerformed(ActionEvent e) {
//		JLabelTest1.moveTO.x=100;
//		
//		
//		
//		  if (t1!=null&&!t1.isAlive()){
//			  
//		   t1.start();
//		  }  
		 }
	
	
	


}
