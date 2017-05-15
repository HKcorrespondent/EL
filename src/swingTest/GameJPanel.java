package swingTest;



import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
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
	
	BlockArgsData blockArgsData;
	CommonGem[][] data;
	public GameJPanel() {
		// TODO Auto-generated constructor stub
		setLayout(null);
		//绝对布局下设置位置和大小
		setBounds(20,20,400,600);
		
		int height=10 ;
		int width=8 ;
		blockArgsData = new BlockArgsData(height, width);
		blockArgsData.initializeData();
		data = blockArgsData.getArgs();
	
		
		
		
		for(int i =0;i<width;i++){
			for(int j =0;j<height;j++){
				add(data[j][i].getLabel());
				final int  jy = j;
				final int  ix = i;
				
				
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
						if(GameJPanel.lock)
						GameJPanel.this.mouseExchage(jy,ix);
					}
					
				
						
					

				
				} );
			}
		}
		
		
		
	

		
		
		

	}
	
	
	static boolean lock =true;
	static int jb=-1;
	static int ib=-1;
	private void mouseExchage(int j,int i){
		
		if(j==jb&&(ib==i-1||ib==i+1)){
			lock=false;
				  	exchage(j,i,jb,ib);
				  
				  
			
		}else if(i==ib&&(jb==j-1||jb==j+1)){
			lock=false;
					exchage(j,i,jb,ib);
				
				
				
		}else {
			if(jb!=-1){
			data[jb][ib].getLabel().setBorder(BorderFactory.createEmptyBorder());}
			jb=	j;
			ib=	i;
			data[j][i].getLabel().setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

		}
		
		
			
		
		
		
		
		
		
		
		
		
		
	}
	  public void exchage(int j1,int i1,int j2,int i2){	
		  
		  new Thread(new Runnable() {//开辟一个工作线程
				@Override
				public void run() {
					t1 = new Thread(data[j1][i1].getLabel());
					t2 = new Thread(data[j2][i2].getLabel());
					data[j1][i1].getLabel().goThere(j2, i2);
					data[j2][i2].getLabel().goThere(j1, i1);
					t1.start();
					t2.start();
		
						try {
							t1.join();
							t2.join();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
//						System.out.println("hello");
						if(blockArgsData.exchangeloc(j1, i1, j2, i2)){
							
							
							
							
							
							
							
							
							
							
							
							
							lock=true;
							
						}else{
//							System.out.println("hello");
							t1 = new Thread(data[j1][i1].getLabel());
							t2 = new Thread(data[j2][i2].getLabel());
							
							data[j1][i1].getLabel().goThere(j1, i1);
							data[j2][i2].getLabel().goThere(j2, i2);
							
							t1.start();
							t2.start();
							
							lock=true;
						}
						
				}
			}).start();

		  
		  
		  
		  
		  
		  
//		  
//			t1 = new Thread(data[j1][i1].getLabel());
//			t2 = new Thread(data[j2][i2].getLabel());
//			data[j1][i1].getLabel().goThere(j2, i2);
//			data[j2][i2].getLabel().goThere(j1, i1);
//			t1.start();
//			t2.start();
//
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//				
//				try {
//					t1.join();
//					t2.join();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				
//				
//				
//				
//					System.out.println("hello");
//					if(blockArgsData.exchangeloc(j1, i1, j2, i2)){
//						
//					}else{
//						System.out.println("hello");
//						t1 = new Thread(data[j1][i1].getLabel());
//						t2 = new Thread(data[j2][i2].getLabel());
//						
//						data[j1][i1].getLabel().goThere(j1, i1);
//						data[j2][i2].getLabel().goThere(j2, i2);
//						
//						t1.start();
//						t2.start();
//						
//					}
//				
				
		
			
			
			
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



